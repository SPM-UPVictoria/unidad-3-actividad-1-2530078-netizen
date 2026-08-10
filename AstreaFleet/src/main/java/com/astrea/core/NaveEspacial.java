package com.astrea.core;

public abstract class NaveEspacial {

    protected String matricula;
    protected String modelo;
    protected double combustible;
    protected double capacidadCombustible;
    protected String tipoCombustible;

    public NaveEspacial(
            String matricula,
            String modelo,
            double combustibleInicial,
            double capacidadCombustible,
            String tipoCombustible)
            throws AstreaException {

        if (matricula == null || matricula.isBlank()) {
            throw new AstreaException(
                    "La matricula no debe estar vacia");
        }

        if (modelo == null || modelo.isBlank()) {
            throw new AstreaException(
                    "El modelo no debe ser nulo o vacio");
        }

        if (combustibleInicial <= 0) {
            throw new AstreaException(
                    "El combustible inicial debe ser mayor a 0");
        }

        if (capacidadCombustible <= 0) {
            throw new AstreaException(
                    "La capacidad de combustible debe ser mayor a 0");
        }

        if (combustibleInicial > capacidadCombustible) {
            throw new AstreaException(
                    "El combustible inicial no debe ser mayor a la capacidad");
        }

        if (tipoCombustible == null || tipoCombustible.isBlank()) {
            throw new AstreaException(
                    "Necesita especificar el tipo de combustible");
        }

        this.matricula = matricula;
        this.modelo = modelo;
        this.combustible = combustibleInicial;
        this.capacidadCombustible = capacidadCombustible;
        this.tipoCombustible = tipoCombustible;
    }

    public String getMatricula() {
        return this.matricula;
    }

    public String getModelo() {
        return this.modelo;
    }

    public double getCombustible() {
        return this.combustible;
    }

    public double getCapacidadCombustible() {
        return this.capacidadCombustible;
    }

    public String getTipoCombustible() {
        return this.tipoCombustible;
    }
    public void repostarCombustible(double cantidad)throws AstreaException{
        if (cantidad <=0){
            throw new AstreaException(
                "La cantidad a repostar debe ser mayor a 0"
            );
        }
        if (cantidad + capacidadCombustible  > capacidadCombustible){
            throw new AstreaException(
                "La cantidad supera a la capacidad de la nave"
            );
        }
        if (tipoCombustible == null  || tipoCombustible.isBlank()){
            throw new AstreaException(
                "Debe escribir el tipo de combustible"
            );
        }
    combustible += cantidad;
    }

    public abstract void viajar (double distanciaAñosluz) throws CombustibleInsuficienteException,AstreaException;
}