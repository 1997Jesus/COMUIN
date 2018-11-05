package comuin;
import ventanas.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
/**
 *
 * @author jesus
 */
public class Conectar {
    Conexion con = new Conexion();
    Connection conecta = null;
    String query;
    String cap = null;
    static Statement st = null;
    static ResultSet rs = null;
    
    //Validacion del login
    
    public boolean verificar(String usuario, String pwr){
        //Desencriptamos la contraseña
        EncriptadorPassword ep = new EncriptadorPassword("12345");
        pwr = (String) ep.encrypt(pwr);
        
        int q = 0;
        
        query = "(SELECT Nombre_Usuario,Contrasena,Tipo_Usuario FROM USUARIO WHERE Nombre_Usuario = '" + usuario + "' and Contrasena = '" + pwr +"')";
        
        try{
            conecta = con.conexion();
            st = conecta.createStatement();
            rs = st.executeQuery(query);
            
            //Ahora nos movemos en los registros
            
            while(rs.next()){
                cap = rs.getString("Tipo_Usuario");
                if(cap.equals("Directivo")){
                    Directivo obj = new Directivo();
                    obj.setVisible(true);
                    obj.pack();
                }
                if(cap.equals("Administrador")){
                    Administrativo obj = new Administrativo();
                    obj.setVisible(true);
                    obj.pack();
                }
                if(cap.equals("Policia")){
                    Policia obj = new Policia();
                    obj.setVisible(true);
                    obj.pack();
                }
                //como no podemos usar true/false por estar dentro del try-catch
                //Usamos 0 y 1 como banderas para despues validar
                
                if(rs.getString(1) == null){
                    q = 0;
                }else{
                    q = 1;
                }
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,"Se genero un error en: " +ex, "ERROR",JOptionPane.ERROR_MESSAGE);
        }
        if(q == 1)
            return true;
        else return false;
    }
    
    public static ResultSet Consulta(String consulta){
        Conexion obj = new Conexion();
        Connection con = obj.conexion();
        Statement declara;
        try{
            
        }catch(Exception e){
        try{
            declara = con.createStatement();
            ResultSet respuesta = declara.executeQuery(consulta);
            declara.executeUpdate(consulta);
            return respuesta;
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Se genero un error", "ERROR",JOptionPane.ERROR_MESSAGE);
        }
      }
        return null;
    }
}
