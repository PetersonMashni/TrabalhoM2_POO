/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemabancario;

import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author Peterson Mashni
 */
public class FrmImpressora extends FrmPadrao implements Observer {

    /**
     * Creates new form FrmImpressora
     */
    public FrmImpressora(FrmPrincipal frmPrincipal){
        super(frmPrincipal);
        initComponents();
        frmPrincipal.getImpressoraTela().addObserver(this);
        update(frmPrincipal.getImpressoraTela(), null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        txtImpressora = new javax.swing.JTextArea();

        setTitle("Impressora em Tela");
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosed(evt);
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        txtImpressora.setEditable(false);
        txtImpressora.setColumns(80);
        txtImpressora.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        txtImpressora.setRows(5);
        jScrollPane1.setViewportView(txtImpressora);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 394, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
        frmPrincipal.getImpressoraTela().deleteObserver(this);
    }//GEN-LAST:event_formInternalFrameClosed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtImpressora;
    // End of variables declaration//GEN-END:variables

    @Override
    public void update(Observable o, Object o1) {
        ImpressoraTela impressoraTela = (ImpressoraTela)o;
        
        txtImpressora.setText(impressoraTela.getBuffer().toString());
    }
}
