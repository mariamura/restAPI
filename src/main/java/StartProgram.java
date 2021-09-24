

import com.sun.net.httpserver.HttpServer;
import controller.UserController;
import model.User;
import repository.Impl.UserRepositoryImpl;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class StartProgram {
    public static void main(String[] args) throws IOException {

    }

        /*int serverPort = 8000;
        HttpServer server = HttpServer.create(new InetSocketAddress(serverPort), 0);

        server.createContext("/api/hello", (exchange -> {
            if ("GET".equals(exchange.getRequestMethod())) {
                String respText = "Hello from get!";
                exchange.sendResponseHeaders(200, respText.getBytes().length);
                OutputStream output = exchange.getResponseBody();
                output.write(respText.getBytes());
                output.flush();
            }
            else if ("POST".equals(exchange.getRequestMethod())) {
                User user = new User("test");
                UserController userService = new UserController(new UserRepositoryImpl());
                String respText = "Hello from post!";
                exchange.sendResponseHeaders(200, respText.getBytes().length);
                OutputStream output = exchange.getResponseBody();
                output.write(respText.getBytes());
                output.flush();
            }
            else {
                exchange.sendResponseHeaders(405, -1);// 405 Method Not Allowed
            }
            exchange.close();
        }));
        server.setExecutor(null); // creates a default executor
        server.start();
    }*/
}
