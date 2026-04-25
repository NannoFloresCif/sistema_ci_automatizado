package com.automatizacion;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class CalculadoraTest {

    @Test
    public void testSumar() {
        // 1. Preparación (Arrange)
        Calculadora calc = new Calculadora();

        // 2. Ejecución (Act)
        int resultado = calc.sumar(5, 3);

        // 3. Verificación (Assert)
        assertEquals(8, resultado, "La suma de 5 + 3 debe ser 8");
    }

    @Test
    public void testRestar() {
        Calculadora calc = new Calculadora();
        int resultado = calc.restar(10, 4);
        assertEquals(6, resultado, "La resta de 10 - 4 debe ser 6");
    }
    
}
