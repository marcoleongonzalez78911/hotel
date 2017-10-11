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
//import net.proteanit.sql.DbUtils;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author mark
 */
public class JF_Detalles_reservacion extends javax.swing.JFrame {
    inicio inicio;
    private Connection conexion;     
    private Statement st;     
    private ResultSet rs;
    private DefaultTableModel model;
    private Connection Conectar1;
    
    
    public final void Conectar() throws SQLException{
    try{ 
//            jb_Combo.setVisible(false);
            conexion=DriverManager.getConnection("jdbc:mysql://localhost/angeles","root","marko");                     
            st=conexion.createStatement(); 

            rs=st.executeQuery("select  cliente.id_cliente, cliente.nombre, cliente.apellido_paterno, cliente.apellido_materno, habitaciones.numero_habitacion, habitaciones.tipo_habitacion, habitaciones.precio, reservaciones.fecha_reservacion, reservaciones.fecha_entrada, reservaciones.fecha_salida\n" +
"from detalles_reservacion\n" +
"inner join cliente on cliente.id_cliente = detalles_reservacion.id_cliente\n" +
"inner join habitaciones on habitaciones.id_habitacion = detalles_reservacion.id_habitacion\n" +
"inner join reservaciones on reservaciones.id_reservacion = detalles_reservacion.id_reservacion;");             

             jt_detalles.setModel(net.proteanit.sql.DbUtils.resultSetToTableModel(rs));
             
          
            

            
              
                
           

        }catch(SQLException err){ 
            JOptionPane.showMessageDialog(null,"Error "+err.getMessage()); 
        }
    }
    
    
    
    
   private void Combo(){
      try{
            Conectar1 = DriverManager.getConnection("jdbc:mysql://localhost/angeles","root","marko");                     
            st=conexion.createStatement(); 
            
            
            rs=st.executeQuery("Select * from cliente where nombre ='"+jbox_cliente.getSelectedItem()+"';");             

           if ( rs.next()){ 
             this.jtf_telefono.setText(String.valueOf(rs.getString("telefono"))); 
             this.jtf_apellido_materno.setText(String.valueOf(rs.getString("apellido_materno")));
             this.jtf_apellido_paterno.setText(String.valueOf(rs.getString("apellido_paterno")));
             this.jtf_id_cliente.setText(String.valueOf(rs.getString("id_cliente"))); 
             Conectar();
           }
           
            
        }catch(SQLException err){ 
            JOptionPane.showMessageDialog(null,"Error "+err.getMessage()); 
        }




}
    

  
   
    
    /*/  private void nuevoRegistro() {
                
              
              jtf_id_cliente.setText("");
              jtf_nombre.setText("");
              jtf_apellido_paterno.setText("");
              jtf_apellido_materno.setText("");
              jtf_telefono.setText("");
             
              
              jtf_id_cliente1.setText("");
              jtf_tipo_habitacion.setText("");
              jtf_numero_habitacion.setText("");
              jtf_precio.setText("");
          
              jtf_id_reservacion.setText("");
              jtf_fecha_reservacion.setText("");
              jtf_fecha_entrada.setText("");
              jtf_numero_gente.setText("");
              jtf_dias_estancia.setText("");
              jtf_fecha_salida.setText("");
      }   
      
      private void guardarRegistro(){
                 try{ 
            String id_cliente=this.jtf_id_cliente.getText();
            String nombre=this.jtf_nombre.getText(); 
            String apellido_paterno=this.jtf_apellido_paterno.getText(); 
            String apellido_materno=this.jtf_apellido_materno.getText();
            String telefono=this.jtf_telefono.getText();
            
            
            st.executeUpdate("Insert into detalles_reservacion (id_cliente, nombre, apellido_paterno, apellido_materno,telefono)"+" values ('"+ id_cliente +"','"+ nombre +"','"+apellido_paterno+"','"+apellido_materno+"','"+telefono+"');"); 
            Conectar();*/
         
            
            
            
            
            
            
