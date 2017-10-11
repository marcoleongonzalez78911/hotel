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

/**
 *
 * @author mark
 */
public final class reservacion extends javax.swing.JFrame {
    inicio inicio;
    private Connection conexion;     
    private Statement st;     
    private ResultSet rs;
    
    
public void Conectar(){
    try{ 
            conexion=DriverManager.getConnection("jdbc:mysql://localhost/angeles","root","marko");                     
            st=conexion.createStatement(); 

            rs=st.executeQuery("Select * from reservaciones");             

            rs.next(); 

            this.jtf_id_reservacion.setText(rs.getString("id_reservacion")); 
            this.jtf_id_cliente.setText(rs.getString("id_cliente")); 
            this.jtf_fecha_reservacion.setText(rs.getString("fecha_reservacion"));             
            this.jtf_fecha_entrada.setText(rs.getString("fecha_entrada"));
            this.jtf_numero_gente.setText(rs.getString("numero_gente"));
            this.jtf_dias_estancia.setText(rs.getString("dias_estancia"));
            this.jtf_fecha_salida.setText(rs.getString("fecha_salida"));
            
             rs=st.executeQuery("select * from reservaciones");
            jt_reservacion.setModel(DbUtils.resultSetToTableModel(rs));
            
              st = conexion.createStatement();
                rs = st.executeQuery("select * from reservaciones");
                while (rs.next())
                this.jcb_numero.addItem(rs.getString("numero_gente"));
                
                 rs = st.executeQuery("select * from reservaciones");

        }catch(SQLException err){ 
            JOptionPane.showMessageDialog(null,"Error "+err.getMessage()); 
        }
    }

     private void primeroRegistro(){  
    try{             
        if(rs.isLast()==false) {   
            
            
            rs.first();                
            this.jtf_id_reservacion.setText(rs.getString("id_reservacion"));
            this.jtf_id_cliente.setText(rs.getString("id_cliente"));
            this.jtf_fecha_reservacion.setText(rs.getString("fecha_reservacion"));             
            this.jtf_fecha_entrada.setText(rs.getString("fecha_entrada"));
            this.jtf_numero_gente.setText(rs.getString("numero_gente"));
            this.jtf_dias_estancia.setText(rs.getString("dias_estancia"));
            this.jtf_fecha_salida.setText(rs.getString("fecha_salida"));
        }        
    }catch(SQLException err) {             
        JOptionPane.showMessageDialog(null,"Error "+err.getMessage());         
    }     
}
    
    private void ultimoRegistro(){  
    try{             
        if(rs.isLast()==false) {   
            
            
            rs.last();                
            this.jtf_id_reservacion.setText(rs.getString("id_reservacion"));      
            this.jtf_id_cliente.setText(rs.getString("id_cliente"));
            this.jtf_fecha_reservacion.setText(rs.getString("fecha_reservacion"));             
            this.jtf_fecha_entrada.setText(rs.getString("fecha_entrada"));
            this.jtf_numero_gente.setText(rs.getString("numero_gente"));
            this.jtf_dias_estancia.setText(rs.getString("dias_estancia"));
            this.jtf_fecha_salida.setText(rs.getString("fecha_salida"));
        }        
    }catch(SQLException err) {             
        JOptionPane.showMessageDialog(null,"Error "+err.getMessage());         
    }     
}
    
    
    private void siguienteRegistro(){  
    try{             
        if(rs.isLast()==false) {   
            
            
            rs.next();                
            this.jtf_id_reservacion.setText(rs.getString("id_reservacion")); 
            this.jtf_id_cliente.setText(rs.getString("id_cliente"));
            this.jtf_fecha_reservacion.setText(rs.getString("fecha_reservacion"));             
            this.jtf_fecha_entrada.setText(rs.getString("fecha_entrada"));
            this.jtf_numero_gente.setText(rs.getString("numero_gente"));
            this.jtf_dias_estancia.setText(rs.getString("dias_estancia"));
            this.jtf_fecha_salida.setText(rs.getString("fecha_salida"));
        }        
    }catch(SQLException err) {             
        JOptionPane.showMessageDialog(null,"Error "+err.getMessage());         
    }     
}

    
    private void anteriorRegistro(){  
    try{             
        if(rs.isLast()==false) {   
            
            
            rs.previous();                
            this.jtf_id_reservacion.setText(rs.getString("id_reservacion"));
            this.jtf_id_cliente.setText(rs.getString("id_cliente"));
            this.jtf_fecha_reservacion.setText(rs.getString("fecha_reservacion"));             
            this.jtf_fecha_entrada.setText(rs.getString("fecha_entrada"));
            this.jtf_numero_gente.setText(rs.getString("numero_gente"));
            this.jtf_dias_estancia.setText(rs.getString("dias_estancia"));
            this.jtf_fecha_salida.setText(rs.getString("fecha_salida"));
        }        
    }catch(SQLException err) {             
        JOptionPane.showMessageDialog(null,"Error "+err.getMessage());         
    }     
}
    
