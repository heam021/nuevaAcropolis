/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formularios;

import core.ConexionDB;
import core.Encriptacion;
import core.UserModel;
import core.Variables;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 *
 * @author funes
 */
public class Logeo extends javax.swing.JFrame {
    
    ConexionDB conexion;
    LinkedList<LinkedList<String>> alResultados;
    boolean conected=false;   
    Timer timer;
       
    /**
     * Creates new form Logeo
     */
    public Logeo() {
        initComponents();
        initConfig();
        try{
            conexion=new ConexionDB(Variables.rutaDB, Variables.userDB, Variables.claveDB);
            conected=true;
        }
        catch(ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException e)
        {
            JOptionPane.showMessageDialog(this, "Error al conectar a la base de datos. Contacte a su administrador. Info: "+e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
            conected=false;
        }
        
        timer = new Timer (1000, new ActionListener ()
        {
            public void actionPerformed(ActionEvent e)
            {
                if(!conected)
                    dispose();
                else
                    timer.stop();
             }
        });
        
        timer.start();
    }
    
    private void initConfig(){
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(Color.WHITE);     
        revisarArchivosConfiguracion();       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlLogin = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        lblLogo = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        tfUsuario = new javax.swing.JTextField();
        ptfClave = new javax.swing.JPasswordField();
        btnLogin = new javax.swing.JButton();
        lblError = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(233, 242, 241));
        setIconImage(getIconImage());
        setUndecorated(true);
        setResizable(false);
        setSize(new java.awt.Dimension(500, 464));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlLogin.setBackground(new java.awt.Color(255, 255, 255));
        pnlLogin.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(1, 64, 46));
        jLabel2.setText("Nueva Acropolis Santa Ana");
        pnlLogin.add(jLabel2);
        jLabel2.setBounds(150, 80, 330, 31);

        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Logo-Nueva-Acrópolis.jpg"))); // NOI18N
        pnlLogin.add(lblLogo);
        lblLogo.setBounds(20, 20, 120, 120);

        jLabel3.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(1, 64, 46));
        jLabel3.setText("Sistema de Biblioteca");
        pnlLogin.add(jLabel3);
        jLabel3.setBounds(190, 50, 260, 31);

        jPanel1.setBackground(new java.awt.Color(233, 242, 241));
        jPanel1.setForeground(new java.awt.Color(233, 242, 241));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tfUsuario.setBackground(new java.awt.Color(233, 242, 241));
        tfUsuario.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        tfUsuario.setText("admin");
        tfUsuario.setBorder(null);
        tfUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfUsuarioActionPerformed(evt);
            }
        });
        jPanel1.add(tfUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 100, 200, 30));

        ptfClave.setBackground(new java.awt.Color(233, 242, 241));
        ptfClave.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        ptfClave.setText("admin");
        ptfClave.setBorder(null);
        ptfClave.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ptfClaveKeyPressed(evt);
            }
        });
        jPanel1.add(ptfClave, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 160, 200, 30));

        btnLogin.setBackground(new java.awt.Color(1, 64, 46));
        btnLogin.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        btnLogin.setForeground(new java.awt.Color(255, 255, 255));
        btnLogin.setText("Iniciar Sesion");
        btnLogin.setBorder(null);
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        jPanel1.add(btnLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 220, 110, 40));

        lblError.setForeground(new java.awt.Color(255, 0, 0));
        lblError.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(lblError, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 270, 255, 30));

        jLabel4.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(1, 64, 46));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/padlock.png"))); // NOI18N
        jLabel4.setText("Contraseña:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 160, -1, -1));

        jLabel6.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(1, 64, 46));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/user (3).png"))); // NOI18N
        jLabel6.setText("Usuario:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, -1, -1));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, 420, 10));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 420, 20));

        pnlLogin.add(jPanel1);
        jPanel1.setBounds(0, 150, 530, 320);

        jLabel5.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(1, 64, 46));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cross.png"))); // NOI18N
        jLabel5.setText("Salir");
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        pnlLogin.add(jLabel5);
        jLabel5.setBounds(420, 10, 70, 24);

        getContentPane().add(pnlLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 463));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        // TODO add your handling code here:
            login();
    }//GEN-LAST:event_btnLoginActionPerformed

    private void ptfClaveKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ptfClaveKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==KeyEvent.VK_ENTER)
            login();
    }//GEN-LAST:event_ptfClaveKeyPressed

    private void tfUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfUsuarioActionPerformed

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        dispose();
    }//GEN-LAST:event_jLabel5MouseClicked

    @Override
    public Image getIconImage(){
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("images/icono.png"));
        return retValue;
    }
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
            java.util.logging.Logger.getLogger(Logeo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Logeo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Logeo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Logeo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Logeo().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblError;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JPanel pnlLogin;
    private javax.swing.JPasswordField ptfClave;
    private javax.swing.JTextField tfUsuario;
    // End of variables declaration//GEN-END:variables

    private void login() {
        if(tfUsuario.getText().equals("") || ptfClave.getPassword().equals(""))
            lblError.setText("No puede dejar campos en blanco");
        else
        {
            try 
            {
                ResultSet rsResultado=conexion.ejecutar("Select * from oina_usuario where nombre='"+tfUsuario.getText() +"'");
                
                alResultados=conexion.convertirRsToArrayList(rsResultado);
                
                if(alResultados.size()==0)
                    lblError.setText("<html>El usuario no existe en la base de datos. <br>Por favor contacte al administrador.</html>");
                else
                {
                    if((new String(ptfClave.getPassword())).equals(Encriptacion.decrypt(alResultados.get(0).get(1))))
                    {
                        Variables.user=new UserModel(alResultados.get(0).get(0),Integer.parseInt(alResultados.get(0).get(4)));
                        new FormularioPrincipal().setVisible(true);
                        this.dispose();
                    }
                    else
                    {
                        lblError.setText("<html>La contraseña es incorrecta. <br>Por favor contacte al administrador.</html>");
                    }
                }
                    
            }
            catch (Exception ex) 
            {
                Logger.getLogger(Logeo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void revisarArchivosConfiguracion() {

        String[] aArchivos=new String[]{System.getProperty("user.dir")+"\\archivos\\DB.txt",System.getProperty("user.dir")+"\\archivos\\USER.txt",
        System.getProperty("user.dir")+"\\archivos\\PASS.txt"};
        
         try {
             File file = new File(System.getProperty("user.dir")+"\\archivos");
             if(!file.exists())
                 file.mkdir();
             
             for(int i=0; i<aArchivos.length; i++)
             {
                file = new File(aArchivos[i]);
                // Si el archivo no existe es creado
                if (!file.exists())
                {
                    file.createNewFile();
                    
                    FileWriter fw = new FileWriter(file);
                    BufferedWriter bw = new BufferedWriter(fw);
                    switch(i)
                    {
                        case 0:
                            bw.write("localhost:3306/oina_biblioteca");
                            break;
                        case 1:
                            bw.write("root");
                            break;
                        case 2:
                            bw.write("mysql");
                            break; 
                    }
                    bw.close();
                }
                
                
                FileReader fr = new FileReader (file);
                BufferedReader br = new BufferedReader(fr);

                switch(i)
                {
                    case 0:
                        Variables.urlDB = br.readLine();
                        Variables.rutaDB=Variables.configuracionDriver+Variables.urlDB;
                        break;
                    case 1:
                        Variables.userDB = br.readLine();
                        break;
                    case 2:
                        Variables.claveDB = br.readLine();
                        break; 
                }
                br.close();
                    
                
             }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

  
}
