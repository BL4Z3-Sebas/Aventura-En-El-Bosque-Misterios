package Vista;

import java.util.Arrays;
import java.util.Collections;
import niveles.GeneradorNiveles;
import niveles.Nivel;

/**
 *
 * @author cotes
 */
public class AcertijoFrame extends javax.swing.JFrame {

    public AcertijoFrame() {
        initComponents();
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
        TextArea1 = new javax.swing.JTextArea();
        Button1 = new javax.swing.JButton();
        Button2 = new javax.swing.JButton();
        Button3 = new javax.swing.JButton();
        Button4 = new javax.swing.JButton();
        RespuestaLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        TextArea1.setEditable(false);
        TextArea1.setColumns(20);
        TextArea1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        TextArea1.setRows(5);
        TextArea1.setAutoscrolls(false);
        TextArea1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane1.setViewportView(TextArea1);

        Button1.setBackground(new java.awt.Color(255, 0, 0));
        Button1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        Button1.setText("jButton1");
        Button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button1ActionPerformed(evt);
            }
        });

        Button2.setBackground(new java.awt.Color(51, 255, 51));
        Button2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        Button2.setText("jButton2");
        Button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button2ActionPerformed(evt);
            }
        });

        Button3.setBackground(new java.awt.Color(255, 255, 51));
        Button3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        Button3.setText("jButton3");
        Button3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button3ActionPerformed(evt);
            }
        });

        Button4.setBackground(new java.awt.Color(51, 51, 255));
        Button4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        Button4.setText("jButton4");
        Button4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button4ActionPerformed(evt);
            }
        });

        RespuestaLabel.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        RespuestaLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        RespuestaLabel.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(Button1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(RespuestaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(Button3, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addComponent(Button2, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Button4, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(87, 87, 87))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(RespuestaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Button1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Button3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Button2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Button4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void Button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button1ActionPerformed
        Nivel nivel = new Nivel();
        nivel = GeneradorNiveles.crearNivel(DialogoFrame.Nivel);

        if (nivel.getSolucion().equals(Button1.getText())) {
            RespuestaLabel.setText("Correcto");
        } else {
            RespuestaLabel.setText("Incorrecto");
        }
    }//GEN-LAST:event_Button1ActionPerformed

    private void Button2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button2ActionPerformed
        Nivel nivel = new Nivel();
        nivel = GeneradorNiveles.crearNivel(DialogoFrame.Nivel);

        if (nivel.getSolucion() == Button2.getText()) {
            RespuestaLabel.setText("Correcto");
        } else {
            RespuestaLabel.setText("Incorrecto");
        }
    }//GEN-LAST:event_Button2ActionPerformed

    private void Button3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button3ActionPerformed
        Nivel nivel = new Nivel();
        nivel = GeneradorNiveles.crearNivel(DialogoFrame.Nivel);

        if (nivel.getSolucion().equals(Button3.getText())) {
            RespuestaLabel.setText("Correcto");
        } else {
            RespuestaLabel.setText("Incorrecto");
        }
    }//GEN-LAST:event_Button3ActionPerformed

    private void Button4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button4ActionPerformed
        Nivel nivel = new Nivel();
        nivel = GeneradorNiveles.crearNivel(DialogoFrame.Nivel);

        if (nivel.getSolucion().equals(Button4.getText())) {
            RespuestaLabel.setText("Correcto");
        } else {
            RespuestaLabel.setText("Incorrecto");
        }
    }//GEN-LAST:event_Button4ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AcertijoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AcertijoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AcertijoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AcertijoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AcertijoFrame().setVisible(true);
            }
        });
    }

    public void mostrarAcertijo(Nivel nivel) {
        TextArea1.append("\n==================ACERTIJO=================" + "\n");

        TextArea1.append(nivel.getAcertijo().replace("+", "\n"));

        Collections.shuffle(Arrays.asList(nivel.getRespuetas()));
        String Respuesta[] = nivel.getRespuetas();
        Button1.setText(Respuesta[0]);
        Button2.setText(Respuesta[1]);
        Button3.setText(Respuesta[2]);
        Button4.setText(Respuesta[3]);

        //  TextArea1.append("Solucion: " + nivel.getSolucion());
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Button1;
    private javax.swing.JButton Button2;
    private javax.swing.JButton Button3;
    private javax.swing.JButton Button4;
    private javax.swing.JLabel RespuestaLabel;
    private javax.swing.JTextArea TextArea1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
