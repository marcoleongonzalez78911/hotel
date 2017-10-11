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
import net.proteanit.sql.DbUtils;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author mark
 */
public final class habitaciones1 extends javax.swing.JFrame {
    inicio inicio;
    private Connection conexion;     
    private Statement st;     
    private ResultSet rs;
    private DefaultTableModel model;
    
     public void Conectar() throws SQLException{
    try{ 
            conexion=DriverManager.getConnection("jdbc:mysql://localhost/angeles","root","marko");                     
            st=conexion.createStatement(); 

            rs=st.executeQuery("Select * from habitaciones");             

            rs.next(); 

            this.jtf_id_habitacion.setText(rs.getString("id_habitacion"));
            this.jtf_id_cliente.setText(rs.getString("id_cliente"));
            this.jtf_tipo_habitacion.setText(rs.getString("tipo_habitacion"));             
            this.jtf_numero_habitacion.setText(rs.getString("numero_habitacion"));
            this.jtf_precio.setText(rs.getString("precio"));
            
             rs=st.executeQuery("select * from habitaciones");
            jt_habitaciones.setModel(DbUtils.resultSetToTableModel(rs));
            
                st = conexion.createStatement();
                rs = st.executeQuery("select * from habitaciones");
                while (rs.next())
                this.jcb_tipo_habitacion.addItem(rs.getString("tipo_habitacion"));
                
                 rs = st.executeQuery("select * from habitaciones");
                
           

        }catch(SQLException err){ 
            JOptionPane.showMessageDialog(null,"Error "+err.getMessage()); 
        }
    }

    /**
     * Creates new form habitaciones1
     * @throws java.sql.SQLException
     */
    public habitaciones1() throws SQLException {
        initComponents();
        Conectar();
        Combobox();
    }
     public habitaciones1(inicio inicio) throws SQLException {
        initComponents();
        this.inicio = inicio;
        Conectar();
     }
    
    
    private void primeroRegistro(){  
    try{             
        if(rs.isLast()==false) {   
            
            
            rs.first();                
           this.jtf_id_habitacion.setText(rs.getString("id_habitacion"));
           this.jtf_id_cliente.setText(rs.getString("id_cliente"));
           this.jtf_tipo_habitacion.setText(rs.getString("tipo_habitacion"));                
           this.jtf_numero_habitacion.setText(rs.getString("numero_habitacion"));
           this.jtf_precio.setText(rs.getString("precio"));
           rs=st.executeQuery("Select * from habitaciones");  
        }        
    }catch(SQLException err) {             
        JOptionPane.showMessageDialog(null,"Error "+err.getMessage());         
    }     
}
    
    private void ultimoRegistro(){  
    try{             
        if(rs.isLast()==false) {   
            
            
            rs.last();                
        this.jtf_id_habitacion.setText(rs.getString("id_habitacion"));
        this.jtf_id_cliente.setText(rs.getString("id_cliente"));        
        this.jtf_tipo_habitacion.setText(rs.getString("tipo_habitacion"));                
        this.jtf_numero_habitacion.setText(rs.getString("numero_habitacion"));
        this.jtf_precio.setText(rs.getString("precio"));
        rs=st.executeQuery("Select * from habitaciones"); 
        }        
    }catch(SQLException err) {             
        JOptionPane.showMessageDialog(null,"Error "+err.getMessage());         
    }     
}
    
    
    private void siguienteRegistro(){  
    try{             
        if(rs.isLast()==false) {   
            
            
            rs.next();                
           this.jtf_id_habitacion.setText(rs.getString("id_habitacion")); 
           this.jtf_id_cliente.setText(rs.getString("id_cliente"));
           this.jtf_tipo_habitacion.setText(rs.getString("tipo_habitacion"));                
           this.jtf_numero_habitacion.setText(rs.getString("numero_habitacion"));
           this.jtf_precio.setText(rs.getString("precio"));
          // rs=st.executeQuery("Select * from habitaciones"); 
        }        
    }catch(SQLException err) {             
        JOptionPane.showMessageDialog(null,"Error "+err.getMessage());         
    }     
}

    
    private void anteriorRegistro(){  
    try{             
        if(rs.isLast()==false) {   
            
            
            rs.previous();                
           this.jtf_id_habitacion.setText(rs.getString("id_habitacion"));
           this.jtf_id_cliente.setText(rs.getString("id_cliente"));
           this.jtf_tipo_habitacion.setText(rs.getString("tipo_habitacion"));                
           this.jtf_numero_habitacion.setText(rs.getString("numero_habitacion"));
           this.jtf_precio.setText(rs.getString("precio"));
           //rs=st.executeQuery("Select * from habitaciones"); 
               
        }        
    }catch(SQLException err) {             
        JOptionPane.showMessageDialog(null,"Error "+err.getMessage());         
    }     
}
    
