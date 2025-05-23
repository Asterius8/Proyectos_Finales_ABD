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
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;

public class VentanaPrincipal extends javax.swing.JFrame {
    
//Atributos --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    String num_Suc, calle, ciudad, estado, cod_pos, tel, num_catalogo, titulo, categoria, actores, director, estadoCP, num_CopiaPelicula;
    float cos_alqui, cos_adqui;
    DefaultTableModel modelo, modelo1, modeloPelicula, modeloPelicula1, modeloCopiaPelicula;
    private HistorialSucursales historialSucursales = new HistorialSucursales();

//Constructor ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    public VentanaPrincipal() throws SQLException {
        
        setTitle("VideoClub");
        initComponents();
        setLocationRelativeTo(null);
        
        modelo = (DefaultTableModel) tbl_sucursal.getModel();
        modelo1 = (DefaultTableModel) tbl_sucursal1.getModel();
        modeloPelicula = (DefaultTableModel)  tbl_pelicula.getModel();
        modeloPelicula1 = (DefaultTableModel) tbl_pelicula1.getModel();
        modeloCopiaPelicula = (DefaultTableModel)  tbl_copiapelicula.getModel();
        
        ocultarSucursal();
        ocultarPelicula();
        
        this.mostrar();
        this.mostrar1();
        this.mostrarPeliculas();
        this.mostrarPeliculas1();
        this.mostrarCopiasPeliculas();
        //Evento para detectar el cambio de pestañas dentro de la VentanaPrincipal
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
        