    private void guardarRegistro() {        
       try{ 
            String id_cliente=this.jtf_id_cliente.getText();
            String fecha_reservacion=this.jtf_fecha_reservacion.getText(); 
            String fecha_entrada=this.jtf_fecha_entrada.getText(); 
            String numero_gente=this.jtf_numero_gente.getText();
            String dias_estancia= this.jtf_dias_estancia.getText();
            String fecha_salida=this.jtf_fecha_salida.getText();
            
            st.executeUpdate("Insert into reservaciones (id_cliente,fecha_reservacion,fecha_entrada,numero_gente,dias_estancia,fecha_salida)"+" values ('"+ id_cliente +"','"+ fecha_reservacion +"','"+fecha_entrada+"','"+numero_gente+"','"+dias_estancia+"','"+fecha_salida+"');"); 
            this.Conectar();
            this.primeroRegistro();
            
             rs=st.executeQuery("Select * from reservaciones");

        } catch(SQLException err)         { 
            JOptionPane.showMessageDialog(null,"Error "+err.getMessage()); 
        } 

    } 
    
    
     private void borrarRegistro(){
        try{ 
           st.executeUpdate("delete from reservaciones where id_reservacion="+this.jtf_id_reservacion.getText());
           
           rs=st.executeQuery("Select * from reservaciones");
           this.primeroRegistro();
           this.Conectar();
       } catch(SQLException err){ 
            JOptionPane.showMessageDialog(null,"Error "+err.getMessage()); 
        } 

    } 
      private void nuevoRegistro() {
              
              jtf_id_cliente.setText("");
              jtf_fecha_reservacion.setText("");
              jtf_fecha_entrada.setText("");
              jtf_numero_gente.setText("");
              jtf_dias_estancia.setText("");
              jtf_fecha_salida.setText("");
              
           }
      private void BuscarRegistro() throws SQLException{
        try{
         
            rs = st.executeQuery("select * from reservaciones where fecha_reservacion like '%"+this.jtf_Buscar.getText()+"%'");
            jt_reservacion.setModel(DbUtils.resultSetToTableModel(rs));
            
            rs=st.executeQuery("Select * from reservaciones"); 
        
        } catch (SQLException err){
             
             JOptionPane.showMessageDialog(null,"Error "+err.getMessage());
         }
    
    }
      
      
      

    /**
     * Creates new form reservacion
     */
    public reservacion() {
        initComponents();
        this.Conectar();
    }
    public reservacion(inicio inicio) {
        initComponents();
        this.inicio = inicio;
        this.Conectar();
     }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jl_id_reservacion = new javax.swing.JLabel();
        jl_fecha_reservacion = new javax.swing.JLabel();
        jl_numero_gente = new javax.swing.JLabel();
        jb_primero = new javax.swing.JButton();
        jb_ultimo = new javax.swing.JButton();
        jb_anterior = new javax.swing.JButton();
        jb_siguiente = new javax.swing.JButton();
        jb_guardar = new javax.swing.JButton();
        jb_borrar = new javax.swing.JButton();
        jb_nuevo = new javax.swing.JButton();
        jb_modificar = new javax.swing.JButton();
        jtf_id_reservacion = new javax.swing.JTextField();
        jtf_fecha_reservacion = new javax.swing.JTextField();
        jtf_numero_gente = new javax.swing.JTextField();
        jl_fecha_entrada = new javax.swing.JLabel();
        jtf_fecha_entrada = new javax.swing.JTextField();
        jl_fecha_salida = new javax.swing.JLabel();
        jtf_fecha_salida = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jt_reservacion = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jb_salir = new javax.swing.JButton();
        jb_regresar = new javax.swing.JButton();
        jcb_numero = new javax.swing.JComboBox<>();
        jb_actualizar = new javax.swing.JButton();
        jtf_Buscar = new javax.swing.JTextField();
        jb_buscar = new javax.swing.JButton();
        jl_dias_estancia = new javax.swing.JLabel();
        jtf_dias_estancia = new javax.swing.JTextField();
        jtf_id_cliente = new javax.swing.JTextField();
        jboxcliente = new javax.swing.JComboBox<>();
        jtf_apellido_paterno = new javax.swing.JTextField();
        jtf_apellido_materno = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        jTextField1.setText("jTextField1");

