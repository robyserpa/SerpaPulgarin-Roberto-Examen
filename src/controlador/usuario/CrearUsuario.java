package controlador.usuario;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAOFactory;
import dao.OperadoraDAO;
import dao.TelefonoDAO;
import dao.TipoDAO;
import dao.UsuarioDAO;
import entidades.Operadora;
import entidades.Tipo;
import entidades.Usuario;

/**
 * Servlet implementation class CrearUsuario
 */
@WebServlet("/crear-usuario")
public class CrearUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UsuarioDAO usuarioDAO;
	private Usuario usuario;
	private TelefonoDAO telefonoDAO;
	private TipoDAO tipoDAO;
	private OperadoraDAO operadoraDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CrearUsuario() {
        super();
        usuarioDAO = DAOFactory.getFactory().getUsuarioDAO();
        usuario = new Usuario();
        telefonoDAO = DAOFactory.getFactory().getTelefonoDAO();
        tipoDAO = DAOFactory.getFactory().getTipoDAO();
        operadoraDAO = DAOFactory.getFactory().getOperadoraDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		usuario.setUsuCedula(request.getParameter("usu_cedula"));
		usuario.setUsuCorreo(request.getParameter("usu_correo"));
		usuario.setUsuNombre(request.getParameter("usu_nombre"));
		
		usuarioDAO.create(usuario);
		
		List<Tipo> tipos;
		tipos = tipoDAO.findAll();
		System.out.println(tipos);
		
		List<Operadora> operadoras;
		operadoras = operadoraDAO.find("opeNombre", 0);
		
		request.setAttribute("tipos", tipos);
		request.setAttribute("operadoras", operadoras);
		
		request.setAttribute("usuario", usuario);
		response.sendRedirect("JSP/agregar-telefono.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
