package io.github.fernandasj.command;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Logout implements Command{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        HttpSession session = request.getSession();
        session.invalidate();
        
        try {
            response.sendRedirect("index.jsp");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
}
