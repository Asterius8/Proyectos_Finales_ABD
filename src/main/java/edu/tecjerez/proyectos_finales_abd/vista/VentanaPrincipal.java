package edu.tecjerez.proyectos_finales_abd.vista;

import edu.tecjerez.proyectos_finales_abd.Controlador.CopiaPeliculaDAO;
import edu.tecjerez.proyectos_finales_abd.Controlador.PeliculaDAO;
import edu.tecjerez.proyectos_finales_abd.Controlador.SucursalDAO;
import edu.tecjerez.proyectos_finales_abd.Modelo.CopiaPelicula;
import edu.tecjerez.proyectos_finales_abd.Modelo.HistorialSucursales;
import edu.tecjerez.proyectos_finales_abd.Modelo.Pelicula;
import edu.tecjerez.proyectos_finales_abd.Modelo.Sucursal;
import edu.tecjerez.proyectos_finales_abd.Modelo.SucursalMemento;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class VentanaPrincipal extends javax.swing.JFrame {
    
    //Atributos
    String num_Suc, calle, ciudad, estado, cod_pos, tel, num_catalogo, titulo, categoria, actores, director, estadoCP, num_CopiaPelicula;
    float cos_alqui, cos_adqui;
    DefaultTableModel modelo, modeloPelicula, modeloCopiaPelicula, modelo1;
    private HistorialSucursales historialSucursales = new HistorialSucursales();

    public VentanaPrincipal() throws SQLException {
        
        setTitle("VideoClub");
        initComponents();
        setLocationRelativeTo(null);
        modelo = (DefaultTableModel) tbl_sucursal.getModel();
        modelo1 = (DefaultTableModel) tbl_sucursal1.getModel();
        modeloPelicula = (DefaultTableModel)  tbl_Pelicula.getModel();
        modeloCopiaPelicula = (DefaultTableModel)  tbl_CopiaPelicula.getModel();
        
        
        this.mostrar();
        this.mostrar1();
        this.mostrarPeliculas();
        this.mostrarCopiasPeliculas();
        
        tpnVideo.addChangeListener(e -> {
        
        int index = tpnVideo.getSelectedIndex();
        
        String tituloPestania = tpnVideo.getTitleAt(index);
        
        if ("Copias de Peliculas".equals(tituloPestania)) {
            
            try {
                
                cargarSucursales();
                cargarPeliculas();
                validarDatosIniciales();
                
            } catch (SQLException ex) {
                
                Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                
            }
            
        }
        
        });
        
    }
    
    public void cancelar(){
    
        Login l = new Login();
        l.setVisible(true);
        this.dispose();
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        btgSuc = new javax.swing.ButtonGroup();
        tpnVideo = new javax.swing.JTabbedPane();
        panSuc = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        lblSuc = new javax.swing.JLabel();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        panAgrSuc = new javax.swing.JPanel();
        lblInsSuc = new javax.swing.JLabel();
        lblNumSuc = new javax.swing.JLabel();
        lblCalSuc = new javax.swing.JLabel();
        lblCiuSuc = new javax.swing.JLabel();
        lblEstSuc = new javax.swing.JLabel();
        lblCodSuc = new javax.swing.JLabel();
        lblTelSuc = new javax.swing.JLabel();
        txtNumSuc = new javax.swing.JTextField();
        txtCalSuc = new javax.swing.JTextField();
        txtCiuSuc = new javax.swing.JTextField();
        txtEstSuc = new javax.swing.JTextField();
        txtCodSuc = new javax.swing.JTextField();
        txtTelSuc = new javax.swing.JTextField();
        btnAgrSuc = new javax.swing.JButton();
        btnCanSuc = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JSeparator();
        jScrollPane5 = new javax.swing.JScrollPane();
        tbl_sucursal = new javax.swing.JTable();
        panBusSuc = new javax.swing.JPanel();
        jrbMosTodSuc = new javax.swing.JRadioButton();
        jrbNumSuc = new javax.swing.JRadioButton();
        jrbCalleSuc = new javax.swing.JRadioButton();
        jrbCiudadSuc = new javax.swing.JRadioButton();
        jrbEstadoSuc = new javax.swing.JRadioButton();
        jrbCodPosSuc = new javax.swing.JRadioButton();
        jrbTelSuc = new javax.swing.JRadioButton();
        txtNumSuc1 = new javax.swing.JTextField();
        txtCalSuc1 = new javax.swing.JTextField();
        txtCiuSuc1 = new javax.swing.JTextField();
        txtEstSuc1 = new javax.swing.JTextField();
        txtCodSuc1 = new javax.swing.JTextField();
        txtTelSuc1 = new javax.swing.JTextField();
        btnEliSuc = new javax.swing.JButton();
        btnEdiSuc = new javax.swing.JButton();
        btnCanSuc1 = new javax.swing.JButton();
        jSeparator5 = new javax.swing.JSeparator();
        jScrollPane6 = new javax.swing.JScrollPane();
        tbl_sucursal1 = new javax.swing.JTable();
        btnDesSuc = new javax.swing.JButton();
        panPel = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        lblPel = new javax.swing.JLabel();
        jTabbedPane4 = new javax.swing.JTabbedPane();
        jPanel16 = new javax.swing.JPanel();
        lblInsPel = new javax.swing.JLabel();
        lblNumCatPel = new javax.swing.JLabel();
        txtNumCatPel = new javax.swing.JTextField();
        lblTitPel = new javax.swing.JLabel();
        txtTitPel = new javax.swing.JTextField();
        lblGenPel = new javax.swing.JLabel();
        txtCatPel = new javax.swing.JTextField();
        lblCosAlqPel = new javax.swing.JLabel();
        txtCosAlqPel = new javax.swing.JTextField();
        lblDirPel = new javax.swing.JLabel();
        txtDirPel = new javax.swing.JTextField();
        lblCosAdqPel = new javax.swing.JLabel();
        txtCosAdqPel = new javax.swing.JTextField();
        lblActPel = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        txaActPel = new javax.swing.JTextArea();
        btnAgrPel = new javax.swing.JButton();
        btnCanPel = new javax.swing.JButton();
        jSeparator6 = new javax.swing.JSeparator();
        jScrollPane8 = new javax.swing.JScrollPane();
        tbl_Pelicula = new javax.swing.JTable();
        jPanel17 = new javax.swing.JPanel();
        jRadioButton28 = new javax.swing.JRadioButton();
        jRadioButton29 = new javax.swing.JRadioButton();
        jRadioButton30 = new javax.swing.JRadioButton();
        jRadioButton31 = new javax.swing.JRadioButton();
        jRadioButton32 = new javax.swing.JRadioButton();
        jRadioButton33 = new javax.swing.JRadioButton();
        txtCosAdqPel1 = new javax.swing.JTextField();
        txtCosAlqPel1 = new javax.swing.JTextField();
        txtCatPel1 = new javax.swing.JTextField();
        txtNumCatPel1 = new javax.swing.JTextField();
        txtDirPel1 = new javax.swing.JTextField();
        jRadioButton34 = new javax.swing.JRadioButton();
        jScrollPane9 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        btnEliPel = new javax.swing.JButton();
        btnEdiPel = new javax.swing.JButton();
        btnBusPel = new javax.swing.JButton();
        btnCanPel1 = new javax.swing.JButton();
        jSeparator7 = new javax.swing.JSeparator();
        jScrollPane10 = new javax.swing.JScrollPane();
        jTable8 = new javax.swing.JTable();
        panCop = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
        lblCop = new javax.swing.JLabel();
        jTabbedPane5 = new javax.swing.JTabbedPane();
        jPanel20 = new javax.swing.JPanel();
        lblInsCop = new javax.swing.JLabel();
        lblNumCop = new javax.swing.JLabel();
        txtNumCop = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        comboEstado = new javax.swing.JComboBox<>();
        lblSucursal = new javax.swing.JLabel();
        comboSucursal = new javax.swing.JComboBox<>();
        lblNumCat = new javax.swing.JLabel();
        comboPeliculas = new javax.swing.JComboBox<>();
        btnAgrCop = new javax.swing.JButton();
        btnCanCop = new javax.swing.JButton();
        jSeparator8 = new javax.swing.JSeparator();
        jScrollPane11 = new javax.swing.JScrollPane();
        tbl_CopiaPelicula = new javax.swing.JTable();
        jPanel21 = new javax.swing.JPanel();
        jRadioButton35 = new javax.swing.JRadioButton();
        jRadioButton36 = new javax.swing.JRadioButton();
        jRadioButton37 = new javax.swing.JRadioButton();
        jRadioButton38 = new javax.swing.JRadioButton();
        jRadioButton39 = new javax.swing.JRadioButton();
        txtNumCop1 = new javax.swing.JTextField();
        jComboBox10 = new javax.swing.JComboBox<>();
        jComboBox11 = new javax.swing.JComboBox<>();
        jComboBox12 = new javax.swing.JComboBox<>();
        btnEliCop = new javax.swing.JButton();
        btnEdiCop = new javax.swing.JButton();
        btnBusCop = new javax.swing.JButton();
        btnCanCop1 = new javax.swing.JButton();
        jSeparator9 = new javax.swing.JSeparator();
        jScrollPane12 = new javax.swing.JScrollPane();
        jTable10 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tpnVideo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tpnVideoMouseClicked(evt);
            }
        });

        jPanel11.setBackground(new java.awt.Color(0, 204, 0));

        lblSuc.setFont(new java.awt.Font("Arial", 3, 36)); // NOI18N
        lblSuc.setText("Sucursal");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(lblSuc, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblSuc)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblInsSuc.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lblInsSuc.setText("Ingrese la informacion de los siguientes campos");

        lblNumSuc.setText("Numero de Sucursal");

        lblCalSuc.setText("Calle");

        lblCiuSuc.setText("Ciudad");

        lblEstSuc.setText("Estado");

        lblCodSuc.setText("Codigo Postal");

        lblTelSuc.setText("Teléfono");

        txtNumSuc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNumSucKeyTyped(evt);
            }
        });

        txtCodSuc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCodSucKeyTyped(evt);
            }
        });

        txtTelSuc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelSucKeyTyped(evt);
            }
        });

        btnAgrSuc.setText("Agregar");
        btnAgrSuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgrSucActionPerformed(evt);
            }
        });

        btnCanSuc.setText("Cancelar");
        btnCanSuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCanSucActionPerformed(evt);
            }
        });

        tbl_sucursal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Num Sucursal", "Calle", "Ciudad", "Estado", "Codigo Postal", "Telefono"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(tbl_sucursal);

        javax.swing.GroupLayout panAgrSucLayout = new javax.swing.GroupLayout(panAgrSuc);
        panAgrSuc.setLayout(panAgrSucLayout);
        panAgrSucLayout.setHorizontalGroup(
            panAgrSucLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator4)
            .addGroup(panAgrSucLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panAgrSucLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5)
                    .addGroup(panAgrSucLayout.createSequentialGroup()
                        .addGroup(panAgrSucLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panAgrSucLayout.createSequentialGroup()
                                .addGroup(panAgrSucLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblNumSuc)
                                    .addComponent(lblCalSuc)
                                    .addComponent(lblCiuSuc))
                                .addGap(18, 18, 18)
                                .addGroup(panAgrSucLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtNumSuc, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                    .addComponent(txtCalSuc)
                                    .addComponent(txtCiuSuc))
                                .addGap(93, 93, 93)
                                .addGroup(panAgrSucLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblCodSuc)
                                    .addComponent(lblTelSuc)
                                    .addComponent(lblEstSuc, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(panAgrSucLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtEstSuc)
                                    .addComponent(txtCodSuc)
                                    .addComponent(txtTelSuc, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(lblInsSuc)
                            .addGroup(panAgrSucLayout.createSequentialGroup()
                                .addComponent(btnAgrSuc)
                                .addGap(18, 18, 18)
                                .addComponent(btnCanSuc)))
                        .addGap(0, 543, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panAgrSucLayout.setVerticalGroup(
            panAgrSucLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panAgrSucLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblInsSuc)
                .addGap(18, 18, 18)
                .addGroup(panAgrSucLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNumSuc)
                    .addComponent(txtNumSuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEstSuc)
                    .addComponent(txtEstSuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panAgrSucLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCalSuc)
                    .addComponent(txtCalSuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCodSuc)
                    .addComponent(txtCodSuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panAgrSucLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCiuSuc)
                    .addComponent(txtCiuSuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTelSuc)
                    .addComponent(txtTelSuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panAgrSucLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgrSuc)
                    .addComponent(btnCanSuc))
                .addGap(18, 18, 18)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 321, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane3.addTab("Agregar", panAgrSuc);

        btgSuc.add(jrbMosTodSuc);
        jrbMosTodSuc.setSelected(true);
        jrbMosTodSuc.setText("Mostrar Todo");
        jrbMosTodSuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbMosTodSucActionPerformed(evt);
            }
        });

        btgSuc.add(jrbNumSuc);
        jrbNumSuc.setText("Numero de Sucursal");
        jrbNumSuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbNumSucActionPerformed(evt);
            }
        });

        btgSuc.add(jrbCalleSuc);
        jrbCalleSuc.setText("Calle");
        jrbCalleSuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbCalleSucActionPerformed(evt);
            }
        });

        btgSuc.add(jrbCiudadSuc);
        jrbCiudadSuc.setText("Ciudad");
        jrbCiudadSuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbCiudadSucActionPerformed(evt);
            }
        });

        btgSuc.add(jrbEstadoSuc);
        jrbEstadoSuc.setText("Estado");
        jrbEstadoSuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbEstadoSucActionPerformed(evt);
            }
        });

        btgSuc.add(jrbCodPosSuc);
        jrbCodPosSuc.setText("Codigo Postal");
        jrbCodPosSuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbCodPosSucActionPerformed(evt);
            }
        });

        btgSuc.add(jrbTelSuc);
        jrbTelSuc.setText("Teléfono");
        jrbTelSuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbTelSucActionPerformed(evt);
            }
        });

        txtNumSuc1.setEnabled(false);
        txtNumSuc1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNumSuc1KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNumSuc1KeyTyped(evt);
            }
        });

        txtCalSuc1.setEnabled(false);
        txtCalSuc1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCalSuc1KeyReleased(evt);
            }
        });

        txtCiuSuc1.setEnabled(false);
        txtCiuSuc1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCiuSuc1KeyReleased(evt);
            }
        });

        txtEstSuc1.setEnabled(false);
        txtEstSuc1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtEstSuc1KeyReleased(evt);
            }
        });

        txtCodSuc1.setEnabled(false);
        txtCodSuc1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCodSuc1KeyReleased(evt);
            }
        });

        txtTelSuc1.setEnabled(false);
        txtTelSuc1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTelSuc1KeyReleased(evt);
            }
        });

        btnEliSuc.setText("Eliminar");
        btnEliSuc.setEnabled(false);
        btnEliSuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliSucActionPerformed(evt);
            }
        });

        btnEdiSuc.setText("Editar");
        btnEdiSuc.setEnabled(false);

        btnCanSuc1.setText("Cancelar");
        btnCanSuc1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCanSuc1ActionPerformed(evt);
            }
        });

        tbl_sucursal1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Numero de Sucursal", "Calle", "Ciudad", "Estado", "Codigo Postal", "Telefono"
            }
        ));
        tbl_sucursal1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_sucursal1MouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(tbl_sucursal1);

        btnDesSuc.setText("Deshacer");
        btnDesSuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesSucActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panBusSucLayout = new javax.swing.GroupLayout(panBusSuc);
        panBusSuc.setLayout(panBusSucLayout);
        panBusSucLayout.setHorizontalGroup(
            panBusSucLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator5, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(panBusSucLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 1153, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(panBusSucLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panBusSucLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jrbMosTodSuc)
                    .addGroup(panBusSucLayout.createSequentialGroup()
                        .addGroup(panBusSucLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jrbNumSuc)
                            .addComponent(jrbCalleSuc)
                            .addComponent(jrbCiudadSuc))
                        .addGap(18, 18, 18)
                        .addGroup(panBusSucLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNumSuc1)
                            .addComponent(txtCalSuc1)
                            .addComponent(txtCiuSuc1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(126, 126, 126)
                        .addGroup(panBusSucLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jrbCodPosSuc)
                            .addComponent(jrbEstadoSuc)
                            .addComponent(jrbTelSuc))
                        .addGap(18, 18, 18)
                        .addGroup(panBusSucLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtEstSuc1)
                            .addComponent(txtCodSuc1)
                            .addComponent(txtTelSuc1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panBusSucLayout.createSequentialGroup()
                        .addComponent(btnEliSuc)
                        .addGap(18, 18, 18)
                        .addComponent(btnDesSuc)
                        .addGap(18, 18, 18)
                        .addComponent(btnEdiSuc)
                        .addGap(18, 18, 18)
                        .addComponent(btnCanSuc1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panBusSucLayout.setVerticalGroup(
            panBusSucLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panBusSucLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jrbMosTodSuc)
                .addGap(18, 18, 18)
                .addGroup(panBusSucLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jrbNumSuc)
                    .addComponent(txtNumSuc1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jrbEstadoSuc)
                    .addComponent(txtEstSuc1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panBusSucLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jrbCalleSuc)
                    .addComponent(txtCalSuc1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jrbCodPosSuc)
                    .addComponent(txtCodSuc1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panBusSucLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jrbCiudadSuc)
                    .addComponent(txtCiuSuc1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jrbTelSuc)
                    .addComponent(txtTelSuc1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panBusSucLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEliSuc)
                    .addComponent(btnEdiSuc)
                    .addComponent(btnCanSuc1)
                    .addComponent(btnDesSuc))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        jTabbedPane3.addTab("Buscar", panBusSuc);

        javax.swing.GroupLayout panSucLayout = new javax.swing.GroupLayout(panSuc);
        panSuc.setLayout(panSucLayout);
        panSucLayout.setHorizontalGroup(
            panSucLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jTabbedPane3)
        );
        panSucLayout.setVerticalGroup(
            panSucLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panSucLayout.createSequentialGroup()
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane3))
        );

        tpnVideo.addTab("Sucursal", panSuc);

        jPanel15.setBackground(new java.awt.Color(255, 153, 0));

        lblPel.setFont(new java.awt.Font("Arial", 3, 36)); // NOI18N
        lblPel.setText("Pelicula");

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(lblPel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblPel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblInsPel.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lblInsPel.setText("Ingrese la informacion de los siguientes campos");

        lblNumCatPel.setText("Numero de Catálogo");

        txtNumCatPel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNumCatPelKeyTyped(evt);
            }
        });

        lblTitPel.setText("Titulo");

        lblGenPel.setText("Categoria");

        lblCosAlqPel.setText("Coste de Alquiler");

        txtCosAlqPel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCosAlqPelKeyTyped(evt);
            }
        });

        lblDirPel.setText("Director");

        lblCosAdqPel.setText("Coste de Adquisición");

        txtCosAdqPel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCosAdqPelKeyTyped(evt);
            }
        });

        lblActPel.setText("Actores");

        txaActPel.setColumns(20);
        txaActPel.setRows(5);
        jScrollPane7.setViewportView(txaActPel);

        btnAgrPel.setText("Agregar");
        btnAgrPel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgrPelActionPerformed(evt);
            }
        });

        btnCanPel.setText("Cancelar");
        btnCanPel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCanPelActionPerformed(evt);
            }
        });

        tbl_Pelicula.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Numero de catalogo", "Titulo", "Categoria", "Director", "Costo de Alquiler", "Coste de Adquisicion", "Actores"
            }
        ));
        jScrollPane8.setViewportView(tbl_Pelicula);

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator6)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblInsPel)
                            .addGroup(jPanel16Layout.createSequentialGroup()
                                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel16Layout.createSequentialGroup()
                                        .addComponent(lblCosAdqPel)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtCosAdqPel, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel16Layout.createSequentialGroup()
                                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblNumCatPel)
                                            .addComponent(lblTitPel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lblGenPel)
                                            .addComponent(lblCosAlqPel)
                                            .addComponent(lblDirPel))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtNumCatPel)
                                            .addComponent(txtTitPel)
                                            .addComponent(txtCatPel, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                            .addComponent(txtCosAlqPel)
                                            .addComponent(txtDirPel))))
                                .addGap(80, 80, 80)
                                .addComponent(lblActPel)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel16Layout.createSequentialGroup()
                                .addComponent(btnAgrPel)
                                .addGap(18, 18, 18)
                                .addComponent(btnCanPel)))
                        .addGap(0, 375, Short.MAX_VALUE))
                    .addComponent(jScrollPane8))
                .addContainerGap())
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblInsPel)
                .addGap(18, 18, 18)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNumCatPel)
                            .addComponent(txtNumCatPel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblActPel))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTitPel)
                            .addComponent(txtTitPel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblGenPel)
                            .addComponent(txtCatPel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblDirPel)
                            .addComponent(txtDirPel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCosAlqPel)
                            .addComponent(txtCosAlqPel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCosAdqPel)
                            .addComponent(txtCosAdqPel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane7))
                .addGap(18, 18, 18)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgrPel)
                    .addComponent(btnCanPel))
                .addGap(18, 18, 18)
                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane4.addTab("Agregar", jPanel16);

        jRadioButton28.setText("Mostrar Todo");

        jRadioButton29.setText("Numero de Catalogo");

        jRadioButton30.setText("Categoria");

        jRadioButton31.setText("Coste de Alquiler");

        jRadioButton32.setText("Coste de Adquisicion");

        jRadioButton33.setText("Director");

        jRadioButton34.setText("Actores");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane9.setViewportView(jTextArea1);

        btnEliPel.setText("Eliminar");

        btnEdiPel.setText("Editar");

        btnBusPel.setText("Buscar");

        btnCanPel1.setText("Cancelar");
        btnCanPel1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCanPel1ActionPerformed(evt);
            }
        });

        jTable8.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane10.setViewportView(jTable8);

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator7)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel17Layout.createSequentialGroup()
                                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel17Layout.createSequentialGroup()
                                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jRadioButton29)
                                            .addComponent(jRadioButton28))
                                        .addGap(18, 18, 18)
                                        .addComponent(txtNumCatPel1, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE))
                                    .addGroup(jPanel17Layout.createSequentialGroup()
                                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jRadioButton32)
                                            .addComponent(jRadioButton31)
                                            .addComponent(jRadioButton30)
                                            .addComponent(jRadioButton33))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtCosAdqPel1, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                            .addComponent(txtCosAlqPel1)
                                            .addComponent(txtCatPel1)
                                            .addComponent(txtDirPel1))))
                                .addGap(64, 64, 64)
                                .addComponent(jRadioButton34)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel17Layout.createSequentialGroup()
                                .addComponent(btnEliPel)
                                .addGap(18, 18, 18)
                                .addComponent(btnEdiPel)
                                .addGap(18, 18, 18)
                                .addComponent(btnBusPel)
                                .addGap(18, 18, 18)
                                .addComponent(btnCanPel1)))
                        .addGap(0, 368, Short.MAX_VALUE))
                    .addComponent(jScrollPane10))
                .addContainerGap())
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jRadioButton28)
                            .addComponent(jRadioButton34))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jRadioButton29)
                            .addComponent(txtNumCatPel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jRadioButton30)
                            .addComponent(txtCatPel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jRadioButton31)
                            .addComponent(txtCosAlqPel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jRadioButton32)
                            .addComponent(txtCosAdqPel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jRadioButton33)
                            .addComponent(txtDirPel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEliPel)
                    .addComponent(btnEdiPel)
                    .addComponent(btnBusPel)
                    .addComponent(btnCanPel1))
                .addGap(18, 18, 18)
                .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane4.addTab("Buscar", jPanel17);

        javax.swing.GroupLayout panPelLayout = new javax.swing.GroupLayout(panPel);
        panPel.setLayout(panPelLayout);
        panPelLayout.setHorizontalGroup(
            panPelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jTabbedPane4)
        );
        panPelLayout.setVerticalGroup(
            panPelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panPelLayout.createSequentialGroup()
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 597, Short.MAX_VALUE))
        );

        tpnVideo.addTab("Pelicula", panPel);

        panCop.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panCopMouseClicked(evt);
            }
        });

        jPanel19.setBackground(new java.awt.Color(153, 153, 255));

        lblCop.setFont(new java.awt.Font("Arial", 3, 36)); // NOI18N
        lblCop.setText("Copias de Peliculas");

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lblCop, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblCop)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblInsCop.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lblInsCop.setText("Ingrese la informacion de los siguientes campos");

        lblNumCop.setText("Numero de Copia");

        txtNumCop.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNumCopKeyTyped(evt);
            }
        });

        jLabel1.setText("Estado de la Pelicula");

        comboEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Elija una opcion", "Disponible", "Rentada", "Dañada" }));

        lblSucursal.setText("Sucursal");

        lblNumCat.setText("Numero de Catalogo");

        btnAgrCop.setText("Agregar");
        btnAgrCop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgrCopActionPerformed(evt);
            }
        });

        btnCanCop.setText("Cancelar");
        btnCanCop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCanCopActionPerformed(evt);
            }
        });

        tbl_CopiaPelicula.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Numero de Copia", "Estado de la Pelicula", "Sucursal", "Numero de Catalogo"
            }
        ));
        jScrollPane11.setViewportView(tbl_CopiaPelicula);

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator8)
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblInsCop)
                            .addGroup(jPanel20Layout.createSequentialGroup()
                                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblNumCat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblNumCop)
                                    .addComponent(lblSucursal)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtNumCop)
                                    .addComponent(comboEstado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(comboSucursal, 0, 150, Short.MAX_VALUE)
                                    .addComponent(comboPeliculas, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel20Layout.createSequentialGroup()
                                .addComponent(btnAgrCop)
                                .addGap(18, 18, 18)
                                .addComponent(btnCanCop)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane11, javax.swing.GroupLayout.DEFAULT_SIZE, 1153, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblInsCop)
                .addGap(18, 18, 18)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNumCop)
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addComponent(txtNumCop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(comboEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(comboSucursal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblSucursal))))
                .addGap(18, 18, 18)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNumCat)
                    .addComponent(comboPeliculas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgrCop)
                    .addComponent(btnCanCop))
                .addGap(18, 18, 18)
                .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane5.addTab("Agregar", jPanel20);

        jRadioButton35.setText("Mostar Todo");

        jRadioButton36.setText("Numero de Copia");

        jRadioButton37.setText("Estado");

        jRadioButton38.setText("Numero de Sucursal");

        jRadioButton39.setText("Numero de Catalogo");

        jComboBox10.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBox11.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBox12.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnEliCop.setText("Eliminar");

        btnEdiCop.setText("Editar");

        btnBusCop.setText("Buscar");

        btnCanCop1.setText("Cancelar");
        btnCanCop1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCanCop1ActionPerformed(evt);
            }
        });

        jTable10.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane12.setViewportView(jTable10);

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator9)
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jRadioButton35)
                            .addGroup(jPanel21Layout.createSequentialGroup()
                                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jRadioButton36)
                                    .addComponent(jRadioButton37))
                                .addGap(36, 36, 36)
                                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jComboBox10, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNumCop1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel21Layout.createSequentialGroup()
                                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jRadioButton39)
                                    .addComponent(jRadioButton38))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jComboBox11, 0, 150, Short.MAX_VALUE)
                                    .addComponent(jComboBox12, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel21Layout.createSequentialGroup()
                                .addComponent(btnEliCop)
                                .addGap(18, 18, 18)
                                .addComponent(btnEdiCop)
                                .addGap(18, 18, 18)
                                .addComponent(btnBusCop)
                                .addGap(18, 18, 18)
                                .addComponent(btnCanCop1)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane12, javax.swing.GroupLayout.DEFAULT_SIZE, 1152, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jRadioButton35)
                .addGap(18, 18, 18)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton36)
                    .addComponent(txtNumCop1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton37)
                    .addComponent(jComboBox10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton38)
                    .addComponent(jComboBox11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton39)
                    .addComponent(jComboBox12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEliCop)
                    .addComponent(btnEdiCop)
                    .addComponent(btnBusCop)
                    .addComponent(btnCanCop1))
                .addGap(18, 18, 18)
                .addComponent(jSeparator9, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jTabbedPane5.addTab("Buscar", jPanel21);

        javax.swing.GroupLayout panCopLayout = new javax.swing.GroupLayout(panCop);
        panCop.setLayout(panCopLayout);
        panCopLayout.setHorizontalGroup(
            panCopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jTabbedPane5)
        );
        panCopLayout.setVerticalGroup(
            panCopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panCopLayout.createSequentialGroup()
                .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane5))
        );

        tpnVideo.addTab("Copias de Peliculas", panCop);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tpnVideo)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tpnVideo)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCanSucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCanSucActionPerformed
       
        cancelar();
        
    }//GEN-LAST:event_btnCanSucActionPerformed

    private void btnCanSuc1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCanSuc1ActionPerformed

        cancelar();

    }//GEN-LAST:event_btnCanSuc1ActionPerformed

    private void btnCanPelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCanPelActionPerformed

        cancelar();

    }//GEN-LAST:event_btnCanPelActionPerformed

    private void btnCanPel1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCanPel1ActionPerformed
        
        cancelar();
        
    }//GEN-LAST:event_btnCanPel1ActionPerformed

    private void btnCanCopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCanCopActionPerformed

        cancelar();

    }//GEN-LAST:event_btnCanCopActionPerformed

    private void btnCanCop1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCanCop1ActionPerformed

        cancelar();
        
    }//GEN-LAST:event_btnCanCop1ActionPerformed

    private void btnAgrSucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgrSucActionPerformed

        num_Suc = txtNumSuc.getText();
        calle = txtCalSuc.getText();
        ciudad = txtCiuSuc.getText();
        estado = txtEstSuc.getText();
        cod_pos = txtCodSuc.getText();
        tel = txtTelSuc.getText();
        
        
        if( !(num_Suc.equals("")  || calle.equals("") || ciudad.equals("") || estado.equals("") || cod_pos.equals("") || tel.equals("")) ){
        
            if(SucursalDAO.nunSucursalIgual(num_Suc)){
            
                JOptionPane.showMessageDialog(this, "El numero de sucursal ya existe.");
            
            }else{
            
                try {
                    SucursalDAO.agregarSucursal(new Sucursal(num_Suc, calle, ciudad, estado, cod_pos,tel));
                    
                    JOptionPane.showMessageDialog(this, "Usuario creado correctamente");
                    
                    this.mostrar();
                } catch (SQLException ex) {
                    Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        
        }else{
        
            JOptionPane.showMessageDialog(this, "Todos los campos deben de ser llenados.");
            
        }

    }//GEN-LAST:event_btnAgrSucActionPerformed

    private void txtTelSucKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelSucKeyTyped

        char c = evt.getKeyChar();

        if (!Character.isDigit(c) || txtTelSuc.getText().length() >= 10) {

            evt.consume();

        }

    }//GEN-LAST:event_txtTelSucKeyTyped

    private void txtCodSucKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodSucKeyTyped

        char c = evt.getKeyChar();

        if (!Character.isDigit(c) || txtCodSuc.getText().length() >= 5) {

            evt.consume();

        }

    }//GEN-LAST:event_txtCodSucKeyTyped

    private void btnAgrPelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgrPelActionPerformed
  
        num_catalogo = txtNumCatPel.getText();
        titulo = txtTitPel.getText();
        categoria = txtCatPel.getText();
        cos_alqui = Float.parseFloat(txtCosAlqPel.getText());
        cos_adqui = Float.parseFloat(txtCosAdqPel.getText());
        actores = txaActPel.getText();
        director = txtDirPel.getText();
        
        if( !(num_catalogo.equals("") || titulo.equals("") || categoria.equals("") || actores.equals("") ||director.equals("")) ){
        
            if(PeliculaDAO.numPeliculaIgual(num_catalogo)){
            
                JOptionPane.showMessageDialog(this, "El numero de catalogo ya existe.");
            
            }else{
            
                try {
                    PeliculaDAO.agregarPelicula(new Pelicula(num_catalogo, titulo, categoria, cos_alqui, cos_adqui, actores, director));
                    
                    JOptionPane.showMessageDialog(this, "Pelicula agregada correctamente");
                    
                    this.mostrarPeliculas();
                    
                } catch (SQLException ex) {
                    
                    Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                    
                }
                
            }
            
        
        }else{
        
            JOptionPane.showMessageDialog(this, "Todos los campos deben de ser llenados.");
            
        }
        
        
        
    }//GEN-LAST:event_btnAgrPelActionPerformed

    private void txtCosAlqPelKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCosAlqPelKeyTyped
        
        char c = evt.getKeyChar();

        if (!Character.isDigit(c) && c != '.') {
            
            evt.consume(); 
            
        } else if (c == '.' && txtCosAlqPel.getText().contains(".")) {
            
            evt.consume();
            
        }
        
    }//GEN-LAST:event_txtCosAlqPelKeyTyped

    private void txtCosAdqPelKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCosAdqPelKeyTyped
        
        char c = evt.getKeyChar();

        if (!Character.isDigit(c) && c != '.') {
            
            evt.consume();
            
        } else if (c == '.' && txtCosAdqPel.getText().contains(".")) {
            
            evt.consume();
            
        }
    }//GEN-LAST:event_txtCosAdqPelKeyTyped

    private void txtNumSucKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumSucKeyTyped
        
        char c = evt.getKeyChar();

        if (!Character.isDigit(c)) {

            evt.consume();

        }
        
    }//GEN-LAST:event_txtNumSucKeyTyped

    private void txtNumCatPelKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumCatPelKeyTyped
        char c = evt.getKeyChar();

        if (!Character.isDigit(c)) {

            evt.consume();

        }
    }//GEN-LAST:event_txtNumCatPelKeyTyped

    private void tpnVideoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tpnVideoMouseClicked

    }//GEN-LAST:event_tpnVideoMouseClicked

    private void panCopMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panCopMouseClicked

    }//GEN-LAST:event_panCopMouseClicked

    private void txtNumCopKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumCopKeyTyped
        
        char c = evt.getKeyChar();

        if (!Character.isDigit(c)) {

            evt.consume();
        }
        
    }//GEN-LAST:event_txtNumCopKeyTyped

    private void btnAgrCopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgrCopActionPerformed
        
        num_CopiaPelicula = txtNumCop.getText();
        estadoCP = String.valueOf(comboEstado.getSelectedItem());
        num_Suc = String.valueOf(comboSucursal.getSelectedItem());
        num_catalogo = String.valueOf(comboPeliculas.getSelectedItem());
        
        if( !(num_CopiaPelicula.equals("") || comboEstado.getSelectedIndex() == 0 || comboSucursal.getSelectedIndex() == 0 || comboPeliculas.getSelectedIndex() == 0 ) ){
        
            if(CopiaPeliculaDAO.numCopiaPeliculaIgual(num_CopiaPelicula)){
            
                JOptionPane.showMessageDialog(this, "El numero de copia ya existe.");
                
            }else{
            
                try {
                    
                CopiaPeliculaDAO.agregarCopiaPelicula(new CopiaPelicula(num_CopiaPelicula, estadoCP, num_Suc, num_catalogo));
                
                JOptionPane.showMessageDialog(this, "Pelicula agregada correctamente");
                
                this.mostrarCopiasPeliculas();
                
                }catch (SQLException ex) {
                    
                    Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                    
                }
                
            }
        
        }else{
        
            JOptionPane.showMessageDialog(this, "Todos los campos deben de ser llenados.");
            
        }
        
    }//GEN-LAST:event_btnAgrCopActionPerformed

    private void jrbMosTodSucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbMosTodSucActionPerformed

        try {
            
            txtNumSuc1.enable(false);
            txtCalSuc1.enable(false);
            txtCiuSuc1.enable(false);
            txtEstSuc1.enable(false);
            txtCodSuc1.enable(false);
            txtTelSuc1.enable(false);
            vaciarComponentesSuc1();
            mostrar1();
            
        } catch (SQLException ex) {
            
            Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        
    }//GEN-LAST:event_jrbMosTodSucActionPerformed

    private void jrbNumSucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbNumSucActionPerformed

        txtNumSuc1.enable(true);
        txtCalSuc1.enable(false);
        txtCiuSuc1.enable(false);
        txtEstSuc1.enable(false);
        txtCodSuc1.enable(false);
        txtTelSuc1.enable(false);
        vaciarComponentesSuc1();

    }//GEN-LAST:event_jrbNumSucActionPerformed

    private void jrbCalleSucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbCalleSucActionPerformed
        txtNumSuc1.enable(false);
        txtCalSuc1.enable(true);
        txtCiuSuc1.enable(false);
        txtEstSuc1.enable(false);
        txtCodSuc1.enable(false);
        txtTelSuc1.enable(false);
        vaciarComponentesSuc1();
    }//GEN-LAST:event_jrbCalleSucActionPerformed

    private void jrbCiudadSucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbCiudadSucActionPerformed

        txtNumSuc1.enable(false);
        txtCalSuc1.enable(false);
        txtCiuSuc1.enable(true);
        txtEstSuc1.enable(false);
        txtCodSuc1.enable(false);
        txtTelSuc1.enable(false);
        vaciarComponentesSuc1();

    }//GEN-LAST:event_jrbCiudadSucActionPerformed

    private void jrbEstadoSucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbEstadoSucActionPerformed
        
        txtNumSuc1.enable(false);
        txtCalSuc1.enable(false);
        txtCiuSuc1.enable(false);
        txtEstSuc1.enable(true);
        txtCodSuc1.enable(false);
        txtTelSuc1.enable(false);
        vaciarComponentesSuc1();
    }//GEN-LAST:event_jrbEstadoSucActionPerformed

    private void jrbCodPosSucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbCodPosSucActionPerformed

        txtNumSuc1.enable(false);
        txtCalSuc1.enable(false);
        txtCiuSuc1.enable(false);
        txtEstSuc1.enable(false);
        txtCodSuc1.enable(true);
        txtTelSuc1.enable(false);
        vaciarComponentesSuc1();

    }//GEN-LAST:event_jrbCodPosSucActionPerformed

    private void jrbTelSucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbTelSucActionPerformed
        
        txtNumSuc1.enable(false);
        txtCalSuc1.enable(false);
        txtCiuSuc1.enable(false);
        txtEstSuc1.enable(false);
        txtCodSuc1.enable(false);
        txtTelSuc1.enable(true);
        vaciarComponentesSuc1();
        
    }//GEN-LAST:event_jrbTelSucActionPerformed

    private void txtNumSuc1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumSuc1KeyTyped

        

    }//GEN-LAST:event_txtNumSuc1KeyTyped

    private void txtNumSuc1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumSuc1KeyReleased
        
        try{
        
            ResultSet rs = SucursalDAO.numSucursal(txtNumSuc1.getText());
            mostrarfiltrados(rs);
        
        }catch (SQLException ex) {

                Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                
        }
        
    }//GEN-LAST:event_txtNumSuc1KeyReleased

    private void txtCalSuc1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCalSuc1KeyReleased
        
        try{
        
            ResultSet rs = SucursalDAO.calSucursal(txtCalSuc1.getText());
            mostrarfiltrados(rs);
        
        }catch (SQLException ex) {

                Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                
        }
        
    }//GEN-LAST:event_txtCalSuc1KeyReleased

    private void txtCiuSuc1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCiuSuc1KeyReleased
        try{
        
            ResultSet rs = SucursalDAO.ciuSucursal(txtCiuSuc1.getText());
            mostrarfiltrados(rs);
        
        }catch (SQLException ex) {

                Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                
        }
    }//GEN-LAST:event_txtCiuSuc1KeyReleased

    private void txtEstSuc1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEstSuc1KeyReleased
        try{
        
            ResultSet rs = SucursalDAO.estSucursal(txtEstSuc1.getText());
            mostrarfiltrados(rs);
        
        }catch (SQLException ex) {

                Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                
        }
    }//GEN-LAST:event_txtEstSuc1KeyReleased

    private void txtCodSuc1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodSuc1KeyReleased
        try{
        
            ResultSet rs = SucursalDAO.codSucursal(txtCodSuc1.getText());
            mostrarfiltrados(rs);
        
        }catch (SQLException ex) {

                Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                
        }
    }//GEN-LAST:event_txtCodSuc1KeyReleased

    private void txtTelSuc1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelSuc1KeyReleased
        try{
        
            ResultSet rs = SucursalDAO.telSucursal(txtTelSuc1.getText());
            mostrarfiltrados(rs);
        
        }catch (SQLException ex) {

                Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                
        }
    }//GEN-LAST:event_txtTelSuc1KeyReleased

    private void tbl_sucursal1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_sucursal1MouseClicked
        
        jrbMosTodSuc.setSelected(true);
        
        jrbMosTodSuc.setEnabled(false);
        jrbNumSuc.setEnabled(false);
        jrbCalleSuc.setEnabled(false);
        jrbCiudadSuc.setEnabled(false);
        jrbEstadoSuc.setEnabled(false);
        jrbCodPosSuc.setEnabled(false);
        jrbTelSuc.setEnabled(false);
        
        btnEliSuc.setEnabled(true);
        btnEdiSuc.setEnabled(true);
        
        txtNumSuc1.enable(false);
        txtCalSuc1.enable(true);
        txtCiuSuc1.enable(true);
        txtEstSuc1.enable(true);
        txtCodSuc1.enable(true);
        txtTelSuc1.enable(true);
        
        txtNumSuc1.setText(modelo1.getValueAt(tbl_sucursal1.getSelectedRow(), 0).toString());
        txtCalSuc1.setText(modelo1.getValueAt(tbl_sucursal1.getSelectedRow(), 1).toString());
        txtCiuSuc1.setText(modelo1.getValueAt(tbl_sucursal1.getSelectedRow(), 2).toString());
        txtEstSuc1.setText(modelo1.getValueAt(tbl_sucursal1.getSelectedRow(), 3).toString());
        txtCodSuc1.setText(modelo1.getValueAt(tbl_sucursal1.getSelectedRow(), 4).toString());
        txtTelSuc1.setText(modelo1.getValueAt(tbl_sucursal1.getSelectedRow(), 5).toString());
    }//GEN-LAST:event_tbl_sucursal1MouseClicked

    private void btnEliSucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliSucActionPerformed
        
        int opcion = JOptionPane.showConfirmDialog(
        null, 
        "¿Estás seguro de que deseas eliminar el registro?", 
        "Confirmación", 
        JOptionPane.YES_NO_OPTION
        );

        if (opcion == JOptionPane.YES_OPTION) {
            
            try {
                // El usuario hizo clic en "Sí"
                System.out.println("Acción confirmada");
                
                ResultSet sucursal = SucursalDAO.numSucursal(txtNumSuc1.getText());
                
                if(sucursal.next()){
                    
                    SucursalMemento memento = new SucursalMemento(
                            
                            sucursal.getString(1), sucursal.getString(2), sucursal.getString(3),
                            sucursal.getString(4), sucursal.getString(5), sucursal.getString(6)
                            
                    );
                    
                    historialSucursales.guardar(memento);
                    
                    SucursalDAO.eliminarSucursal(txtNumSuc1.getText());
                    
                    mostrar1();
                                    
                    JOptionPane.showMessageDialog(null, "Alumno eliminado correctamente");
                    
                }
                
            } catch (SQLException ex) {
                
                Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                
            }
            
        } else {
            // El usuario hizo clic en "No" o cerró el cuadro
            System.out.println("Acción cancelada");
        }
                
    }//GEN-LAST:event_btnEliSucActionPerformed

    private void btnDesSucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesSucActionPerformed
       
        SucursalMemento memento = historialSucursales.deshacer();
        
        if (memento != null) {
        
            if(SucursalDAO.restaurarSucursal(memento)){
            
                JOptionPane.showMessageDialog(this, "Alumno restaurado correctamente");
                try {
                    mostrar1();
                } catch (SQLException ex) {
                    Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                }
            
            } else {
                JOptionPane.showMessageDialog(this, "No se pudo restaurar el alumno");
            }
        } else {
            JOptionPane.showMessageDialog(this, "No hay alumnos para restaurar");
        
        }
        
    }//GEN-LAST:event_btnDesSucActionPerformed

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
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new VentanaPrincipal().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup btgSuc;
    private javax.swing.JButton btnAgrCop;
    private javax.swing.JButton btnAgrPel;
    private javax.swing.JButton btnAgrSuc;
    private javax.swing.JButton btnBusCop;
    private javax.swing.JButton btnBusPel;
    private javax.swing.JButton btnCanCop;
    private javax.swing.JButton btnCanCop1;
    private javax.swing.JButton btnCanPel;
    private javax.swing.JButton btnCanPel1;
    private javax.swing.JButton btnCanSuc;
    private javax.swing.JButton btnCanSuc1;
    private javax.swing.JButton btnDesSuc;
    private javax.swing.JButton btnEdiCop;
    private javax.swing.JButton btnEdiPel;
    private javax.swing.JButton btnEdiSuc;
    private javax.swing.JButton btnEliCop;
    private javax.swing.JButton btnEliPel;
    private javax.swing.JButton btnEliSuc;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> comboEstado;
    private javax.swing.JComboBox<String> comboPeliculas;
    private javax.swing.JComboBox<String> comboSucursal;
    private javax.swing.JComboBox<String> jComboBox10;
    private javax.swing.JComboBox<String> jComboBox11;
    private javax.swing.JComboBox<String> jComboBox12;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JRadioButton jRadioButton28;
    private javax.swing.JRadioButton jRadioButton29;
    private javax.swing.JRadioButton jRadioButton30;
    private javax.swing.JRadioButton jRadioButton31;
    private javax.swing.JRadioButton jRadioButton32;
    private javax.swing.JRadioButton jRadioButton33;
    private javax.swing.JRadioButton jRadioButton34;
    private javax.swing.JRadioButton jRadioButton35;
    private javax.swing.JRadioButton jRadioButton36;
    private javax.swing.JRadioButton jRadioButton37;
    private javax.swing.JRadioButton jRadioButton38;
    private javax.swing.JRadioButton jRadioButton39;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JTabbedPane jTabbedPane4;
    private javax.swing.JTabbedPane jTabbedPane5;
    private javax.swing.JTable jTable10;
    private javax.swing.JTable jTable8;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JRadioButton jrbCalleSuc;
    private javax.swing.JRadioButton jrbCiudadSuc;
    private javax.swing.JRadioButton jrbCodPosSuc;
    private javax.swing.JRadioButton jrbEstadoSuc;
    private javax.swing.JRadioButton jrbMosTodSuc;
    private javax.swing.JRadioButton jrbNumSuc;
    private javax.swing.JRadioButton jrbTelSuc;
    private javax.swing.JLabel lblActPel;
    private javax.swing.JLabel lblCalSuc;
    private javax.swing.JLabel lblCiuSuc;
    private javax.swing.JLabel lblCodSuc;
    private javax.swing.JLabel lblCop;
    private javax.swing.JLabel lblCosAdqPel;
    private javax.swing.JLabel lblCosAlqPel;
    private javax.swing.JLabel lblDirPel;
    private javax.swing.JLabel lblEstSuc;
    private javax.swing.JLabel lblGenPel;
    private javax.swing.JLabel lblInsCop;
    private javax.swing.JLabel lblInsPel;
    private javax.swing.JLabel lblInsSuc;
    private javax.swing.JLabel lblNumCat;
    private javax.swing.JLabel lblNumCatPel;
    private javax.swing.JLabel lblNumCop;
    private javax.swing.JLabel lblNumSuc;
    private javax.swing.JLabel lblPel;
    private javax.swing.JLabel lblSuc;
    private javax.swing.JLabel lblSucursal;
    private javax.swing.JLabel lblTelSuc;
    private javax.swing.JLabel lblTitPel;
    private javax.swing.JPanel panAgrSuc;
    private javax.swing.JPanel panBusSuc;
    private javax.swing.JPanel panCop;
    private javax.swing.JPanel panPel;
    private javax.swing.JPanel panSuc;
    private javax.swing.JTable tbl_CopiaPelicula;
    private javax.swing.JTable tbl_Pelicula;
    private javax.swing.JTable tbl_sucursal;
    private javax.swing.JTable tbl_sucursal1;
    private javax.swing.JTabbedPane tpnVideo;
    private javax.swing.JTextArea txaActPel;
    private javax.swing.JTextField txtCalSuc;
    private javax.swing.JTextField txtCalSuc1;
    private javax.swing.JTextField txtCatPel;
    private javax.swing.JTextField txtCatPel1;
    private javax.swing.JTextField txtCiuSuc;
    private javax.swing.JTextField txtCiuSuc1;
    private javax.swing.JTextField txtCodSuc;
    private javax.swing.JTextField txtCodSuc1;
    private javax.swing.JTextField txtCosAdqPel;
    private javax.swing.JTextField txtCosAdqPel1;
    private javax.swing.JTextField txtCosAlqPel;
    private javax.swing.JTextField txtCosAlqPel1;
    private javax.swing.JTextField txtDirPel;
    private javax.swing.JTextField txtDirPel1;
    private javax.swing.JTextField txtEstSuc;
    private javax.swing.JTextField txtEstSuc1;
    private javax.swing.JTextField txtNumCatPel;
    private javax.swing.JTextField txtNumCatPel1;
    private javax.swing.JTextField txtNumCop;
    private javax.swing.JTextField txtNumCop1;
    private javax.swing.JTextField txtNumSuc;
    private javax.swing.JTextField txtNumSuc1;
    private javax.swing.JTextField txtTelSuc;
    private javax.swing.JTextField txtTelSuc1;
    private javax.swing.JTextField txtTitPel;
    // End of variables declaration//GEN-END:variables

    
