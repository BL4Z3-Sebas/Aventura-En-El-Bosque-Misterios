package Vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.KeyEvent;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import musica.Audio;

/**
 *
 * @author Alfonso
 */
public class MainFrame extends javax.swing.JFrame {

    Audio bgAudio = new Audio("src/musica/Escape.wav", 10);

    public MainFrame() {
        bgAudio.loopSound();
        initComponents();
        cargarFondo();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlJuego = new javax.swing.JPanel();
        pnlMenu = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        lblJugar = new javax.swing.JLabel();
        lblAcercaDe = new javax.swing.JLabel();
        lblSalir = new javax.swing.JLabel();
        pnlArbol = new javax.swing.JPanel();
        pnlBackground = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlJuego.setOpaque(false);

        javax.swing.GroupLayout pnlJuegoLayout = new javax.swing.GroupLayout(pnlJuego);
        pnlJuego.setLayout(pnlJuegoLayout);
        pnlJuegoLayout.setHorizontalGroup(
            pnlJuegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1980, Short.MAX_VALUE)
        );
        pnlJuegoLayout.setVerticalGroup(
            pnlJuegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1080, Short.MAX_VALUE)
        );

        getContentPane().add(pnlJuego, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1980, 1080));

        pnlMenu.setBackground(new java.awt.Color(0, 0, 0));
        pnlMenu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTitulo.setFont(new java.awt.Font("Blackadder ITC", 0, 150)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(150, 150, 150));
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Fractalum");
        lblTitulo.setAlignmentY(0.0F);
        lblTitulo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblTitulo.setIconTextGap(0);
        pnlMenu.add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 330, 550, -1));

        lblJugar.setFont(new java.awt.Font("Blackadder ITC", 0, 48)); // NOI18N
        lblJugar.setForeground(new java.awt.Color(150, 150, 150));
        lblJugar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblJugar.setText("Jugar");
        lblJugar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblJugarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblJugarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblJugarMouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lblJugarMouseReleased(evt);
            }
        });
        pnlMenu.add(lblJugar, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 530, 300, 80));

        lblAcercaDe.setFont(new java.awt.Font("Blackadder ITC", 0, 48)); // NOI18N
        lblAcercaDe.setForeground(new java.awt.Color(150, 150, 150));
        lblAcercaDe.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAcercaDe.setText("Acerca de");
        lblAcercaDe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAcercaDeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblAcercaDeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblAcercaDeMouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lblAcercaDeMouseReleased(evt);
            }
        });
        pnlMenu.add(lblAcercaDe, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 630, 300, 80));

        lblSalir.setFont(new java.awt.Font("Blackadder ITC", 0, 48)); // NOI18N
        lblSalir.setForeground(new java.awt.Color(150, 150, 150));
        lblSalir.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSalir.setText("Salir");
        lblSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblSalirMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblSalirMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblSalirMouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lblSalirMouseReleased(evt);
            }
        });
        pnlMenu.add(lblSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 730, 300, 80));

        getContentPane().add(pnlMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 1080));
        getContentPane().add(pnlArbol, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 0, 1280, 1080));

        javax.swing.GroupLayout pnlBackgroundLayout = new javax.swing.GroupLayout(pnlBackground);
        pnlBackground.setLayout(pnlBackgroundLayout);
        pnlBackgroundLayout.setHorizontalGroup(
            pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnlBackgroundLayout.setVerticalGroup(
            pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        getContentPane().add(pnlBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1980, 1080));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyChar() == KeyEvent.VK_ESCAPE) {
            int sw = JOptionPane.showConfirmDialog(null,
                    "¿Deseas salir del juego?",
                    "Aviso",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.WARNING_MESSAGE);
            if (sw == 0) {
                System.exit(0);
            }
        }
    }//GEN-LAST:event_formKeyPressed

    private void lblJugarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblJugarMouseEntered
        // TODO add your handling code here:
        lblJugar.setBorder(BorderFactory.createLineBorder(Color.white, 2));
        lblJugar.setForeground(Color.white);
        lblJugar.setFont(new java.awt.Font("Blackadder ITC", 1, 54));
    }//GEN-LAST:event_lblJugarMouseEntered

    private void lblJugarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblJugarMouseExited
        // TODO add your handling code here:
        lblJugar.setBorder(null);
        lblJugar.setForeground(Paleta.GRIS_OSCURO.getColor());
        lblJugar.setFont(new java.awt.Font("Blackadder ITC", 0, 48));
    }//GEN-LAST:event_lblJugarMouseExited

    private void lblAcercaDeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAcercaDeMouseEntered
        // TODO add your handling code here:
        lblAcercaDe.setBorder(BorderFactory.createLineBorder(Color.white, 2));
        lblAcercaDe.setForeground(Color.white);
        lblAcercaDe.setFont(new java.awt.Font("Blackadder ITC", 1, 54));
    }//GEN-LAST:event_lblAcercaDeMouseEntered

    private void lblAcercaDeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAcercaDeMouseExited
        // TODO add your handling code here:
        lblAcercaDe.setBorder(null);
        lblAcercaDe.setForeground(Paleta.GRIS_OSCURO.getColor());
        lblAcercaDe.setFont(new java.awt.Font("Blackadder ITC", 0, 48));
    }//GEN-LAST:event_lblAcercaDeMouseExited

    private void lblSalirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSalirMouseEntered
        // TODO add your handling code here:
        lblSalir.setBorder(BorderFactory.createLineBorder(Color.white, 2));
        lblSalir.setForeground(Color.white);
        lblSalir.setFont(new java.awt.Font("Blackadder ITC", 1, 54));
    }//GEN-LAST:event_lblSalirMouseEntered

    private void lblSalirMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSalirMouseExited
        // TODO add your handling code here:
        lblSalir.setBorder(null);
        lblSalir.setForeground(Paleta.GRIS_OSCURO.getColor());
        lblSalir.setFont(new java.awt.Font("Blackadder ITC", 0, 48));
    }//GEN-LAST:event_lblSalirMouseExited

    private void lblSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSalirMouseClicked
        // TODO add your handling code here:
        bgAudio.stopSound();
        System.exit(0);
    }//GEN-LAST:event_lblSalirMouseClicked

    private void lblSalirMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSalirMouseReleased
        // TODO add your handling code here:
        if (lblSalir.contains(evt.getX(), evt.getY())) {
            lblSalirMouseClicked(evt);
        }
    }//GEN-LAST:event_lblSalirMouseReleased

    private void lblAcercaDeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAcercaDeMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lblAcercaDeMouseClicked

    private void lblAcercaDeMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAcercaDeMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_lblAcercaDeMouseReleased

    private void lblJugarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblJugarMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lblJugarMouseClicked

    private void lblJugarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblJugarMouseReleased
        // TODO add your handling code here:
        pnlMenu.setVisible(false);
        pnlArbol.setVisible(false);
        MenuPanel menu = new MenuPanel();
        menu.setLocation(0, 0);
        menu.setSize(1980, 1080);
        pnlJuego.add(menu);
        pnlJuego.revalidate();
        pnlJuego.repaint();
    }//GEN-LAST:event_lblJugarMouseReleased

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
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblAcercaDe;
    private javax.swing.JLabel lblJugar;
    private javax.swing.JLabel lblSalir;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel pnlArbol;
    private javax.swing.JPanel pnlBackground;
    private javax.swing.JPanel pnlJuego;
    private javax.swing.JPanel pnlMenu;
    // End of variables declaration//GEN-END:variables

    private void cargarFondo() {
        RecursiveTree treePanel = new RecursiveTree();

//        treePanel.setLocation(0, 0);
        pnlArbol.setLayout(new BorderLayout());
        pnlArbol.add(treePanel);

        pnlArbol.revalidate();
        pnlArbol.repaint();
    }
}
