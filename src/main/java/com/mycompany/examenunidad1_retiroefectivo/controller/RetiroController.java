/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.examenunidad1_retiroefectivo.controller;

import com.mycompany.examenunidad1_retiroefectivo.model.RetiroModel;

/**
 * Esta es la clase Controller del MVC.  Tiene la responsabilidad de recibir
 * las acciones/eventos provenientes de la Vista y delegarlas al responsable de
 * atenderlas.
 * @author cmartinez
 */
public class RetiroController {

    /**
     * Atributo del MVC que gestiona la coordinación de operaciones y notificaciones
     * de la Vista.
     */
    private final RetiroModel model;

    /**
     * Contructor que crea el controlador con el modelo correspondiente como parámetro.
     * @param model Es el modelo encargado para "Retirar Efectivo"
     */
    public RetiroController(RetiroModel model) {
        this.model = model;
    }

    /**
     * Este método será el encargado de reaccionar al evento de selección  de un
     * monto a retirar por parte del Cliente.
     * 
     * @param monto Es el monto seleccionado por el usuario
     */
    public void seleccionarMonto(int monto) {
        model.previsualizarRetiro(monto);
    }

    /**
     * Este método se encarga de reaccionar al evento confirmar monto recibido
     * por parte del Cliente
     */
    public void confirmarRetiro() {
        model.realizarRetiro();
    }

}
