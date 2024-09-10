package aula;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AlunoTest {

    @Test
    public void testConstructor() {
        Aluno aluno = new Aluno("Carlos Silva", 20, 5, 2000);
        Assertions.assertEquals("Carlos Silva", aluno.getNome());
        Assertions.assertEquals(20, aluno.getIdade());
        Assertions.assertEquals(5, aluno.getMes());
        Assertions.assertEquals(2000, aluno.getAno());
    }

    @Test
    public void testSetNome() {
        Aluno aluno = new Aluno("Carlos Silva", 20, 5, 2000);
        Assertions.assertFalse(aluno.setNome(null));
        Assertions.assertFalse(aluno.setNome(""));
        Assertions.assertFalse(aluno.setNome("Ana"));
        Assertions.assertFalse(aluno.setNome("A".repeat(51)));
        Assertions.assertTrue(aluno.setNome("Maria Joaquina"));
        Assertions.assertEquals("Maria Joaquina", aluno.getNome());
    }

    @Test
    public void testSetIdade() {
        Aluno aluno = new Aluno("Carlos Silva", 20, 5, 2000);
        Assertions.assertFalse(aluno.setIdade(0));
        Assertions.assertFalse(aluno.setIdade(151));
        Assertions.assertTrue(aluno.setIdade(25));
        Assertions.assertEquals(25, aluno.getIdade());
    }

    @Test
    public void testSetMes() {
        Aluno aluno = new Aluno("Carlos Silva", 20, 5, 2000);
        Assertions.assertFalse(aluno.setMes(0));
        Assertions.assertFalse(aluno.setMes(13));
        Assertions.assertTrue(aluno.setMes(6));
        Assertions.assertEquals(6, aluno.getMes());
    }

    @Test
    public void testSetAno() {
        Aluno aluno = new Aluno("Carlos Silva", 20, 5, 2000);
        Assertions.assertFalse(aluno.setAno(1899));
        Assertions.assertFalse(aluno.setAno(2025));
        Assertions.assertTrue(aluno.setAno(1999));
        Assertions.assertEquals(1999, aluno.getAno());
    }

    
}