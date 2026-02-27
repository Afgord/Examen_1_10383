/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.examenunidad1_retiroefectivo.ui;

import com.mycompany.examenunidad1_retiroefectivo.controller.RetiroController;
import com.mycompany.examenunidad1_retiroefectivo.domain.PreviewRetiro;
import com.mycompany.examenunidad1_retiroefectivo.domain.ReciboRetiro;
import com.mycompany.examenunidad1_retiroefectivo.observer.RetiroObserver;
import java.awt.*;
import java.text.DecimalFormat;
import javax.swing.*;

/**
 *
 * Esta clase es la Vista dentro del Modelo MVC.
 * Está dividida en dos parte, un panel izquierdo y un panel derecho.
 * En el panel izquierdo se presentan al Cliente las diferentes opciones de montos
 * a retirar en múltiplos de $200.00.  En el panel derecho se presentan la vista
 * previa de un retiro con la información correspondiente y, una vez realizada la
 * transacción, se presenta el recibo de la misma.
 * 
 * Cuando un evento ocurre en esta Vista, el mismo es recibido por el Controller, el
 * cual lo delega a la parte que debe atenderlo.  Una vez atendido el evento, la Vista
 * recibe esta actualización mediante el Observer.
 * 
 * @author cmartinez
 */
public class frmRetiroEfectivo extends javax.swing.JFrame implements RetiroObserver {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(frmRetiroEfectivo.class.getName());

    private final RetiroController controller;

    private final DefaultListModel<Integer> montosModel = new DefaultListModel<>();
    private final JList<Integer> lstMontos = new JList<>(montosModel);

    private final JTextArea txtDerecha = new JTextArea();
    private final JButton btnRetirar = new JButton("Retirar efectivo");

    private final DecimalFormat money = new DecimalFormat("#,##0.00");

    /**
     * Este es el constructor para el formulario de retiro de efectivo.
     * @param controller
     */
    public frmRetiroEfectivo(RetiroController controller) {
        initComponents();

        this.controller = controller;

        setTitle("Cajero - Retirar Efectivo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        construirUI();
        cargarMontos();

        pack();
        setLocationRelativeTo(null);

    }

    /**
     * Esta función construye la interfaz de usuario del formulario.
     */
    private void construirUI() {
        JPanel root = new JPanel(new BorderLayout(12, 12));
        root.setBorder(BorderFactory.createEmptyBorder(12, 12, 12, 12));
        setContentPane(root);

        // Este es el Panel izquierdo
        JPanel left = new JPanel(new BorderLayout(8, 8));
        left.setBorder(BorderFactory.createTitledBorder("Montos disponibles (múltiplos de 200)"));

        lstMontos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        lstMontos.setVisibleRowCount(8);
        lstMontos.setFixedCellHeight(28);
        lstMontos.setCellRenderer((list, value, index, isSelected, cellHasFocus) -> {
            JLabel lbl = new JLabel("$ " + money.format(value));
            lbl.setOpaque(true);
            lbl.setBorder(BorderFactory.createEmptyBorder(4, 8, 4, 8));
            if (isSelected) {
                lbl.setBackground(list.getSelectionBackground());
                lbl.setForeground(list.getSelectionForeground());
            } else {
                lbl.setBackground(list.getBackground());
                lbl.setForeground(list.getForeground());
            }
            return lbl;
        });

        lstMontos.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                Integer monto = lstMontos.getSelectedValue();
                if (monto != null) {
                    controller.seleccionarMonto(monto);
                    btnRetirar.setEnabled(true);
                }
            }
        });

        left.add(new JScrollPane(lstMontos), BorderLayout.CENTER);

        // Panel derecho
        JPanel right = new JPanel(new BorderLayout(8, 8));
        right.setBorder(BorderFactory.createTitledBorder("Detalle / Recibo"));

        txtDerecha.setEditable(false);
        txtDerecha.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 13));
        //txtDerecha.setText("Seleccione un monto para ver la vista previa...\n");

        right.add(new JScrollPane(txtDerecha), BorderLayout.CENTER);

        // Botón Retirar Efectivo
        btnRetirar.setEnabled(false);
        btnRetirar.addActionListener(e -> controller.confirmarRetiro());

        JPanel bottom = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        bottom.add(btnRetirar);

        // Agregar a root
        root.add(left, BorderLayout.WEST);
        root.add(right, BorderLayout.CENTER);
        root.add(bottom, BorderLayout.SOUTH);
        
        left.setPreferredSize(new Dimension(280, 320));
        right.setPreferredSize(new Dimension(420, 320));
    }

    /**
     * Esta función aplica una regla para la UI, no sustituye las reglas del
     * dominio.  Simplemente ayuda a cargar los montos disponibles para el retiro.
     * 
     */
    private void cargarMontos() {
        // Ejemplo: 200 a 2000
        for (int m = 200; m <= 2000; m += 200) {
            montosModel.addElement(m);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
//            logger.log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(() -> new frmRetiroEfectivo().setVisible(true));
//    }

    /**
     * Esta función es un callback del patrón Observer, el cual se ejecuta
     * cuando el Modelo notifica que la vista previa del retiro está lista
     * para ser visualizada.  La Vista presenta la información en pantalla.
     * 
     * @param preview de los datos de la vista previa
     */
    @Override
    public void onPreview(PreviewRetiro preview) {
        StringBuilder sb = new StringBuilder();
        sb.append("=== VISTA PREVIA DE RETIRO ===\n\n");
        sb.append("Nombre: ").append(preview.getNombre()).append("\n");
        sb.append("Saldo actual: $ ").append(money.format(preview.getSaldoActual())).append("\n");
        sb.append("Monto a retirar: $ ").append(money.format(preview.getMonto())).append("\n");
        sb.append("Comisión: $ ").append(money.format(preview.getComision())).append("\n");
        sb.append("Saldo final: $ ").append(money.format(preview.getSaldoFinal())).append("\n");

        txtDerecha.setText(sb.toString());
        txtDerecha.setCaretPosition(0);
    }

    /**
     * Esta función es un callback del patrón Observer, el cual se ejecuta
     * cuando el Modelo notifica que recibo del retiro está listo para ser 
     * visualizado.  La Vista presenta la información en pantalla.
     * 
     * @param recibo de los datos de la vista previa
     */
    @Override
    public void onRecibo(ReciboRetiro recibo) {
        StringBuilder sb = new StringBuilder();
        sb.append("=== RECIBO DE RETIRO ===\n\n");
        sb.append("Cuenta: ").append(recibo.getUltimos4()).append("\n");
        sb.append("Nombre: ").append(recibo.getNombre()).append("\n");
        sb.append("Cantidad retirada: $ ").append(money.format(recibo.getMontoRetirado())).append("\n");
        sb.append("Comisión: $ ").append(money.format(recibo.getComision())).append("\n");

        txtDerecha.setText(sb.toString());
        txtDerecha.setCaretPosition(0);

        // opcional: deshabilitar para evitar re-retiro sin volver a seleccionar
        btnRetirar.setEnabled(false);
        lstMontos.clearSelection();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
