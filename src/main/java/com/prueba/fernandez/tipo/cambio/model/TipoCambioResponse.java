package com.prueba.fernandez.tipo.cambio.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;

public class TipoCambioResponse {
    @JsonProperty("monto")
    private double monto;
    @JsonProperty("montoTipoCambio")
    private double valor;
    @JsonProperty("monedaOrigen")
    private String monedaOrigen;
    @JsonProperty("monedaDestino")
    private String monedaDestino;
    @JsonProperty("tipoCambio")
    private double tipoCambio;

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getMonedaOrigen() {
        return monedaOrigen;
    }

    public void setMonedaOrigen(String monedaOrigen) {
        this.monedaOrigen = monedaOrigen;
    }

    public String getMonedaDestino() {
        return monedaDestino;
    }

    public void setMonedaDestino(String monedaDestino) {
        this.monedaDestino = monedaDestino;
    }

    public double getTipoCambio() {
        return tipoCambio;
    }

    public void setTipoCambio(double tipoCambio) {
        this.tipoCambio = tipoCambio;
    }
}
