package filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@WebFilter(urlPatterns = {"/principal/*"})//intercepta todas as requisiçoes que vem do projeto
public class FilterAltenticacao extends HttpFilter implements Filter {
       
   
    public FilterAltenticacao() {
        super();
    }

	/*encerra o pocessos quando o servidor é parado*/
	public void destroy() {
	}

	/*intercepta todas as requisições e da resposta de tudo*/
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession sessao = req.getSession();
		
		String usuario = (String) sessao.getAttribute("usuario");
		
		String urlParaAutenticar = req.getServletPath();
		
		if(usuario == null || (usuario != null && usuario.isEmpty()) &&
				!urlParaAutenticar.equalsIgnoreCase("/principal/ServletLogin") &&
				!urlParaAutenticar.equalsIgnoreCase("/ServletLogin")) {
			
			RequestDispatcher redireciona = request.getRequestDispatcher("index.jsp?url="+urlParaAutenticar);
			request.setAttribute("msg", "Por favor, Loge no Sistema!!");
			redireciona.forward(request, response);
			return;
		}else {			
			
			chain.doFilter(request, response);
		}
	}

	/*inicia os processos quando o servidor sobe o projeto */
	public void init(FilterConfig fConfig) throws ServletException {
	}

}
