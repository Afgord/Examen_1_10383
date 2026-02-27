/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.examenunidad1_retiroefectivo.facade;

import com.mycompany.examenunidad1_retiroefectivo.domain.Cliente;
import com.mycompany.examenunidad1_retiroefectivo.domain.Cuenta;
import com.mycompany.examenunidad1_retiroefectivo.domain.PreviewRetiro;
import com.mycompany.examenunidad1_retiroefectivo.domain.ReciboRetiro;

/**
 * Esta es la clase fachada SistemaBancarioFacade. Su función es impedir que el
 * Modelo MVC conozca directamente a la entidades del dominio, en este caso, a
 * las entidades Cliente y Cuenta.  En lugar de eso, el Modelo se comunicará con
 * esta clase para solicitar la información necesaria para mostrar los resultados
 * esperados.
 * 
 * @author cmartinez
 */
public class SistemaBancarioFacade {
    
    /**
     * Se crea un objeto de la entidad Cuenta
     */
    private final Cuenta cuenta;
    
    /**
     * Se crea un objeto de la entidad Cliente
     */
    private final Cliente cliente;

    /**
     * Se construye un objeto de la clase SistemaBancarioFacade que recibe como
     * parámetros los objetos del dominio
     * @param cuenta
     * @param cliente
     */
    public SistemaBancarioFacade(Cuenta cuenta, Cliente cliente) {
        this.cuenta = cuenta;
        this.cliente = cliente;
    }
    
    /**
     * Se crea un objeto de la clase DTO PreviewRetiro llamada previsualizarRetiro
     * la cual recibe como parámetro el monto a retirar
     * @param monto
     * @return Retorna un objeto con la información para la vista previa: monto 
     * a retirar y el nombre del cliente.
     */
    public PreviewRetiro previsualizarRetiro(int monto){
        return cuenta.previsualizarRetiro(monto, cliente.getNombre());
    }
    
    /**
     * Se crea un objeto de la clase DTO ReciboRetiro llamada realizarRetiro
     * la cual recibe como parámetro el monto a retirar
     * @param monto
     * @return Retorna un objeto con la información para el recibo a mostrar
     * en pantalla: monto a retirar y el nombre del cliente.
     */
    public ReciboRetiro realizarRetiro(int monto){
        return cuenta.retirar(monto, cliente.getNombre());
    }
    
}
