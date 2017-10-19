import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ShowUsersServlet", urlPatterns = "/users")
 public class ShowUsersServlet extends HttpServlet {
    protected void doGet(
        HttpServletRequest request,
        HttpServletResponse response
    ) throws ServletException, IOException {
        Users users = DaoFactory.getUsersDao(); //new UsersArrayList(); // DAO

                request.setAttribute("users", users.all()  /* Real collection (list) */);

                request.getRequestDispatcher("users.jsp").forward(request, response);
    }
}