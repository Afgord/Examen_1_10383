/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.examenunidad1_retiroefectivo;

import com.mycompany.examenunidad1_retiroefectivo.controller.RetiroController;
import com.mycompany.examenunidad1_retiroefectivo.domain.Cliente;
import com.mycompany.examenunidad1_retiroefectivo.domain.Cuenta;
import com.mycompany.examenunidad1_retiroefectivo.facade.SistemaBancarioFacade;
import com.mycompany.examenunidad1_retiroefectivo.model.RetiroModel;
import com.mycompany.examenunidad1_retiroefectivo.ui.frmRetiroEfectivo;
import javax.swing.SwingUtilities;

/**
 * Esta es la clase principal donde se ensamblan y configuran todos los componentes 
 * del sistema de retiro de efectivo.
 * 
 * Aquí se crean las entidades del dominio, se crea la fachada para desacoplar
 * el Modelo del dominio, se crea el MVC y se regista la Vista como Observer del
 * Modelo.
 * 
 * @author cmartinez
 */
public class ExamenUnidad1_RetiroEfectivo {

    /**
     * Método main para ejecutar la aplicación.
     * @param args
     */
    public static void main(String[] args) {
        
        // Ejecuta la UI en el Event Dispatch Thread
        SwingUtilities.invokeLater(() -> {

            // Objetos del Dominio
            Cliente cliente = new Cliente("Christian Martínez");
            Cuenta cuenta = new Cuenta("1234567890", 10000.00);

            // Objeto Fachada
            SistemaBancarioFacade facade =
                    new SistemaBancarioFacade(cuenta, cliente);

            // Objeto Modelo
            RetiroModel model = new RetiroModel(facade);

            // Objeto Controller
            RetiroController controller = new RetiroController(model);
            
            // Objeto Vista
            frmRetiroEfectivo frm =
                    new frmRetiroEfectivo(controller);

            // Objeto Observer
            model.setObserver(frm);

            // Se visualiza el formulario
            frm.setVisible(true);
        });
    }
}
