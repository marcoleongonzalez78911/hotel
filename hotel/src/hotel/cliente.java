/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel;
import java.sql.DriverManager; 
import java.sql.Connection; 
//import java.sql.PreparedStatement;
import java.sql.ResultSet; 
import java.sql.SQLException;
import java.sql.Statement; 
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
//import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;
//import javax.swing.table.DefaultTableModel;




/**
 *
 * @author mark
 */
public final class cliente extends javax.swing.JFrame {
    inicio inicio;
   // DefaultTableModel modelo;
    private Connection conexion;     
    private Statement st;     
    private ResultSet rs;

    
public void Conectar() throws SQLException{
    try{ 
            conexion=DriverManager.getConnection("jdbc:mysql://localhost/angeles","root","marko");                     
            st=conexion.createStatement(); 

            rs=st.executeQuery("Select * from cliente");             

            rs.next(); 

            this.jtf_id_cliente.setText(rs.getString("id_cliente"));                         
            this.jtf_nombre.setText(rs.getString("nombre"));             
            this.jtf_apellido_paterno.setText(rs.getString("apellido_paterno"));
            this.jtf_apellido_materno.setText(rs.getString("apellido_materno"));
            this.jtf_telefono.setText(rs.getString("telefono"));
            
            rs = st.executeQuery("select * from cliente");
            jt_clientes.setModel(DbUtils.resultSetToTableModel(rs));
            
            
            rs = st.executeQuery("select * from cliente");
            while (rs.next())
            this.jcb_clientes.addItem(rs.getString("nombre"));
            
      

        }catch(SQLException err){ 
            JOptionPane.showMessageDialog(null,"Error "+err.getMessage()); 
        }
    }
    /**
     * Creates new form cliente
     * @throws java.sql.SQLException
     */
    public cliente() throws SQLException {
        initComponents();
        this.Conectar();
        
        
    }
     public cliente(inicio inicio) throws SQLException {
        initComponents();
        this.inicio = inicio;
        this.Conectar();
     }
     
    private void primeroRegistro(){  
    try{             
        if(rs.isLast()==false) {   
            
            
            rs.first();                
           this.jtf_id_cliente.setText(rs.getString("id_cliente"));        
           this.jtf_nombre.setText(rs.getString("nombre"));                
           this.jtf_apellido_paterno.setText(rs.getString("apellido_paterno"));                
           this.jtf_apellido_materno.setText(rs.getString("apellido_materno"));
           this.jtf_telefono.setText(rs.getString("telefono"));
           
          rs = st.executeQuery("select * from cliente");
        }        
    }catch(SQLException err) {             
        JOptionPane.showMessageDialog(null,"Error "+err.getMessage());         
    }     
}
    
    private void ultimoRegistro(){  
    try{             
        if(rs.isLast()==false) {   
            
            
            rs.last();                
           this.jtf_id_cliente.setText(rs.getString("id_cliente"));        
           this.jtf_nombre.setText(rs.getString("nombre"));                
           this.jtf_apellido_paterno.setText(rs.getString("apellido_paterno"));                
           this.jtf_apellido_materno.setText(rs.getString("apellido_materno"));
           this.jtf_telefono.setText(rs.getString("telefono"));
           
            rs = st.executeQuery("select * from cliente");
        }        
    }catch(SQLException err) {             
        JOptionPane.showMessageDialog(null,"Error "+err.getMessage());         
    }     
}
    
    
    private void siguienteRegistro(){  
    try{             
        if(rs.isLast()==false) {   
            
            
            rs.next();                
           this.jtf_id_cliente.setText(rs.getString("id_cliente"));        
           this.jtf_nombre.setText(rs.getString("nombre"));                
           this.jtf_apellido_paterno.setText(rs.getString("apellido_paterno"));                
           this.jtf_apellido_materno.setText(rs.getString("apellido_materno"));
           this.jtf_telefono.setText(rs.getString("telefono"));
           
           // rs = st.executeQuery("select * from cliente");
        }        
    }catch(SQLException err) {             
        JOptionPane.showMessageDialog(null,"Error "+err.getMessage());         
    }     
}

    
    private void anteriorRegistro(){  
    try{             
        if(rs.isLast()==false) {   
            
            
            rs.previous();                
           this.jtf_id_cliente.setText(rs.getString("id_cliente"));        
           this.jtf_nombre.setText(rs.getString("nombre"));                
           this.jtf_apellido_paterno.setText(rs.getString("apellido_paterno"));                
           this.jtf_apellido_materno.setText(rs.getString("apellido_materno"));
           this.jtf_telefono.setText(rs.getString("telefono"));
        }        
    }catch(SQLException err) {             
        JOptionPane.showMessageDialog(null,"Error "+err.getMessage());         
    }     
}
    
