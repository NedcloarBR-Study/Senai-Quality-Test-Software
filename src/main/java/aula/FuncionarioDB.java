import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDAO {
    private Connection connection;

    public FuncionarioDAO() {
        try {
            // Conectando ao banco H2 em memória
            connection = DriverManager.getConnection("jdbc:h2:mem:testdb", "sa", "");
            criarTabela();  // Criar a tabela quando o DAO for instanciado
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Criar a tabela de Funcionários
    private void criarTabela() throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS funcionario ("
                   + "id INT AUTO_INCREMENT PRIMARY KEY, "
                   + "nome VARCHAR(100) NOT NULL, "
                   + "setor VARCHAR(100) NOT NULL)";
        try (Statement stmt = connection.createStatement()) {
            stmt.execute(sql);
        }
    }

    public void inserirFuncionario(Funcionario funcionario) throws SQLException {
        String sql = "INSERT INTO funcionario (nome, setor) VALUES (?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, funcionario.getNome());
            statement.setString(2, funcionario.getSetor());
            statement.executeUpdate();
        }
    }

    public void deletarFuncionario(int id) throws SQLException {
        String sql = "DELETE FROM funcionario WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        }
    }

    public List<Funcionario> buscarPeloNome(String nome) throws SQLException {
        String sql = "SELECT * FROM funcionario WHERE nome LIKE ?";
        List<Funcionario> funcionarios = new ArrayList<>();

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, "%" + nome + "%");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Funcionario funcionario = new Funcionario(
                        resultSet.getInt("id"),
                        resultSet.getString("nome"),
                        resultSet.getString("setor")
                );
                funcionarios.add(funcionario);
            }
        }
        return funcionarios;
    }
}
