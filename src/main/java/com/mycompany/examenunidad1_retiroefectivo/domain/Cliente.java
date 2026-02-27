/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.examenunidad1_retiroefectivo.domain;

/**
 *
 * La clase Cliente es una entidad del dominio que representa al Cliente del
 * sistema; sin embargo, su única función es mantener la información básica del
 * cliente para este CU.
 *
 * No contiene lógica de negocio ya que su responsabilidad se limita a representar
 * los datos del cliente, en esta caso en concreto, su nombre para efectos de
 * visualización en la vista previa.
 * 
 * @author cmartinez
 */
public class Cliente {
    
    /**
     * Nombre del cliente
     */
    private final String nombre;

    /**
     * Crea un cliente con el nombre especificado.
     * @param nombre Nombre completo del cliente
     */
    public Cliente(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el nombre del cliente
     * @return Nombre del cliente
     */
    public String getNombre() {
        return nombre;
    }
}
