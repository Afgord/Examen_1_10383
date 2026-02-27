/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.examenunidad1_retiroefectivo.model;

import com.mycompany.examenunidad1_retiroefectivo.domain.PreviewRetiro;
import com.mycompany.examenunidad1_retiroefectivo.domain.ReciboRetiro;
import com.mycompany.examenunidad1_retiroefectivo.facade.SistemaBancarioFacade;
import com.mycompany.examenunidad1_retiroefectivo.observer.RetiroObserver;

/**
 * Esta es la clase Modelo dentro del MVC.  Se encarga de preparar
 * la información requerida por la Vista para mostrar en pantalla.  Para ello
 * solicita esta información al dominio a través de la clase fachada.  Una vez
 * recibida y preparada esta información, la envía a la Vista a travez del patrón
 * Obsever.
 * 
 * No está en sus funciones implementar la reglas del negocio ni conoce los detalles
 * del UI.
 * @author cmartinez
 */
public class RetiroModel {
    
    /**
     * Objeto de tipo SistemaBancarioFacade para desacoplar el Modelo del dominio.
     */
    private final SistemaBancarioFacade facade;
    
    /**
     * Objeto RetiroObserver que recibe las actualizaciones por parte del Modelo
     * para reflejarlas en la vista.
     */
    private RetiroObserver observer;
    
    /**
     * Monto seleccionado por el Cliente.
     */
    private int montoSeleccionado;
    
    /**
     * Constructor de objeto RetiroModel que recibe como parámetro el objeto
     * facade e inicializa el monto seleccionado por el cliente.
     * @param facade Es la fachada del sistema bancario
     */
    public RetiroModel(SistemaBancarioFacade facade){
        this.facade = facade;
        this.montoSeleccionado = 0;
    }
    
    /**
     * Este método registra el observador que será notificado cuando existan
     * resultados para mostrar en la Vista.
     * @param observer Es el observador que recibirá las notificaciones de vista
     * previa y recibo.
     */
    public void setObserver(RetiroObserver observer){
        this.observer = observer;
    }
    
    /**
     * Este método solicita la información necesaria para mostrar la vista previa
     * del retiro.  Recibe como parámetro el monto a retirar.
     * Guarda el monto seleccionado, solicita a la fachada la vista previa por
     * parte del dominio y notifica a la Vista mediante el observador para que 
     * la muestre.
     * 
     * @param monto
     */
    public void previsualizarRetiro(int monto){
        this.montoSeleccionado = monto;
        PreviewRetiro preview = facade.previsualizarRetiro(monto);
        if(observer != null){
            observer.onPreview(preview);
        }
    }
    
    /**
     * Este método es el encargado de confirmar y ejecutar el retiro utilizando
     * el monto previamente seleccionado.
     * Solicita a la fachada que realice el retiro del monto seleccionado, recibe
     * el recibo generado por parte del dominio y lo notifica a la Vista a través
     * del observador.
     */
     public void realizarRetiro() {
        ReciboRetiro recibo = facade.realizarRetiro(montoSeleccionado);
        if (observer != null) {
            observer.onRecibo(recibo);
        }
    }
    
}