    private void guardarRegistro() {        
       try{ 
            
            String id_cliente=this.jtf_id_cliente.getText();
            String tipo_habitacion=this.jtf_tipo_habitacion.getText(); 
            String numero_habitacion=this.jtf_numero_habitacion.getText();
            String precio=this.jtf_precio.getText();
            
            st.executeUpdate("Insert into habitaciones (id_cliente,tipo_habitacion,numero_habitacion,precio)"+" values ('"+ id_cliente +"','"+ tipo_habitacion +"','"+numero_habitacion+"','"+precio+"');"); 
            
            this.Conectar();
            this.primeroRegistro();
           
            
            rs=st.executeQuery("Select * from habitaciones");

        } catch(SQLException err)         { 
            JOptionPane.showMessageDialog(null,"Error "+err.getMessage()); 
            
        } 

    } 
    
    
     private void borrarRegistro(){
        try{ 
           st.executeUpdate("delete from habitaciones where id_habitacion="+this.jtf_id_habitacion.getText());
           
           rs=st.executeQuery("Select * from habitaciones");
           this.primeroRegistro();
           this.Conectar();
          
       } catch(SQLException err){ 
            JOptionPane.showMessageDialog(null,"Error "+err.getMessage()); 
        } 

           

              
    } 
     private void nuevoRegistro() throws SQLException {
              
              jtf_id_cliente.setText("");
              jtf_tipo_habitacion.setText("");
              jtf_numero_habitacion.setText("");
              jtf_precio.setText("");
              
              rs=st.executeQuery("Select * from habitaciones"); 
           }

     
    public void Combobox() {
         try{
                 conexion=DriverManager.getConnection("jdbc:mysql://localhost/angeles","root","marko");
                 
               
                 st = conexion.createStatement();
                 rs = st.executeQuery("select * from habitaciones");
                 while (rs.next()){
                    this.jcb_tipo_habitacion.addItem(rs.getString("tipo_habitacion"));
         }
         } catch (SQLException err){
             
             JOptionPane.showMessageDialog(null,"Error "+err.getMessage());
         }
    
    
    }
/*    public void Buscar(String texto){
        String[] titulos = {"id_habitacion","tipo_habitacion","numero_habitacion","precio"};
        String[] registro = new String[5];
        
        
        String sql = "select * from habitaciones where id_empleado like '%" + jtf_buscar.getText() + "' "
            + "OR tipo_habitaacion like '%" + jtf_buscar.getText() + "%' "
            + "OR numero_habitacion like '%" + jtf_buscar.getText() + "%' "
            + "OR precio like '%" + jtf_buscar.getText() + "%'";
        model = new DefaultTableModel(null, titulos);
        Conectar cc = new Conectar();
        Connection conect = cc.conexion();
        try{
                Statement sta= (Statement) conect.createStatement();
                ResultSet rst = sta.executeQuery(sql);
                while (rst.next()){
                
                    registro[0]=rst.getString("id_habitacion");
                    registro[1]=rst.getString("numero_habitacion");
                    registro[2]=rst.getString("tipo_habitacion");
                    registro[3]=rst.getString("precio");
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(habitaciones1.class.getName()).log(Level.SEVERE, null, ex);
            }
}*/
    
    private void BuscarRegistro() throws SQLException{
        try{
         
            rs = st.executeQuery("select * from habitaciones where tipo_habitacion like '%"+this.jtf_buscar.getText()+"%'");
            jt_habitaciones.setModel(DbUtils.resultSetToTableModel(rs));
            
            rs=st.executeQuery("Select * from habitaciones"); 
        
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

        jl_id_habitacion = new javax.swing.JLabel();
        jl_tipo_habitacion = new javax.swing.JLabel();
        jl_numero_habitacion = new javax.swing.JLabel();
        jl_precio = new javax.swing.JLabel();
        jtf_id_habitacion = new javax.swing.JTextField();
        jtf_tipo_habitacion = new javax.swing.JTextField();
        jtf_numero_habitacion = new javax.swing.JTextField();
        jtf_precio = new javax.swing.JTextField();
        jb_primero = new javax.swing.JButton();
        jb_ultimo = new javax.swing.JButton();
        jb_anterior = new javax.swing.JButton();
        jb_siguiente = new javax.swing.JButton();
        jb_guardar = new javax.swing.JButton();
        jb_borrar = new javax.swing.JButton();
        jb_nuevo = new javax.swing.JButton();
        jb_modificar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jt_habitaciones = new javax.swing.JTable();
        jb_salir = new javax.swing.JButton();
        jb_regresar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jcb_tipo_habitacion = new javax.swing.JComboBox<>();
        jb_buscar = new javax.swing.JButton();
        jtf_buscar = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jtf_id_cliente = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Habitaciones");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jl_id_habitacion.setForeground(new java.awt.Color(255, 255, 255));
        jl_id_habitacion.setText("Clave De Habitacion");
        getContentPane().add(jl_id_habitacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, -1, -1));

        jl_tipo_habitacion.setForeground(new java.awt.Color(255, 255, 255));
        jl_tipo_habitacion.setText("tipo_habitacion");
        getContentPane().add(jl_tipo_habitacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 150, -1, -1));

