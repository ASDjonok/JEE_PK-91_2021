import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
//        System.out.println(req.getReader().readLine());
        String username = req.getParameter("user_name");
        String password = req.getParameter("user_password");
//        String path = "/index.html";
        /*ServletContext servletContext = getServletContext();
        RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher(path);
        requestDispatcher.forward(req, resp);*/
        if ("admin".equals(username) && "admin".equals(password)) {
//            todo change token
            String token = username + password;
            resp.addCookie(new Cookie("token", token));
            resp.addCookie(new Cookie("test", "test"));
            resp.sendRedirect("/");
        } else {
            resp.sendError(HttpServletResponse.SC_FORBIDDEN, ":P");
        }
    }
}
