
package controldetareas.vista;

import controldetareas.dao.CategoriaDAO;
import controldetareas.modelo.Categoria;
import controldetareas.modelo.Usuario;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class Categorias extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Categorias.class.getName());

    private Usuario usuario;
    private int idCategoriaSeleccionada = -1;

    public Categorias(Usuario usuario) {
        
        initComponents();
        
        setLocationRelativeTo(null);
        setResizable(false);
        
        this.usuario = usuario;
        
        cargarCategorias();
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelTitulos = new javax.swing.JPanel();
        lblTituloPrincipal = new javax.swing.JLabel();
        panelPrincipal = new javax.swing.JPanel();
        btnGuardarCategoria = new javax.swing.JButton();
        txtNuevaCategoria = new javax.swing.JTextField();
        lblNombreCategoria = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaCategoriasRegistradas = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btnEditarCategoria = new javax.swing.JButton();
        btnEliminarCategoria = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        panelTitulos.setBackground(new java.awt.Color(16, 27, 48));

        lblTituloPrincipal.setBackground(new java.awt.Color(255, 255, 255));
        lblTituloPrincipal.setFont(new java.awt.Font("Liberation Sans", 1, 24)); // NOI18N
        lblTituloPrincipal.setForeground(new java.awt.Color(255, 255, 255));
        lblTituloPrincipal.setText("Administrar Categorias");

        javax.swing.GroupLayout panelTitulosLayout = new javax.swing.GroupLayout(panelTitulos);
        panelTitulos.setLayout(panelTitulosLayout);
        panelTitulosLayout.setHorizontalGroup(
            panelTitulosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTitulosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTituloPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelTitulosLayout.setVerticalGroup(
            panelTitulosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTitulosLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(lblTituloPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        panelPrincipal.setBackground(new java.awt.Color(255, 255, 255));

        btnGuardarCategoria.setBackground(new java.awt.Color(0, 51, 153));
        btnGuardarCategoria.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        btnGuardarCategoria.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardarCategoria.setText("Guardar");
        btnGuardarCategoria.setFocusPainted(false);
        btnGuardarCategoria.addActionListener(this::btnGuardarCategoriaActionPerformed);

        txtNuevaCategoria.setBackground(new java.awt.Color(204, 204, 204));
        txtNuevaCategoria.setForeground(new java.awt.Color(0, 0, 0));

        lblNombreCategoria.setBackground(new java.awt.Color(255, 255, 255));
        lblNombreCategoria.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        lblNombreCategoria.setForeground(new java.awt.Color(0, 0, 0));
        lblNombreCategoria.setText("Nombre de la categoría");

        tablaCategoriasRegistradas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre"
            }
        ));
        tablaCategoriasRegistradas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaCategoriasRegistradasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaCategoriasRegistradas);

        jLabel1.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Categorias registradas");

        btnEditarCategoria.setBackground(new java.awt.Color(0, 153, 153));
        btnEditarCategoria.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        btnEditarCategoria.setForeground(new java.awt.Color(255, 255, 255));
        btnEditarCategoria.setText("Editar");
        btnEditarCategoria.setBorderPainted(false);
        btnEditarCategoria.addActionListener(this::btnEditarCategoriaActionPerformed);

        btnEliminarCategoria.setBackground(new java.awt.Color(204, 0, 0));
        btnEliminarCategoria.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        btnEliminarCategoria.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminarCategoria.setText("Eliminar");
        btnEliminarCategoria.setFocusPainted(false);
        btnEliminarCategoria.addActionListener(this::btnEliminarCategoriaActionPerformed);

        javax.swing.GroupLayout panelPrincipalLayout = new javax.swing.GroupLayout(panelPrincipal);
        panelPrincipal.setLayout(panelPrincipalLayout);
        panelPrincipalLayout.setHorizontalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(panelPrincipalLayout.createSequentialGroup()
                        .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(panelPrincipalLayout.createSequentialGroup()
                                .addComponent(btnGuardarCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(btnEditarCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37)
                                .addComponent(btnEliminarCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtNuevaCategoria)
                                .addComponent(lblNombreCategoria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(0, 166, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelPrincipalLayout.setVerticalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPrincipalLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(lblNombreCategoria)
                .addGap(18, 18, 18)
                .addComponent(txtNuevaCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardarCategoria)
                    .addComponent(btnEditarCategoria)
                    .addComponent(btnEliminarCategoria))
                .addGap(40, 40, 40)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelTitulos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelTitulos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(panelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarCategoriaActionPerformed
        
        String nombre = txtNuevaCategoria.getText().trim();

        if (nombre.isEmpty()) {
            JOptionPane.showMessageDialog(
                    this,
                    "Ingrese el nombre de la categoría",
                    "Aviso",
                    JOptionPane.WARNING_MESSAGE
            );
            return;
        }

        CategoriaDAO categoriaDAO = new CategoriaDAO();

        boolean guardado = categoriaDAO.guardarCategoria(
                usuario.getId(),
                nombre
        );

        if (guardado) {
            JOptionPane.showMessageDialog(
                    this,
                    "Categoría registrada correctamente"
            );

            txtNuevaCategoria.setText("");
            idCategoriaSeleccionada = -1;
            cargarCategorias();
            tablaCategoriasRegistradas.clearSelection();

        } else {
            JOptionPane.showMessageDialog(
                    this,
                    "No se pudo registrar la categoría. Verifique que no exista otra con el mismo nombre.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
      
    }//GEN-LAST:event_btnGuardarCategoriaActionPerformed

    private void btnEditarCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarCategoriaActionPerformed
       
        if (idCategoriaSeleccionada == -1) {
            JOptionPane.showMessageDialog(
                    this,
                    "Seleccione una categoría para editar",
                    "Aviso",
                    JOptionPane.WARNING_MESSAGE
            );
            return;
        }

        String nombre = txtNuevaCategoria.getText().trim();

        if (nombre.isEmpty()) {
            JOptionPane.showMessageDialog(
                    this,
                    "El nombre de la categoría no puede estar vacío",
                    "Aviso",
                    JOptionPane.WARNING_MESSAGE
            );
            return;
        }

        CategoriaDAO categoriaDAO = new CategoriaDAO();

        boolean actualizado = categoriaDAO.actualizarCategoria(
                idCategoriaSeleccionada,
                usuario.getId(),
                nombre
        );

        if (actualizado) {
            JOptionPane.showMessageDialog(
                    this,
                    "Categoría actualizada correctamente"
            );

            txtNuevaCategoria.setText("");
            idCategoriaSeleccionada = -1;
            cargarCategorias();

        } else {
            JOptionPane.showMessageDialog(
                    this,
                    "No se pudo actualizar la categoría. Verifique que no exista otra con el mismo nombre.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
        
    }//GEN-LAST:event_btnEditarCategoriaActionPerformed

    private void tablaCategoriasRegistradasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaCategoriasRegistradasMouseClicked
       
        int filaSeleccionada = tablaCategoriasRegistradas.getSelectedRow();

        if (filaSeleccionada != -1) {

            int filaModelo = tablaCategoriasRegistradas.convertRowIndexToModel(filaSeleccionada);

            idCategoriaSeleccionada = (int) tablaCategoriasRegistradas
                    .getModel().getValueAt(filaModelo, 0);

            String nombre = (String) tablaCategoriasRegistradas
                    .getModel().getValueAt(filaModelo, 1);

            txtNuevaCategoria.setText(nombre);
        }        
        
    }//GEN-LAST:event_tablaCategoriasRegistradasMouseClicked

    private void btnEliminarCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarCategoriaActionPerformed
        
        if (idCategoriaSeleccionada == -1) {
            JOptionPane.showMessageDialog(
                    this,
                    "Seleccione una categoría para eliminar",
                    "Aviso",
                    JOptionPane.WARNING_MESSAGE
            );
            return;
        }

        int confirmacion = JOptionPane.showConfirmDialog(
                this,
                "¿Está seguro de eliminar esta categoría?",
                "Confirmar eliminación",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE
        );

        if (confirmacion != JOptionPane.YES_OPTION) {
            return;
        }

        CategoriaDAO categoriaDAO = new CategoriaDAO();

        boolean eliminado = categoriaDAO.eliminarCategoria(
                idCategoriaSeleccionada,
                usuario.getId()
        );

        if (eliminado) {
            JOptionPane.showMessageDialog(
                    this,
                    "Categoría eliminada correctamente"
            );

            txtNuevaCategoria.setText("");
            idCategoriaSeleccionada = -1;
            cargarCategorias();

        } else {
            JOptionPane.showMessageDialog(
                    this,
                    "No se pudo eliminar la categoría. Es posible que esté siendo utilizada por alguna tarea.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
        
    }//GEN-LAST:event_btnEliminarCategoriaActionPerformed

    private void cargarCategorias() {

        DefaultTableModel modelo =
                (DefaultTableModel) tablaCategoriasRegistradas.getModel();

        modelo.setRowCount(0);

        CategoriaDAO categoriaDAO = new CategoriaDAO();
        List<Categoria> categorias =
                categoriaDAO.listarCategorias(usuario.getId());

        for (Categoria categoria : categorias) {
            modelo.addRow(new Object[]{
                categoria.getIdCategoria(),
                categoria.getNombre()
            });
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditarCategoria;
    private javax.swing.JButton btnEliminarCategoria;
    private javax.swing.JButton btnGuardarCategoria;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblNombreCategoria;
    private javax.swing.JLabel lblTituloPrincipal;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JPanel panelTitulos;
    private javax.swing.JTable tablaCategoriasRegistradas;
    private javax.swing.JTextField txtNuevaCategoria;
    // End of variables declaration//GEN-END:variables
}
