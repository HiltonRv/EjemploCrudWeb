
package Controlador;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Modelo.Bean.UsuarioBean;
import Modelo.DAO.UsuarioDAO;
import javax.swing.JOptionPane;
        
public class UsuarioServlet extends HttpServlet{
    
    protected void processRequest( HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException{
    String opcad=request.getParameter("op");
    int op = Integer.parseInt(opcad);
    String pagina="";
    switch(op)
    {
        case 1:{
            String usuario = request.getParameter("txtusu");
            String clave = request.getParameter("txtclave");
            UsuarioBean objUsuarioBean= new UsuarioBean();
                        objUsuarioBean.setUsuario(usuario);
                        objUsuarioBean.setClave(clave);
            UsuarioDAO objUsuarioDAO=new UsuarioDAO();
            
            boolean estado = objUsuarioDAO.ValidarUsuario(objUsuarioBean);
            
            JOptionPane.showMessageDialog(null,"Estado es:"+ estado);
            
            if(estado==true){
                pagina="/Vista/Seguridad/AccesoSistema/Estudiante/FrmMenu.jsp";
            }else{
                pagina="/Vista/Seguridad/AccesoSistema/Estudiante/FrmLoginEstudiante.jsp";
                request.setAttribute("mensaje","Usuario INCORRECTO");
            }
            break;
            
            }
        } 
        getServletContext().getRequestDispatcher(pagina).forward(request, response);
    }
}