    private void guardarRegistro() {        
       try{ 
            String id_cliente=this.jtf_id_cliente.getText();
            String nombre=this.jtf_nombre.getText(); 
            String apellido_paterno=this.jtf_apellido_paterno.getText(); 
            String apellido_materno=this.jtf_apellido_materno.getText();
            String telefono=this.jtf_telefono.getText();
            
            st.executeUpdate("Insert into cliente (id_cliente,nombre,apellido_paterno,apellido_materno,telefono)"+" values ('"+ id_cliente +"','"+ nombre +"','"+apellido_paterno+"','"+apellido_materno+"','"+telefono+"');"); 
            this.Conectar();
            this.primeroRegistro();
            
             rs=st.executeQuery("Select * from cliente");

        } catch(SQLException err)         { 
            JOptionPane.showMessageDialog(null,"Error "+err.getMessage()); 
        } 

    } 
    
    
     private void borrarRegistro(){
        try{ 
           st.executeUpdate("delete from cliente where id_cliente="+this.jtf_id_cliente.getText());
           
           rs=st.executeQuery("Select * from cliente");
           this.primeroRegistro();
           this.Conectar();
       } catch(SQLException err){ 
            JOptionPane.showMessageDialog(null,"Error "+err.getMessage()); 
        } 

    } 
      private void nuevoRegistro() {
              
              jtf_id_cliente.setText("");
              jtf_nombre.setText("");
              jtf_apellido_paterno.setText("");
              jtf_apellido_materno.setText("");
              jtf_telefono.setText("");
              
           }
      
    /*  void mostrartabla() throws SQLException{
          DefaultTableModel modelo = new DefaultTableModel();
          modelo.addColumn("id_cliente");
          modelo.addColumn("nombre");
          modelo.addColumn("apellido_paterno");
          modelo.addColumn("apellido_materno");
          modelo.addColumn("telefono");
          jt_clientes.setModel(modelo);
          
          String sql = "select * from cliente";
          
          String datos[] = new String [5];
          Statement ste;
          try{
              ste = cn.createStatement();
              ResultSet rst = ste.executeQuery(sql);
              while(rst.next()){
                  datos[0]= rst.getString(1);
                  datos[1]= rst.getString(2);
                  datos[2]= rst.getString(3);
                  datos[3]= rst.getString(4);
                  datos[4]= rst.getString(5);
                  modelo.addRow(datos);
              }
              jt_clientes.setModel(modelo);
          
          } catch (SQLException ex){
               Logger.getLogger(cliente.class.getName()).log(Level.SEVERE, null, ex);
          
          }
          
      }*/
      
     /* private void BuscarRegistro (){
          try{
          
              rs=st.executeQuery("select * from cliente where cliente like '%"+this.jtf_buscar_cliente.getText()+"%'");
               jt_clientes.setModel(DbUtils.resultSetToTableModel(rs));
          
          }  catch(SQLException err)         { 
            JOptionPane.showMessageDialog(null,"Error "+err.getMessage()); 

          }
      }*/
      
      
       // public void Combobox() {
       //  try{
                
             //    rs = st.executeQuery("select nombre from clientes");
           //      while (rs.next()){
         
         //      this.jcb_clientes.addItem(rs.getString("nombre"));
         //}
        // } catch (SQLException err){
             
       //      JOptionPane.showMessageDialog(null,"Error "+err.getMessage());
     //    }
    
    
   // }
        
        private void Buscar(){
        try{
         
            rs = st.executeQuery("select * from cliente where nombre like '%"+this.jtf_buscar_cliente.getText()+"%'");
            jt_clientes.setModel(DbUtils.resultSetToTableModel(rs));
            
            rs=st.executeQuery("Select * from cliente"); 
        
        } catch (SQLException err){
             
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

        jL_nombre = new javax.swing.JLabel();
        jL_apellido_paterno = new javax.swing.JLabel();
        jL_apellido_materno = new javax.swing.JLabel();
        jL_id_cliente = new javax.swing.JLabel();
        jL_telefono = new javax.swing.JLabel();
        jtf_nombre = new javax.swing.JTextField();
        jtf_apellido_paterno = new javax.swing.JTextField();
        jtf_apellido_materno = new javax.swing.JTextField();
        jtf_telefono = new javax.swing.JTextField();
        jB_anterior = new javax.swing.JButton();
        jtf_id_cliente = new javax.swing.JTextField();
        jB_guardar = new javax.swing.JButton();
        jB_borrar = new javax.swing.JButton();
        jB_siguiente = new javax.swing.JButton();
        jB_nuevo = new javax.swing.JButton();
        jB_modificar = new javax.swing.JButton();
        jB_primero = new javax.swing.JButton();
        jB_ultimo = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jt_clientes = new javax.swing.JTable();
        jB_buscar_cliente = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jtf_buscar_cliente = new javax.swing.JTextField();
        jb_salir = new javax.swing.JButton();
        jb_regresar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jcb_clientes = new javax.swing.JComboBox<>();
        jb_actualizar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("cliente");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jL_nombre.setForeground(new java.awt.Color(255, 255, 255));
        jL_nombre.setText("nombre");
        getContentPane().add(jL_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 70, -1, -1));

        jL_apellido_paterno.setForeground(new java.awt.Color(255, 255, 255));
        jL_apellido_paterno.setText("apellido_paterno");
        getContentPane().add(jL_apellido_paterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, -1, -1));

