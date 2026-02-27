/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.examenunidad1_retiroefectivo.domain;

/**
 *
 * La clase Cuenta representa una cuenta bancaria.
 * Tiene la responsabilidad de mantener el estado de la cuenta bancaria, es decir,
 * el saldo actual y el número de cuenta. Así mismo, esta clase se encarga de la 
 * lógica de negocio a la hora de retirar efectivo de la cuenta, calcular la comisión
 * y actualizar el saldo.
 * 
 * @author cmartinez
 */
public class Cuenta {
   
    /**
     * El atributo numero refiere al número de cuenta del cliente y se utiliza
     * únicamente para imprimirlo en pantalla.
     * El atributo saldo se usa para mostrar el saldo actual de la cuenta, así como
     * sus actualizaciones a la hora de retirar efectivo y aplicar comisión.
     */
    private final String numero;
    private double saldo;

    /**
     * Constructor de la clase Cuenta que recibe como parámetros el numero
     * de cuenta y el saldo de la cuenta.
     * @param numero  Número de cuenta del cliente
     * @param saldo Saldo inicial de la cuenta del cliente
     * 
     */
    public Cuenta(String numero, double saldo) {
        this.numero = numero;
        this.saldo = saldo;
    }

    /**
     * Obtiene el saldo actual de la cuenta
     * @return saldo
     */
    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    
    /**
     * Este método devuelve los últimos cuatro dígitos de la cuenta del cliente.
     * Esto se hace para respetar la regla de negocio indicada en el ejercicio.
     * 
     * @return Devuelve los últimos cuatro dígitos del número de cuenta del cliente.
     */
    public String ultimos4(){
        if(numero == null)
            return "----";
        
        String n = numero.trim();
        
        if(n.length() <= 4)
            return n;
        
        return n.substring(n.length() - 4);
    }
    
    /**
     * Este método calcula la comisión a cobrar por el trámite de retiro de
     * efectivo.  Para este ejercicio se dejó comisión fija de $10.00.
     * 
     * @param monto Cantidad seleccionada para retirar.
     * @return Devuelve el costo de comisión por el trámite.
     */
    public double calcularComision(int monto){
        return 10.00;
    }
    
    /**
     * Este método genera una vista previa del retiro sin alterar el saldo actual
     * de la cuenta. Gracias a esto es que se puede mostrar al cliente la información
     * del monto, la comisión y el saldo final proyectados después del trámite.
     * 
     * @param monto Cantidad que se desea retirar
     * @param nombreCliente Nombre del cliente a mostrar en la vista previa.
     * @return objeto con la información de la vista previa del retiro.
     */
    public PreviewRetiro previsualizarRetiro(int monto, String nombreCliente){
        double comision = calcularComision(monto);
        
        double saldoFinal = saldo - monto - comision;
        
        return new PreviewRetiro(nombreCliente, saldo, monto, comision, saldoFinal);
    }
    
    /**
     * Realiza el retiro y actualiza el saldo de la cuenta del cliente descontando
     * el monto retirado y la comisión por el trámite.
     * 
     * @param monto Cantidad que se retira.
     * @param nombreCliente nombre del cliente
     * @return recibo del retiro realizado
     */
    public ReciboRetiro retirar(int monto, String nombreCliente){
        double comision = calcularComision(monto);
        
        saldo = saldo - monto - comision;
        
        return new ReciboRetiro(ultimos4(), nombreCliente, monto, comision);
    }
    
}