//Otros metodos   
    
    //
    public void vaciarComponentesSuc(){
        
        txtNumSuc.setText("");
        txtCalSuc.setText("");
        txtCiuSuc.setText("");
        txtEstSuc.setText("");
        txtCodSuc.setText("");
        txtTelSuc.setText("");

    }
    
    public void vaciarComponentesSuc1(){
        
        txtNumSuc1.setText("");
        txtCalSuc1.setText("");
        txtCiuSuc1.setText("");
        txtEstSuc1.setText("");
        txtCodSuc1.setText("");
        txtTelSuc1.setText("");

    }
    
    public void mostrar() throws SQLException {

        ResultSet rs = SucursalDAO.buscar();

        String datos[] = new String[6];

        //vaciar filas anteriores
        modelo.setRowCount(0);

        while (rs.next()) {
            
            datos[0] = rs.getString(1);
            datos[1] = rs.getString(2);
            datos[2] = rs.getString(3);
            datos[3] = rs.getString(4);
            datos[4] = rs.getString(5);
            datos[5] = rs.getString(6);
            
            
            modelo.addRow(datos);

        }

    }
    
    public void mostrar1() throws SQLException {

        ResultSet rs = SucursalDAO.buscar();

        String datos[] = new String[6];

        //vaciar filas anteriores
        modelo1.setRowCount(0);

        while (rs.next()) {
            
            datos[0] = rs.getString(1);
            datos[1] = rs.getString(2);
            datos[2] = rs.getString(3);
            datos[3] = rs.getString(4);
            datos[4] = rs.getString(5);
            datos[5] = rs.getString(6);
            
            
            modelo1.addRow(datos);

        }

    }
    
    public void mostrarPeliculas() throws SQLException {

        ResultSet rs = PeliculaDAO.buscar();

        String datos[] = new String[7];

        //vaciar filas anteriores
        modeloPelicula.setRowCount(0);

        while (rs.next()) {
            
            datos[0] = rs.getString(1);
            datos[1] = rs.getString(2);
            datos[2] = rs.getString(3);
            datos[3] = rs.getString(4);
            datos[4] = rs.getString(5);
            datos[5] = rs.getString(6);
            datos[6] = rs.getString(7);
            
            modeloPelicula.addRow(datos);

        }

    }
    
    public void mostrarCopiasPeliculas() throws SQLException{
    
        ResultSet rs = CopiaPeliculaDAO.buscar();
        
        String datos[] = new String[4];
        
        //vaciar filas anteriores
        modeloCopiaPelicula.setRowCount(0);
        
        while (rs.next()) {
            
            datos[0] = rs.getString(1);
            datos[1] = rs.getString(2);
            datos[2] = rs.getString(3);
            datos[3] = rs.getString(4);
            
            modeloCopiaPelicula.addRow(datos);

        }
        
    }
    
    //Metodos para comprobar la existencia de num sucursal y num catalogo
    private void cargarSucursales() throws SQLException{

        comboSucursal.removeAllItems();

        ResultSet rs = CopiaPeliculaDAO.buscarNumSucursal();
        comboSucursal.addItem("Elija una opcion");
        while (rs.next()) {
            
            comboSucursal.addItem(rs.getString("num_sucursal"));
            
        }
        
    }
    
    private void cargarPeliculas() throws SQLException{

        comboPeliculas.removeAllItems();

        ResultSet rs = CopiaPeliculaDAO.buscarNumCatalogo();
        comboPeliculas.addItem("Elija una opcion");
        while (rs.next()) {
            
            comboPeliculas.addItem(rs.getString("num_catalogo"));
            
        }
    
    }
    
    private void validarDatosIniciales() {
        
        if (comboSucursal.getItemCount() == 0 || comboPeliculas.getItemCount() == 0) {
        
            btnAgrCop.setEnabled(false); // Desactiva si faltan datos
        
            JOptionPane.showMessageDialog(this, "Debes registrar al menos una sucursal y una película antes de agregar copias.");
        
        } else {
        
            btnAgrCop.setEnabled(true);
        
        }
    
    }
    
    public void mostrarfiltrados(ResultSet rs) throws SQLException {

        String datos[] = new String[6];

        //vaciar filas anteriores
        modelo1.setRowCount(0);

        while (rs.next()) {
            
            datos[0] = rs.getString(1);
            datos[1] = rs.getString(2);
            datos[2] = rs.getString(3);
            datos[3] = rs.getString(4);
            datos[4] = rs.getString(5);
            datos[5] = rs.getString(6);
            modelo1.addRow(datos);
        }
          
    }
    
}

