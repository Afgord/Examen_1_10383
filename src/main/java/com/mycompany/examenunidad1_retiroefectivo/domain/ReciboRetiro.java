/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.examenunidad1_retiroefectivo.domain;

/**
 * La clase ReciboRetiro es una clase DTO que representa el recibo mostrado
 * en pantalla al usuario después de retirar el monto deseado.
 * 
 * @author cmartinez
 */
public class ReciboRetiro {
    
    private final String ultimos4;
    private final String nombre;
    private final int montoRetirado;
    private final double comision;

    /**
     * Constructor de la clase ReciboRetiro que recibe como parámetros:
     * @param ultimos4 Los últimos cuatro dígitos del número de cuenta del cliente
     * @param nombre El nombre del cliente
     * @param montoRetirado El monto retirado
     * @param comision La comisión aplicada por el trámite
     */
    public ReciboRetiro(String ultimos4, String nombre, int montoRetirado, double comision) {
        this.ultimos4 = ultimos4;
        this.nombre = nombre;
        this.montoRetirado = montoRetirado;
        this.comision = comision;
    }

    /**
     * @return Los últimos cuatro dígitos del número de cuenta del cliente
     */
    public String getUltimos4() {
        return ultimos4;
    }

    /**
     * @return El nombre del cliente
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @return El monto retirado
     */
    public int getMontoRetirado() {
        return montoRetirado;
    }

    /**
     * @return La comisión aplicada
     */
    public double getComision() {
        return comision;
    }

}
