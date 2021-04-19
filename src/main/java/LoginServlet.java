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
//            todo add more users
        if ("admin".equals(username) && "admin".equals(password)) {
            String tokenFromDataBase = DataBaseDeputy.getToken();
            if (tokenFromDataBase == null) {
                String newToken = "" + Integer.toHexString(username.hashCode() + (int) System.currentTimeMillis()) +
                        Integer.toHexString(password.hashCode() + (int) System.currentTimeMillis());
                DataBaseDeputy.setToken(newToken);
                tokenFromDataBase = newToken;
            }
            resp.addCookie(new Cookie("token", tokenFromDataBase));
            resp.sendRedirect("/");
        } else {
            resp.sendError(HttpServletResponse.SC_FORBIDDEN, ":P");
        }
    }
}