        jL_apellido_materno.setForeground(new java.awt.Color(255, 255, 255));
        jL_apellido_materno.setText("apellido_materno");
        getContentPane().add(jL_apellido_materno, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 120, -1, -1));

        jL_id_cliente.setForeground(new java.awt.Color(255, 255, 255));
        jL_id_cliente.setText("id_cliente");
        getContentPane().add(jL_id_cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

        jL_telefono.setForeground(new java.awt.Color(255, 255, 255));
        jL_telefono.setText("telefono");
        getContentPane().add(jL_telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, -1, -1));
        getContentPane().add(jtf_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 70, 122, -1));
        getContentPane().add(jtf_apellido_paterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 120, 122, -1));
        getContentPane().add(jtf_apellido_materno, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 120, 122, -1));
        getContentPane().add(jtf_telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 160, 122, -1));

        jB_anterior.setText("Anterior");
        jB_anterior.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jB_anteriorMouseClicked(evt);
            }
        });
        getContentPane().add(jB_anterior, new org.netbeans.lib.awtextra.AbsoluteConstraints(136, 283, -1, -1));
        getContentPane().add(jtf_id_cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 70, 49, -1));

        jB_guardar.setText("Guardar");
        jB_guardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jB_guardarMouseClicked(evt);
            }
        });
        getContentPane().add(jB_guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 327, -1, -1));

        jB_borrar.setText("Borrar");
        jB_borrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jB_borrarMouseClicked(evt);
            }
        });
        getContentPane().add(jB_borrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(92, 327, -1, -1));

        jB_siguiente.setText("Siguiente");
        jB_siguiente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jB_siguienteMouseClicked(evt);
            }
        });
        getContentPane().add(jB_siguiente, new org.netbeans.lib.awtextra.AbsoluteConstraints(222, 283, -1, -1));

        jB_nuevo.setText("Nuevo ");
        jB_nuevo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jB_nuevoMouseClicked(evt);
            }
        });
        getContentPane().add(jB_nuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(175, 327, -1, -1));

        jB_modificar.setText("Modificar");
        jB_modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_modificarActionPerformed(evt);
            }
        });
        getContentPane().add(jB_modificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 320, -1, -1));

        jB_primero.setText("<<");
        jB_primero.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jB_primeroMouseClicked(evt);
            }
        });
        getContentPane().add(jB_primero, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 283, -1, -1));

        jB_ultimo.setText(">>");
        jB_ultimo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jB_ultimoMouseClicked(evt);
            }
        });
        getContentPane().add(jB_ultimo, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 283, -1, -1));

        jt_clientes.setAutoCreateRowSorter(true);
        jt_clientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "id_cliente", "Nombre", "apellido_paterno", "apellido_materno", "telefono"
            }
        ));
        jScrollPane1.setViewportView(jt_clientes);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 389, 533, 184));

        jB_buscar_cliente.setText("Buscar");
        getContentPane().add(jB_buscar_cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 210, -1, -1));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("      Clientes");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 30, 104, -1));

        jtf_buscar_cliente.setText("ingrese datos para buscar");
        jtf_buscar_cliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtf_buscar_clienteMouseClicked(evt);
            }
        });
        jtf_buscar_cliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtf_buscar_clienteKeyReleased(evt);
            }
        });
        getContentPane().add(jtf_buscar_cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 210, 106, 26));

        jb_salir.setText("Salir");
        jb_salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_salirActionPerformed(evt);
            }
        });
        getContentPane().add(jb_salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 10, -1, -1));

        jb_regresar.setText("Regresar");
        jb_regresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_regresarActionPerformed(evt);
            }
        });
        getContentPane().add(jb_regresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(447, 10, 90, -1));

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("         HOTEL LOS ANGELES ");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 10, 190, -1));

        jcb_clientes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "(seleccione cliente)" }));
        getContentPane().add(jcb_clientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 160, -1));

        jb_actualizar.setText("Actualizar");
        jb_actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_actualizarActionPerformed(evt);
            }
        });
        getContentPane().add(jb_actualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 320, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/imagenes/aaf5294a47a7c4e617953d98fe8c0b82.jpg"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 550, 590));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jB_siguienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jB_siguienteMouseClicked
      
         this.siguienteRegistro();
    }//GEN-LAST:event_jB_siguienteMouseClicked

    private void jB_anteriorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jB_anteriorMouseClicked
        // TODO add your handling code here:
        this.anteriorRegistro();
    }//GEN-LAST:event_jB_anteriorMouseClicked

    private void jB_guardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jB_guardarMouseClicked
        // TODO add your handling code here:
        this.guardarRegistro();
    }//GEN-LAST:event_jB_guardarMouseClicked

    private void jB_primeroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jB_primeroMouseClicked
        // TODO add your handling code here:
        this.primeroRegistro();
    }//GEN-LAST:event_jB_primeroMouseClicked

    private void jB_ultimoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jB_ultimoMouseClicked
        // TODO add your handling code here:
        this.ultimoRegistro();
    }//GEN-LAST:event_jB_ultimoMouseClicked

    private void jB_borrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jB_borrarMouseClicked
        // TODO add your handling code here:
        this.borrarRegistro();
    }//GEN-LAST:event_jB_borrarMouseClicked

    private void jB_nuevoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jB_nuevoMouseClicked
        // TODO add your handling code here:
        this.nuevoRegistro();
    }//GEN-LAST:event_jB_nuevoMouseClicked

    private void jtf_buscar_clienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtf_buscar_clienteMouseClicked
        // TODO add your handling code here:
        this.Buscar();
    }//GEN-LAST:event_jtf_buscar_clienteMouseClicked

    private void jb_regresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_regresarActionPerformed
        // TODO add your handling code here:
        inicio.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jb_regresarActionPerformed

    private void jb_salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_salirActionPerformed
        // TODO add your handling code here:
        dispose();
    
    }//GEN-LAST:event_jb_salirActionPerformed

    private void jB_modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_modificarActionPerformed
        // TODO add your handling code here:
        int fila = jt_clientes.getSelectedRow();
        if (fila>=0){
            jtf_id_cliente.setText(jt_clientes.getValueAt(fila, 0).toString());
            jtf_nombre.setText(jt_clientes.getValueAt(fila, 1).toString());
            jtf_apellido_paterno.setText(jt_clientes.getValueAt(fila, 2).toString());
            jtf_apellido_materno.setText(jt_clientes.getValueAt(fila, 3).toString());
            jtf_telefono.setText(jt_clientes.getValueAt(fila, 4).toString());
        }else{
            
              JOptionPane.showMessageDialog(this, "Fila no seleccionada");
        }
    }//GEN-LAST:event_jB_modificarActionPerformed

    private void jb_actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_actualizarActionPerformed
       /* try{
            PreparedStatement pst = cn.prepareStatement("UPDATE cliente SETNombre='"+ jtf_nombre.getText() +"',apellido_paterno='"
               +jtf_apellido_paterno.getText()+"',apellido_materno='"
                +jtf_apellido_materno.getText()+"',telefono='"
                + jtf_telefono.getText()+"'");
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Actualizado");
            nuevoRegistro();
            mostrartabla();
            
        } catch (SQLException e){
        JOptionPane.showMessageDialog(null, "Error:" + e);
        }*/
    }//GEN-LAST:event_jb_actualizarActionPerformed

    private void jtf_buscar_clienteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_buscar_clienteKeyReleased
       this.Buscar();
    }//GEN-LAST:event_jtf_buscar_clienteKeyReleased

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
            java.util.logging.Logger.getLogger(cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new cliente().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(cliente.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jB_anterior;
    private javax.swing.JButton jB_borrar;
    private javax.swing.JButton jB_buscar_cliente;
    private javax.swing.JButton jB_guardar;
    private javax.swing.JButton jB_modificar;
    private javax.swing.JButton jB_nuevo;
    private javax.swing.JButton jB_primero;
    private javax.swing.JButton jB_siguiente;
    private javax.swing.JButton jB_ultimo;
    private javax.swing.JLabel jL_apellido_materno;
    private javax.swing.JLabel jL_apellido_paterno;
    private javax.swing.JLabel jL_id_cliente;
    private javax.swing.JLabel jL_nombre;
    private javax.swing.JLabel jL_telefono;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jb_actualizar;
    private javax.swing.JButton jb_regresar;
    private javax.swing.JButton jb_salir;
    private javax.swing.JComboBox<String> jcb_clientes;
    private javax.swing.JTable jt_clientes;
    private javax.swing.JTextField jtf_apellido_materno;
    private javax.swing.JTextField jtf_apellido_paterno;
    private javax.swing.JTextField jtf_buscar_cliente;
    private javax.swing.JTextField jtf_id_cliente;
    private javax.swing.JTextField jtf_nombre;
    private javax.swing.JTextField jtf_telefono;
    // End of variables declaration//GEN-END:variables
    
    
    Conectar cn = new Conectar();
    Connection con = cn.Connectar();    

}
