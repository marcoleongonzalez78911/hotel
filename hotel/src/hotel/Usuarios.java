/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel;
import java.sql.DriverManager; 
import java.sql.Connection; 
import java.sql.ResultSet; 
import java.sql.SQLException;
import java.sql.Statement; 
import java.util.logging.Level;
import java.util.logging.Logger;
//import java.util.logging.Level;
//import java.util.logging.Logger;
import net.proteanit.sql.DbUtils;
import javax.swing.JOptionPane;
//import javax.swing.table.DefaultTableModel;
/**
 *
 * @author mark
 */
public final class Usuarios extends javax.swing.JFrame {
    inicio inicio;
    private Connection conexion;     
    private Statement st;     
    private ResultSet rs;
    
    
    
    public void Conectar() throws SQLException{
    try{ 
            conexion=DriverManager.getConnection("jdbc:mysql://localhost/angeles","root","marko");                     
            st=conexion.createStatement(); 

            rs=st.executeQuery("Select * from usuarios");             

            rs.next(); 

            this.jtf_usuario.setText(rs.getString("usuario"));                         
            this.jtf_password.setText(rs.getString("password"));             
            this.jtf_tipo_usuario.setText(rs.getString("tipo_usuario"));
           
            
             rs=st.executeQuery("select * from usuarios");
            jt_usuario.setModel(DbUtils.resultSetToTableModel(rs));
            
                /*st = conexion.createStatement();
                rs = st.executeQuery("select * from habitaciones");
                while (rs.next())
                this.jcb_tipo_habitacion.addItem(rs.getString("tipo_habitacion"));
                
                 rs = st.executeQuery("select * from habitaciones");*/
                
           

        }catch(SQLException err){ 
            JOptionPane.showMessageDialog(null,"Error "+err.getMessage()); 
        }
    }
    /**
     * Creates new form Usuarios
     * @throws java.sql.SQLException
     */
    public Usuarios() throws SQLException  {
        initComponents();
        Conectar();
    }
        public Usuarios(inicio inicio) throws SQLException {
        initComponents();
        this.inicio = inicio;
        this.Conectar();
     }
        
        private void primeroRegistro(){  
    try{             
        if(rs.isLast()==false) {   
            
            
            rs.first();                
            this.jtf_usuario.setText(rs.getString("usuario"));                         
            this.jtf_password.setText(rs.getString("password"));             
            this.jtf_tipo_usuario.setText(rs.getString("tipo_usuario"));
            rs=st.executeQuery("Select * from usuarios"); 
        }        
    }catch(SQLException err) {             
        JOptionPane.showMessageDialog(null,"Error "+err.getMessage());         
    }     
}
    
    private void ultimoRegistro(){  
    try{             
        if(rs.isLast()==false) {   
            
            
            rs.last();                
            this.jtf_usuario.setText(rs.getString("usuario"));                         
            this.jtf_password.setText(rs.getString("password"));             
            this.jtf_tipo_usuario.setText(rs.getString("tipo_usuario"));
            rs=st.executeQuery("Select * from usuarios"); 
        }        
    }catch(SQLException err) {             
        JOptionPane.showMessageDialog(null,"Error "+err.getMessage());         
    }     
}
    
        
     private void anteriorRegistro(){  
    try{             
        if(rs.isLast()==false) {   
            
            
            rs.previous(); 
            this.jtf_usuario.setText(rs.getString("usuario"));                         
            this.jtf_password.setText(rs.getString("password"));             
            this.jtf_tipo_usuario.setText(rs.getString("tipo_usuario"));
           
        }        
    }catch(SQLException err) {             
        JOptionPane.showMessageDialog(null,"Error "+err.getMessage());         
    }     
}
     
        private void siguienteRegistro(){  
    try{             
        if(rs.isLast()==false) {   
            
            
            rs.next();
            this.jtf_usuario.setText(rs.getString("usuario"));                         
            this.jtf_password.setText(rs.getString("password"));             
            this.jtf_tipo_usuario.setText(rs.getString("tipo_usuario"));
           
        }        
    }catch(SQLException err) {             
        JOptionPane.showMessageDialog(null,"Error "+err.getMessage());         
    }     
}
        
          private void guardarRegistro() {        
       try{ 
            String usuario=this.jtf_usuario.getText(); 
            String password=this.jtf_password.getText(); 
            String tipo_usuario=this.jtf_tipo_usuario.getText();
        
             st.executeUpdate("Insert into usuarios (usuario, password, tipo_usuario)"+" values ('"+ usuario +"','"+ password +"','"+tipo_usuario+"');"); 
             this.Conectar();
             this.primeroRegistro();
          
             rs=st.executeQuery("Select * from usuarios");

        } catch(SQLException err)         { 
            JOptionPane.showMessageDialog(null,"Error "+err.getMessage()); 
            
        } 

    }
            private void borrarRegistro(){
        try{ 
           st.executeUpdate("delete from usuarios where usuario="+this.jtf_usuario.getText());

           this.primeroRegistro();
           this.Conectar();
           
          
          

       } catch(SQLException err){ 
            JOptionPane.showMessageDialog(null,"Error "+err.getMessage()); 
        }
     }
            
