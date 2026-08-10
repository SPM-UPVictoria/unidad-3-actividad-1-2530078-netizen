package com.astrea.core;

import java.util.Random;

public class NaveExploracion  extends NaveEspacial implements Defendible, Propulsable{
    private double integridadEscudo;
    private boolean hiperviajeListo;
    public NaveExploracion(
            String matricula,
            String modelo,
            double combustibleInicial,
            double capacidadCombustible,
            String tipoCombustible) throws AstreaException{
                super(matricula, modelo, combustibleInicial, capacidadCombustible, tipoCombustible);
                this.integridadEscudo = 100.0;
                this.hiperviajeListo = false;
            }
            public double getIntegridadEscudo(){
                return this.integridadEscudo;
            }
            public boolean getHiperviajeListo(){
                return this.hiperviajeListo;
            }
        @Override 
        public void viajar (double distanciaAñosluz)throws CombustibleInsuficienteException, AstreaException{
            if (distanciaAñosluz <=0){
                throw new AstreaException(
                    "la distancia debe ser mayor a 0"
                );
            }

            double consumoPorAñoLuz = 0.8;
            double combustibleNecesario = distanciaAñosluz * consumoPorAñoLuz;
            if (combustible < combustibleNecesario){
                throw new CombustibleInsuficienteException(
                    "Combustible insuficiente para el viaje"
                );
            }
            combustible -=  combustibleNecesario;
            
        }
        @Override
        public void activarHiperViaje( double factorWarp)throws FallaSistemasException, CombustibleInsuficienteException{
            if (combustible < 50.0){
                throw new CombustibleInsuficienteException(
                    "Combustible insuficiente"
                );
            }
            combustible-=50.0;
            if (factorWarp < 9.0){
                Random random = new  Random();
                if (random.nextDouble() < 0.30){
                    hiperviajeListo = false;
                    throw new FallaSistemasException(
                        "Falla en el nucleo de salto"
                    );
                }
            }
            hiperviajeListo = true;
        }
        @Override
        public void recibirImpacto(double potenciaDano)throws EscudoCriticoException{
            if (integridadEscudo <=0){
                throw new EscudoCriticoException(
                    "El escudo esta inhabilitado"
                );
            }
            if (potenciaDano <0){
                throw new EscudoCriticoException(
                    "La potencia  del daño"
                );

            }
            integridadEscudo -= potenciaDano;
            if (integridadEscudo <0){
                integridadEscudo = 0;
                throw new EscudoCriticoException(
                    "La integridad del escudo  ha llegado a nivel critico"
                );
            }
        }
}
