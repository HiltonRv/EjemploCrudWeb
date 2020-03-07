
package Modelo.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Modelo.Bean.UsuarioBean;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.ConexionBD;

public class UsuarioDAO {
    Connection cn=null;
    PreparedStatement pt=null;
    ResultSet rs=null;
    UsuarioBean objUsuarioBean=null;
    ArrayList<UsuarioBean> lista=null;
    
    
    public boolean ValidarUsuario(UsuarioBean obj){
        boolean estado=false;
        try {
            
            cn=ConexionBD.getConexion();// aver aver tata ta tannn!
            pt=cn.prepareStatement("SELECT * FROM usuario WHERE usu_usu=? and clave clave_usu=?;");
            pt.setString(1,obj.getUsuario());
            pt.setString(2,obj.getClave());
            
            rs=pt.executeQuery();
            
            if(rs.next()){
                estado=true;
            }
            pt.close();rs.close();cn.close();
            
        } catch (Exception ex) {
            estado=false;
        }
        return estado;
    }
}
