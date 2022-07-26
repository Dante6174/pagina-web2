
package aplicacion;


import java.sql.DriverManager;
import java.sql.Connection;
import java.awt.HeadlessException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexion extends javax.swing.JFrame {
    //para la conexion con la bases de datos
    public static final String URL = "jdbc:mysql://localhost:3306/escuela ";
    public static final String user = "root";
    public static final String password = "user";
    public Conexion() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        conectionButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        conectionButton.setText("Conectar");
        conectionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                conectionButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(173, Short.MAX_VALUE)
                .addComponent(conectionButton)
                .addGap(150, 150, 150))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(134, 134, 134)
                .addComponent(conectionButton)
                .addContainerGap(143, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // METODO PARA LA CONEXION
    public Connection getConnection(){
        Connection conection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conection = (Connection)DriverManager.getConnection(URL, user, password);
            JOptionPane.showMessageDialog(null, "Conexion Exitosa");
        } catch (HeadlessException | ClassNotFoundException | SQLException e) {
            System.err.println("Error: "+e);
        }
        return conection;
    }
    private void conectionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_conectionButtonActionPerformed
        Connection conection = getConnection();
        //para realizar las consultas que se harán
        PreparedStatement ps;
        //para guardar los resuultados de la consulta
        ResultSet rs;
        try {
            ps = conection.prepareStatement("select * from persona");
            rs = ps.executeQuery();
            if (rs.next()) { //para saber si existe al menos un registro
                JOptionPane.showMessageDialog(null, "Nombre: "+rs.getString("nombre") + 
                                                "\nDomicilio: "+rs.getString("domicilio")+ 
                                                "\nCelular: "+rs.getString("celular") +
                                                "\nCorreo electronico: "+rs.getString("correo_electronico") +
                                                "\nFecha de nacimiento:"+String.valueOf( rs.getDate("fecha_nacimiento") ) +
                                                "\nGenero: "+rs.getString("genero"));
            }
            else{
                JOptionPane.showMessageDialog(null, "No existen registros");
            }
            //importante cerrar la conexion con la base de datos
            conection.close(); 
        } catch (Exception e) {
            System.err.println("Erro: "+e);
        }
    }//GEN-LAST:event_conectionButtonActionPerformed

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
            java.util.logging.Logger.getLogger(Conexion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Conexion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Conexion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Conexion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Conexion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton conectionButton;
    // End of variables declaration//GEN-END:variables
}
