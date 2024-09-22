package Vista;



import Vista.EscenarioPanel;
import Vista.MainFrame;
import Vista.Paleta;
import java.awt.Color;
import javax.swing.BorderFactory;

/**
 *
 * @author Alfonso
 */
public class MenuPanel extends javax.swing.JPanel {

    /**
     * Creates new form MainPanel
     */
    public MenuPanel() {
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

        pnlMenu = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        lblJugar = new javax.swing.JLabel();
        lblAcercaDe = new javax.swing.JLabel();
        lblSalir = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        lblJugar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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
        lblAcercaDe.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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

        add(pnlMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 1080));
    }// </editor-fold>//GEN-END:initComponents

    private void lblSalirMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSalirMouseReleased
        // TODO add your handling code here:
        if (lblSalir.contains(evt.getX(), evt.getY())) {
            lblSalirMouseClicked(evt);
        }
    }//GEN-LAST:event_lblSalirMouseReleased

    private void lblSalirMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSalirMouseExited
        // TODO add your handling code here:
        lblSalir.setBorder(null);
        lblSalir.setForeground(Paleta.GRIS_OSCURO.getColor());
        lblSalir.setFont(new java.awt.Font("Blackadder ITC", 0, 48));
    }//GEN-LAST:event_lblSalirMouseExited

    private void lblSalirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSalirMouseEntered
        // TODO add your handling code here:
        lblSalir.setBorder(BorderFactory.createLineBorder(Color.white, 2));
        lblSalir.setForeground(Color.white);
        lblSalir.setFont(new java.awt.Font("Blackadder ITC", 1, 54));
    }//GEN-LAST:event_lblSalirMouseEntered

    private void lblSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSalirMouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_lblSalirMouseClicked

    private void lblAcercaDeMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAcercaDeMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_lblAcercaDeMouseReleased

    private void lblAcercaDeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAcercaDeMouseExited
        // TODO add your handling code here:
        lblAcercaDe.setBorder(null);
        lblAcercaDe.setForeground(Paleta.GRIS_OSCURO.getColor());
        lblAcercaDe.setFont(new java.awt.Font("Blackadder ITC", 0, 48));
    }//GEN-LAST:event_lblAcercaDeMouseExited

    private void lblAcercaDeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAcercaDeMouseEntered
        // TODO add your handling code here:
        lblAcercaDe.setBorder(BorderFactory.createLineBorder(Color.white, 2));
        lblAcercaDe.setForeground(Color.white);
        lblAcercaDe.setFont(new java.awt.Font("Blackadder ITC", 1, 54));
    }//GEN-LAST:event_lblAcercaDeMouseEntered

    private void lblAcercaDeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAcercaDeMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lblAcercaDeMouseClicked

    private void lblJugarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblJugarMouseReleased
        // TODO add your handling code here:
        pnlMenu.setVisible(false);
        EscenarioPanel menu = new EscenarioPanel();
        menu.setLocation(0, 0);
        menu.setSize(1980, 1080);
    }//GEN-LAST:event_lblJugarMouseReleased

    private void lblJugarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblJugarMouseExited
        // TODO add your handling code here:
        lblJugar.setBorder(null);
        lblJugar.setForeground(Paleta.GRIS_OSCURO.getColor());
        lblJugar.setFont(new java.awt.Font("Blackadder ITC", 0, 48));
    }//GEN-LAST:event_lblJugarMouseExited

    private void lblJugarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblJugarMouseEntered
        // TODO add your handling code here:
        lblJugar.setBorder(BorderFactory.createLineBorder(Color.white, 2));
        lblJugar.setForeground(Color.white);
        lblJugar.setFont(new java.awt.Font("Blackadder ITC", 1, 54));
    }//GEN-LAST:event_lblJugarMouseEntered

    private void lblJugarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblJugarMouseClicked
        // TODO add your handling code here:
        this.getParent().removeAll();
//        MainFrame.cargarJuego();

    }//GEN-LAST:event_lblJugarMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblAcercaDe;
    private javax.swing.JLabel lblJugar;
    private javax.swing.JLabel lblSalir;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel pnlMenu;
    // End of variables declaration//GEN-END:variables
}
