package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoLoginRepository;
import model.ModelLogin;


@WebServlet(urlPatterns = {"/principal/ServletLogin", "/ServletLogin"})
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private DaoLoginRepository daoLoginRepository = new DaoLoginRepository();
    
    public ServletLogin() {
    }
    //recebe dados pela url como parametro
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}
	//recebe dados por formulario
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		String url = request.getParameter("url");
		
		
		
		if(login != null && !login.isEmpty() && senha != null && !senha.isEmpty()) {
			ModelLogin modellogin = new ModelLogin(login,senha);
			
			//verifica se o login do usuario esta no banco
			if(daoLoginRepository.validarAutenticacao(modellogin)) {
				
				request.getSession().setAttribute("usuario", modellogin.getLogin());
				
				if(url == null || url.equals("null")) {
					
					url = "principal/principal.jsp";
				}
				
				RequestDispatcher redirecionar = request.getRequestDispatcher(url);
				redirecionar.forward(request, response);
			}else {
				RequestDispatcher redirecionar = request.getRequestDispatcher("index.jsp");
				request.setAttribute("msg", "Por favor Informe O Login e Senha corretamente!!");
				redirecionar.forward(request, response);
				
			}
			
		}else {
			RequestDispatcher redirecionar = request.getRequestDispatcher("index.jsp");
			request.setAttribute("msg", "Por favor Informe O Login e Senha corretamente!!");
			redirecionar.forward(request, response);
			
		}
	}

}
