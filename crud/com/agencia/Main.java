package com.agencia;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.agencia.dao.ReservaDAO;
import com.agencia.dao.ClienteDAO;
import com.agencia.database.DatabaseConnection;
import com.agencia.model.Cliente;
import com.agencia.model.Reserva;
import com.agencia.utils.Colors;

public class Main {Cliente cliente = null;


	public static void main(String[] args) {
		var connection = DatabaseConnection.createConnection();
		ClienteDAO clienteDAO = new ClienteDAO(connection);
		ReservaDAO reservaDAO = new ReservaDAO(connection);



		Scanner scanner = new Scanner(System.in);

		int option = 0;

		do {
			System.out.println(Colors.CYAN_BOLD.get() + "Escolha uma opcao de 1 - 5\n" + Colors.RESET.get()
					+ "1 - Cadastrar Novo Cliente\n"
					+ "2 - Escolher Local de Viagem\n"
					+ "3 - Ver Reservas\n"
					+ "4 - Deletar Reserva\n"
					+ "5 - Sair\n");
			option = scanner.nextInt();

			switch (option) {
				case 1:
					scanner.nextLine();
					Cliente cliente = new Cliente();
					System.out.println("Nome Completo: ");
					cliente.setNomeCliente(scanner.nextLine());
					System.out.println("CPF: ");
					cliente.setCpfCliente(scanner.nextLine().trim());
					System.out.println("Endereço: ");
					cliente.setEnderecoCliente(scanner.nextLine());
					System.out.println("Telefone: ");
					cliente.setTelefone(scanner.nextLine().trim());

					clienteDAO.createClient(cliente);
					System.out.println("Cliente cadastrado com sucesso!");
					break;
				case 2:
					scanner.nextLine();


				    cliente = new Cliente();
					System.out.println("Escolha um dos seguintes destinos:");

					List<String> destinos = new ArrayList<>();
					destinos.add("Rio de Janeiro");
					destinos.add("Fernando de Noronha");
					destinos.add("Paris");
					destinos.add("Nova York");

					for (int i = 0; i < destinos.size(); i++) {
						System.out.println((i + 1) + ". " + destinos.get(i));
					}

					System.out.println("Escolha o número do destino desejado: ");
					int escolhaDestino = scanner.nextInt();

					if (escolhaDestino >= 1 && escolhaDestino <= destinos.size()) {
						String destinoEscolhido = destinos.get(escolhaDestino - 1);

						System.out.println("Data de partida (dd/mm/aaaa): ");
						String dataPartida = scanner.next();
						System.out.println("Número de pessoas: ");
						int numeroPessoas = scanner.nextInt();

						Reserva reserva = new Reserva();
						reserva.setIdCliente(cliente.getIdCliente());
						reserva.setDestino(destinoEscolhido);
						reserva.setDataPartida(dataPartida);
						reserva.setNumeroPessoas(numeroPessoas);

						reservaDAO.createReserva(reserva);

						System.out.println("Reserva criada com sucesso!");
					} else {
						System.out.println("Escolha de destino inválida.");
					}
					break;

				case 3:
					 cliente = null;

					scanner.nextLine();


					List<Reserva> reservas = reservaDAO.getReservasByCliente(cliente.getIdCliente());

					if (reservas.isEmpty()) {
						System.out.println("Nenhuma reserva encontrada para este cliente.");
					} else {
						System.out.println("Reservas para o cliente " + cliente.getNomeCliente() + ":");
						for (Reserva reserva : reservas) {
							System.out.println("----");
						}
					}
					break;

				case 4:
					System.out.println("Digite o ID da Reserva a ser deletada: ");
					int idReserva = scanner.nextInt();
					reservaDAO.deleteReserva(idReserva);
					System.out.println("Reserva deletada com sucesso!");
					break;
				case 5:
					System.out.println("Saindo do sistema. Até logo!");
					break;
				default:
					System.out.println("Opção inválida. Tente novamente.");
					break;
			}
		} while (option != 5);

		scanner.close();
	}

}
