package ventanas;
import comuin.EncriptadorPassword;
import comuin.Conectar;
import comuin.Conexion;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author jesus
 */
public class Usuarios extends javax.swing.JFrame {

    /**
     * Creates new form Usuarios
     */
    Connection con = null;
    Conexion obj = new Conexion();
    public Usuarios() {
        initComponents();
        this.setLocationRelativeTo(this);
    }
    
    void usuario(){
        EncriptadorPassword ep = new EncriptadorPassword("12345");
        int tipU = comboTipo.getSelectedIndex();
        int tipM = comboMpio.getSelectedIndex();
        String tipo = (String) comboTipo.getSelectedItem();
        
        String conect = String.valueOf(this.txtNPass.getPassword());
        conect = (String) ep.encrypt(conect);
        String sql = "INSERT INTO USUARIO (Matricula,CURP,Id_Municipio,Nombre,Apellido_Paterno,Apellido_Materno,Nombre_Usuario,Contrasena,Tipo_Usuario)"
                + " values " + "('"+ this.txtMatricula.getText() + "','" + this.txtCurp.getText() + "','" + tipM + "','"+ this.txtNombre.getText()+ "','" 
                + this.txtApP.getText() + "','" + this.txtApM.getText() + "','" + this.txtUsuarioN.getText()+"','" + conect +"','" + tipo + "')";
        
        Connection connection = obj.conexion();
        PreparedStatement st = null;
        
        if(tipU == 0){
            JOptionPane.showMessageDialog(null,"LLene el campo Tipo Usuario","ERROR",JOptionPane.ERROR_MESSAGE);
        }else{
            try{
                //Se deshabilita el modo de confirmacion automatica
                connection.setAutoCommit(false);
                st = connection.prepareStatement(sql);
                st.executeUpdate();
                //Indicamos que se deben aplicar los cambios a la BD
                connection.commit();
                JOptionPane.showMessageDialog(rootPane,"Datos Guardados", "Correcto", JOptionPane.INFORMATION_MESSAGE);
            }catch(Exception ex){
                JOptionPane.showMessageDialog(null,"Ocurrio un error en: " + ex, "ERROR",JOptionPane.ERROR_MESSAGE);
                if(connection != null){
                    JOptionPane.showMessageDialog(rootPane, "RollBack","RollBack",JOptionPane.INFORMATION_MESSAGE);
                    
                    try{
                        //Deshacer los cambios
                        connection.rollback();
                    }catch(SQLException e){
                        JOptionPane.showMessageDialog(rootPane,"No se pudo hacer: " + e, "ERROR", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
            finally{
                //cerramos la conexion
                try{
                    if(st != null) st.close();
                    if(connection != null) connection.close();
                }catch(SQLException ex){
                    JOptionPane.showMessageDialog(rootPane,"ERROR en: " + ex, "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }
    
    void cargo(){
        int tipM = comboMpio.getSelectedIndex();
        
        String sql = "INSERT INTO CARGO (Matricula,CURP,Id_Municipio,Nombre,Apellido_Paterno,Apellido_Materno) values " + "('" + this.txtMatricula.getText()+"','" + this.txtCurp.getText() + "','" + tipM + "','"+ this.txtNombre.getText()
                        +"','" + this.txtApP.getText()+"','"+ this.txtApM.getText()+ "')";
        Connection connection = obj.conexion();
        PreparedStatement st = null;
        if(tipM == 0){
            JOptionPane.showMessageDialog(null,"LLene el campo Municipio","ERROR",JOptionPane.ERROR_MESSAGE);
        }else{
            try{
                //Se deshabilita el modo de confirmacion automatica
                connection.setAutoCommit(false);
                st = connection.prepareStatement(sql);
                st.executeUpdate();
                
                //Indicamos que se deben hacer los cambios a la BD
                connection.commit();
                
            }catch(Exception e){
                JOptionPane.showMessageDialog(null,"Ocurrio un error en: " + e,"ERROR",JOptionPane.ERROR_MESSAGE);
            if(connection != null){
                JOptionPane.showMessageDialog(rootPane,"RollBack", "RollBack", JOptionPane.INFORMATION_MESSAGE);
                
                try{
                    connection.rollback();
                }catch(SQLException ex){
                    JOptionPane.showMessageDialog(rootPane,"Error en: " + ex, "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            
             }
            }
            finally{
                //Cerramos la conexion
                try{
                if(st != null) st.close();
                if(connection != null) connection.close();
                }catch(SQLException e){
                    JOptionPane.showMessageDialog(rootPane,"Error en: " + e, "ERROR",JOptionPane.ERROR_MESSAGE);
                
                }
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtApP = new javax.swing.JTextField();
        txtApM = new javax.swing.JTextField();
        txtMatricula = new javax.swing.JTextField();
        txtUsuarioN = new javax.swing.JTextField();
        txtNPass = new javax.swing.JPasswordField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        comboMpio = new javax.swing.JComboBox<>();
        comboTipo = new javax.swing.JComboBox<>();
        btnGuarda = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        txtCurp = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 30, 30));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel1.setText("Nombre:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(39, 26, -1, -1));

        jLabel2.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel2.setText("Apellido Paterno:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(39, 74, -1, -1));

        jLabel3.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel3.setText("Apellido Materno:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(39, 125, -1, -1));

        jLabel4.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel4.setText("Nombre Usuario:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 350, -1, -1));

        jLabel5.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel5.setText("Contraseña:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 400, -1, -1));

        jLabel6.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel6.setText("Tipo de usuario:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 450, -1, -1));

        jLabel7.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel7.setText("Matricula:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, -1, -1));

        jLabel8.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel8.setText("Municipio:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 300, -1, -1));

        txtNombre.setBackground(new java.awt.Color(255, 255, 255));
        txtNombre.setForeground(new java.awt.Color(51, 51, 51));
        txtNombre.setBorder(null);
        txtNombre.setCaretColor(new java.awt.Color(51, 51, 51));
        jPanel1.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 25, 190, 20));

        txtApP.setBackground(new java.awt.Color(255, 255, 255));
        txtApP.setForeground(new java.awt.Color(51, 51, 51));
        txtApP.setBorder(null);
        txtApP.setCaretColor(new java.awt.Color(51, 51, 51));
        jPanel1.add(txtApP, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 75, 190, 20));

        txtApM.setBackground(new java.awt.Color(255, 255, 255));
        txtApM.setForeground(new java.awt.Color(51, 51, 51));
        txtApM.setBorder(null);
        txtApM.setCaretColor(new java.awt.Color(51, 51, 51));
        jPanel1.add(txtApM, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 125, 190, 20));

        txtMatricula.setBackground(new java.awt.Color(255, 255, 255));
        txtMatricula.setForeground(new java.awt.Color(51, 51, 51));
        txtMatricula.setBorder(null);
        txtMatricula.setCaretColor(new java.awt.Color(51, 51, 51));
        jPanel1.add(txtMatricula, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 235, 190, 20));

        txtUsuarioN.setBackground(new java.awt.Color(255, 255, 255));
        txtUsuarioN.setForeground(new java.awt.Color(51, 51, 51));
        txtUsuarioN.setBorder(null);
        txtUsuarioN.setCaretColor(new java.awt.Color(51, 51, 51));
        jPanel1.add(txtUsuarioN, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 345, 190, 20));

        txtNPass.setBackground(new java.awt.Color(255, 255, 255));
        txtNPass.setForeground(new java.awt.Color(51, 51, 51));
        txtNPass.setText("jPasswordField1");
        txtNPass.setBorder(null);
        txtNPass.setCaretColor(new java.awt.Color(51, 51, 51));
        jPanel1.add(txtNPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 395, 190, 20));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/texto2.png"))); // NOI18N
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 390, 220, 30));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/texto2.png"))); // NOI18N
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 20, 220, 30));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/texto2.png"))); // NOI18N
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 70, 220, 30));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/texto2.png"))); // NOI18N
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 120, 220, 30));

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/texto2.png"))); // NOI18N
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 230, 220, 30));

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/texto2.png"))); // NOI18N
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 340, 220, 30));

        comboMpio.setBackground(new java.awt.Color(255, 255, 255));
        comboMpio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecciona...", "Tlahuelilpan" }));
        jPanel1.add(comboMpio, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 290, 110, -1));

        comboTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecciona...", "Directivo", "Administrativo", "Policia" }));
        jPanel1.add(comboTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 450, 110, -1));

        btnGuarda.setBackground(new java.awt.Color(51, 51, 51));
        btnGuarda.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        btnGuarda.setText("Guardar");
        btnGuarda.setBorder(null);
        btnGuarda.setOpaque(false);
        btnGuarda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardaActionPerformed(evt);
            }
        });
        jPanel1.add(btnGuarda, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 520, 70, 25));

        jLabel15.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel15.setText("CURP:");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, -1, -1));

        txtCurp.setBackground(new java.awt.Color(255, 255, 255));
        txtCurp.setForeground(new java.awt.Color(51, 51, 51));
        txtCurp.setBorder(null);
        txtCurp.setCaretColor(new java.awt.Color(51, 51, 51));
        jPanel1.add(txtCurp, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 185, 190, 20));

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/texto2.png"))); // NOI18N
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 180, 210, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 450, 590));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardaActionPerformed
        // TODO add your handling code here:
        //cargo();
        usuario();
    }//GEN-LAST:event_btnGuardaActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
        Directivo obj = new Directivo();
        obj.setVisible(true);
        dispose();
    }//GEN-LAST:event_formWindowClosed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Usuarios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuarda;
    private javax.swing.JComboBox<String> comboMpio;
    private javax.swing.JComboBox<String> comboTipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtApM;
    private javax.swing.JTextField txtApP;
    private javax.swing.JTextField txtCurp;
    private javax.swing.JTextField txtMatricula;
    private javax.swing.JPasswordField txtNPass;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtUsuarioN;
    // End of variables declaration//GEN-END:variables
}