        jTextField2.setText("jTextField2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Reservaciones");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jl_id_reservacion.setForeground(new java.awt.Color(255, 255, 255));
        jl_id_reservacion.setText("Clave Reservacion");
        getContentPane().add(jl_id_reservacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, -1));

        jl_fecha_reservacion.setForeground(new java.awt.Color(255, 255, 255));
        jl_fecha_reservacion.setText("Fecha De Reservacion");
        getContentPane().add(jl_fecha_reservacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 130, -1, -1));

        jl_numero_gente.setForeground(new java.awt.Color(255, 255, 255));
        jl_numero_gente.setText("Numero De Persnas");
        getContentPane().add(jl_numero_gente, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 200, -1, -1));

        jb_primero.setText("<<");
        jb_primero.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jb_primeroMouseClicked(evt);
            }
        });
        getContentPane().add(jb_primero, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, -1, -1));

        jb_ultimo.setText(">>");
        jb_ultimo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jb_ultimoMouseClicked(evt);
            }
        });
        getContentPane().add(jb_ultimo, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 360, -1, -1));

        jb_anterior.setText("Anterior");
        jb_anterior.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jb_anteriorMouseClicked(evt);
            }
        });
        getContentPane().add(jb_anterior, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 360, -1, -1));

        jb_siguiente.setText("Siguiente");
        jb_siguiente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jb_siguienteMouseClicked(evt);
            }
        });
        getContentPane().add(jb_siguiente, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 360, -1, -1));

        jb_guardar.setText("Guardar");
        jb_guardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jb_guardarMouseClicked(evt);
            }
        });
        getContentPane().add(jb_guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 410, -1, -1));

        jb_borrar.setText("Borrar");
        jb_borrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jb_borrarMouseClicked(evt);
            }
        });
        getContentPane().add(jb_borrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 410, -1, -1));

        jb_nuevo.setText("Nuevo");
        jb_nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_nuevoActionPerformed(evt);
            }
        });
        getContentPane().add(jb_nuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 410, -1, -1));

        jb_modificar.setText("Modificar");
        jb_modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_modificarActionPerformed(evt);
            }
        });
        getContentPane().add(jb_modificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 410, -1, -1));

        jtf_id_reservacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtf_id_reservacionActionPerformed(evt);
            }
        });
        getContentPane().add(jtf_id_reservacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 130, 45, -1));
        getContentPane().add(jtf_fecha_reservacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 130, 102, -1));
        getContentPane().add(jtf_numero_gente, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 190, 55, -1));

        jl_fecha_entrada.setForeground(new java.awt.Color(255, 255, 255));
        jl_fecha_entrada.setText("Fecha De Entrada");
        getContentPane().add(jl_fecha_entrada, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, -1, -1));
        getContentPane().add(jtf_fecha_entrada, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 190, 102, -1));

        jl_fecha_salida.setForeground(new java.awt.Color(255, 255, 255));
        jl_fecha_salida.setText("Fecha De Salida");
        getContentPane().add(jl_fecha_salida, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 240, -1, -1));
        getContentPane().add(jtf_fecha_salida, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 240, 110, -1));

        jt_reservacion.setAutoCreateRowSorter(true);
        jt_reservacion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "id_reservacion", "fecha_reservacion", "fecha_entrada", "Numero_gente", "dias_estancia", "fecha_salida"
            }
        ));
        jScrollPane1.setViewportView(jt_reservacion);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 480, 600, 199));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("HOTEL LOS ANGELES");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 10, 130, -1));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("     Reservaciones");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 30, 130, -1));

        jb_salir.setText("Salir");
        jb_salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_salirActionPerformed(evt);
            }
        });
        getContentPane().add(jb_salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 10, -1, -1));

        jb_regresar.setText("Regresar");
        jb_regresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_regresarActionPerformed(evt);
            }
        });
        getContentPane().add(jb_regresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 10, 90, -1));

        jcb_numero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "(numero de huespedes)" }));
        getContentPane().add(jcb_numero, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 110, -1));

        jb_actualizar.setText("Actualizar");
        getContentPane().add(jb_actualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 410, -1, -1));

        jtf_Buscar.setText("(Buscar)");
        jtf_Buscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtf_BuscarKeyReleased(evt);
            }
        });
        getContentPane().add(jtf_Buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(183, 290, 120, 30));

        jb_buscar.setText("Buscar");
        getContentPane().add(jb_buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 290, -1, -1));

        jl_dias_estancia.setForeground(new java.awt.Color(255, 255, 255));
        jl_dias_estancia.setText("Dias De Estancia");
        getContentPane().add(jl_dias_estancia, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, -1, -1));
        getContentPane().add(jtf_dias_estancia, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 240, 80, -1));
        getContentPane().add(jtf_id_cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 80, 50, -1));

        jboxcliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jboxcliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jboxclienteActionPerformed(evt);
            }
        });
        getContentPane().add(jboxcliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 100, -1));

        jtf_apellido_paterno.setText("jTextField3");
        getContentPane().add(jtf_apellido_paterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 80, -1, -1));

        jtf_apellido_materno.setText("jTextField3");
        getContentPane().add(jtf_apellido_materno, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 80, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/imagenes/aaf5294a47a7c4e617953d98fe8c0b82.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 640, 720));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jb_primeroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jb_primeroMouseClicked
        // TODO add your handling code here:
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

    private void jb_nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_nuevoActionPerformed
     this.nuevoRegistro();
    }//GEN-LAST:event_jb_nuevoActionPerformed

    private void jb_salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_salirActionPerformed
       dispose();
    }//GEN-LAST:event_jb_salirActionPerformed

    private void jb_regresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_regresarActionPerformed
         inicio.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jb_regresarActionPerformed

    private void jb_modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_modificarActionPerformed
        int fila = jt_reservacion.getSelectedRow();
        if (fila>=0){
            jtf_id_reservacion.setText(jt_reservacion.getValueAt(fila, 0).toString());
            jtf_fecha_reservacion.setText(jt_reservacion.getValueAt(fila, 1).toString());
            jtf_fecha_entrada.setText(jt_reservacion.getValueAt(fila, 2).toString());
            jtf_numero_gente.setText(jt_reservacion.getValueAt(fila, 3).toString());
            jtf_dias_estancia.setText(jt_reservacion.getValueAt(fila, 4).toString());
            jtf_fecha_salida.setText(jt_reservacion.getValueAt(fila, 5).toString());
        }else{
            
              JOptionPane.showMessageDialog(this, "Fila no seleccionada");
        }
    }//GEN-LAST:event_jb_modificarActionPerformed

    private void jtf_id_reservacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtf_id_reservacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_id_reservacionActionPerformed

    private void jtf_BuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_BuscarKeyReleased
        try {
            this.BuscarRegistro();
        } catch (SQLException ex) {
            Logger.getLogger(reservacion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jtf_BuscarKeyReleased

    private void jboxclienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jboxclienteActionPerformed

    }//GEN-LAST:event_jboxclienteActionPerformed

    private void jb_borrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jb_borrarMouseClicked
       this.borrarRegistro();
    }//GEN-LAST:event_jb_borrarMouseClicked

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
            java.util.logging.Logger.getLogger(reservacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(reservacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(reservacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(reservacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new reservacion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JButton jb_actualizar;
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
    private javax.swing.JComboBox<String> jboxcliente;
    private javax.swing.JComboBox<String> jcb_numero;
    private javax.swing.JLabel jl_dias_estancia;
    private javax.swing.JLabel jl_fecha_entrada;
    private javax.swing.JLabel jl_fecha_reservacion;
    private javax.swing.JLabel jl_fecha_salida;
    private javax.swing.JLabel jl_id_reservacion;
    private javax.swing.JLabel jl_numero_gente;
    private javax.swing.JTable jt_reservacion;
    private javax.swing.JTextField jtf_Buscar;
    private javax.swing.JTextField jtf_apellido_materno;
    private javax.swing.JTextField jtf_apellido_paterno;
    private javax.swing.JTextField jtf_dias_estancia;
    private javax.swing.JTextField jtf_fecha_entrada;
    private javax.swing.JTextField jtf_fecha_reservacion;
    private javax.swing.JTextField jtf_fecha_salida;
    private javax.swing.JTextField jtf_id_cliente;
    private javax.swing.JTextField jtf_id_reservacion;
    private javax.swing.JTextField jtf_numero_gente;
    // End of variables declaration//GEN-END:variables
}
