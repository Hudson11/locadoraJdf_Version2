/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Filtro;

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
import ufrn.Locadora.Model.Cliente;

/**
 *
 * @author Hudson
 */
@WebFilter(urlPatterns = "/Restrita/*")
public class Filtro implements Filter {
   
    @Override
    public void destroy() {        
    }
    
    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
        
        Cliente c = null;
        
        HttpSession session = ((HttpServletRequest) request).getSession(false);
            
        if(c != null){
            c = (Cliente) session.getAttribute("usuario-logado");
        }
        
        if(c == null){
            String contextPath = ((HttpServletRequest) request).getContextPath();
            ((HttpServletResponse) response).sendRedirect(contextPath + "/Login.xhtml");
        }else{
            chain.doFilter(request, response);
        }
    }
    
    @Override
    public void init(FilterConfig filterConfig) throws ServletException{          
    }
    
}
