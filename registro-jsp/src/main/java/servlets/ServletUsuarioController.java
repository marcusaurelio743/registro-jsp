package servlets;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoUsuarioRepository;
import model.ModelLogin;


@WebServlet(urlPatterns = {"/ServletUsuarioController"})
public class ServletUsuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
      private DaoUsuarioRepository daoUser = new DaoUsuarioRepository(); 
    
    public ServletUsuarioController() {
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acao = request.getParameter("acao");
		String id = request.getParameter("id");
		
		ModelLogin modelLogin = new ModelLogin();
		if(acao != null && !acao.isEmpty() && acao.equalsIgnoreCase("users")) {
			RequestDispatcher redirecionar = request.getRequestDispatcher("principal/usuario.jsp");
			request.setAttribute("todosUser", daoUser.buscarTodos());
			redirecionar.forward(request, response);
		}
		else if(acao != null && !acao.isEmpty() && acao.equalsIgnoreCase("verEditar") && id !=null && !id.isEmpty()) {
			RequestDispatcher redirecionar = request.getRequestDispatcher("principal/usuario.jsp");
			request.setAttribute("modelLogin", modelLogin = daoUser.buscarPorId(Long.valueOf(id)));
			request.setAttribute("msg", "Usuário Carregado na Tela!!!!");
			request.setAttribute("todosUser", daoUser.buscarTodos());
			redirecionar.forward(request, response);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String nome = request.getParameter("nome");
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		
		
		ModelLogin modelLogin = new ModelLogin(login, senha, nome, null);
		
		if( id != null && !id.isEmpty()) {
			modelLogin.setId(Long.valueOf(id));
		}
		
		if(daoUser.buscarPorLogin(login) != null ) {
			RequestDispatcher redirecionar = request.getRequestDispatcher("principal/usuario.jsp");
			request.setAttribute("modelLogin", modelLogin);
			request.setAttribute("msg", "Usuário Já possui um Login Cadastrado!!!!");
			request.setAttribute("todosUser", daoUser.buscarTodos());
			redirecionar.forward(request, response);
			return;
		}
		daoUser.salvar(modelLogin);
		
		RequestDispatcher redirecionar = request.getRequestDispatcher("principal/usuario.jsp");
		request.setAttribute("modelLogin", modelLogin);
		request.setAttribute("msg", "Usuário Salvo com Sucesso!!!!");
		request.setAttribute("todosUser", daoUser.buscarTodos());
		redirecionar.forward(request, response);
	}

}
