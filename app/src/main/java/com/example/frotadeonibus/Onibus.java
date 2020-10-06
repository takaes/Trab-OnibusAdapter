package com.example.frotadeonibus;

import android.widget.Spinner;

public class Onibus {
    private String nome;
    private String marca;
    private String modelo;
    private String origDest;
    private String tipo;
    private int quantLugar;
    private int quantLugarZero;

    public Onibus(){

    }

    public Onibus(String nome, String marca, String modelo, String origDest, String tipo, int quantLugar, int quantLugarZero) {
        this.nome = nome;
        this.marca = marca;
        this.modelo = modelo;
        this.origDest = origDest;
        this.tipo = tipo;
        this.quantLugar = quantLugar;
        this.quantLugarZero = quantLugarZero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getOrigDest() {
        return origDest;
    }

    public void setOrigDest(String origDest) {
        this.origDest = origDest;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getQuantLugar() {
        return quantLugar;
    }

    public void setQuantLugar(int quantLugar) {
        this.quantLugar = quantLugar;
    }

    public int getQuantLugarZero() {
        return quantLugarZero;
    }

    public void setQuantLugarZero(int quantLugarZero) {
        this.quantLugarZero = quantLugarZero;
    }


}
