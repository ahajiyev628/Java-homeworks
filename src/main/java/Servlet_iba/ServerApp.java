package Servlet_iba;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;

import javax.servlet.Servlet;

public class ServerApp {
    public static void main(String[] args) throws Exception {
        Server server = new Server(8080);
        ServletContextHandler handler = new ServletContextHandler();
        handler.addServlet(HelloServlet.class, "/hello");

        server.setHandler(handler);
        server.start();
        server.join();
    }
}
