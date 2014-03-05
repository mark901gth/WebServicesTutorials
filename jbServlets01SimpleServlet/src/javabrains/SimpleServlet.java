package javabrains;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

// @formatter:off
/**
 * Servlet implementation class SimpleServlet
 */
@WebServlet(description = "A simple servlet", urlPatterns = { "/SimpleServletPath" })
// @formatter:on
public class SimpleServlet extends HttpServlet
{
    private static final long serialVersionUID = 1L;


    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        response.setContentType( "text/html" );
        PrintWriter writer = response.getWriter();
        String userName = request.getParameter( "name" );
        
        HttpSession session = request.getSession();            
        if ( userName != "" && userName!= null )
        {
            session.setAttribute( "savedUserName", userName );
        }
        writer.println( "Request parameter has username as: " + userName );
        writer.println( "Session parameter has username as: " + (String)session.getAttribute( "savedUserName" ) );
    }

}
