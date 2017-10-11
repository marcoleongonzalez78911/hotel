/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
/**
 *
 * @author mark
 */
public class Conectar {

    static void rollback() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
      
    public String db = "angeles";
    public String url = "jdbc:posgresql://localhost/" + db;
    public String user = "postgres";
    public String pass = "";
    
    public Conectar()
    {
}
    
 public Connection Connectar(){
    Connection link = null;
    
    try{
        
        Class.forName("org.posgresql.Driver");
        //Class.forName("org.mm.mysql.Driver");
        link = DriverManager.getConnection(url, user, pass);
    } catch(Exception err){ 
            JOptionPane.showMessageDialog(null,"Error "+err.getMessage()); 
    
    }
    return link;
     
 }

    PreparedStatement prepareStatement(String sql) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    Statement createStatement() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
