
package controldetareas.vista;

import controldetareas.dao.PrioridadDAO;
import controldetareas.modelo.Prioridad;
import controldetareas.modelo.Usuario;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class Prioridades extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Prioridades.class.getName());
    
    private Usuario usuario;
    private int idPrioridadSeleccionada = -1;

    public Prioridades(Usuario usuario) {
        
        initComponents();
        
        setLocationRelativeTo(null);
        setResizable(false);
        
        this.usuario = usuario;
        
        cargarPrioridades();
        
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelTitulos = new javax.swing.JPanel();
        lblTituloPrincipal = new javax.swing.JLabel();
        panelPrincipalPrioridades = new javax.swing.JPanel();
        lblNombrePrioridad = new javax.swing.JLabel();
        txtNombrePrioridad = new javax.swing.JTextField();
        btnGuardarPrioridad = new javax.swing.JButton();
        btnEditarPrioridad = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaPrioridadesRegistradas = new javax.swing.JTable();
        lblPrioridadesRegistradas = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        panelTitulos.setBackground(new java.awt.Color(16, 27, 48));
        panelTitulos.setForeground(new java.awt.Color(255, 255, 255));

        lblTituloPrincipal.setBackground(new java.awt.Color(255, 255, 255));
        lblTituloPrincipal.setFont(new java.awt.Font("Liberation Sans", 1, 24)); // NOI18N
        lblTituloPrincipal.setForeground(new java.awt.Color(255, 255, 255));
        lblTituloPrincipal.setText("Administrar Prioridades");

        javax.swing.GroupLayout panelTitulosLayout = new javax.swing.GroupLayout(panelTitulos);
        panelTitulos.setLayout(panelTitulosLayout);
        panelTitulosLayout.setHorizontalGroup(
            panelTitulosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTitulosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTituloPrincipal)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelTitulosLayout.setVerticalGroup(
            panelTitulosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTitulosLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(lblTituloPrincipal)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        panelPrincipalPrioridades.setBackground(new java.awt.Color(255, 255, 255));

        lblNombrePrioridad.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        lblNombrePrioridad.setForeground(new java.awt.Color(0, 0, 0));
        lblNombrePrioridad.setText("Nombre de la prioridad");

        txtNombrePrioridad.setBackground(new java.awt.Color(204, 204, 204));
        txtNombrePrioridad.setForeground(new java.awt.Color(0, 0, 0));
        txtNombrePrioridad.addActionListener(this::txtNombrePrioridadActionPerformed);

        btnGuardarPrioridad.setBackground(new java.awt.Color(0, 51, 153));
        btnGuardarPrioridad.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        btnGuardarPrioridad.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardarPrioridad.setText("Guardar");
        btnGuardarPrioridad.setFocusPainted(false);
        btnGuardarPrioridad.addActionListener(this::btnGuardarPrioridadActionPerformed);

        btnEditarPrioridad.setBackground(new java.awt.Color(0, 153, 153));
        btnEditarPrioridad.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        btnEditarPrioridad.setForeground(new java.awt.Color(255, 255, 255));
        btnEditarPrioridad.setText("Editar");
        btnEditarPrioridad.setFocusPainted(false);
        btnEditarPrioridad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEditarPrioridadMouseClicked(evt);
            }
        });
        btnEditarPrioridad.addActionListener(this::btnEditarPrioridadActionPerformed);

        btnEliminar.setBackground(new java.awt.Color(204, 0, 0));
        btnEliminar.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminar.setText("Eliminar");
        btnEliminar.setFocusPainted(false);
        btnEliminar.addActionListener(this::btnEliminarActionPerformed);

        tablaPrioridadesRegistradas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre"
            }
        ));
        tablaPrioridadesRegistradas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaPrioridadesRegistradasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaPrioridadesRegistradas);

        lblPrioridadesRegistradas.setBackground(new java.awt.Color(0, 0, 0));
        lblPrioridadesRegistradas.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        lblPrioridadesRegistradas.setForeground(new java.awt.Color(0, 0, 0));
        lblPrioridadesRegistradas.setText("Prioridades registradas");

        javax.swing.GroupLayout panelPrincipalPrioridadesLayout = new javax.swing.GroupLayout(panelPrincipalPrioridades);
        panelPrincipalPrioridades.setLayout(panelPrincipalPrioridadesLayout);
        panelPrincipalPrioridadesLayout.setHorizontalGroup(
            panelPrincipalPrioridadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalPrioridadesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelPrincipalPrioridadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelPrincipalPrioridadesLayout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPrincipalPrioridadesLayout.createSequentialGroup()
                        .addComponent(btnGuardarPrioridad, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                        .addGap(26, 26, 26)
                        .addComponent(btnEditarPrioridad, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(166, 166, 166))
                    .addGroup(panelPrincipalPrioridadesLayout.createSequentialGroup()
                        .addComponent(lblPrioridadesRegistradas)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panelPrincipalPrioridadesLayout.createSequentialGroup()
                        .addGroup(panelPrincipalPrioridadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNombrePrioridad, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNombrePrioridad, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        panelPrincipalPrioridadesLayout.setVerticalGroup(
            panelPrincipalPrioridadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalPrioridadesLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(lblNombrePrioridad, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtNombrePrioridad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelPrincipalPrioridadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardarPrioridad)
                    .addComponent(btnEditarPrioridad)
                    .addComponent(btnEliminar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(lblPrioridadesRegistradas)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelTitulos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelPrincipalPrioridades, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelTitulos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(panelPrincipalPrioridades, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombrePrioridadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombrePrioridadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombrePrioridadActionPerformed

    private void btnGuardarPrioridadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarPrioridadActionPerformed
       
        String nombre = txtNombrePrioridad.getText().trim();

        if (nombre.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Ingrese el nombre de la prioridad",
                    "Aviso",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        PrioridadDAO prioridadDAO = new PrioridadDAO();

        boolean guardado = prioridadDAO.guardarPrioridad(
                usuario.getId(),
                nombre
        );

        if (guardado) {
            JOptionPane.showMessageDialog(this,
                    "Prioridad registrada correctamente");

            txtNombrePrioridad.setText("");
            cargarPrioridades();

        } else {
            JOptionPane.showMessageDialog(this,
                    "No se pudo registrar la prioridad. Verifique que no exista otra con el mismo nombre.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_btnGuardarPrioridadActionPerformed

    private void btnEditarPrioridadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditarPrioridadMouseClicked

    }//GEN-LAST:event_btnEditarPrioridadMouseClicked

    private void btnEditarPrioridadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarPrioridadActionPerformed
       
        if (idPrioridadSeleccionada == -1) {
            JOptionPane.showMessageDialog(this,
                    "Seleccione una prioridad para editar",
                    "Aviso",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        String nombre = txtNombrePrioridad.getText().trim();

        if (nombre.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "El nombre de la prioridad no puede estar vacío",
                    "Aviso",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        PrioridadDAO prioridadDAO = new PrioridadDAO();

        boolean actualizado = prioridadDAO.actualizarPrioridad(
                idPrioridadSeleccionada,
                usuario.getId(),
                nombre
        );

        if (actualizado) {
            JOptionPane.showMessageDialog(this,
                    "Prioridad actualizada correctamente");

            txtNombrePrioridad.setText("");
            idPrioridadSeleccionada = -1;
            cargarPrioridades();

        } else {
            JOptionPane.showMessageDialog(this,
                    "No se pudo actualizar la prioridad. Verifique que no exista otra con el mismo nombre.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_btnEditarPrioridadActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
      
        if (idPrioridadSeleccionada == -1) {
            JOptionPane.showMessageDialog(this,
                    "Seleccione una prioridad para eliminar",
                    "Aviso",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        int confirmacion = JOptionPane.showConfirmDialog(
                this,
                "¿Está seguro de eliminar esta prioridad?",
                "Confirmar eliminación",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE
        );

        if (confirmacion != JOptionPane.YES_OPTION) {
            return;
        }

        PrioridadDAO prioridadDAO = new PrioridadDAO();

        boolean eliminado = prioridadDAO.eliminarPrioridad(
                idPrioridadSeleccionada,
                usuario.getId()
        );

        if (eliminado) {
            JOptionPane.showMessageDialog(this,
                    "Prioridad eliminada correctamente");

            txtNombrePrioridad.setText("");
            idPrioridadSeleccionada = -1;
            cargarPrioridades();

        } else {
            JOptionPane.showMessageDialog(this,
                    "No se pudo eliminar la prioridad. Es posible que esté siendo utilizada por alguna tarea.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void tablaPrioridadesRegistradasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaPrioridadesRegistradasMouseClicked
        
    int filaSeleccionada = tablaPrioridadesRegistradas.getSelectedRow();

        if (filaSeleccionada != -1) {
            int filaModelo = tablaPrioridadesRegistradas.convertRowIndexToModel(filaSeleccionada);

            idPrioridadSeleccionada = (int) tablaPrioridadesRegistradas
                    .getModel().getValueAt(filaModelo, 0);

            String nombre = (String) tablaPrioridadesRegistradas
                    .getModel().getValueAt(filaModelo, 1);

            txtNombrePrioridad.setText(nombre);
        }
        
    }//GEN-LAST:event_tablaPrioridadesRegistradasMouseClicked

    private void cargarPrioridades() {
        DefaultTableModel modelo = (DefaultTableModel) tablaPrioridadesRegistradas.getModel();

        modelo.setRowCount(0);

        PrioridadDAO prioridadDAO = new PrioridadDAO();

        List<Prioridad> prioridades =
                prioridadDAO.listarPrioridades(usuario.getId());

        for (Prioridad prioridad : prioridades) {
            modelo.addRow(new Object[]{
                prioridad.getIdPrioridad(),
                prioridad.getNombre()
            });
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditarPrioridad;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardarPrioridad;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblNombrePrioridad;
    private javax.swing.JLabel lblPrioridadesRegistradas;
    private javax.swing.JLabel lblTituloPrincipal;
    private javax.swing.JPanel panelPrincipalPrioridades;
    private javax.swing.JPanel panelTitulos;
    private javax.swing.JTable tablaPrioridadesRegistradas;
    private javax.swing.JTextField txtNombrePrioridad;
    // End of variables declaration//GEN-END:variables
}
