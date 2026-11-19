
package controldetareas.vista;

import controldetareas.dao.CategoriaDAO;
import controldetareas.modelo.Categoria;
import controldetareas.modelo.Usuario;
import controldetareas.dao.PrioridadDAO;
import controldetareas.modelo.Prioridad;
import controldetareas.modelo.Tarea;
import java.util.List;
import javax.swing.JOptionPane;


public class NuevaTarea extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(NuevaTarea.class.getName());

    private Usuario usuario;
    private Inicio ventanaInicio;
    
    private Tarea tareaEditar;
    private boolean modoEdicion = false;
    
    private boolean modoVisualizacion = false;
    
    public NuevaTarea(Usuario usuario, Inicio ventanaInicio) {
        this(usuario, ventanaInicio, null);
    }

    public NuevaTarea(Usuario usuario, Inicio ventanaInicio, Tarea tareaEditar) {

        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);

        this.usuario = usuario;
        this.ventanaInicio = ventanaInicio;
        this.tareaEditar = tareaEditar;

        cargarCategorias();
        cargarPrioridades();

        if (tareaEditar != null) {

            modoEdicion = true;

            lblTituloNuevaTarea.setText("Editar Tarea");

            txtNombreTarea.setText(tareaEditar.getTitulo());
            txtDescripcion.setText(tareaEditar.getDescripcion());

            cbCategoria.setSelectedItem(tareaEditar.getNombreCategoria());
            cbPrioridad.setSelectedItem(tareaEditar.getNombrePrioridad());

            if (tareaEditar.getFechaLimite() !=  null) {
                java.text.SimpleDateFormat formato =
                        new java.text.SimpleDateFormat("dd/MM/yyyy");

                txtFecha.setText(formato.format(tareaEditar.getFechaLimite()));
            }
        }

    }

    public NuevaTarea(Usuario usuario, Inicio ventanaInicio, Tarea tareaEditar, boolean modoVisualizacion) {

        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);

        this.usuario = usuario;
        this.ventanaInicio = ventanaInicio;
        this.tareaEditar = tareaEditar;
        this.modoVisualizacion = modoVisualizacion;

        cargarCategorias();
        cargarPrioridades();

        if(tareaEditar != null) {

            txtNombreTarea.setText(tareaEditar.getTitulo());
            txtDescripcion.setText(tareaEditar.getDescripcion());

            cbCategoria.setSelectedItem(tareaEditar.getNombreCategoria());
            cbPrioridad.setSelectedItem(tareaEditar.getDescripcion());

            btnCancelarTarea.setText("Volver");


            if (tareaEditar.getFechaLimite() != null) {

               java.text.SimpleDateFormat formato = new java.text.SimpleDateFormat("dd/MM/yyyy");

               txtFecha.setText(formato.format(tareaEditar.getFechaLimite()));

            }

            if (modoVisualizacion) {

                lblTituloNuevaTarea.setText("Detalles de la tarea");

                btnGuardarTarea.setVisible(false);

                txtNombreTarea.setEditable(false);
                txtDescripcion.setEditable(false);
                txtFecha.setEditable(false);

                cbCategoria.setEnabled(false);
                cbPrioridad.setEnabled(false);

            }

        }

    }
        
        
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelTitulo = new javax.swing.JPanel();
        lblTituloNuevaTarea = new javax.swing.JLabel();
        panelPrincipal = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        txtNombreTarea = new javax.swing.JTextField();
        lblDescripcion = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextArea();
        lblPrioridad = new javax.swing.JLabel();
        cbPrioridad = new javax.swing.JComboBox<>();
        lblCategoria = new javax.swing.JLabel();
        cbCategoria = new javax.swing.JComboBox<>();
        lblFechaLimite = new javax.swing.JLabel();
        txtFecha = new javax.swing.JFormattedTextField();
        btnGuardarTarea = new javax.swing.JButton();
        btnCancelarTarea = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        panelTitulo.setBackground(new java.awt.Color(16, 27, 48));

        lblTituloNuevaTarea.setBackground(new java.awt.Color(255, 255, 255));
        lblTituloNuevaTarea.setFont(new java.awt.Font("Liberation Sans", 1, 24)); // NOI18N
        lblTituloNuevaTarea.setForeground(new java.awt.Color(255, 255, 255));
        lblTituloNuevaTarea.setText("Nueva tarea");

        javax.swing.GroupLayout panelTituloLayout = new javax.swing.GroupLayout(panelTitulo);
        panelTitulo.setLayout(panelTituloLayout);
        panelTituloLayout.setHorizontalGroup(
            panelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTituloLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTituloNuevaTarea, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelTituloLayout.setVerticalGroup(
            panelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTituloLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTituloNuevaTarea, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelPrincipal.setBackground(new java.awt.Color(255, 255, 255));

        lblTitulo.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(0, 0, 0));
        lblTitulo.setText("Titulo");

        txtNombreTarea.setBackground(new java.awt.Color(204, 204, 204));
        txtNombreTarea.setForeground(new java.awt.Color(0, 0, 0));

        lblDescripcion.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        lblDescripcion.setForeground(new java.awt.Color(0, 0, 0));
        lblDescripcion.setText("Descripción");

        txtDescripcion.setBackground(new java.awt.Color(204, 204, 204));
        txtDescripcion.setColumns(20);
        txtDescripcion.setForeground(new java.awt.Color(0, 0, 0));
        txtDescripcion.setRows(5);
        jScrollPane1.setViewportView(txtDescripcion);

        lblPrioridad.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        lblPrioridad.setForeground(new java.awt.Color(0, 0, 0));
        lblPrioridad.setText("Prioridad");

        cbPrioridad.setMaximumSize(new java.awt.Dimension(72, 22));

        lblCategoria.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        lblCategoria.setForeground(new java.awt.Color(0, 0, 0));
        lblCategoria.setText("Categoría");

        lblFechaLimite.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        lblFechaLimite.setForeground(new java.awt.Color(0, 0, 0));
        lblFechaLimite.setText("Fecha límite (dd/mm/aa)");

        try {
            txtFecha.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtFecha.addActionListener(this::txtFechaActionPerformed);

        btnGuardarTarea.setBackground(new java.awt.Color(0, 51, 153));
        btnGuardarTarea.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        btnGuardarTarea.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardarTarea.setText("Guardar");
        btnGuardarTarea.addActionListener(this::btnGuardarTareaActionPerformed);

        btnCancelarTarea.setBackground(new java.awt.Color(204, 0, 0));
        btnCancelarTarea.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        btnCancelarTarea.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelarTarea.setText("Cancelar");
        btnCancelarTarea.addActionListener(this::btnCancelarTareaActionPerformed);

        javax.swing.GroupLayout panelPrincipalLayout = new javax.swing.GroupLayout(panelPrincipal);
        panelPrincipal.setLayout(panelPrincipalLayout);
        panelPrincipalLayout.setHorizontalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelPrincipalLayout.createSequentialGroup()
                        .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbPrioridad, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblPrioridad, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE))
                        .addGap(51, 51, 51)
                        .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbCategoria, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblCategoria, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblFechaLimite)
                            .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelPrincipalLayout.createSequentialGroup()
                        .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNombreTarea, javax.swing.GroupLayout.PREFERRED_SIZE, 446, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 446, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblDescripcion))
                        .addGap(0, 69, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnGuardarTarea, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCancelarTarea, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );
        panelPrincipalLayout.setVerticalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNombreTarea, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(lblDescripcion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPrioridad, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCategoria)
                    .addComponent(lblFechaLimite, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbPrioridad, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                    .addComponent(cbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(69, 69, 69)
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardarTarea)
                    .addComponent(btnCancelarTarea))
                .addGap(19, 19, 19))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(panelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaActionPerformed

    private void btnGuardarTareaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarTareaActionPerformed

        String titulo = txtNombreTarea.getText().trim();
        String descripcion = txtDescripcion.getText().trim();
        String prioridad = (String) cbPrioridad.getSelectedItem();
        String nombreCategoria = (String) cbCategoria.getSelectedItem();
        String fechaTexto = txtFecha.getText().trim();

        if (titulo.isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(
                    this, "Ingresá el título de la tarea.");
        txtNombreTarea.requestFocus();
            return;
        }

        if (nombreCategoria == null) {
            javax.swing.JOptionPane.showMessageDialog(
                    this, "Seleccioná una categoría.");
            return;
        }

        java.sql.Date fechaLimite;

        try {
            java.text.SimpleDateFormat formato =
                    new java.text.SimpleDateFormat("dd/MM/yyyy");

            formato.setLenient(false);

            java.util.Date fecha =
                    formato.parse(fechaTexto);

            fechaLimite = new java.sql.Date(fecha.getTime());

        } catch (java.text.ParseException e) {
            javax.swing.JOptionPane.showMessageDialog(
                    this, "Ingresa una fecha valida con formato dd/MM/aaaa.");
            txtFecha.requestFocus();
            return;
        }

        CategoriaDAO categoriaDAO = new CategoriaDAO();
        List<Categoria> categorias = categoriaDAO.listarCategorias(usuario.getId());

        int idCategoria = -1;

        for (Categoria categoria : categorias) {
            if (categoria.getNombre().equalsIgnoreCase(nombreCategoria)) {
                idCategoria = categoria.getIdCategoria();
                break;
            }
        }

        if (idCategoria == -1) {
            javax.swing.JOptionPane.showMessageDialog(
                    this, "No se encontró la categoría seleccionada.");
            return;
        }
        
        PrioridadDAO prioridadDAO = new PrioridadDAO();
        List<Prioridad> prioridades = prioridadDAO.listarPrioridades(usuario.getId());

        int idPrioridad = -1;

        for (Prioridad prioridadBD : prioridades) {
            if (prioridadBD.getNombre().equalsIgnoreCase(prioridad)) {
                idPrioridad = prioridadBD.getIdPrioridad();
                break;
            }
        }

        if (idPrioridad == -1) {
            JOptionPane.showMessageDialog(this, "No se encontró la prioridad seleccionada.");
            return;
        }

        controldetareas.dao.TareaDAO tareaDAO = new controldetareas.dao.TareaDAO();

        boolean guardado;

        if (modoEdicion) {
            guardado = tareaDAO.editarTarea(
                    tareaEditar.getIdTareas(),
                    usuario.getId(),
                    idCategoria,
                    idPrioridad,
                    titulo,
                    descripcion,
                    fechaLimite
            );
        } else {
            guardado = tareaDAO.crearTarea(
                    usuario.getId(),
                    idCategoria,
                    idPrioridad,
                    titulo,
                    descripcion,
                    fechaLimite
            );
        }

        if (guardado) {
            if (modoEdicion) {
                JOptionPane.showMessageDialog(this, "Tarea actualizada correctamente");
            } else {
                JOptionPane.showMessageDialog(this, "Tarea guardada correctamente");
            }

            ventanaInicio.cargarTareas();
            this.dispose();

        } else {
            JOptionPane.showMessageDialog(this, "No se pudo guardar la tarea.");
        }

    }//GEN-LAST:event_btnGuardarTareaActionPerformed

    private void btnCancelarTareaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarTareaActionPerformed

        this.dispose();
        
    }//GEN-LAST:event_btnCancelarTareaActionPerformed


    private void cargarCategorias() {

        CategoriaDAO categoriaDAO = new CategoriaDAO();
        List<Categoria> categorias = categoriaDAO.listarCategorias(usuario.getId());

        cbCategoria.removeAllItems();

        for (Categoria categoria : categorias) {
            cbCategoria.addItem(categoria.getNombre());
        }
        
    }
    
    private void cargarPrioridades() {
        PrioridadDAO prioridadDAO = new PrioridadDAO();
        List<Prioridad> prioridades = prioridadDAO.listarPrioridades(usuario.getId());

        cbPrioridad.removeAllItems();

        for (Prioridad prioridad : prioridades) {
            cbPrioridad.addItem(prioridad.getNombre());
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelarTarea;
    private javax.swing.JButton btnGuardarTarea;
    private javax.swing.JComboBox<String> cbCategoria;
    private javax.swing.JComboBox<String> cbPrioridad;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCategoria;
    private javax.swing.JLabel lblDescripcion;
    private javax.swing.JLabel lblFechaLimite;
    private javax.swing.JLabel lblPrioridad;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblTituloNuevaTarea;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JPanel panelTitulo;
    private javax.swing.JTextArea txtDescripcion;
    private javax.swing.JFormattedTextField txtFecha;
    private javax.swing.JTextField txtNombreTarea;
    // End of variables declaration//GEN-END:variables
}
