package com.astrea.core;
public class NaveCarga extends NaveEspacial {
    private double cargaActual;
    private double cargaMaxima;

    NaveCarga(
        String matricula,
        String modelo,
        double combustibleInicial,
        double capacidadCombustible,
        String tipoCombustible,
        double cargaActual,
        double cargaMaxima
    ) throws AstreaException{
        super(
            matricula,
            modelo,
            combustibleInicial,
            capacidadCombustible,
            tipoCombustible

        
        );
        if (cargaMaxima <=0){
            throw new AstreaException(
                "La carga maxima debe ser mayor a 0"
            );
        }
        if (cargaActual<0){
            throw new AstreaException(
                "La carga actual debe ser mayor a 0"
            );
        }
        if (cargaActual > cargaMaxima){
            throw new AstreaException(
                    "La carga no debe superar a la carga maxima"
            );
        }
        this.cargaActual = cargaActual;
        this.cargaMaxima = cargaMaxima;


    }
    public double getCargaActual (){
        return this.cargaActual =cargaActual;
    }
    public double getCargaMaxima (){
        return this.cargaMaxima;
    }
    @Override
    public void viajar(double distanciaAñosluz)
            throws AstreaException, CombustibleInsuficienteException {

        if (distanciaAñosluz <= 0) {
            throw new AstreaException(
                "La distancia debe ser mayor a 0"
            );
        }

        double consumoAñosLuz;

        if (cargaActual > cargaMaxima * 0.50) {
            consumoAñosLuz = 3.0;
        } else {
            consumoAñosLuz = 1.5;
        }

        double combustibleNecesario =
            distanciaAñosluz * consumoAñosLuz;

        if (combustible < combustibleNecesario) {
            throw new CombustibleInsuficienteException(
                "Combustible insuficiente"
            );
        }

        combustible -= combustibleNecesario;
    }
}
