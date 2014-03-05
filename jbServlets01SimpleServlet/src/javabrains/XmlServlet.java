package javabrains;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class XmlServlet extends HttpServlet
{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;


    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        response.setContentType( "text/html" );
        PrintWriter out = response.getWriter();

        String userName = request.getParameter( "userName" );

        out.printf( "Hello %s from XmlServlet GET method\n", userName );
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException
    {
        response.setContentType( "text/html" );
        PrintWriter out = response.getWriter();

        String userName = request.getParameter( "userName" );
        String fullName = request.getParameter( "fullName" );

        out.printf( "Hello  %s, %s  from XmlServlet POST method\n", userName, fullName );

        String prof = request.getParameter( "prof" );
        out.printf( "You are a %s\n", prof );

        // if only 1 item to return
        //String location = request.getParameter( "location" );
        // if multiple items to return
        String[] location = request.getParameterValues( "location" );
        out.printf( "Your location is %d places\n", location.length );
        for ( int i = 0 ; i < location.length ; i++ )
        {
            out.println( location[i] );
        }
    }

}