        //Evento para detectar el cambio de pestañas dentro de la pestaña Sucursal
        tpnSucursal.addChangeListener(new javax.swing.event.ChangeListener() {
            
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
            
                int selectedIndex = tpnSucursal.getSelectedIndex();
        
                String selectedTitle = tpnSucursal.getTitleAt(selectedIndex);

                if (selectedTitle.equals("Agregar")) {
            
                    try {
                        
                        mostrar();
                        
                    } catch (SQLException ex) {
                        
                        Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                        
                    }
            
            
                } else if (selectedTitle.equals("Buscar")) {
            
                    try {
                        
                        mostrar1();
                        
                    } catch (SQLException ex) {
                        
                        Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                        
                    }
            
                }
        
            }
        
        });
        
        //Evento para detectar el cambio de pestañas dentro de pelicula
        tpnPelicula.addChangeListener(new javax.swing.event.ChangeListener() {
            
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
            
                int selectedIndex = tpnPelicula.getSelectedIndex();
        
                String selectedTitle = tpnPelicula.getTitleAt(selectedIndex);

                if (selectedTitle.equals("Agregar")) {
            
                    try {
                        
                        mostrarPeliculas();
                        
                    } catch (SQLException ex) {
                        
                        Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                        
                    }
            
            
                } else if (selectedTitle.equals("Buscar")) {
            
                    try {
                        
                        mostrarPeliculas1();
                        
                    } catch (SQLException ex) {
                        
                        Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                        
                    }
            
                }
        
            }
        
        });
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btgSuc = new javax.swing.ButtonGroup();
        btgSuc1 = new javax.swing.ButtonGroup();
        btgPel = new javax.swing.ButtonGroup();
        btgPel1 = new javax.swing.ButtonGroup();
        btgCop = new javax.swing.ButtonGroup();
        tpnVideo = new javax.swing.JTabbedPane();
        panSuc = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        lblSuc = new javax.swing.JLabel();
        btnCanSuc1 = new javax.swing.JButton();
        tpnSucursal = new javax.swing.JTabbedPane();
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
        jSeparator5 = new javax.swing.JSeparator();
        jScrollPane6 = new javax.swing.JScrollPane();
        tbl_sucursal1 = new javax.swing.JTable();
        btnDesSuc = new javax.swing.JButton();
        btnConfSuc = new javax.swing.JButton();
        lblTituloSuc = new javax.swing.JLabel();
        jrbMosFilSuc = new javax.swing.JRadioButton();
        lblResultadoSuc = new javax.swing.JLabel();
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
        panPel = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        lblPel = new javax.swing.JLabel();
        btnCanPel1 = new javax.swing.JButton();
        tpnPelicula = new javax.swing.JTabbedPane();
        panBusPel = new javax.swing.JPanel();
        jrbMosTodPel = new javax.swing.JRadioButton();
        jrbNumCatPel = new javax.swing.JRadioButton();
        jrbCatPel = new javax.swing.JRadioButton();
        jrbCosAlqPel = new javax.swing.JRadioButton();
        jrbCosAdqPel = new javax.swing.JRadioButton();
        jrbDirPel = new javax.swing.JRadioButton();
        jrbActPel = new javax.swing.JRadioButton();
        jrbTitPel = new javax.swing.JRadioButton();
        txtCosAdqPel1 = new javax.swing.JTextField();
        txtCosAlqPel1 = new javax.swing.JTextField();
        txtTitPel1 = new javax.swing.JTextField();
        txtCatPel1 = new javax.swing.JTextField();
        txtNumCatPel1 = new javax.swing.JTextField();
        txtDirPel1 = new javax.swing.JTextField();
        jScrollPane9 = new javax.swing.JScrollPane();
        txaActPel1 = new javax.swing.JTextArea();
        btnEliPel = new javax.swing.JButton();
        btnEdiPel = new javax.swing.JButton();
        btnDesPel = new javax.swing.JButton();
        jSeparator7 = new javax.swing.JSeparator();
        jScrollPane10 = new javax.swing.JScrollPane();
        tbl_pelicula1 = new javax.swing.JTable();
        lblTituloPel = new javax.swing.JLabel();
        jrbMosFilPel = new javax.swing.JRadioButton();
        lblResultadoPel = new javax.swing.JLabel();
        btnAcePel = new javax.swing.JButton();
        panAgrPel = new javax.swing.JPanel();
        lblInsPel = new javax.swing.JLabel();
        lblNumCatPel = new javax.swing.JLabel();
        lblTitPel = new javax.swing.JLabel();
        lblGenPel = new javax.swing.JLabel();
        lblCosAlqPel = new javax.swing.JLabel();
        lblDirPel = new javax.swing.JLabel();
        lblCosAdqPel = new javax.swing.JLabel();
        lblActPel = new javax.swing.JLabel();
        txtNumCatPel = new javax.swing.JTextField();
        txtTitPel = new javax.swing.JTextField();
        txtCatPel = new javax.swing.JTextField();
        txtCosAlqPel = new javax.swing.JTextField();
        txtDirPel = new javax.swing.JTextField();
        txtCosAdqPel = new javax.swing.JTextField();
        jScrollPane7 = new javax.swing.JScrollPane();
        txaActPel = new javax.swing.JTextArea();
        btnAgrPel = new javax.swing.JButton();
        btnCanPel = new javax.swing.JButton();
        jSeparator6 = new javax.swing.JSeparator();
        jScrollPane8 = new javax.swing.JScrollPane();
        tbl_pelicula = new javax.swing.JTable();
        panCop = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
        lblCop = new javax.swing.JLabel();
        jTabbedPane5 = new javax.swing.JTabbedPane();
        panAgrCop = new javax.swing.JPanel();
        lblInsCop = new javax.swing.JLabel();
        txtNumCop = new javax.swing.JTextField();
        comboEstado = new javax.swing.JComboBox<>();
        comboSucursal = new javax.swing.JComboBox<>();
        comboPeliculas = new javax.swing.JComboBox<>();
        lblNumCop = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblSucursal = new javax.swing.JLabel();
        lblNumCat = new javax.swing.JLabel();
        btnAgrCop = new javax.swing.JButton();
        btnCanCop = new javax.swing.JButton();
        jSeparator8 = new javax.swing.JSeparator();
        jScrollPane11 = new javax.swing.JScrollPane();
        tbl_copiapelicula = new javax.swing.JTable();
        panBusCop = new javax.swing.JPanel();
        jrbMosTodCop = new javax.swing.JRadioButton();
        jrbNumCopCop = new javax.swing.JRadioButton();
        jrbEstCop = new javax.swing.JRadioButton();
        jrbNumSucCop = new javax.swing.JRadioButton();
        jrbNumCatCop = new javax.swing.JRadioButton();
        txtNumCop1 = new javax.swing.JTextField();
        comboEstado1 = new javax.swing.JComboBox<>();
        comboSucursal1 = new javax.swing.JComboBox<>();
        comboPeliculas1 = new javax.swing.JComboBox<>();
        btnEliCop = new javax.swing.JButton();
        btnEdiCop = new javax.swing.JButton();
        btnBusCop = new javax.swing.JButton();
        btnCanCop1 = new javax.swing.JButton();
        jSeparator9 = new javax.swing.JSeparator();
        jScrollPane12 = new javax.swing.JScrollPane();
        tbl_copiapelicula1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel11.setBackground(new java.awt.Color(0, 204, 0));

        lblSuc.setFont(new java.awt.Font("Arial", 3, 36)); // NOI18N
        lblSuc.setText("Sucursal");

        btnCanSuc1.setText("Cerrar Sesion");
        btnCanSuc1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCanSuc1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblSuc, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(324, 324, 324)
                .addComponent(btnCanSuc1)
                .addGap(13, 13, 13))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(lblSuc)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(btnCanSuc1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        btgSuc1.add(jrbMosTodSuc);
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
        btnEdiSuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEdiSucActionPerformed(evt);
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

        btnConfSuc.setText("Aceptar");
        btnConfSuc.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnConfSuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfSucActionPerformed(evt);
            }
        });

        lblTituloSuc.setFont(new java.awt.Font("Arial", 3, 36)); // NOI18N
        lblTituloSuc.setText("Buscar");

        btgSuc1.add(jrbMosFilSuc);
        jrbMosFilSuc.setText("Mostrar Filtros");
        jrbMosFilSuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbMosFilSucActionPerformed(evt);
            }
        });

        lblResultadoSuc.setFont(new java.awt.Font("Arial", 3, 36)); // NOI18N
        lblResultadoSuc.setText("Resultados");

        javax.swing.GroupLayout panBusSucLayout = new javax.swing.GroupLayout(panBusSuc);
        panBusSuc.setLayout(panBusSucLayout);
        panBusSucLayout.setHorizontalGroup(
            panBusSucLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator5, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(panBusSucLayout.createSequentialGroup()
                .addGroup(panBusSucLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panBusSucLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 1153, Short.MAX_VALUE))
                    .addGroup(panBusSucLayout.createSequentialGroup()
                        .addGroup(panBusSucLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panBusSucLayout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addGroup(panBusSucLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jrbMosTodSuc)
                                    .addComponent(jrbMosFilSuc)
                                    .addGroup(panBusSucLayout.createSequentialGroup()
                                        .addComponent(btnEdiSuc)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnConfSuc))))
                            .addGroup(panBusSucLayout.createSequentialGroup()
                                .addGap(38, 38, 38)
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
                                .addGap(485, 485, 485)
                                .addComponent(btnEliSuc)
                                .addGap(18, 18, 18)
                                .addComponent(btnDesSuc))
                            .addGroup(panBusSucLayout.createSequentialGroup()
                                .addGap(487, 487, 487)
                                .addComponent(lblTituloSuc, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(panBusSucLayout.createSequentialGroup()
                .addGap(461, 461, 461)
                .addComponent(lblResultadoSuc)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panBusSucLayout.setVerticalGroup(
            panBusSucLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panBusSucLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(lblTituloSuc)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jrbMosTodSuc)
                .addGap(17, 17, 17)
                .addComponent(jrbMosFilSuc)
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
                    .addComponent(btnEdiSuc)
                    .addComponent(btnConfSuc))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblResultadoSuc)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panBusSucLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEliSuc)
                    .addComponent(btnDesSuc))
                .addContainerGap())
        );

        tpnSucursal.addTab("Buscar", panBusSuc);

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
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 410, Short.MAX_VALUE)
                .addContainerGap())
        );

        tpnSucursal.addTab("Agregar", panAgrSuc);

        javax.swing.GroupLayout panSucLayout = new javax.swing.GroupLayout(panSuc);
        panSuc.setLayout(panSucLayout);
        panSucLayout.setHorizontalGroup(
            panSucLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(tpnSucursal)
        );
        panSucLayout.setVerticalGroup(
            panSucLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panSucLayout.createSequentialGroup()
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tpnSucursal))
        );

        tpnVideo.addTab("Sucursal", panSuc);

        jPanel15.setBackground(new java.awt.Color(255, 153, 0));

        lblPel.setFont(new java.awt.Font("Arial", 3, 36)); // NOI18N
        lblPel.setText("Pelicula");

        btnCanPel1.setText("Cerrar Sesion");
        btnCanPel1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCanPel1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblPel)
                .addGap(420, 420, 420)
                .addComponent(btnCanPel1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnCanPel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblPel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btgPel1.add(jrbMosTodPel);
        jrbMosTodPel.setSelected(true);
        jrbMosTodPel.setText("Mostrar Todo");
        jrbMosTodPel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbMosTodPelActionPerformed(evt);
            }
        });

        btgPel.add(jrbNumCatPel);
        jrbNumCatPel.setText("Numero de Catalogo");
        jrbNumCatPel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbNumCatPelActionPerformed(evt);
            }
        });

        btgPel.add(jrbCatPel);
        jrbCatPel.setText("Categoria");
        jrbCatPel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbCatPelActionPerformed(evt);
            }
        });

        btgPel.add(jrbCosAlqPel);
        jrbCosAlqPel.setText("Coste de Alquiler");
        jrbCosAlqPel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbCosAlqPelActionPerformed(evt);
            }
        });

        btgPel.add(jrbCosAdqPel);
        jrbCosAdqPel.setText("Coste de Adquisicion");
        jrbCosAdqPel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbCosAdqPelActionPerformed(evt);
            }
        });

        btgPel.add(jrbDirPel);
        jrbDirPel.setText("Director");
        jrbDirPel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbDirPelActionPerformed(evt);
            }
        });

        btgPel.add(jrbActPel);
        jrbActPel.setText("Actores");
        jrbActPel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbActPelActionPerformed(evt);
            }
        });

        btgPel.add(jrbTitPel);
        jrbTitPel.setText("Titulo");
        jrbTitPel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbTitPelActionPerformed(evt);
            }
        });

        txtCosAdqPel1.setEnabled(false);
        txtCosAdqPel1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCosAdqPel1KeyReleased(evt);
            }
        });

        txtCosAlqPel1.setEnabled(false);
        txtCosAlqPel1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCosAlqPel1KeyReleased(evt);
            }
        });

        txtTitPel1.setEnabled(false);
        txtTitPel1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTitPel1KeyReleased(evt);
            }
        });

        txtCatPel1.setEnabled(false);
        txtCatPel1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCatPel1KeyReleased(evt);
            }
        });

        txtNumCatPel1.setEnabled(false);
        txtNumCatPel1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNumCatPel1KeyReleased(evt);
            }
        });

        txtDirPel1.setEnabled(false);
        txtDirPel1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDirPel1KeyReleased(evt);
            }
        });

        txaActPel1.setColumns(20);
        txaActPel1.setRows(5);
        txaActPel1.setEnabled(false);
        txaActPel1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txaActPel1KeyReleased(evt);
            }
        });
        jScrollPane9.setViewportView(txaActPel1);

        btnEliPel.setText("Eliminar");
        btnEliPel.setEnabled(false);
        btnEliPel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliPelActionPerformed(evt);
            }
        });

        btnEdiPel.setText("Editar");
        btnEdiPel.setEnabled(false);
        btnEdiPel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEdiPelActionPerformed(evt);
            }
        });

        btnDesPel.setText("Deshacer");

        tbl_pelicula1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Numero de Catalogo", "Titulo", "Categorias", "Coste de Alquiler", "Coste de Adquisicion", "Actores", "Director"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_pelicula1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_pelicula1MouseClicked(evt);
            }
        });
        jScrollPane10.setViewportView(tbl_pelicula1);

        lblTituloPel.setFont(new java.awt.Font("Arial", 3, 36)); // NOI18N
        lblTituloPel.setText("Buscar");

        btgPel1.add(jrbMosFilPel);
        jrbMosFilPel.setText("Mostrar Filtros");
        jrbMosFilPel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbMosFilPelActionPerformed(evt);
            }
        });

        lblResultadoPel.setFont(new java.awt.Font("Arial", 3, 36)); // NOI18N
        lblResultadoPel.setText("Resultados");

        btnAcePel.setText("Aceptar");
        btnAcePel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAcePelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panBusPelLayout = new javax.swing.GroupLayout(panBusPel);
        panBusPel.setLayout(panBusPelLayout);
        panBusPelLayout.setHorizontalGroup(
            panBusPelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panBusPelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panBusPelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator7)
                    .addGroup(panBusPelLayout.createSequentialGroup()
                        .addComponent(jScrollPane10)
                        .addContainerGap())
                    .addGroup(panBusPelLayout.createSequentialGroup()
                        .addGroup(panBusPelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jrbMosFilPel)
                            .addComponent(jrbMosTodPel))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panBusPelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(panBusPelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panBusPelLayout.createSequentialGroup()
                                .addComponent(lblResultadoPel)
                                .addGap(483, 483, 483))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panBusPelLayout.createSequentialGroup()
                                .addComponent(lblTituloPel, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(490, 490, 490))))))
            .addGroup(panBusPelLayout.createSequentialGroup()
                .addGroup(panBusPelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panBusPelLayout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(panBusPelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(panBusPelLayout.createSequentialGroup()
                                .addComponent(jrbNumCatPel)
                                .addGap(18, 18, 18)
                                .addComponent(txtNumCatPel1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jrbTitPel, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panBusPelLayout.createSequentialGroup()
                                .addComponent(jrbCatPel)
                                .addGap(79, 79, 79)
                                .addGroup(panBusPelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtTitPel1)
                                    .addComponent(txtCatPel1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(panBusPelLayout.createSequentialGroup()
                                .addComponent(jrbCosAlqPel)
                                .addGap(40, 40, 40)
                                .addComponent(txtCosAlqPel1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panBusPelLayout.createSequentialGroup()
                                .addComponent(jrbCosAdqPel)
                                .addGap(18, 18, 18)
                                .addComponent(txtCosAdqPel1)))
                        .addGap(76, 76, 76)
                        .addGroup(panBusPelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jrbActPel)
                            .addComponent(jrbDirPel))
                        .addGap(88, 88, 88)
                        .addGroup(panBusPelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtDirPel1)
                            .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 349, Short.MAX_VALUE)))
                    .addGroup(panBusPelLayout.createSequentialGroup()
                        .addGap(497, 497, 497)
                        .addComponent(btnEdiPel)
                        .addGap(18, 18, 18)
                        .addComponent(btnAcePel)))
                .addContainerGap(249, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panBusPelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnEliPel)
                .addGap(18, 18, 18)
                .addComponent(btnDesPel)
                .addGap(494, 494, 494))
        );
        panBusPelLayout.setVerticalGroup(
            panBusPelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panBusPelLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(lblTituloPel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jrbMosTodPel)
                .addGap(18, 18, 18)
                .addComponent(jrbMosFilPel)
                .addGap(18, 18, 18)
                .addGroup(panBusPelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panBusPelLayout.createSequentialGroup()
                        .addGroup(panBusPelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jrbNumCatPel)
                            .addComponent(txtNumCatPel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panBusPelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jrbTitPel)
                            .addComponent(txtTitPel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panBusPelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jrbCatPel)
                            .addComponent(txtCatPel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panBusPelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jrbCosAdqPel)
                            .addComponent(txtCosAdqPel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jrbActPel)
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panBusPelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panBusPelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jrbDirPel)
                        .addComponent(txtDirPel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panBusPelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jrbCosAlqPel)
                        .addComponent(txtCosAlqPel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(27, 27, 27)
                .addGroup(panBusPelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEdiPel)
                    .addComponent(btnAcePel))
                .addGap(18, 18, 18)
                .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblResultadoPel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panBusPelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEliPel)
                    .addComponent(btnDesPel))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        tpnPelicula.addTab("Buscar", panBusPel);

        lblInsPel.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lblInsPel.setText("Ingrese la informacion de los siguientes campos");

        lblNumCatPel.setText("Numero de Catálogo");

        lblTitPel.setText("Titulo");

        lblGenPel.setText("Categoria");

        lblCosAlqPel.setText("Coste de Alquiler");

        lblDirPel.setText("Director");

        lblCosAdqPel.setText("Coste de Adquisición");

        lblActPel.setText("Actores");

        txtNumCatPel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNumCatPelKeyTyped(evt);
            }
        });

        txtCosAlqPel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCosAlqPelKeyTyped(evt);
            }
        });

        txtCosAdqPel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCosAdqPelKeyTyped(evt);
            }
        });

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

        tbl_pelicula.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane8.setViewportView(tbl_pelicula);

        javax.swing.GroupLayout panAgrPelLayout = new javax.swing.GroupLayout(panAgrPel);
        panAgrPel.setLayout(panAgrPelLayout);
        panAgrPelLayout.setHorizontalGroup(
            panAgrPelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panAgrPelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panAgrPelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator6)
                    .addGroup(panAgrPelLayout.createSequentialGroup()
                        .addGroup(panAgrPelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblInsPel)
                            .addGroup(panAgrPelLayout.createSequentialGroup()
                                .addGroup(panAgrPelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panAgrPelLayout.createSequentialGroup()
                                        .addComponent(lblCosAdqPel)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtCosAdqPel, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panAgrPelLayout.createSequentialGroup()
                                        .addGroup(panAgrPelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblNumCatPel)
                                            .addComponent(lblTitPel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lblGenPel)
                                            .addComponent(lblCosAlqPel)
                                            .addComponent(lblDirPel))
                                        .addGap(18, 18, 18)
                                        .addGroup(panAgrPelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtNumCatPel)
                                            .addComponent(txtTitPel)
                                            .addComponent(txtCatPel, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                            .addComponent(txtCosAlqPel)
                                            .addComponent(txtDirPel))))
                                .addGap(80, 80, 80)
                                .addComponent(lblActPel)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panAgrPelLayout.createSequentialGroup()
                                .addComponent(btnAgrPel)
                                .addGap(18, 18, 18)
                                .addComponent(btnCanPel)))
                        .addGap(0, 375, Short.MAX_VALUE))
                    .addComponent(jScrollPane8))
                .addContainerGap())
        );
        panAgrPelLayout.setVerticalGroup(
            panAgrPelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panAgrPelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblInsPel)
                .addGap(18, 18, 18)
                .addGroup(panAgrPelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panAgrPelLayout.createSequentialGroup()
                        .addGroup(panAgrPelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNumCatPel)
                            .addComponent(txtNumCatPel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblActPel))
                        .addGap(18, 18, 18)
                        .addGroup(panAgrPelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTitPel)
                            .addComponent(txtTitPel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panAgrPelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblGenPel)
                            .addComponent(txtCatPel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panAgrPelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblDirPel)
                            .addComponent(txtDirPel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panAgrPelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCosAlqPel)
                            .addComponent(txtCosAlqPel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panAgrPelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCosAdqPel)
                            .addComponent(txtCosAdqPel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane7))
                .addGap(18, 18, 18)
                .addGroup(panAgrPelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgrPel)
                    .addComponent(btnCanPel))
                .addGap(18, 18, 18)
                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tpnPelicula.addTab("Agregar", panAgrPel);

        javax.swing.GroupLayout panPelLayout = new javax.swing.GroupLayout(panPel);
        panPel.setLayout(panPelLayout);
        panPelLayout.setHorizontalGroup(
            panPelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(tpnPelicula)
        );
        panPelLayout.setVerticalGroup(
            panPelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panPelLayout.createSequentialGroup()
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tpnPelicula))
        );

        tpnVideo.addTab("Pelicula", panPel);

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

        txtNumCop.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNumCopKeyTyped(evt);
            }
        });

        comboEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Elija una opcion", "Disponible", "Rentada", "Dañada" }));

        lblNumCop.setText("Numero de Copia");

        jLabel1.setText("Estado de la Pelicula");

        lblSucursal.setText("Numero de Sucursal");

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

        tbl_copiapelicula.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Numero de Copia", "Estado de la Pelicula", "Numero de Sucursal", "Numero de Catalogo"
            }
        ));
        jScrollPane11.setViewportView(tbl_copiapelicula);

        javax.swing.GroupLayout panAgrCopLayout = new javax.swing.GroupLayout(panAgrCop);
        panAgrCop.setLayout(panAgrCopLayout);
        panAgrCopLayout.setHorizontalGroup(
            panAgrCopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panAgrCopLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panAgrCopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator8)
                    .addGroup(panAgrCopLayout.createSequentialGroup()
                        .addGroup(panAgrCopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblInsCop)
                            .addGroup(panAgrCopLayout.createSequentialGroup()
                                .addGroup(panAgrCopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblNumCat, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
                                    .addComponent(lblNumCop)
                                    .addComponent(lblSucursal)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(panAgrCopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtNumCop)
                                    .addComponent(comboEstado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(comboSucursal, 0, 150, Short.MAX_VALUE)
                                    .addComponent(comboPeliculas, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(panAgrCopLayout.createSequentialGroup()
                                .addComponent(btnAgrCop)
                                .addGap(18, 18, 18)
                                .addComponent(btnCanCop)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane11, javax.swing.GroupLayout.DEFAULT_SIZE, 1153, Short.MAX_VALUE))
                .addContainerGap())
        );
        panAgrCopLayout.setVerticalGroup(
            panAgrCopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panAgrCopLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblInsCop)
                .addGap(18, 18, 18)
                .addGroup(panAgrCopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNumCop)
                    .addGroup(panAgrCopLayout.createSequentialGroup()
                        .addComponent(txtNumCop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(panAgrCopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(comboEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(panAgrCopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(comboSucursal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblSucursal))))
                .addGap(18, 18, 18)
                .addGroup(panAgrCopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNumCat)
                    .addComponent(comboPeliculas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panAgrCopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgrCop)
                    .addComponent(btnCanCop))
                .addGap(18, 18, 18)
                .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane5.addTab("Agregar", panAgrCop);

        btgCop.add(jrbMosTodCop);
        jrbMosTodCop.setText("Mostar Todo");

        btgCop.add(jrbNumCopCop);
        jrbNumCopCop.setText("Numero de Copia");

        btgCop.add(jrbEstCop);
        jrbEstCop.setText("Estado");

        btgCop.add(jrbNumSucCop);
        jrbNumSucCop.setText("Numero de Sucursal");

        btgCop.add(jrbNumCatCop);
        jrbNumCatCop.setText("Numero de Catalogo");

        comboEstado1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Elija una opcion", "Disponible", "Rentada", "Dañada" }));

        btnEliCop.setText("Eliminar");

        btnEdiCop.setText("Editar");

        btnBusCop.setText("Buscar");

        btnCanCop1.setText("Cancelar");
        btnCanCop1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCanCop1ActionPerformed(evt);
            }
        });

        tbl_copiapelicula1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Numero de Copia", "Estado de la Pelicula", "Numero de Sucursal", "Numero de Catalogo"
            }
        ));
        jScrollPane12.setViewportView(tbl_copiapelicula1);

        javax.swing.GroupLayout panBusCopLayout = new javax.swing.GroupLayout(panBusCop);
        panBusCop.setLayout(panBusCopLayout);
        panBusCopLayout.setHorizontalGroup(
            panBusCopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panBusCopLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panBusCopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator9)
                    .addGroup(panBusCopLayout.createSequentialGroup()
                        .addGroup(panBusCopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jrbMosTodCop)
                            .addGroup(panBusCopLayout.createSequentialGroup()
                                .addGroup(panBusCopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jrbNumCopCop)
                                    .addComponent(jrbEstCop))
                                .addGap(36, 36, 36)
                                .addGroup(panBusCopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(comboEstado1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNumCop1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(panBusCopLayout.createSequentialGroup()
                                .addGroup(panBusCopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jrbNumCatCop)
                                    .addComponent(jrbNumSucCop))
                                .addGap(18, 18, 18)
                                .addGroup(panBusCopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(comboSucursal1, 0, 150, Short.MAX_VALUE)
                                    .addComponent(comboPeliculas1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(panBusCopLayout.createSequentialGroup()
                                .addComponent(btnEliCop)
                                .addGap(18, 18, 18)
                                .addComponent(btnEdiCop)
                                .addGap(18, 18, 18)
                                .addComponent(btnBusCop)
                                .addGap(18, 18, 18)
                                .addComponent(btnCanCop1)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane12, javax.swing.GroupLayout.DEFAULT_SIZE, 1153, Short.MAX_VALUE))
                .addContainerGap())
        );
        panBusCopLayout.setVerticalGroup(
            panBusCopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panBusCopLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jrbMosTodCop)
                .addGap(18, 18, 18)
                .addGroup(panBusCopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jrbNumCopCop)
                    .addComponent(txtNumCop1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panBusCopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jrbEstCop)
                    .addComponent(comboEstado1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panBusCopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jrbNumSucCop)
                    .addComponent(comboSucursal1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panBusCopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jrbNumCatCop)
                    .addComponent(comboPeliculas1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panBusCopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEliCop)
                    .addComponent(btnEdiCop)
                    .addComponent(btnBusCop)
                    .addComponent(btnCanCop1))
                .addGap(18, 18, 18)
                .addComponent(jSeparator9, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(108, Short.MAX_VALUE))
        );

        jTabbedPane5.addTab("Buscar", panBusCop);

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
//Boton Cancelar --------------------------------------------------------------------------------------------------------------------------------------------------------------------
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
//Boton Agregar Sucursal -------------------------------------------------------------------------------------------------------------------------------------------------------------------
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
                    
                    vaciarComponentesSuc();
                    
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

