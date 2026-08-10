package com.astrea.core;

import static org.junit.Assert.*;
import org.junit.Test;
public class NaveEspacialTest {

    @Test 
    public void crearNaveCargaCorrectamente() throws AstreaException{
        NaveCarga naveCarga = new NaveCarga(
            "NC-001", 
            "Mortero", 
            100, 
            300, 
            "Especial", 
            900, 
            1000
        );
        assertEquals("NC-001", naveCarga.getMatricula());
        assertEquals("Mortero", naveCarga.getModelo());
        assertEquals(100.0, naveCarga.getCombustible(), 0.001);
        assertEquals(300, naveCarga.getCapacidadCombustible(),0.001);
        assertEquals(900, naveCarga.getCargaActual(), 0.001);
        assertEquals(1000, naveCarga.getCargaMaxima(), 0.001);


    }
    @Test
    public void crearNaveExploracionCorectamente() throws AstreaException{
        NaveExploracion naveExploracion = new NaveExploracion(
        "NE-001",
        "Exploradora",
        400,
        900,
        "Especial"
    );
    assertEquals("NE-001", naveExploracion.getMatricula());
    assertEquals("Exploradora", naveExploracion.getModelo());
    assertEquals(400, naveExploracion.getCombustible(), 0.001);
    assertEquals(900, naveExploracion.getCapacidadCombustible(), 0.001);
    assertEquals("Especial", naveExploracion.getTipoCombustible());

    }
    @Test
    public void crearNavecargaArribadeMaximoCombustible() throws AstreaException{
         NaveCarga naveCarga = new NaveCarga(
            "NC-001", 
            "Mortero", 
            100, 
            300, 
            "Especial", 
            900, 
            1000
        );
        assertEquals("NC-001", naveCarga.getMatricula());
    }
    @Test
    public void crearNaveNavegacionArribadeMaximoDeviaje() throws AstreaException{
        NaveExploracion naveExploracion = new NaveExploracion(
        "NC-004", 
        "Exploradora", 
        900, 
        1000, 
        "Especial"
    );
    assertThrows(
        CombustibleInsuficienteException.class, 
        ()-> naveExploracion.viajar(1000000
        )
    );
}
    @Test
    public void crearNaveExploracionCombustibleMasDeLimite() throws AstreaException{
        assertThrows(AstreaException.class, ()->{
            NaveExploracion naveExploracion = new NaveExploracion(
            "NC-004", 
            "Exploradora", 
            20000, 
            1000, 
            "Especial");
        }
    );
    }
    @Test
    public void cargaInvalida () throws AstreaException{
        assertThrows(AstreaException.class, ()->{
            NaveCarga naveCarga = new NaveCarga(
            "NC-005", 
            "Carguera", 
            900, 
            1000, 
            "Especial", 
            10000000, 
            1000);
        });
    }
    @Test
    public void repostarCombustible0() throws AstreaException {
    NaveExploracion naveExploracion = new NaveExploracion(
        "NC-006",
        "Exploradora",
        900,
        1000,
        "Especial"
    );

    assertThrows(AstreaException.class, () -> {
        naveExploracion.repostarCombustible(0);
    });
    }
    @Test
    public void tipoCombustibleNulo() throws AstreaException{
        assertThrows(AstreaException.class, ()->{
            NaveExploracion naveExploracion = new NaveExploracion(
            "NC-008", 
            "Exploradora", 
            900, 
            1000, 
            null
        );
        }
    );
    }
    @Test 
    public void activarHiperviajeFallido() throws AstreaException{
        NaveExploracion naveExploracion = new NaveExploracion(
        "NC-002", 
        "Exploradora", 
        30, 
        1000, 
        "Especial"
    );
    assertThrows(AstreaException.class, ()->{
        naveExploracion.activarHiperViaje(naveExploracion.getCombustible());
    });
    }
    @Test
    public void impacto() throws AstreaException{
        NaveExploracion naveExploracion = new NaveExploracion(
        "NC-001", 
        "Exploradora", 
        900, 
        1000, 
        "Especial"
    );
    assertThrows(AstreaException.class, ()->{
        naveExploracion.recibirImpacto(200);
    });

    }
    @Test 
    public void repostarinvalido() throws AstreaException{
        NaveCarga naveCarga = new NaveCarga(
        "NC-001", 
        "Cargero", 
        900, 
        1000, 
        "Especial", 
        900, 
        2000
    );
    assertThrows(AstreaException.class, ()->{
        naveCarga.repostarCombustible(100000000);
    });
    }

}
