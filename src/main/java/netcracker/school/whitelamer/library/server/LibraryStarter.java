package netcracker.school.whitelamer.library.server;

import netcracker.school.whitelamer.logmanager.LogManager;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.xml.stream.XMLStreamException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class LibraryStarter {
    private static final int DEFAULT_PORT = 9090;
    private static final String CONTEXT_PATH = "/";
    private static final String CONFIG_LOCATION = "netcracker.school.whitelamer.library.config";
    private static final String MAPPING_URL = "/*";

    public static void main(String[] args) throws Exception {
        String logconfig= String.join("\n", Files.readAllLines(Paths.get(new ClassPathResource("LogManager.xml").getURI())));
        //System.out.println(logconfig);
        try {
            LogManager.loadFromXml(logconfig);
        }catch (XMLStreamException ignore){

        }
        new LibraryStarter().startJetty(getPortFromArgs(args));
    }

    private static int getPortFromArgs(String[] args) {
        if (args.length > 0) {
            try {
                return Integer.valueOf(args[0]);
            } catch (NumberFormatException ignore) {
            }
        }
        LogManager.writeLog(LogManager.Type.INFO,"serverlogger","No server port configured, falling back to {"+DEFAULT_PORT+"}");
        return DEFAULT_PORT;
    }

    private void startJetty(int port) throws Exception {
        LogManager.writeLog(LogManager.Type.INFO,"serverlogger","Starting server at port {"+port+"}");
        Server server = new Server(port);
        server.setHandler(getServletContextHandler(getContext()));
        addRuntimeShutdownHook(server);
        server.start();
        LogManager.writeLog(LogManager.Type.INFO,"serverlogger","Server started at port {"+port+"}");
        server.join();
    }

    private static ServletContextHandler getServletContextHandler(WebApplicationContext context) throws IOException {

        ServletContextHandler contextHandler = new ServletContextHandler(ServletContextHandler.SESSIONS);
        contextHandler.setErrorHandler(null);

        System.out.println(new ClassPathResource("/").getURI().toString());

        contextHandler.setResourceBase(new ClassPathResource("/").getURI().toString());
        contextHandler.setContextPath(CONTEXT_PATH);
        WebApplicationContext webAppContext = getContext();
        DispatcherServlet dispatcherServlet = new DispatcherServlet(webAppContext);
        ServletHolder springServletHolder = new ServletHolder("dispatcher", dispatcherServlet);
        contextHandler.addServlet(springServletHolder, MAPPING_URL);
        contextHandler.addEventListener(new ContextLoaderListener(context));
        return contextHandler;
    }

    private static WebApplicationContext getContext() {
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.setConfigLocation(CONFIG_LOCATION);
        context.getEnvironment();
        return context;
    }
    private static void addRuntimeShutdownHook(final Server server) {
        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            @Override
            public void run() {
                if (server.isStarted()) {
                    server.setStopAtShutdown(true);
                    try {
                        server.stop();
                        LogManager.writeLog(LogManager.Type.INFO,"serverlogger","stopping jetty server");
                    } catch (Exception e) {
                        LogManager.writeLog(LogManager.Type.INFO,"serverlogger","Error while stopping jetty server: " + e.getMessage());
                    }
                }
            }
        }));
    }
}