//Boton para Agregar Pelicula --------------------------------------------------------------------------------------------------------------------------------------------------------------    
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

    private void txtNumCopKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumCopKeyTyped
        
        char c = evt.getKeyChar();

        if (!Character.isDigit(c)) {

            evt.consume();
        }
        
    }//GEN-LAST:event_txtNumCopKeyTyped
//Boton Para Agregar Copia Pelicula --------------------------------------------------------------------------------------------------------------------------------------------------------
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
//RadioButon para seleccionar el filtro en sucursal ----------------------------------------------------------------------------------------------------------------------------------------
    private void jrbMosTodSucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbMosTodSucActionPerformed

        ocultarSucursal();
        
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
        panBusSuc.revalidate();
        panBusSuc.repaint();

    }//GEN-LAST:event_jrbNumSucActionPerformed

    private void jrbCalleSucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbCalleSucActionPerformed
        txtNumSuc1.enable(false);
        txtCalSuc1.enable(true);
        txtCiuSuc1.enable(false);
        txtEstSuc1.enable(false);
        txtCodSuc1.enable(false);
        txtTelSuc1.enable(false);
        vaciarComponentesSuc1();
        panBusSuc.revalidate();
        panBusSuc.repaint();
    }//GEN-LAST:event_jrbCalleSucActionPerformed

    private void jrbCiudadSucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbCiudadSucActionPerformed

        txtNumSuc1.enable(false);
        txtCalSuc1.enable(false);
        txtCiuSuc1.enable(true);
        txtEstSuc1.enable(false);
        txtCodSuc1.enable(false);
        txtTelSuc1.enable(false);
        vaciarComponentesSuc1();
        panBusSuc.revalidate();
        panBusSuc.repaint();

    }//GEN-LAST:event_jrbCiudadSucActionPerformed

    private void jrbEstadoSucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbEstadoSucActionPerformed
        
        txtNumSuc1.enable(false);
        txtCalSuc1.enable(false);
        txtCiuSuc1.enable(false);
        txtEstSuc1.enable(true);
        txtCodSuc1.enable(false);
        txtTelSuc1.enable(false);
        vaciarComponentesSuc1();
        panBusSuc.revalidate();
        panBusSuc.repaint();
    }//GEN-LAST:event_jrbEstadoSucActionPerformed

    private void jrbCodPosSucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbCodPosSucActionPerformed

        txtNumSuc1.enable(false);
        txtCalSuc1.enable(false);
        txtCiuSuc1.enable(false);
        txtEstSuc1.enable(false);
        txtCodSuc1.enable(true);
        txtTelSuc1.enable(false);
        vaciarComponentesSuc1();
        panBusSuc.revalidate();
        panBusSuc.repaint();

    }//GEN-LAST:event_jrbCodPosSucActionPerformed

    private void jrbTelSucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbTelSucActionPerformed
        
        txtNumSuc1.enable(false);
        txtCalSuc1.enable(false);
        txtCiuSuc1.enable(false);
        txtEstSuc1.enable(false);
        txtCodSuc1.enable(false);
        txtTelSuc1.enable(true);
        vaciarComponentesSuc1();
        panBusSuc.revalidate();
        panBusSuc.repaint();
        
    }//GEN-LAST:event_jrbTelSucActionPerformed

