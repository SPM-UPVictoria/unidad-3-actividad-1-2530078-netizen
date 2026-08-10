package com.astrea.core;

/**
 * InterfazPropulsable
 */
public interface Propulsable {

    void activarHiperViaje(double factorWarp) throws FallaSistemasException, CombustibleInsuficienteException;
}