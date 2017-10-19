import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

 @WebServlet(name = "hello", urlPatterns = "/")
public class HelloWorldServlet extends HttpServlet {
    protected void doGet(
            HttpServletRequest request,