//Filtra la tabla con lo que se ingresa en las cajas de texto
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

//Click a la tabla de sucursal1 para cargar los datos y poder eliminar o modificar
    private void tbl_sucursal1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_sucursal1MouseClicked
        
        reaparecerComSuc();
        
        jrbNumSuc.setEnabled(false);
        jrbCalleSuc.setEnabled(false);
        jrbCiudadSuc.setEnabled(false);
        jrbEstadoSuc.setEnabled(false);
        jrbCodPosSuc.setEnabled(false);
        jrbTelSuc.setEnabled(false);
        
        btnEliSuc.setEnabled(true);
        btnEdiSuc.setEnabled(true);
        
        txtNumSuc1.enable(false);
        txtCalSuc1.enable(false);
        txtCiuSuc1.enable(false);
        txtEstSuc1.enable(false);
        txtCodSuc1.enable(false);
        txtTelSuc1.enable(false);
        
        panBusSuc.revalidate();
        panBusSuc.repaint();
        
        txtNumSuc1.setText(modelo1.getValueAt(tbl_sucursal1.getSelectedRow(), 0).toString());
        txtCalSuc1.setText(modelo1.getValueAt(tbl_sucursal1.getSelectedRow(), 1).toString());
        txtCiuSuc1.setText(modelo1.getValueAt(tbl_sucursal1.getSelectedRow(), 2).toString());
        txtEstSuc1.setText(modelo1.getValueAt(tbl_sucursal1.getSelectedRow(), 3).toString());
        txtCodSuc1.setText(modelo1.getValueAt(tbl_sucursal1.getSelectedRow(), 4).toString());
        txtTelSuc1.setText(modelo1.getValueAt(tbl_sucursal1.getSelectedRow(), 5).toString());
        
    }//GEN-LAST:event_tbl_sucursal1MouseClicked

