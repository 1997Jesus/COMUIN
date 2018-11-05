package comuin;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author jesus
 */
public class Conexion {
    Connection conect = null;
    
    public Connection conexion(){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conect = DriverManager.getConnection("jdbc:sqlserver://JESUS-LAP\\SQLEXPRESS:1433;databaseName=COMUIN","sa","123");
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Se genero un error en: " +ex, "ERROR",JOptionPane.ERROR_MESSAGE);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conect;
    }
}
