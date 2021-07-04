package com.prueba.fernandez.tipo.cambio.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tipo_cambio")
public class TipoCambio implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "origen")
    private String monedaOrigen;

    @Column(name = "destino")
    private String monedaDestino;

    @Column(name = "valor")
    private double valor;

    @Column(name = "signo")
    private String signo;

    public TipoCambio() {
    }

    public TipoCambio(long id, String monedaOrigen, String monedaDestino, double valor, String signo) {
        this.id = id;
        this.monedaOrigen = monedaOrigen;
        this.monedaDestino = monedaDestino;
        this.valor = valor;
        this.signo = signo;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getSigno() {
        return signo;
    }

    public void setSigno(String signo) {
        this.signo = signo;
    }
}
