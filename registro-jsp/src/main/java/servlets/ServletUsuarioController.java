package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ModelLogin;


@WebServlet("/ServletUsuarioController")
public class ServletUsuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ServletUsuarioController() {
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome = request.getParameter("nome");
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		String id = request.getParameter("id");
		
		ModelLogin modelLogin = new ModelLogin(login, senha, nome, null);
		
		if( id != null && !id.isEmpty()) {
			modelLogin.setId(Long.valueOf(id));
		}
		
		System.out.println(modelLogin);
		RequestDispatcher redirecionar = request.getRequestDispatcher("principal/usuario.jsp");
		
		redirecionar.forward(request, response);
	}

}
