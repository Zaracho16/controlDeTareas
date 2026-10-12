
package controldetareas.vista;

import controldetareas.dao.UsuarioDAO;
import javax.swing.JOptionPane;


public class CrearCuenta extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(CrearCuenta.class.getName());

    public CrearCuenta() {
        initComponents();
        
        setResizable(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblCrearCuenta = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        lblCorreo = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        lblPassword = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        btnCrearCuenta = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();
        lblIImagenFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        lblCrearCuenta.setFont(new java.awt.Font("Liberation Sans", 1, 24)); // NOI18N
        lblCrearCuenta.setText("Crear Cuenta");

        lblNombre.setForeground(new java.awt.Color(102, 102, 102));
        lblNombre.setText("Nombre");

        txtNombre.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtNombre.setMargin(new java.awt.Insets(4, 8, 4, 8));
        txtNombre.setMinimumSize(new java.awt.Dimension(64, 26));
        txtNombre.setPreferredSize(new java.awt.Dimension(100, 25));
        txtNombre.setRequestFocusEnabled(false);

        lblCorreo.setForeground(new java.awt.Color(102, 102, 102));
        lblCorreo.setText("Correo");

        txtCorreo.setMargin(new java.awt.Insets(4, 8, 4, 8));
        txtCorreo.setPreferredSize(new java.awt.Dimension(100, 25));
        txtCorreo.addActionListener(this::txtCorreoActionPerformed);

        lblPassword.setForeground(new java.awt.Color(102, 102, 102));
        lblPassword.setText("Contraseña");

        txtPassword.setMargin(new java.awt.Insets(4, 8, 4, 8));
        txtPassword.setPreferredSize(new java.awt.Dimension(100, 25));
        txtPassword.addActionListener(this::txtPasswordActionPerformed);

        btnCrearCuenta.setBackground(new java.awt.Color(0, 153, 204));
        btnCrearCuenta.setForeground(new java.awt.Color(255, 255, 255));
        btnCrearCuenta.setText("Crear");
        btnCrearCuenta.setMargin(new java.awt.Insets(6, 18, 6, 18));
        btnCrearCuenta.setMaximumSize(new java.awt.Dimension(114, 30));
        btnCrearCuenta.setMinimumSize(new java.awt.Dimension(114, 30));
        btnCrearCuenta.setPreferredSize(new java.awt.Dimension(114, 30));
        btnCrearCuenta.addActionListener(this::btnCrearCuentaActionPerformed);

        btnVolver.setText("Volver");
        btnVolver.addActionListener(this::btnVolverActionPerformed);

        lblIImagenFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/controldetareas/recursos/fondo-login.jpeg"))); // NOI18N
        lblIImagenFondo.setText("jLabel1");
        lblIImagenFondo.setPreferredSize(new java.awt.Dimension(410, 611));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblIImagenFondo, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnVolver)
                        .addGap(17, 17, 17))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCrearCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCorreo)
                            .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPassword)
                            .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(btnCrearCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(63, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(lblCrearCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(lblNombre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(lblCorreo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(lblPassword)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(btnCrearCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                .addComponent(btnVolver)
                .addGap(52, 52, 52))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblIImagenFondo, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCorreoActionPerformed

    }//GEN-LAST:event_txtCorreoActionPerformed

    private void btnCrearCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearCuentaActionPerformed
        
        String nombre = txtNombre.getText();
        String email = txtCorreo.getText();
        String password = new String(txtPassword.getPassword());
        
        if(nombre.isEmpty() || email.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debes completar todos los campos");
            return;
        }
        
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        
        boolean usuarioCreado = usuarioDAO.crearUsuario(nombre, email, password);
        
        if(usuarioCreado) {
            
            JOptionPane.showMessageDialog(this, "Cuenta creada correctamente");
            
            txtNombre.setText("");
            txtCorreo.setText("");
            txtPassword.setText("");
            
        } else {
            
            JOptionPane.showMessageDialog(this, "Error al crear la cuenta");
            
        }
        
    }//GEN-LAST:event_btnCrearCuentaActionPerformed

    private void txtPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPasswordActionPerformed
  
    }//GEN-LAST:event_txtPasswordActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        
        Login login = new Login();
        login.setVisible(true);
        
        this.dispose();
        
    }//GEN-LAST:event_btnVolverActionPerformed

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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new CrearCuenta().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCrearCuenta;
    private javax.swing.JButton btnVolver;
    private javax.swing.JLabel lblCorreo;
    private javax.swing.JLabel lblCrearCuenta;
    private javax.swing.JLabel lblIImagenFondo;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JPasswordField txtPassword;
    // End of variables declaration//GEN-END:variables
}
