package com.desarrollodeaplicaciones.ejercicio2;

/**
 * Created by Irbing on 18/01/2017.
 */

public class Persona {
    private String nombre;
    private double peso;
    private double estatura;
    private char sexo;
    private byte ejercicio;
    private double imc;
    private String status;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getEstatura() {
        return estatura;
    }

    public void setEstatura(double estatura) {
        this.estatura = estatura;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public byte getEjercicio() {
        return ejercicio;
    }

    public void setEjercicio(byte ejercicio) {
        this.ejercicio = ejercicio;
    }

    public double getImc() {
        return imc;
    }

    public void calcularImc(){
        imc=peso/(estatura*estatura);
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", peso=" + peso +
                ", estatura=" + estatura +
                ", sexo=" + sexo +
                ", ejercicio=" + ejercicio +
                ", imc=" + imc +
                ", status='" + status + '\'' +
                '}';
    }
}