        jl_numero_habitacion.setForeground(new java.awt.Color(255, 255, 255));
        jl_numero_habitacion.setText("Numero_habitacion");
        getContentPane().add(jl_numero_habitacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, -1, -1));

        jl_precio.setForeground(new java.awt.Color(255, 255, 255));
        jl_precio.setText("Precio");
        getContentPane().add(jl_precio, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 200, -1, -1));
        getContentPane().add(jtf_id_habitacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 150, 50, -1));
        getContentPane().add(jtf_tipo_habitacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 150, 84, -1));
        getContentPane().add(jtf_numero_habitacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 200, 74, -1));
        getContentPane().add(jtf_precio, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 200, 74, -1));

        jb_primero.setText("<<");
        jb_primero.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jb_primeroMouseClicked(evt);
            }
        });
        getContentPane().add(jb_primero, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, -1, -1));

        jb_ultimo.setText(">>");
        jb_ultimo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jb_ultimoMouseClicked(evt);
            }
        });
        getContentPane().add(jb_ultimo, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 300, -1, -1));

        jb_anterior.setText("Anterior");
        jb_anterior.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jb_anteriorMouseClicked(evt);
            }
        });
        getContentPane().add(jb_anterior, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 300, -1, -1));

        jb_siguiente.setText("Siguiente");
        jb_siguiente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jb_siguienteMouseClicked(evt);
            }
        });
        jb_siguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_siguienteActionPerformed(evt);
            }
        });
        getContentPane().add(jb_siguiente, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 300, -1, -1));

        jb_guardar.setText("Guardar");
        jb_guardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jb_guardarMouseClicked(evt);
            }
        });
        getContentPane().add(jb_guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 350, -1, -1));

        jb_borrar.setText("Borrar");
        jb_borrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jb_borrarMouseClicked(evt);
            }
        });
        getContentPane().add(jb_borrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 350, -1, -1));

        jb_nuevo.setText("Nuevo");
        jb_nuevo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jb_nuevoMouseClicked(evt);
            }
        });
        jb_nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_nuevoActionPerformed(evt);
            }
        });
        getContentPane().add(jb_nuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 350, -1, -1));

        jb_modificar.setText("Modificar");
        jb_modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_modificarActionPerformed(evt);
            }
        });
        getContentPane().add(jb_modificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 350, -1, -1));

        jt_habitaciones.setAutoCreateRowSorter(true);
        jt_habitaciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "id_habitacion", "tipo_habitacion", "Numero_habitacion", "Precio"
            }
        ));
        jScrollPane1.setViewportView(jt_habitaciones);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 400, 520, 220));

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
        getContentPane().add(jb_regresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 10, -1, -1));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("   Habitaciones");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 30, 100, -1));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("       HOTEL LOS ANGELES");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(162, 10, 150, -1));

        jcb_tipo_habitacion.setEditable(true);
        jcb_tipo_habitacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "(Seleccione una habitacion)" }));
        jcb_tipo_habitacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcb_tipo_habitacionActionPerformed(evt);
            }
        });
        getContentPane().add(jcb_tipo_habitacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 190, -1));

        jb_buscar.setText("Buscar");
        jb_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_buscarActionPerformed(evt);
            }
        });
        jb_buscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jb_buscarKeyPressed(evt);
            }
        });
        getContentPane().add(jb_buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 240, -1, -1));

        jtf_buscar.setText("(BUSCAR)");
        jtf_buscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtf_buscarKeyReleased(evt);
            }
        });
        getContentPane().add(jtf_buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 240, 120, 30));

        jButton1.setText("Actualizar");
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 350, -1, -1));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Clave De Cliente");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, -1));
        getContentPane().add(jtf_id_cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 90, 40, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/imagenes/aaf5294a47a7c4e617953d98fe8c0b82.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 550, 640));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jb_nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_nuevoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_nuevoActionPerformed

    private void jb_primeroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jb_primeroMouseClicked
        // TODO add your handling code here:
        this.primeroRegistro();
    }//GEN-LAST:event_jb_primeroMouseClicked

    private void jb_ultimoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jb_ultimoMouseClicked
        // TODO add your handling code here:
        this.ultimoRegistro();
    }//GEN-LAST:event_jb_ultimoMouseClicked

    private void jb_anteriorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jb_anteriorMouseClicked
        // TODO add your handling code here:
        this.anteriorRegistro();
    }//GEN-LAST:event_jb_anteriorMouseClicked

    private void jb_siguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_siguienteActionPerformed
      //this.siguienteRegistro();
    }//GEN-LAST:event_jb_siguienteActionPerformed

    private void jb_siguienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jb_siguienteMouseClicked
       
        this.siguienteRegistro();
    }//GEN-LAST:event_jb_siguienteMouseClicked

    private void jb_guardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jb_guardarMouseClicked
        // TODO add your handling code here
        this.guardarRegistro();
    }//GEN-LAST:event_jb_guardarMouseClicked

    private void jb_borrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jb_borrarMouseClicked
        // TODO add your handling code here:
        this.borrarRegistro();
    }//GEN-LAST:event_jb_borrarMouseClicked

    private void jb_nuevoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jb_nuevoMouseClicked
        try {
            // TODO add your handling code here:
            this.nuevoRegistro();
        } catch (SQLException ex) {
            Logger.getLogger(habitaciones1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jb_nuevoMouseClicked

    private void jb_salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_salirActionPerformed
       dispose();
    }//GEN-LAST:event_jb_salirActionPerformed

    private void jb_regresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_regresarActionPerformed
        // TODO add your handling code here:
        inicio.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jb_regresarActionPerformed

    private void jcb_tipo_habitacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcb_tipo_habitacionActionPerformed
        /*jtf_buscar.setEnabled(true);
        jb_buscar.setEnabled()true;
        Deshabilitar();*/
    }//GEN-LAST:event_jcb_tipo_habitacionActionPerformed

    private void jb_buscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jb_buscarKeyPressed
              
    }//GEN-LAST:event_jb_buscarKeyPressed

    private void jb_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_buscarActionPerformed
        /*jtf_buscar.setEnabled(true);
        jb_buscar.setEnabled()true;
        Deshabilitar();*/
    }//GEN-LAST:event_jb_buscarActionPerformed

    private void jtf_buscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_buscarKeyReleased
        try {
            this.BuscarRegistro();
        } catch (SQLException ex) {
            Logger.getLogger(habitaciones1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jtf_buscarKeyReleased

    private void jb_modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_modificarActionPerformed
          int fila = jt_habitaciones.getSelectedRow();
        if (fila>=0){
            jtf_id_habitacion.setText(jt_habitaciones.getValueAt(fila, 0).toString());
            jtf_tipo_habitacion.setText(jt_habitaciones.getValueAt(fila, 1).toString());
            jtf_numero_habitacion.setText(jt_habitaciones.getValueAt(fila, 2).toString());
            jtf_precio.setText(jt_habitaciones.getValueAt(fila, 3).toString());
            
        }else{
            
              JOptionPane.showMessageDialog(this, "Fila no seleccionada");
        }
            
    }//GEN-LAST:event_jb_modificarActionPerformed

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
            java.util.logging.Logger.getLogger(habitaciones1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(habitaciones1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(habitaciones1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(habitaciones1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                 try {
                    new habitaciones1().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(cliente.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jb_anterior;
    private javax.swing.JButton jb_borrar;
    private javax.swing.JButton jb_buscar;
    private javax.swing.JButton jb_guardar;
    private javax.swing.JButton jb_modificar;
    private javax.swing.JButton jb_nuevo;
    private javax.swing.JButton jb_primero;
    private javax.swing.JButton jb_regresar;
    private javax.swing.JButton jb_salir;
    private javax.swing.JButton jb_siguiente;
    private javax.swing.JButton jb_ultimo;
    private javax.swing.JComboBox<String> jcb_tipo_habitacion;
    private javax.swing.JLabel jl_id_habitacion;
    private javax.swing.JLabel jl_numero_habitacion;
    private javax.swing.JLabel jl_precio;
    private javax.swing.JLabel jl_tipo_habitacion;
    private javax.swing.JTable jt_habitaciones;
    private javax.swing.JTextField jtf_buscar;
    private javax.swing.JTextField jtf_id_cliente;
    private javax.swing.JTextField jtf_id_habitacion;
    private javax.swing.JTextField jtf_numero_habitacion;
    private javax.swing.JTextField jtf_precio;
    private javax.swing.JTextField jtf_tipo_habitacion;
    // End of variables declaration//GEN-END:variables


}
