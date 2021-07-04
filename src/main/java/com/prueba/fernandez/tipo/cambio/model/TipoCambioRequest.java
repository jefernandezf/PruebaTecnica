package com.prueba.fernandez.tipo.cambio.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TipoCambioRequest {
    @JsonProperty("monto")
    private double monto;
    @JsonProperty("monedaOrigen")
    private String origen;
    @JsonProperty("monedaDestino")
    private String destino;


    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }
}