             //} catch(SQLException err)         { 
           // JOptionPane.showMessageDialog(null,"Error "+err.getMessage()); 
        //}
      //}
 /*     private void guardarRegistro(){
                 try{ 
            String id_cliente=this.jtf_id_cliente.getText();
            String nombre=this.jtf_nombre.getText(); 
            String apellido_paterno=this.jtf_apellido_paterno.getText(); 
            String apellido_materno=this.jtf_apellido_materno.getText();
            String telefono=this.jtf_telefono.getText();
            
            st.executeUpdate("Insert into cliente (id_cliente, nombre, apellido_paterno, apellido_materno,telefono)"+" values ('"+ id_cliente +"','"+ nombre +"','"+apellido_paterno+"','"+apellido_materno+"','"+telefono+"');"); 
            Conectar();
            
             rs=st.executeQuery("Select * from cliente"); 

            
        } catch(SQLException err)         { 
            JOptionPane.showMessageDialog(null,"Error "+err.getMessage()); 
        }
      
      
      
      }
      
       private void guardarRegistro2() {        
       try{ 
            
            String id_cliente =this.jtf_id_cliente1.getText();
            String tipo_habitacion=this.jtf_tipo_habitacion.getText(); 
            String numero_habitacion=this.jtf_numero_habitacion.getText();
            String precio=this.jtf_precio.getText();
            
            st.executeUpdate("Insert into habitaciones (id_cliente, tipo_habitacion,numero_habitacion,precio)"+" values ('"+ id_cliente +"','"+ tipo_habitacion +"','"+numero_habitacion+"','"+precio+"');"); 
            
            Conectar();
            
           rs=st.executeQuery("Select * from habitaciones"); 
   

        } catch(SQLException err)         { 
            JOptionPane.showMessageDialog(null,"Error "+err.getMessage()); 
            
        } 

    }
         private void guardarRegistro3() {        
       try{ 
            String id_cliente=this.jtf_id_cliente.getText();
            String fecha_reservacion=this.jtf_fecha_reservacion.getText(); 
            String fecha_entrada=this.jtf_fecha_entrada.getText(); 
            String numero_gente=this.jtf_numero_gente.getText();
            String dias_estancia= this.jtf_dias_estancia.getText();
            String fecha_salida=this.jtf_fecha_salida.getText();
            
            st.executeUpdate("Insert into reservaciones (id_cliente,fecha_reservacion,fecha_entrada,numero_gente,dias_estancia,fecha_salida)"+" values ('"+ id_cliente +"','"+ fecha_reservacion +"','"+fecha_entrada+"','"+numero_gente+"','"+dias_estancia+"','"+fecha_salida+"');"); 
            Conectar();
            
             rs=st.executeQuery("Select * from reservaciones"); 
             

        } catch(SQLException err)         { 
            JOptionPane.showMessageDialog(null,"Error "+err.getMessage()); 
        } 

    } */
          private void BuscarRegistro() throws SQLException{
        try{
         
            rs = st.executeQuery("Select cliente.id_cliente, cliente.nombre, cliente.apellido_paterno, cliente.apellido_materno, habitaciones.numero_habitacion, habitaciones.tipo_habitacion, habitaciones.precio, reservaciones.fecha_reservacion, reservaciones.fecha_entrada, reservaciones.fecha_salida\n" +
"from detalles_reservacion\n" +
"inner join cliente on cliente.id_cliente = detalles_reservacion.id_cliente\n" +
"inner join habitaciones on habitaciones.id_habitacion = detalles_reservacion.id_habitacion\n" +
"inner join reservaciones on reservaciones.id_reservacion = detalles_reservacion.id_reservacion where cliente.nombre like '%"+this.txtbuscar.getText()+"%'");
            jt_detalles.setModel(net.proteanit.sql.DbUtils.resultSetToTableModel(rs));
            
    
         
        
        } catch (SQLException err){
             
             JOptionPane.showMessageDialog(null,"Error "+err.getMessage());
         }
    
    }
          
          
    
