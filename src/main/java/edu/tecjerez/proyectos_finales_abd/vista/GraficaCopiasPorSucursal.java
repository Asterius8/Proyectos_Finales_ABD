package edu.tecjerez.proyectos_finales_abd.vista;

import edu.tecjerez.proyectos_finales_abd.ConexionBD.ConexionBD;
import edu.tecjerez.proyectos_finales_abd.Controlador.SucursalDAO;

import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

public class GraficaCopiasPorSucursal extends JFrame {

    public GraficaCopiasPorSucursal() {
        initComponents();
        setTitle("Gráfica de Copias por Sucursal");
        setSize(800, 600);
        
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JFreeChart chart = crearGrafica();
        ChartPanel panel = new ChartPanel(chart);
        setContentPane(panel);
    }

    private JFreeChart crearGrafica() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        try {
            ConexionBD.getConexion();

            ResultSet rs = SucursalDAO.contarCopiasPorSucursal(); // Método en DAO

            while (rs.next()) {
                String ciudad = rs.getString("ciudad");
                int total = rs.getInt("total_copias");
                dataset.addValue(total, "Copias", ciudad);
            }

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al obtener los datos: " + e.getMessage());
        }

        return ChartFactory.createBarChart(
                "Cantidad de Copias por Sucursal",
                "Sucursal (Ciudad)",
                "Número de Copias",
                dataset
        );
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(GraficaCopiasPorSucursal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GraficaCopiasPorSucursal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GraficaCopiasPorSucursal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GraficaCopiasPorSucursal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GraficaCopiasPorSucursal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
