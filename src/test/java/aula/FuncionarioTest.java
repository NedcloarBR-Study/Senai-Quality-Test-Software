package aula;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class FuncionarioDAOTest {

    private FuncionarioDAO funcionarioDAO;

    @BeforeEach
    public void setUp() {
        funcionarioDAO = new FuncionarioDAO();
    }

    @AfterEach
    public void tearDown() {
        try {
            funcionarioDAO.deletarTodos();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testInserirEProcurarFuncionario() throws SQLException {
        Funcionario funcionario = new Funcionario(0, "João Silva", "Vendas");
        funcionarioDAO.inserirFuncionario(funcionario);

        List<Funcionario> resultado = funcionarioDAO.buscarPeloNome("João");
        assertEquals(1, resultado.size());
        assertEquals("João Silva", resultado.get(0).getNome());
    }

    @Test
    public void testDeletarFuncionario() throws SQLException {
        Funcionario funcionario = new Funcionario(0, "Maria Oliveira", "TI");
        funcionarioDAO.inserirFuncionario(funcionario);

        List<Funcionario> resultado = funcionarioDAO.buscarPeloNome("Maria");
        assertEquals(1, resultado.size());

        funcionarioDAO.deletarFuncionario(resultado.get(0).getId());

        List<Funcionario> resultadoAposDelete = funcionarioDAO.buscarPeloNome("Maria");
        assertEquals(0, resultadoAposDelete.size());
    }
}
