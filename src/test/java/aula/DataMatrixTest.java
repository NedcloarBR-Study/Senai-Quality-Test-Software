package aps1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class DataMatrixTest {

    @Test
    public void testeExtracaoCode_med() {
        String codigo = "1234567890123A12345001234567890";
        DataMatrix dataMatrix = new DataMatrix(codigo);
        
        Assertions.assertEquals(codigo.substring(0, 13), dataMatrix.getCode_med());
    }

    @Test
    public void testeExtracaoDt_producao() {
        String codigo = "1234567890123A12345001234567890";
        DataMatrix dataMatrix = new DataMatrix(codigo);
        
        Assertions.assertEquals(12345, dataMatrix.getDt_producao());
    }

    @Test
    public void testeExtracaoSerial() {
        String codigo = "1234567890123A12345001234567890";
        DataMatrix dataMatrix = new DataMatrix(codigo);
        
        Assertions.assertEquals("0123", dataMatrix.getSerial());
    }

    @Test
    public void testeExtracaoLote() {
        String codigo = "1234567890123A12345001234567890";
        DataMatrix dataMatrix = new DataMatrix(codigo);
        
        Assertions.assertEquals(56789, dataMatrix.getLote());
    }

    @Test
    public void testeCodigoInvalidoComprimentoCurto() {
        String codigo = "1234567890123A12345001234567";
        DataMatrix dataMatrix = new DataMatrix(codigo);
        
        Assertions.assertFalse(dataMatrix.getIsValid());
    }
}
