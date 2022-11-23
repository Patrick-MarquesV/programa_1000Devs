import java.sql.*;

public class CidadeDAO {

    private Connection conn;

    public CidadeDAO(){
        this.conn = new ConnectionFactory().getConnection();
    }

    public boolean insereCidade(Cidade cidade){

        String sql = "INSERT INTO cidades(nome, nro_habitantes, renda_per_capita, capital, estado, nome_prefeito) " +
                "VALUES(?, ?, ?, ?, ?, ?)";

        PreparedStatement stmt;

        try{
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, cidade.getNome());
            stmt.setLong(2, cidade.getNroHabitantes());
            stmt.setDouble(3, cidade.getRendaPerCapita());
            stmt.setBoolean(4, cidade.isCapital());
            stmt.setString(5, cidade.getEstado());
            stmt.setString(6, cidade.getNomePrefeito());
            stmt.execute();
            stmt.close();

            return true;

        } catch (SQLException e){
            System.err.println("Erro ao enviar os dados para DB");
            System.err.println(e.getMessage());
            return false;
        }
    }

    public boolean deletaCidade(int ddd){
        String sql = "DELETE FROM cidades " +
                "WHERE ddd = ?";

        PreparedStatement stmt;

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, ddd);
            stmt.execute();
            stmt.close();

        } catch (SQLException e) {
            System.err.println("Erro ao deletar dados da DB");
            System.err.println(e.getMessage());
            return false;
        }

        return true;
    }

    public boolean exibeCidades(){
        String query = "SELECT * FROM cidades ";

        Statement stmt;

        try {
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()){
                System.out.print(rs.getInt("ddd")+"\t");
                System.out.print(rs.getString("nome")+"\t");
                System.out.print(rs.getInt("nro_habitantes")+"\t");
                System.out.print(rs.getDouble("renda_per_capita")+"\t");
                System.out.print(rs.getBoolean("capital")+"\t");
                System.out.print(rs.getString("estado")+"\t");
                System.out.println(rs.getString("nome_prefeito"));

            }
            rs.close();

            return true;

        } catch (SQLException e) {
            System.err.println("Erro ao exibir dados da DB");
            System.err.println(e.getMessage());
            return false;
        }

    }

}
