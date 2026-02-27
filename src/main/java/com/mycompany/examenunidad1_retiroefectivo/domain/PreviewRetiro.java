/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.examenunidad1_retiroefectivo.domain;

/**
 * La clase PreviewRetiro es un DTO que representa a vista previa de un retiro.
 * Su función es transportar la información necesaria para mostrar al usuario el
 * detalle del retiro antes de confirmarlo.
 * @author cmartinez
 */
public class PreviewRetiro {

    private final String nombre;
    private final double saldoActual;
    private final int monto;
    private final double comision;
    private final double saldoFinal;

    /**
     * Constructor de la clase PreviewRetiro que recibe como parámetros:
     * @param nombre Nombre del cliente
     * @param saldoActual saldo actual de la cuenta del cliente antes del retiro
     * @param monto monto seleccionado a retirar
     * @param comision comisión aplicada por el trámite de retiro
     * @param saldoFinal saldo final proyectado después de retirar el monto deseado
     * y aplicar la comisión correspondiente.
     */
    public PreviewRetiro(String nombre, double saldoActual, int monto, double comision, double saldoFinal) {
        this.nombre = nombre;
        this.saldoActual = saldoActual;
        this.monto = monto;
        this.comision = comision;
        this.saldoFinal = saldoFinal;
    }

    /**
     * @return Regresa el nombre del cliente
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @return regresa el saldo actual de la cuenta
     */
    public double getSaldoActual() {
        return saldoActual;
    }

    /**
     * @return regresa el monto deseado a retirar
     */
    public int getMonto() {
        return monto;
    }

    /**
     * @return regresa la comisión aplicada por el retiro
     */
    public double getComision() {
        return comision;
    }

    /**
     * @return regresa el saldo final proyectado al retirar el monto deseado
     */
    public double getSaldoFinal() {
        return saldoFinal;
    }

}
