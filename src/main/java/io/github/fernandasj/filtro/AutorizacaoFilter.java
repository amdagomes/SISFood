package io.github.fernandasj.filtro;

import io.github.fernandasj.modelo.Usuario;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Amanda
 */

@WebFilter(filterName = "filtroAutorizacao",
        urlPatterns = {"/home.jsp"})
public class AutorizacaoFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpSession session = ((HttpServletRequest) request).getSession();

        String usuario = (String) session.getAttribute("email");

        if (usuario == null) {

            ((HttpServletResponse) response).sendRedirect("index.jsp");

        } else {
            ((HttpServletResponse) response).sendRedirect("home.jsp");
            chain.doFilter(request, response);

        }
    }

    @Override
    public void destroy() {

    }

}