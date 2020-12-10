package controlador.telefono;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAOFactory;
import dao.OperadoraDAO;
import dao.TelefonoDAO;
import dao.TipoDAO;
import entidades.Operadora;
import entidades.Telefono;
import entidades.Tipo;
import entidades.Usuario;

/**
 * Servlet implementation class ListarTelefonos
 */
@WebServlet("/listar-telefonos")
public class ListarTelefonos extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private TelefonoDAO telefonoDAO;
	private TipoDAO tipoDAO;
	private OperadoraDAO operadoraDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListarTelefonos() {
        super();
        telefonoDAO = DAOFactory.getFactory().getTelefonoDAO();
        tipoDAO = DAOFactory.getFactory().getTipoDAO();
        operadoraDAO = DAOFactory.getFactory().getOperadoraDAO();

    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Usuario usuario = (Usuario) request.getAttribute("usuario");
			int usuId =  usuario.getUsuId();
					
			List<Telefono> telefonos;
			String [][] atributos = {{"telUsu", "usuId"}};
			String [] valores = {"" + usuId};
			telefonos = telefonoDAO.findByPath(atributos, valores, null, 0, true);
			
			List<Tipo> tipos;
			tipos = tipoDAO.find("tipNombre", 0);
			
			List<Operadora> operadoras;
			operadoras = operadoraDAO.find("opeNombre", 0);
			
			request.setAttribute("telefonos", telefonos);
			request.setAttribute("tipos", tipos);
			request.setAttribute("operadoras", operadoras);
//			RequestDispatcher view = request.getRequestDispatcher("JSP/listar_telefonos.jsp");
//			view.forward(request, response);
		} catch (Exception e) {
			response.sendRedirect("JSP/error.jsp");
		}
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