    /**
     * Creates new form JF_Detallles_reservacion
     * @throws java.sql.SQLException
     */
    public JF_Detalles_reservacion() throws SQLException {
        initComponents();
        Conectar();
        Combo();
   //     Connection();
 //       jbox_cliente();
        
    }
    public JF_Detalles_reservacion(inicio inicio) throws SQLException {
        initComponents();
        this.inicio = inicio;
        Conectar();
     }
   
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jb_salir = new javax.swing.JButton();
        jb_regresar = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        jt_detalles = new javax.swing.JTable();
        jb_nueva = new javax.swing.JButton();
        jbtnguardar = new javax.swing.JButton();
        jb_cancelar = new javax.swing.JButton();
        txtbuscar = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jbox_cliente = new javax.swing.JComboBox<>();
        jtf_id_cliente = new javax.swing.JTextField();
        jtf_apellido_paterno = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jtf_apellido_materno = new javax.swing.JTextField();
        jtf_telefono = new javax.swing.JTextField();
        jl_Fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("         HOTEL LOS ANGELES ");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 0, 190, -1));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Reservacion");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 30, -1, -1));

        jb_salir.setText("Salir");
        jb_salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_salirActionPerformed(evt);
            }
        });
        getContentPane().add(jb_salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 0, -1, -1));

        jb_regresar.setText("Regresar");
        jb_regresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_regresarActionPerformed(evt);
            }
        });
        getContentPane().add(jb_regresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 0, 90, -1));
        getContentPane().add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 460, 780, 10));

        jt_detalles.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jt_detalles);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 510, 750, 170));

        jb_nueva.setText("Nueva Reservacion");
        jb_nueva.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jb_nuevaMouseClicked(evt);
            }
        });
        getContentPane().add(jb_nueva, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 470, -1, -1));

        jbtnguardar.setText("Guardar");
        jbtnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnguardarActionPerformed(evt);
            }
        });
        getContentPane().add(jbtnguardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 470, -1, -1));

        jb_cancelar.setText("Cancelar");
        jb_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_cancelarActionPerformed(evt);
            }
        });
        getContentPane().add(jb_cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 470, -1, -1));

        txtbuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtbuscarKeyReleased(evt);
            }
        });
        getContentPane().add(txtbuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 470, 80, -1));

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Buscar");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 470, 50, 20));

        jbox_cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbox_clienteActionPerformed(evt);
            }
        });
        getContentPane().add(jbox_cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 170, -1));
        getContentPane().add(jtf_id_cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 70, 30, -1));
        getContentPane().add(jtf_apellido_paterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 70, 110, -1));

        getContentPane().add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 160, -1));
        getContentPane().add(jtf_apellido_materno, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 70, 100, -1));
        getContentPane().add(jtf_telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 70, 90, -1));

        jl_Fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/imagenes/aaf5294a47a7c4e617953d98fe8c0b82.jpg"))); // NOI18N
        getContentPane().add(jl_Fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 780, 800));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jb_salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_salirActionPerformed
        dispose();
    }//GEN-LAST:event_jb_salirActionPerformed

    private void jb_regresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_regresarActionPerformed
       inicio.setVisible(true);
       this.setVisible(false);
    }//GEN-LAST:event_jb_regresarActionPerformed

    private void jb_nuevaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jb_nuevaMouseClicked
//       this.nuevoRegistro();
    }//GEN-LAST:event_jb_nuevaMouseClicked

    private void jb_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_cancelarActionPerformed
        Conectar.rollback();
    }//GEN-LAST:event_jb_cancelarActionPerformed

    private void jbtnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnguardarActionPerformed
   
/*      this.guardarRegistro();
        this.guardarRegistro2();
        this.guardarRegistro3();*/
   
    }//GEN-LAST:event_jbtnguardarActionPerformed

    private void txtbuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbuscarKeyReleased
        try {
            this.BuscarRegistro();
        } catch (SQLException ex) {
            Logger.getLogger(JF_Detalles_reservacion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txtbuscarKeyReleased

    private void jbox_clienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbox_clienteActionPerformed
       this.Combo();
    }//GEN-LAST:event_jbox_clienteActionPerformed

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JF_Detalles_reservacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new JF_Detalles_reservacion().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(JF_Detalles_reservacion.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JButton jb_cancelar;
    private javax.swing.JButton jb_nueva;
    private javax.swing.JButton jb_regresar;
    private javax.swing.JButton jb_salir;
    private javax.swing.JComboBox<String> jbox_cliente;
    private javax.swing.JButton jbtnguardar;
    private javax.swing.JLabel jl_Fondo;
    private javax.swing.JTable jt_detalles;
    private javax.swing.JTextField jtf_apellido_materno;
    private javax.swing.JTextField jtf_apellido_paterno;
    private javax.swing.JTextField jtf_id_cliente;
    private javax.swing.JTextField jtf_telefono;
    private javax.swing.JTextField txtbuscar;
    // End of variables declaration//GEN-END:variables
}