//Boton para eliminar el registro de sucursal seleccionado
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
                                    
                    JOptionPane.showMessageDialog(null, "Sucursal eliminado correctamente");
                    
                    vaciarComponentesSuc1();
                    
                    restaurarJRBSuc();
                    
                    mostrar1();
                    
                    
                    
                }
                
            } catch (SQLException ex) {
                
                Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                
            }
            
        } else {
            // El usuario hizo clic en "No" o cerró el cuadro
            System.out.println("Acción cancelada");
        }
                
    }//GEN-LAST:event_btnEliSucActionPerformed
//Boton de deshacer para traer el ultimo registro borrado
    private void btnDesSucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesSucActionPerformed
       
        SucursalMemento memento = historialSucursales.deshacer();
        
        //System.out.println(memento.toString());
        
        if (memento != null) {
        
            if(SucursalDAO.restaurarSucursal(memento)){
            
                JOptionPane.showMessageDialog(this, "Sucursal restaurado correctamente");
                
                try {
                    
                    mostrar1();
                    restaurarJRBSuc();
                    
                } catch (SQLException ex) {
                    
                    Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                    
                }
            
            } else {
                
                JOptionPane.showMessageDialog(this, "No se pudo restaurar la sucursal");
                
            }
        } else {
            
            JOptionPane.showMessageDialog(this, "No hay sucursal para restaurar");
        
        }
        
    }//GEN-LAST:event_btnDesSucActionPerformed

    private void btnEdiSucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEdiSucActionPerformed

        txtCalSuc1.enable(true);
        txtCiuSuc1.enable(true);
        txtEstSuc1.enable(true);
        txtCodSuc1.enable(true);
        txtTelSuc1.enable(true);
        
        btnConfSuc.setVisible(true);
        
        panBusSuc.revalidate();
        panBusSuc.repaint();

    }//GEN-LAST:event_btnEdiSucActionPerformed

    private void btnConfSucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfSucActionPerformed

        if(!(txtCalSuc1.getText().equals("") || txtCiuSuc1.getText().equals("") || txtEstSuc1.getText().equals("") || txtCodSuc1.getText().equals("") || txtTelSuc1.getText().equals(""))){
        
            num_Suc = txtNumSuc1.getText();
            calle = txtCalSuc1.getText();
            ciudad = txtCiuSuc1.getText();
            estado = txtEstSuc1.getText();
            cod_pos = txtCodSuc1.getText();
            tel = txtTelSuc1.getText();
            

            
            if(SucursalDAO.cambiosSucursal(new Sucursal(num_Suc, calle, ciudad, estado, cod_pos, tel))){
            
                try {
                    
                    vaciarComponentesSuc1();
                    JOptionPane.showMessageDialog(this, "Sucursal modifica exitosamente");
                    restaurarJRBSuc();
                    btnConfSuc.setVisible(false);
                    mostrar1();
                    
                } catch (SQLException ex) {
                    
                    Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                    
                }
                
            }
        
        }
        
    }//GEN-LAST:event_btnConfSucActionPerformed

    private void jrbMosFilSucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbMosFilSucActionPerformed
        
        reaparecerComSuc();
        
    }//GEN-LAST:event_jrbMosFilSucActionPerformed

    private void jrbMosFilPelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbMosFilPelActionPerformed

        reaparecerComPel();

    }//GEN-LAST:event_jrbMosFilPelActionPerformed

    private void jrbMosTodPelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbMosTodPelActionPerformed
        
        ocultarPelicula();
        
        try {
        
            mostrarPeliculas1();
        
        }catch (SQLException ex) {
            
            Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        
    }//GEN-LAST:event_jrbMosTodPelActionPerformed

    private void jrbNumCatPelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbNumCatPelActionPerformed

        vaciarCajasPel();
        txtNumCatPel1.setEnabled(true);
        txtTitPel1.setEnabled(false);
        txtCatPel1.setEnabled(false);
        txtCosAlqPel1.setEnabled(false);
        txtCosAdqPel1.setEnabled(false);
        txaActPel1.setEnabled(false);
        jScrollPane9.setEnabled(false);
        txtDirPel1.setEnabled(false);

    }//GEN-LAST:event_jrbNumCatPelActionPerformed

    private void jrbTitPelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbTitPelActionPerformed

        vaciarCajasPel();
        txtNumCatPel1.setEnabled(false);
        txtTitPel1.setEnabled(true);
        txtCatPel1.setEnabled(false);
        txtCosAlqPel1.setEnabled(false);
        txtCosAdqPel1.setEnabled(false);
        txaActPel1.setEnabled(false);
        jScrollPane9.setEnabled(false);
        txtDirPel1.setEnabled(false);
        
    }//GEN-LAST:event_jrbTitPelActionPerformed

    private void jrbCatPelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbCatPelActionPerformed
        
        vaciarCajasPel();
        txtNumCatPel1.setEnabled(false);
        txtTitPel1.setEnabled(false);
        txtCatPel1.setEnabled(true);
        txtCosAlqPel1.setEnabled(false);
        txtCosAdqPel1.setEnabled(false);
        txaActPel1.setEnabled(false);
        jScrollPane9.setEnabled(false);
        txtDirPel1.setEnabled(false);
    }//GEN-LAST:event_jrbCatPelActionPerformed

    private void jrbDirPelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbDirPelActionPerformed
        
        vaciarCajasPel();
        txtNumCatPel1.setEnabled(false);
        txtTitPel1.setEnabled(false);
        txtCatPel1.setEnabled(false);
        txtCosAlqPel1.setEnabled(false);
        txtCosAdqPel1.setEnabled(false);
        txaActPel1.setEnabled(false);
        jScrollPane9.setEnabled(false);
        txtDirPel1.setEnabled(true);
    }//GEN-LAST:event_jrbDirPelActionPerformed

    private void jrbCosAlqPelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbCosAlqPelActionPerformed
        vaciarCajasPel();
        txtNumCatPel1.setEnabled(false);
        txtTitPel1.setEnabled(false);
        txtCatPel1.setEnabled(false);
        txtCosAlqPel1.setEnabled(true);
        txtCosAdqPel1.setEnabled(false);
        txaActPel1.setEnabled(false);
        jScrollPane9.setEnabled(false);
        txtDirPel1.setEnabled(false);
    }//GEN-LAST:event_jrbCosAlqPelActionPerformed

    private void jrbCosAdqPelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbCosAdqPelActionPerformed
    vaciarCajasPel();
        txtNumCatPel1.setEnabled(false);
        txtTitPel1.setEnabled(false);
        txtCatPel1.setEnabled(false);
        txtCosAlqPel1.setEnabled(false);
        txtCosAdqPel1.setEnabled(true);
        txaActPel1.setEnabled(false);
        jScrollPane9.setEnabled(false);
        txtDirPel1.setEnabled(false);

    }//GEN-LAST:event_jrbCosAdqPelActionPerformed

    private void jrbActPelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbActPelActionPerformed
        vaciarCajasPel();
        txtNumCatPel1.setEnabled(false);
        txtTitPel1.setEnabled(false);
        txtCatPel1.setEnabled(false);
        txtCosAlqPel1.setEnabled(false);
        txtCosAdqPel1.setEnabled(false);
        txaActPel1.setEnabled(true);
        jScrollPane9.setEnabled(true);
        txtDirPel1.setEnabled(false);

    }//GEN-LAST:event_jrbActPelActionPerformed

    private void txtNumCatPel1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumCatPel1KeyReleased

        try {
            
            ResultSet rs = PeliculaDAO.numCatPelicula(txtNumCatPel1.getText());
            mostrarPelFiltrados(rs);
            
        }catch (SQLException ex) {

                Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                
        }

    }//GEN-LAST:event_txtNumCatPel1KeyReleased

    private void txtTitPel1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTitPel1KeyReleased

        try {
            
            ResultSet rs = PeliculaDAO.titPelicula(txtTitPel1.getText());
            mostrarPelFiltrados(rs);
            
        }catch (SQLException ex) {

                Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                
        }

    }//GEN-LAST:event_txtTitPel1KeyReleased

    private void txtCatPel1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCatPel1KeyReleased
        try {
            
            ResultSet rs = PeliculaDAO.catPelicula(txtCatPel1.getText());
            mostrarPelFiltrados(rs);
            
        }catch (SQLException ex) {

                Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                
        }
    }//GEN-LAST:event_txtCatPel1KeyReleased

    private void txtDirPel1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDirPel1KeyReleased

        try {
            
            ResultSet rs = PeliculaDAO.dirPelicula(txtDirPel1.getText());
            mostrarPelFiltrados(rs);
            
        }catch (SQLException ex) {

                Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                
        }

    }//GEN-LAST:event_txtDirPel1KeyReleased

    private void txtCosAlqPel1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCosAlqPel1KeyReleased
        try {
            
            ResultSet rs = PeliculaDAO.cosPelicula( txtCosAlqPel1.getText() );
            mostrarPelFiltrados(rs);
            
        }catch (SQLException ex) {

                Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                
        }
    }//GEN-LAST:event_txtCosAlqPel1KeyReleased
    //Coste de Aquisicion -------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    private void txtCosAdqPel1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCosAdqPel1KeyReleased
        
        try {
            
            ResultSet rs = PeliculaDAO.cosAdPelicula(  txtCosAdqPel1.getText() );
            mostrarPelFiltrados(rs);
            
        }catch (SQLException ex) {

                Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                
        }
    }//GEN-LAST:event_txtCosAdqPel1KeyReleased

    private void txaActPel1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txaActPel1KeyReleased
        try {
            
            ResultSet rs = PeliculaDAO.actPelicula(txaActPel1.getText());
            mostrarPelFiltrados(rs);
            
        }catch (SQLException ex) {

                Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                
        }
    }//GEN-LAST:event_txaActPel1KeyReleased

    private void tbl_pelicula1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_pelicula1MouseClicked

        btnEdiPel.setEnabled(true);
        btnEliPel.setEnabled(true);
        
        reaparecerComPel();
        
        txtNumCatPel1.setText(modeloPelicula1.getValueAt(tbl_pelicula1.getSelectedRow(), 0).toString());
        txtTitPel1.setText(modeloPelicula1.getValueAt(tbl_pelicula1.getSelectedRow(), 1).toString());
        txtCatPel1.setText(modeloPelicula1.getValueAt(tbl_pelicula1.getSelectedRow(), 2).toString());
        txtCosAlqPel1.setText(modeloPelicula1.getValueAt(tbl_pelicula1.getSelectedRow(), 3).toString());
        txtCosAdqPel1.setText(modeloPelicula1.getValueAt(tbl_pelicula1.getSelectedRow(), 4).toString());
        txaActPel1.setText(modeloPelicula1.getValueAt(tbl_pelicula1.getSelectedRow(), 5).toString());
        txtDirPel1.setText(modeloPelicula1.getValueAt(tbl_pelicula1.getSelectedRow(), 6).toString());

    }//GEN-LAST:event_tbl_pelicula1MouseClicked

    private void btnEliPelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliPelActionPerformed

        int opcion = JOptionPane.showConfirmDialog(
        null, 
        "¿Estás seguro de que deseas eliminar la pelicula?", 
        "Confirmación", 
        JOptionPane.YES_NO_OPTION
        );

        if (opcion == JOptionPane.YES_OPTION) {
            
            try {
                
                System.out.println("Acción aceptada");
            
                PeliculaDAO.eliminarPelicula(txtNumCatPel1.getText());
            
                JOptionPane.showMessageDialog(null, "Pelicula eliminada correctamente");
                
                mostrarPeliculas1();
                
            } catch (SQLException ex) {
                Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else {
            // El usuario hizo clic en "No" o cerró el cuadro
            System.out.println("Acción cancelada");
        }

    }//GEN-LAST:event_btnEliPelActionPerformed

    private void btnEdiPelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEdiPelActionPerformed
        
        txtTitPel1.setEnabled(true);
        txtCatPel1.setEnabled(true);
        txtCosAlqPel1.setEnabled(true);
        txtCosAdqPel1.setEnabled(true);
        txaActPel1.setEnabled(true);
        jScrollPane9.setEnabled(true);
        txtDirPel1.setEnabled(true);
        
        btnAcePel.setVisible(true);
        
        panBusPel.revalidate();
        panBusPel.repaint();

        
    }//GEN-LAST:event_btnEdiPelActionPerformed

    private void btnAcePelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAcePelActionPerformed
        
        if( !( txtNumCatPel1.getText().equals("") || txtTitPel1.getText().equals("") || txtCatPel1.getText().equals("") ||
               txtCosAlqPel1.getText().equals("") || txtCosAdqPel1.getText().equals("") || txaActPel1.getText().equals("") || txtDirPel1.getText().equals("") ) ){
        
            num_catalogo = txtNumCatPel1.getText();
            titulo = txtTitPel1.getText();
            categoria = txtCatPel1.getText();
            cos_alqui = Float.parseFloat(txtCosAlqPel1.getText());
            cos_adqui = Float.parseFloat(txtCosAdqPel1.getText());
            actores = txaActPel1.getText();
            director = txtDirPel1.getText();

           
            if(PeliculaDAO.cambiosPelicula(new Pelicula(num_catalogo, titulo, categoria, cos_alqui, cos_adqui, actores, director) )){
            
                try {
                    
                    //vaciarComponentesSuc1();
                    JOptionPane.showMessageDialog(this, "Pelicula modifica exitosamente");
                    //restaurarJRBSuc();
                    btnAcePel.setVisible(false);
                    mostrarPeliculas1();
                    
                } catch (SQLException ex) {
                    
                    Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                    
                }
                
            }
        
        }
    }//GEN-LAST:event_btnAcePelActionPerformed
    
    
    
    
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
    private javax.swing.ButtonGroup btgCop;
    private javax.swing.ButtonGroup btgPel;
    private javax.swing.ButtonGroup btgPel1;
    private javax.swing.ButtonGroup btgSuc;
    private javax.swing.ButtonGroup btgSuc1;
    private javax.swing.JButton btnAcePel;
    private javax.swing.JButton btnAgrCop;
    private javax.swing.JButton btnAgrPel;
    private javax.swing.JButton btnAgrSuc;
    private javax.swing.JButton btnBusCop;
    private javax.swing.JButton btnCanCop;
    private javax.swing.JButton btnCanCop1;
    private javax.swing.JButton btnCanPel;
    private javax.swing.JButton btnCanPel1;
    private javax.swing.JButton btnCanSuc;
    private javax.swing.JButton btnCanSuc1;
    private javax.swing.JButton btnConfSuc;
    private javax.swing.JButton btnDesPel;
    private javax.swing.JButton btnDesSuc;
    private javax.swing.JButton btnEdiCop;
    private javax.swing.JButton btnEdiPel;
    private javax.swing.JButton btnEdiSuc;
    private javax.swing.JButton btnEliCop;
    private javax.swing.JButton btnEliPel;
    private javax.swing.JButton btnEliSuc;
    private javax.swing.JComboBox<String> comboEstado;
    private javax.swing.JComboBox<String> comboEstado1;
    private javax.swing.JComboBox<String> comboPeliculas;
    private javax.swing.JComboBox<String> comboPeliculas1;
    private javax.swing.JComboBox<String> comboSucursal;
    private javax.swing.JComboBox<String> comboSucursal1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel19;
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
    private javax.swing.JTabbedPane jTabbedPane5;
    private javax.swing.JRadioButton jrbActPel;
    private javax.swing.JRadioButton jrbCalleSuc;
    private javax.swing.JRadioButton jrbCatPel;
    private javax.swing.JRadioButton jrbCiudadSuc;
    private javax.swing.JRadioButton jrbCodPosSuc;
    private javax.swing.JRadioButton jrbCosAdqPel;
    private javax.swing.JRadioButton jrbCosAlqPel;
    private javax.swing.JRadioButton jrbDirPel;
    private javax.swing.JRadioButton jrbEstCop;
    private javax.swing.JRadioButton jrbEstadoSuc;
    private javax.swing.JRadioButton jrbMosFilPel;
    private javax.swing.JRadioButton jrbMosFilSuc;
    private javax.swing.JRadioButton jrbMosTodCop;
    private javax.swing.JRadioButton jrbMosTodPel;
    private javax.swing.JRadioButton jrbMosTodSuc;
    private javax.swing.JRadioButton jrbNumCatCop;
    private javax.swing.JRadioButton jrbNumCatPel;
    private javax.swing.JRadioButton jrbNumCopCop;
    private javax.swing.JRadioButton jrbNumSuc;
    private javax.swing.JRadioButton jrbNumSucCop;
    private javax.swing.JRadioButton jrbTelSuc;
    private javax.swing.JRadioButton jrbTitPel;
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
    private javax.swing.JLabel lblResultadoPel;
    private javax.swing.JLabel lblResultadoSuc;
    private javax.swing.JLabel lblSuc;
    private javax.swing.JLabel lblSucursal;
    private javax.swing.JLabel lblTelSuc;
    private javax.swing.JLabel lblTitPel;
    private javax.swing.JLabel lblTituloPel;
    private javax.swing.JLabel lblTituloSuc;
    private javax.swing.JPanel panAgrCop;
    private javax.swing.JPanel panAgrPel;
    private javax.swing.JPanel panAgrSuc;
    private javax.swing.JPanel panBusCop;
    private javax.swing.JPanel panBusPel;
    private javax.swing.JPanel panBusSuc;
    private javax.swing.JPanel panCop;
    private javax.swing.JPanel panPel;
    private javax.swing.JPanel panSuc;
    private javax.swing.JTable tbl_copiapelicula;
    private javax.swing.JTable tbl_copiapelicula1;
    private javax.swing.JTable tbl_pelicula;
    private javax.swing.JTable tbl_pelicula1;
    private javax.swing.JTable tbl_sucursal;
    private javax.swing.JTable tbl_sucursal1;
    private javax.swing.JTabbedPane tpnPelicula;
    private javax.swing.JTabbedPane tpnSucursal;
    private javax.swing.JTabbedPane tpnVideo;
    private javax.swing.JTextArea txaActPel;
    private javax.swing.JTextArea txaActPel1;
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
    private javax.swing.JTextField txtTitPel1;
    // End of variables declaration//GEN-END:variables

    
