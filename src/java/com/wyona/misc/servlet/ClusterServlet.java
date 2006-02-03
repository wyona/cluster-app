package com.wyona.misc.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 */
public class ClusterServlet extends HttpServlet {

    /**
     *
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter writer = response.getWriter();
        response.setContentType("application/xml");

	HttpSession session = request.getSession(true);

        writer.println("<?xml version=\"1.0\"?>");
        writer.println("<cluster>");

        writer.println("<session id=\""+session.getId()+"\">");
	Enumeration e = session.getAttributeNames();
        if (!e.hasMoreElements()) {
            writer.println("<no-attributes/>");
        }
        while (e.hasMoreElements()) {
            String name = (String)e.nextElement();
            String value = session.getAttribute(name).toString();
            writer.println("<attribute name=\"" + name + "\">" + value + "</attribute>");
        }
        writer.println("</session>");

        writer.println("</cluster>");
    }

    /**
     *
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter writer = response.getWriter();
        response.setContentType("text/html");

        writer.println("<html>");
        writer.println("<body>");

        String name = request.getParameter("name");
        if (name != null && name.length() > 0) {
           String value = request.getParameter("value");
	   HttpSession session = request.getSession(true);
           session.setAttribute(name, value);

           writer.println("Session attribute has been set: " + name + " = " + value);
        } else {
           writer.println("No session attribute has been set!");
        }

        writer.println("</body>");
        writer.println("</html>");
    }
}