             private void nuevoRegistro() throws SQLException {
              try{
              jtf_usuario.setText("");
              jtf_password.setText("");
              jtf_tipo_usuario.setText("");
              
              
              rs=st.executeQuery("Select * from usuarios");
              }  catch(SQLException err){ 
            JOptionPane.showMessageDialog(null,"Error "+err.getMessage()); 
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

        jl_usuario = new javax.swing.JLabel();
        jl_password = new javax.swing.JLabel();
        jl_tipo_usuario = new javax.swing.JLabel();
        jtf_usuario = new javax.swing.JTextField();
        jtf_password = new javax.swing.JTextField();
        jtf_tipo_usuario = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jt_usuario = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jb_salir = new javax.swing.JButton();
        jb_regresar = new javax.swing.JButton();
        jb_anterior = new javax.swing.JButton();
        jb_siguiente = new javax.swing.JButton();
        jb_guardar = new javax.swing.JButton();
        jb_borrar = new javax.swing.JButton();
        jb_nuevo = new javax.swing.JButton();
        jb_primero = new javax.swing.JButton();
        jb_ultimo = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jl_usuario.setForeground(new java.awt.Color(255, 255, 255));
        jl_usuario.setText("Usuario");
        getContentPane().add(jl_usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 50, -1));

        jl_password.setForeground(new java.awt.Color(255, 255, 255));
        jl_password.setText("Contraseña");
        getContentPane().add(jl_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, -1, -1));

        jl_tipo_usuario.setForeground(new java.awt.Color(255, 255, 255));
        jl_tipo_usuario.setText("Tipo_Usuario");
        getContentPane().add(jl_tipo_usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, -1, -1));
        getContentPane().add(jtf_usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 110, 90, -1));
        getContentPane().add(jtf_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 150, 90, -1));
        getContentPane().add(jtf_tipo_usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 190, 90, -1));

        jt_usuario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Usuario", "Contraseña", "Tipo_Usuario"
            }
        ));
        jScrollPane1.setViewportView(jt_usuario);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 370, 370, 160));

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("HOTEL LOS ANGELES");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 30, 130, -1));

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Usuarios");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 50, -1, -1));

        jb_salir.setText("Salir");
        jb_salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_salirActionPerformed(evt);
            }
        });
        getContentPane().add(jb_salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 10, 60, -1));

        jb_regresar.setText("Regresar");
        jb_regresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_regresarActionPerformed(evt);
            }
        });
        getContentPane().add(jb_regresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 10, -1, -1));

        jb_anterior.setText("Anterior");
        jb_anterior.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jb_anteriorMouseClicked(evt);
            }
        });
        getContentPane().add(jb_anterior, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 270, -1, -1));

        jb_siguiente.setText("Siguiente");
        jb_siguiente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jb_siguienteMouseClicked(evt);
            }
        });
        getContentPane().add(jb_siguiente, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 270, -1, -1));

        jb_guardar.setText("Guardar");
        jb_guardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jb_guardarMouseClicked(evt);
            }
        });
        getContentPane().add(jb_guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, -1, -1));

        jb_borrar.setText("Borrar");
        jb_borrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jb_borrarMouseClicked(evt);
            }
        });
        getContentPane().add(jb_borrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 320, -1, -1));

        jb_nuevo.setText("Nuevo");
        jb_nuevo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jb_nuevoMouseClicked(evt);
            }
        });
        getContentPane().add(jb_nuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 320, -1, -1));

        jb_primero.setText("<<");
        jb_primero.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jb_primeroMouseClicked(evt);
            }
        });
        getContentPane().add(jb_primero, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, -1, -1));

        jb_ultimo.setText(">>");
        jb_ultimo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jb_ultimoMouseClicked(evt);
            }
        });
        getContentPane().add(jb_ultimo, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 270, 50, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/imagenes/aaf5294a47a7c4e617953d98fe8c0b82.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 450, 550));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jb_salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_salirActionPerformed
        dispose();
    }//GEN-LAST:event_jb_salirActionPerformed

    private void jb_regresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_regresarActionPerformed
         inicio.setVisible(true);
         this.setVisible(false);
    }//GEN-LAST:event_jb_regresarActionPerformed

    private void jb_primeroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jb_primeroMouseClicked
        this.primeroRegistro();
    }//GEN-LAST:event_jb_primeroMouseClicked

    private void jb_ultimoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jb_ultimoMouseClicked
       this.ultimoRegistro();
    }//GEN-LAST:event_jb_ultimoMouseClicked

    private void jb_anteriorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jb_anteriorMouseClicked
        this.anteriorRegistro();
    }//GEN-LAST:event_jb_anteriorMouseClicked

    private void jb_siguienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jb_siguienteMouseClicked
       this.siguienteRegistro();
    }//GEN-LAST:event_jb_siguienteMouseClicked

    private void jb_guardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jb_guardarMouseClicked
        this.guardarRegistro();
    }//GEN-LAST:event_jb_guardarMouseClicked

    private void jb_borrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jb_borrarMouseClicked
        this.borrarRegistro();
    }//GEN-LAST:event_jb_borrarMouseClicked

    private void jb_nuevoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jb_nuevoMouseClicked
        try {
            this.nuevoRegistro();
        } catch (SQLException ex) {
            Logger.getLogger(Usuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jb_nuevoMouseClicked

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
                try {
                    new Usuarios().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(Usuarios.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jb_anterior;
    private javax.swing.JButton jb_borrar;
    private javax.swing.JButton jb_guardar;
    private javax.swing.JButton jb_nuevo;
    private javax.swing.JButton jb_primero;
    private javax.swing.JButton jb_regresar;
    private javax.swing.JButton jb_salir;
    private javax.swing.JButton jb_siguiente;
    private javax.swing.JButton jb_ultimo;
    private javax.swing.JLabel jl_password;
    private javax.swing.JLabel jl_tipo_usuario;
    private javax.swing.JLabel jl_usuario;
    private javax.swing.JTable jt_usuario;
    private javax.swing.JTextField jtf_password;
    private javax.swing.JTextField jtf_tipo_usuario;
    private javax.swing.JTextField jtf_usuario;
    // End of variables declaration//GEN-END:variables
}