//Otros metodos   
    
    //Cancelar
    public void cancelar(){
    
        Login l = new Login();
        l.setVisible(true);
        this.dispose();
        
    }
    
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
    
    public void vaciarCajasPel (){
        
        txtNumCatPel1.setText("");
        txtTitPel1.setText("");
        txtCatPel1.setText("");
        txtCosAlqPel1.setText("");
        txtCosAdqPel1.setText("");
        txaActPel1.setText("");
        txtDirPel1.setText("");
        panBusPel.revalidate();
        panBusPel.repaint();
    }
    
    public void restaurarJRBSuc(){
        
        jrbMosTodSuc.setSelected(true);
    
        jrbMosTodSuc.setEnabled(true);
        jrbNumSuc.setEnabled(true);
        jrbCalleSuc.setEnabled(true);
        jrbCiudadSuc.setEnabled(true);
        jrbEstadoSuc.setEnabled(true);
        jrbCodPosSuc.setEnabled(true);
        jrbTelSuc.setEnabled(true);
        
        btnEliSuc.setEnabled(false);
        btnEdiSuc.setEnabled(false);
        
        txtNumSuc1.enable(false);
        txtCalSuc1.enable(false);
        txtCiuSuc1.enable(false);
        txtEstSuc1.enable(false);
        txtCodSuc1.enable(false);
        txtTelSuc1.enable(false);
        
    }
    
    public void ocultarSucursal(){
    
        btnConfSuc.setVisible(false);
        txtNumSuc1.setVisible(false);
        txtCalSuc1.setVisible(false);
        txtCiuSuc1.setVisible(false);
        txtEstSuc1.setVisible(false);;
        txtCodSuc1.setVisible(false);;
        txtTelSuc1.setVisible(false);
       
        jrbNumSuc.setVisible(false);
        jrbCalleSuc.setVisible(false);
        jrbCiudadSuc.setVisible(false);
        jrbEstadoSuc.setVisible(false);
        jrbCodPosSuc.setVisible(false);
        jrbTelSuc.setVisible(false);
    
    }
    
    public void ocultarPelicula(){
    
        btnAcePel.setVisible(false);
        txtNumCatPel1.setVisible(false);
        txtTitPel1.setVisible(false);
        txtCatPel1.setVisible(false);
        txtCosAlqPel1.setVisible(false);
        txtCosAdqPel1.setVisible(false);
        txaActPel1.setVisible(false);
        jScrollPane9.setVisible(false);
        txtDirPel1.setVisible(false);
        
        jrbNumCatPel.setVisible(false);
        jrbTitPel.setVisible(false);
        jrbCatPel.setVisible(false);
        jrbCosAlqPel.setVisible(false);
        jrbCosAdqPel.setVisible(false);
        jrbActPel.setVisible(false);
        jrbDirPel.setVisible(false);
    
    }
    
    public void reaparecerComSuc(){
    
        txtNumSuc1.setVisible(true);
        txtCalSuc1.setVisible(true);
        txtCiuSuc1.setVisible(true);
        txtEstSuc1.setVisible(true);;
        txtCodSuc1.setVisible(true);;
        txtTelSuc1.setVisible(true);
       
        jrbNumSuc.setVisible(true);
        jrbCalleSuc.setVisible(true);
        jrbCiudadSuc.setVisible(true);
        jrbEstadoSuc.setVisible(true);
        jrbCodPosSuc.setVisible(true);
        jrbTelSuc.setVisible(true);
        
        panBusSuc.revalidate();
        panBusSuc.repaint();
        
    }
    
    public void reaparecerComPel(){
    
        txtNumCatPel1.setVisible(true);
        txtTitPel1.setVisible(true);
        txtCatPel1.setVisible(true);
        txtCosAlqPel1.setVisible(true);
        txtCosAdqPel1.setVisible(true);
        txaActPel1.setVisible(true);
        jScrollPane9.setVisible(true);
        txtDirPel1.setVisible(true);
        
        jrbNumCatPel.setVisible(true);
        jrbTitPel.setVisible(true);
        jrbCatPel.setVisible(true);
        jrbCosAlqPel.setVisible(true);
        jrbCosAdqPel.setVisible(true);
        jrbActPel.setVisible(true);
        jrbDirPel.setVisible(true);
        
        panBusPel.revalidate();
        panBusPel.repaint();
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
    
    public void mostrarPeliculas1() throws SQLException {

        ResultSet rs = PeliculaDAO.buscar();

        String datos[] = new String[7];

        //vaciar filas anteriores
        modeloPelicula1.setRowCount(0);

        while (rs.next()) {
            
            datos[0] = rs.getString(1);
            datos[1] = rs.getString(2);
            datos[2] = rs.getString(3);
            datos[3] = rs.getString(4);
            datos[4] = rs.getString(5);
            datos[5] = rs.getString(6);
            datos[6] = rs.getString(7);
            
            modeloPelicula1.addRow(datos);

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
    
        public void mostrarPelFiltrados(ResultSet rs) throws SQLException {

        String datos[] = new String[7];

        //vaciar filas anteriores
        modeloPelicula1.setRowCount(0);

        while (rs.next()) {
            
            datos[0] = rs.getString(1);
            datos[1] = rs.getString(2);
            datos[2] = rs.getString(3);
            datos[3] = rs.getString(4);
            datos[4] = rs.getString(5);
            datos[5] = rs.getString(6);
            datos[6] = rs.getString(7);
            modeloPelicula1.addRow(datos);
            
        }
          
    }
    
}

