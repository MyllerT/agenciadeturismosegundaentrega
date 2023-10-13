package com.agencia.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.agencia.model.Reserva;
public class ReservaDAO {
    private Connection connection;

    public ReservaDAO(Connection connection) {
        this.connection = connection;
    }

    public void createReserva(Reserva reserva) {
        try {
            String query = "INSERT INTO reservas (idCliente, dataReserva, duracaoDias) VALUES (?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, reserva.getIdCliente());
            preparedStatement.setDate(2, new java.sql.Date(reserva.getDataReserva().getTime()));

            preparedStatement.setInt(4, reserva.getDuracaoDias());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Reserva> getReservasByCliente(int idCliente) {
        List<Reserva> reservas = new ArrayList<>();
        try {
            String query = "SELECT * FROM reservas WHERE idCliente = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, idCliente);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Reserva reserva = new Reserva();
                reserva.setIdReserva(resultSet.getInt("idReserva"));
                reserva.setIdCliente(resultSet.getInt("idCliente"));
                reserva.setDataReserva(resultSet.getDate("dataReserva"));

                reserva.setDuracaoDias(resultSet.getInt("duracaoDias"));
                reservas.add(reserva);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reservas;
    }
    public void deleteReserva(int idReserva) {
        try {
            String query = "DELETE FROM reservas WHERE idReserva = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, idReserva);
            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Reserva com ID " + idReserva + " foi excluída com sucesso.");
            } else {
                System.out.println("Nenhuma reserva encontrada com o ID " + idReserva);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}








