/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.examenunidad1_retiroefectivo.observer;

import com.mycompany.examenunidad1_retiroefectivo.domain.PreviewRetiro;
import com.mycompany.examenunidad1_retiroefectivo.domain.ReciboRetiro;

/**
 * Esta es la interfaz para el patrón Observer.  Permite que el Modelo MVC
 * notifique a la Vista cuando exista información nueva que deba mostrarse, en
 * este caso, la vista previa de un retiro y el recibo después de realizarlo.
 * 
 * @author cmartinez
 */
public interface RetiroObserver {
    
    /**
     * Este método envia una notificación cuando se genera la vista previa del retiro
     * @param preview vista previa con la información antes de realizar la transacción
     */
    void onPreview(PreviewRetiro preview);
    
    /**
     * Este método envia una notificación cuando se genera el recibo del retiro
     * @param recibo Es el recibo con la información posterior a la transacción
     */
    void onRecibo(ReciboRetiro recibo);
}
