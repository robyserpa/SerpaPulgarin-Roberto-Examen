package controlador.usuario;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DAOFactory;
import dao.UsuarioDAO;
import entidades.Usuario;

/**
 * Servlet implementation class Login
 */
@WebServlet("/busqueda")
public class busqueda extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UsuarioDAO usuarioDAO;
    private Usuario usuario;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public busqueda() {
        super();
        usuarioDAO = DAOFactory.getFactory().getUsuarioDAO();
        usuario = new Usuario();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			String key = request.getParameter("usu_cedula");
			response.setCharacterEncoding("UTF-8");
			usuario = (Usuario) usuarioDAO.findUsuarioByCedulaByTelefono(key);
			request.setAttribute("usuario", usuario);
			response.getWriter().append("Credenciales correctas&correcto");
		} catch (Exception e) {
			response.getWriter().append("Credenciales incorrectas&error");
			System.out.println(e.getMessage());
		}		
	}

}
