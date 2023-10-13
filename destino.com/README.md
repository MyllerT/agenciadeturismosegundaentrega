# agenciaViagem2
<h1>Usuário e Reserva - Relação Um para Muitos (1:N):,</h1>

<p>No modelo lógico do meu projeto de site de viagens, temos uma relação de um para muitos entre as entidades "Usuário" e "Reserva".
Isso significa que cada instância da entidade "Usuário" pode estar associada a várias instâncias da entidade "Reserva".
Por exemplo, um usuário pode fazer várias reservas de viagens ao longo do tempo, e essas reservas são relacionadas a esse usuário.
Além disso, estabeleci uma relação um para um (1:1) entre a entidade "Reserva" e os "Detalhes de Viagem".
Isso significa que cada reserva está diretamente relacionada a um único conjunto de detalhes de viagem.
Essa relação permite armazenar informações específicas da reserva, como datas, preços e itinerários em detalhes de viagem associados à reserva correspondente.
Usuário - Avaliações (Usuário para Avaliações - Um para Muitos, 1:N):

Para capturar as avaliações que os usuários podem fazer sobre suas viagens, estabeleci uma relação de um para muitos (1:N) entre a entidade "Usuário" e "Avaliações".
Cada usuário pode fazer várias avaliações, mas cada avaliação está vinculada a um único usuário.
Isso permite que os usuários compartilhem suas experiências e opiniões sobre as viagens que reservaram.
</P>
