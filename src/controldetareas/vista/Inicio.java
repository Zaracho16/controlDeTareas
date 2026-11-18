
package controldetareas.vista;

import controldetareas.dao.TareaDAO;
import controldetareas.modelo.Tarea;
import controldetareas.modelo.Usuario;
import controldetareas.dao.CategoriaDAO;
import controldetareas.dao.PrioridadDAO;
import controldetareas.modelo.Categoria;
import controldetareas.modelo.Prioridad;

import java.util.ArrayList;
import java.util.regex.Pattern;
import javax.swing.JComboBox;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.TableRowSorter;
import java.awt.Color;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Inicio extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Inicio.class.getName());

    private Usuario usuario;
    private TableRowSorter<DefaultTableModel> sorter;

    public Inicio(Usuario usuario) {
        
        initComponents();
        
        tablaTareas.getTableHeader().setBackground(new Color(16, 29, 50));
        tablaTareas.getTableHeader().setForeground(Color.WHITE);
        
        setLocationRelativeTo(null);
        setResizable(false);
        
        this.usuario = usuario;
        
        cargarFiltros();
        configurarFiltros();
        cargarTareas();
        
    }
    
    public void cargarTareas() {
        
        DefaultTableModel modelo = (DefaultTableModel) tablaTareas.getModel();
        
        for (int i = 1; i <= 5; i++) {
            tablaTareas.getColumnModel().getColumn(i).setCellRenderer(new TareaRenderer());
        }

        modelo.setRowCount(0);
        
        // "ocultamos" la columna de numero id en la tabla, asi podemos recuperar el id a eliminar, modificar etc sin tener que mostrarlo en la interfaz
        tablaTareas.getColumnModel().getColumn(0).setMinWidth(0);
        tablaTareas.getColumnModel().getColumn(0).setMaxWidth(0);
        tablaTareas.getColumnModel().getColumn(0).setWidth(0);
        
        // ocultamos tambien la columna de completada
        tablaTareas.getColumnModel().getColumn(6).setMinWidth(0);
        tablaTareas.getColumnModel().getColumn(6).setMaxWidth(0);
        tablaTareas.getColumnModel().getColumn(6).setWidth(0);

        TareaDAO tareaDAO = new TareaDAO();
        List<Tarea> tareas = tareaDAO.listarTareas(usuario.getId());

        for (Tarea tarea : tareas) {
            modelo.addRow(new Object[]{
                tarea.getIdTareas(),
                tarea.getTitulo(),
                tarea.getNombrePrioridad(),
                tarea.getNombreEstado(),
                tarea.getNombreCategoria(),
                tarea.getFechaLimite(),
                tarea.isCompletada()
            });
        }
        
    }
    
    private void cargarFiltros() {

        cbCategoria.removeAllItems();
        cbCategoria.addItem("Todas");

        CategoriaDAO categoriaDAO = new CategoriaDAO();
        List<Categoria> categorias =
                categoriaDAO.listarCategorias(usuario.getId());

        for (Categoria categoria : categorias) {
            cbCategoria.addItem(categoria.getNombre());
        }

        cbPrioridad.removeAllItems();
        cbPrioridad.addItem("Todos");

        PrioridadDAO prioridadDAO = new PrioridadDAO();
        List<Prioridad> prioridades =
                prioridadDAO.listarPrioridades(usuario.getId());

        for (Prioridad prioridad : prioridades) {
            cbPrioridad.addItem(prioridad.getNombre());
        }
    }
    
    private void configurarFiltros() {

        sorter = new TableRowSorter<>((DefaultTableModel) tablaTareas.getModel());
        tablaTareas.setRowSorter(sorter);

        txtBuscarPorTitulo.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) { aplicarFiltros(); }
            @Override
            public void removeUpdate(DocumentEvent e) { aplicarFiltros(); }
            @Override
            public void changedUpdate(DocumentEvent e) { aplicarFiltros(); }
        });

        cbEstado.addActionListener(e -> aplicarFiltros());
        cbPrioridad.addActionListener(e -> aplicarFiltros());
        cbCategoria.addActionListener(e -> aplicarFiltros());

        btnLimpiarFiltro.addActionListener(e -> limpiarFiltros());
    }

    private void aplicarFiltros() {

        List<RowFilter<DefaultTableModel, Object>> filtros = new ArrayList<>();

        String texto = txtBuscarPorTitulo.getText().trim();
        if (texto.length() >= 3) {
            filtros.add(RowFilter.regexFilter("(?i)" + Pattern.quote(texto), 1));
        }

        agregarFiltroCombo(filtros, cbPrioridad, 2);
        agregarFiltroCombo(filtros, cbEstado, 3);
        agregarFiltroCombo(filtros, cbCategoria, 4);

        if (filtros.isEmpty()) {
            sorter.setRowFilter(null);
        } else {
            sorter.setRowFilter(RowFilter.andFilter(filtros));
        }
    }

    private void agregarFiltroCombo(List<RowFilter<DefaultTableModel, Object>> filtros, JComboBox<String> combo, int columna) {
        if (combo.getSelectedIndex() > 0) {
            String valor = combo.getSelectedItem().toString();
            filtros.add(RowFilter.regexFilter("^" + Pattern.quote(valor) + "$", columna));
        }
    }

    private void limpiarFiltros() {

        txtBuscarPorTitulo.setText("");
        cbEstado.setSelectedIndex(0);
        cbPrioridad.setSelectedIndex(0);
        cbCategoria.setSelectedIndex(0);
        sorter.setRowFilter(null);
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jToggleButton1 = new javax.swing.JToggleButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jEditorPane1 = new javax.swing.JEditorPane();
        panelTituloInicio = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        btnInfoIntegrantes = new javax.swing.JButton();
        btnCerrarSesion = new javax.swing.JButton();
        panelPrincipal = new javax.swing.JPanel();
        lblPrioridadFiltro = new javax.swing.JLabel();
        cbEstado = new javax.swing.JComboBox<>();
        lblCategoriaFiltro = new javax.swing.JLabel();
        cbCategoria = new javax.swing.JComboBox<>();
        lblEstadoFiltro = new javax.swing.JLabel();
        cbPrioridad = new javax.swing.JComboBox<>();
        txtBuscarPorTitulo = new javax.swing.JTextField();
        lblLupaIcono = new javax.swing.JLabel();
        btnLimpiarFiltro = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaTareas = new javax.swing.JTable();
        panelAcciones = new javax.swing.JPanel();
        btnVerDetallesTarea = new javax.swing.JButton();
        btnCompletadoTarea = new javax.swing.JButton();
        btnEditarTarea = new javax.swing.JButton();
        btnEliminarTarea = new javax.swing.JButton();
        lblAcciones = new javax.swing.JLabel();
        btnNuevaTarea = new javax.swing.JButton();
        btnCategorias = new javax.swing.JButton();
        btnPrioridades = new javax.swing.JButton();

        jTextField1.setText("jTextField1");

        jToggleButton1.setText("jToggleButton1");

        jScrollPane2.setViewportView(jEditorPane1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(181, 199, 216));

        panelTituloInicio.setBackground(new java.awt.Color(16, 29, 50));

        lblTitulo.setBackground(new java.awt.Color(255, 255, 255));
        lblTitulo.setFont(new java.awt.Font("Liberation Sans", 1, 28)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo.setText("Control de tareas");

        btnInfoIntegrantes.setBackground(new java.awt.Color(7, 155, 197));
        btnInfoIntegrantes.setFont(new java.awt.Font("Liberation Sans", 1, 13)); // NOI18N
        btnInfoIntegrantes.setForeground(new java.awt.Color(255, 255, 255));
        btnInfoIntegrantes.setText("Desarrollado por");
        btnInfoIntegrantes.setFocusPainted(false);
        btnInfoIntegrantes.addActionListener(this::btnInfoIntegrantesActionPerformed);

        btnCerrarSesion.setBackground(new java.awt.Color(153, 0, 0));
        btnCerrarSesion.setFont(new java.awt.Font("Liberation Sans", 1, 13)); // NOI18N
        btnCerrarSesion.setForeground(new java.awt.Color(255, 255, 255));
        btnCerrarSesion.setText("Cerrar Sesión");
        btnCerrarSesion.setFocusPainted(false);
        btnCerrarSesion.addActionListener(this::btnCerrarSesionActionPerformed);

        javax.swing.GroupLayout panelTituloInicioLayout = new javax.swing.GroupLayout(panelTituloInicio);
        panelTituloInicio.setLayout(panelTituloInicioLayout);
        panelTituloInicioLayout.setHorizontalGroup(
            panelTituloInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTituloInicioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnInfoIntegrantes, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCerrarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelTituloInicioLayout.setVerticalGroup(
            panelTituloInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTituloInicioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelTituloInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTitulo)
                    .addComponent(btnInfoIntegrantes)
                    .addComponent(btnCerrarSesion))
                .addContainerGap(11, Short.MAX_VALUE))
        );

        panelPrincipal.setBackground(new java.awt.Color(234, 241, 246));

        lblPrioridadFiltro.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        lblPrioridadFiltro.setForeground(new java.awt.Color(0, 0, 0));
        lblPrioridadFiltro.setText("Prioridad");

        cbEstado.setBackground(new java.awt.Color(214, 234, 248));
        cbEstado.setForeground(new java.awt.Color(51, 51, 51));
        cbEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "Pendiente", "En progreso", "Completada" }));

        lblCategoriaFiltro.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        lblCategoriaFiltro.setForeground(new java.awt.Color(0, 0, 0));
        lblCategoriaFiltro.setText("Categoria");

        cbCategoria.setBackground(new java.awt.Color(214, 234, 248));
        cbCategoria.setForeground(new java.awt.Color(51, 51, 51));
        cbCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todas", "Facultad", "Personal", "Trabajo" }));

        lblEstadoFiltro.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        lblEstadoFiltro.setForeground(new java.awt.Color(0, 0, 0));
        lblEstadoFiltro.setText("Estado");

        cbPrioridad.setBackground(new java.awt.Color(214, 234, 248));
        cbPrioridad.setForeground(new java.awt.Color(51, 51, 51));
        cbPrioridad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "Alta", "Media", "Baja" }));

        txtBuscarPorTitulo.setBackground(new java.awt.Color(255, 255, 255));
        txtBuscarPorTitulo.setForeground(new java.awt.Color(0, 0, 0));
        txtBuscarPorTitulo.setMargin(new java.awt.Insets(4, 8, 4, 8));
        txtBuscarPorTitulo.addActionListener(this::txtBuscarPorTituloActionPerformed);

        lblLupaIcono.setIcon(new javax.swing.ImageIcon(getClass().getResource("/controldetareas/recursos/lupa (1).png"))); // NOI18N

        btnLimpiarFiltro.setBackground(new java.awt.Color(211, 222, 232));
        btnLimpiarFiltro.setForeground(new java.awt.Color(0, 0, 0));
        btnLimpiarFiltro.setText("Limpiar");
        btnLimpiarFiltro.setFocusPainted(false);

        tablaTareas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Tarea", "Prioridad", "Estado", "Categoria", "Fecha limite", "Completada"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                true, true, true, true, true, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaTareas);

        panelAcciones.setBackground(new java.awt.Color(234, 241, 246));

        btnVerDetallesTarea.setBackground(new java.awt.Color(102, 163, 163));
        btnVerDetallesTarea.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        btnVerDetallesTarea.setForeground(new java.awt.Color(255, 255, 255));
        btnVerDetallesTarea.setIcon(new javax.swing.ImageIcon(getClass().getResource("/controldetareas/recursos/ojo-detalles (2).png"))); // NOI18N
        btnVerDetallesTarea.setText("Ver detalles");
        btnVerDetallesTarea.setFocusPainted(false);
        btnVerDetallesTarea.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnVerDetallesTarea.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnVerDetallesTarea.addActionListener(this::btnVerDetallesTareaActionPerformed);

        btnCompletadoTarea.setBackground(new java.awt.Color(39, 166, 106));
        btnCompletadoTarea.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        btnCompletadoTarea.setForeground(new java.awt.Color(255, 255, 255));
        btnCompletadoTarea.setIcon(new javax.swing.ImageIcon(getClass().getResource("/controldetareas/recursos/checkk (1).png"))); // NOI18N
        btnCompletadoTarea.setText("Completar");
        btnCompletadoTarea.setFocusPainted(false);
        btnCompletadoTarea.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCompletadoTarea.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCompletadoTarea.addActionListener(this::btnCompletadoTareaActionPerformed);

        btnEditarTarea.setBackground(new java.awt.Color(36, 127, 203));
        btnEditarTarea.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        btnEditarTarea.setForeground(new java.awt.Color(255, 255, 255));
        btnEditarTarea.setIcon(new javax.swing.ImageIcon(getClass().getResource("/controldetareas/recursos/editarLapiz (1).png"))); // NOI18N
        btnEditarTarea.setText("Editar");
        btnEditarTarea.setFocusPainted(false);
        btnEditarTarea.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEditarTarea.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEditarTarea.addActionListener(this::btnEditarTareaActionPerformed);

        btnEliminarTarea.setBackground(new java.awt.Color(223, 80, 85));
        btnEliminarTarea.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        btnEliminarTarea.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminarTarea.setIcon(new javax.swing.ImageIcon(getClass().getResource("/controldetareas/recursos/basurero (4).png"))); // NOI18N
        btnEliminarTarea.setText("Eliminar");
        btnEliminarTarea.setFocusPainted(false);
        btnEliminarTarea.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEliminarTarea.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEliminarTarea.addActionListener(this::btnEliminarTareaActionPerformed);

        lblAcciones.setBackground(new java.awt.Color(0, 0, 0));
        lblAcciones.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        lblAcciones.setForeground(new java.awt.Color(0, 0, 0));
        lblAcciones.setText("ACCIONES");

        btnNuevaTarea.setBackground(new java.awt.Color(0, 153, 153));
        btnNuevaTarea.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        btnNuevaTarea.setForeground(new java.awt.Color(255, 255, 255));
        btnNuevaTarea.setIcon(new javax.swing.ImageIcon(getClass().getResource("/controldetareas/recursos/nuevaTarea.png"))); // NOI18N
        btnNuevaTarea.setText("Nueva Tarea");
        btnNuevaTarea.setFocusPainted(false);
        btnNuevaTarea.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNuevaTarea.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnNuevaTarea.addActionListener(this::btnNuevaTareaActionPerformed);

        javax.swing.GroupLayout panelAccionesLayout = new javax.swing.GroupLayout(panelAcciones);
        panelAcciones.setLayout(panelAccionesLayout);
        panelAccionesLayout.setHorizontalGroup(
            panelAccionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAccionesLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panelAccionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelAccionesLayout.createSequentialGroup()
                        .addComponent(btnEliminarTarea, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 12, Short.MAX_VALUE))
                    .addGroup(panelAccionesLayout.createSequentialGroup()
                        .addGroup(panelAccionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblAcciones, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnVerDetallesTarea, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnEditarTarea, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnCompletadoTarea, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnNuevaTarea, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        panelAccionesLayout.setVerticalGroup(
            panelAccionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAccionesLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(lblAcciones)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnNuevaTarea)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addComponent(btnVerDetallesTarea, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEditarTarea, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCompletadoTarea, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnEliminarTarea, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );

        btnCategorias.setBackground(new java.awt.Color(0, 102, 102));
        btnCategorias.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        btnCategorias.setForeground(new java.awt.Color(255, 255, 255));
        btnCategorias.setText("Categorias");
        btnCategorias.setFocusPainted(false);
        btnCategorias.addActionListener(this::btnCategoriasActionPerformed);

        btnPrioridades.setBackground(new java.awt.Color(0, 102, 153));
        btnPrioridades.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        btnPrioridades.setForeground(new java.awt.Color(255, 255, 255));
        btnPrioridades.setText("Prioridades");
        btnPrioridades.setFocusPainted(false);
        btnPrioridades.addActionListener(this::btnPrioridadesActionPerformed);

        javax.swing.GroupLayout panelPrincipalLayout = new javax.swing.GroupLayout(panelPrincipal);
        panelPrincipal.setLayout(panelPrincipalLayout);
        panelPrincipalLayout.setHorizontalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelPrincipalLayout.createSequentialGroup()
                        .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblPrioridadFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCategoriaFiltro)
                            .addComponent(cbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(118, 118, 118)
                        .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblEstadoFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbPrioridad, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 616, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelPrincipalLayout.createSequentialGroup()
                        .addComponent(lblLupaIcono)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtBuscarPorTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 477, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLimpiarFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelPrincipalLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(panelAcciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(30, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPrincipalLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnPrioridades, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
                            .addComponent(btnCategorias, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(42, 42, 42))))
        );
        panelPrincipalLayout.setVerticalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelPrincipalLayout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblPrioridadFiltro)
                            .addComponent(lblEstadoFiltro))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbPrioridad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPrincipalLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnCategorias, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)))
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelPrincipalLayout.createSequentialGroup()
                        .addComponent(lblCategoriaFiltro)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblLupaIcono, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtBuscarPorTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnLimpiarFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(28, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPrincipalLayout.createSequentialGroup()
                        .addComponent(btnPrioridades, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelAcciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelTituloInicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelTituloInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(panelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnInfoIntegrantesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInfoIntegrantesActionPerformed
        
        InfoDesarrolladores infodesarrolladores = new InfoDesarrolladores();
        infodesarrolladores.setVisible(true);
        
    }//GEN-LAST:event_btnInfoIntegrantesActionPerformed

    private void btnNuevaTareaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevaTareaActionPerformed
       
        NuevaTarea ventana = new NuevaTarea(usuario, this);
        ventana.setVisible(true);
        
    }//GEN-LAST:event_btnNuevaTareaActionPerformed

    private void btnEliminarTareaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarTareaActionPerformed

        int filaSeleccionada = tablaTareas.getSelectedRow();

        if (filaSeleccionada == -1) {

            javax.swing.JOptionPane.showMessageDialog (
                this,
                "Seleccione una tarea para eliminar",
                "Aviso",
                javax.swing.JOptionPane.WARNING_MESSAGE
            );

            return;

        }

        int confirmacionEliminar = javax.swing.JOptionPane.showConfirmDialog (
            this,
            "¿Eliminar tarea?",
            "Confirmar eliminación",
            javax.swing.JOptionPane.YES_NO_OPTION,
            javax.swing.JOptionPane.QUESTION_MESSAGE
        );

        if (confirmacionEliminar != javax.swing.JOptionPane.YES_OPTION) {
            return;
        }

        int idTarea = (int) tablaTareas.getValueAt(filaSeleccionada, 0);

        TareaDAO tareaDAO = new TareaDAO();
        boolean eliminada = tareaDAO.eliminarTarea(idTarea);

        if(eliminada) {

            javax.swing.JOptionPane.showMessageDialog (
                this,
                "La tarea se elimino",
                "Éxito",
                javax.swing.JOptionPane.INFORMATION_MESSAGE
            );

        } else {

            javax.swing.JOptionPane.showMessageDialog(
                this,
                "Error al eliminar la tarea",
                "Error",
                javax.swing.JOptionPane.ERROR_MESSAGE
            );

        }

        cargarTareas();

    }//GEN-LAST:event_btnEliminarTareaActionPerformed

    private void btnEditarTareaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarTareaActionPerformed

        int filaSeleccionada = tablaTareas.getSelectedRow();

        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione una tarea para editarla", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int filaModelo = tablaTareas.convertRowIndexToModel(filaSeleccionada);
        int idTarea = (int) tablaTareas.getModel().getValueAt(filaModelo, 0);

        TareaDAO tareaDAO = new TareaDAO();
        List<Tarea> tareas = tareaDAO.listarTareas(usuario.getId());

        Tarea tareaSeleccionada = null;

        for (Tarea tarea : tareas) {
            if(tarea.getIdTareas() == idTarea) {
                tareaSeleccionada = tarea;
                break;
            }
        }

        if (tareaSeleccionada == null) {

            JOptionPane.showMessageDialog(this, "No se encontro la tarea seleccionada", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        NuevaTarea ventana = new NuevaTarea(
            usuario,
            this,
            tareaSeleccionada
        );

        ventana.setVisible(true);

    }//GEN-LAST:event_btnEditarTareaActionPerformed

    private void btnCompletadoTareaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCompletadoTareaActionPerformed

        int filaSeleccionada = tablaTareas.getSelectedRow();

        if(filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar una tarea para marcarlo como completada");
            return;
        }

        int idTarea = (int) tablaTareas.getValueAt(filaSeleccionada, 0);

        int confirmacion = JOptionPane.showConfirmDialog (
            this,
            "¿Marcar la tarea como completada?",
            "Confirmar tarea",
            JOptionPane.YES_NO_OPTION
        );

        if(confirmacion != JOptionPane.YES_OPTION) {
            return;
        }

        TareaDAO tareaDAO = new TareaDAO();

        boolean tareaCompletada = tareaDAO.completarTarea(idTarea);

        if (tareaCompletada) {

            JOptionPane.showMessageDialog(this, "Tarea completada correctamente!");
            cargarTareas();

        } else {

            JOptionPane.showMessageDialog(this, "Error al completar la tarea");

        }

    }//GEN-LAST:event_btnCompletadoTareaActionPerformed

    private void btnVerDetallesTareaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerDetallesTareaActionPerformed
       
        int filaSeleccionada = tablaTareas.getSelectedRow();
        
        if (filaSeleccionada == -1) {
            
            JOptionPane.showMessageDialog(this, "Seleccione una tarea para ver sus detalles", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
            
        }
        
        int filaModelo = tablaTareas.convertRowIndexToModel(filaSeleccionada);
        int idTarea = (int) tablaTareas.getModel().getValueAt(filaModelo, 0);
        
        TareaDAO tareaDAO = new TareaDAO();
        List<Tarea> tareas = tareaDAO.listarTareas(usuario.getId());
        
        Tarea tareaSeleccionada = null;
        
        for (Tarea tarea : tareas) {
            
            if (tarea.getIdTareas() == idTarea) {
                tareaSeleccionada = tarea;
                break;
            }
            
        }
        
        if (tareaSeleccionada == null) {
            
            JOptionPane.showMessageDialog(this, "No se encontro la tarea seleccionada", "Error", JOptionPane.ERROR_MESSAGE);
            return;
            
        }
        
        NuevaTarea ventana = new NuevaTarea(
                usuario,
                this,
                tareaSeleccionada,
                true
        );
        
        ventana.setVisible(true);
        
    }//GEN-LAST:event_btnVerDetallesTareaActionPerformed

    private void txtBuscarPorTituloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarPorTituloActionPerformed

    }//GEN-LAST:event_txtBuscarPorTituloActionPerformed

    private void btnCategoriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCategoriasActionPerformed
        
        Categorias categorias = new Categorias(usuario);
        
        categorias.addWindowListener(new java.awt.event.WindowAdapter () {
            @Override
            public void windowClosed(java.awt.event.WindowEvent e) {
                cargarFiltros();
                aplicarFiltros();
            }
        });
        
        categorias.setVisible(true);
        
    }//GEN-LAST:event_btnCategoriasActionPerformed

    private void btnPrioridadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrioridadesActionPerformed
        
        Prioridades prioridades = new Prioridades(usuario);
        
        prioridades.addWindowListener(new java.awt.event.WindowAdapter () {
            @Override
            public void windowClosed(java.awt.event.WindowEvent e) {
                cargarFiltros();
                aplicarFiltros();
            }
        });      
        
        prioridades.setVisible(true);
        
    }//GEN-LAST:event_btnPrioridadesActionPerformed

    private void btnCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarSesionActionPerformed
        
        Login login = new Login();
        
        login.setVisible(true);
        
        this.dispose();
        
    }//GEN-LAST:event_btnCerrarSesionActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCategorias;
    private javax.swing.JButton btnCerrarSesion;
    private javax.swing.JButton btnCompletadoTarea;
    private javax.swing.JButton btnEditarTarea;
    private javax.swing.JButton btnEliminarTarea;
    private javax.swing.JButton btnInfoIntegrantes;
    private javax.swing.JButton btnLimpiarFiltro;
    private javax.swing.JButton btnNuevaTarea;
    private javax.swing.JButton btnPrioridades;
    private javax.swing.JButton btnVerDetallesTarea;
    private javax.swing.JComboBox<String> cbCategoria;
    private javax.swing.JComboBox<String> cbEstado;
    private javax.swing.JComboBox<String> cbPrioridad;
    private javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JLabel lblAcciones;
    private javax.swing.JLabel lblCategoriaFiltro;
    private javax.swing.JLabel lblEstadoFiltro;
    private javax.swing.JLabel lblLupaIcono;
    private javax.swing.JLabel lblPrioridadFiltro;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel panelAcciones;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JPanel panelTituloInicio;
    private javax.swing.JTable tablaTareas;
    private javax.swing.JTextField txtBuscarPorTitulo;
    // End of variables declaration//GEN-END:variables
}
