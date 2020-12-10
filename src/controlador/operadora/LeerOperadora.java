package controlador.operadora;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAOFactory;
import dao.OperadoraDAO;
import entidades.Operadora;

/**
 * Servlet implementation class LeerOperadora
 */
@WebServlet("/leer-operadora")
public class LeerOperadora extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private OperadoraDAO operadoraDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LeerOperadora() {
        super();
        operadoraDAO = DAOFactory.getFactory().getOperadoraDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			List<Operadora> operadoras;
			
			operadoras = operadoraDAO.find("opeNombre", 0);
			request.setAttribute("operadoras", operadoras);
		} catch (Exception e) {
			getServletContext().setAttribute("operadora", null);
			response.sendRedirect("JSP/error.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
