import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Servlet")
public class Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("!!!!!!!!!!! request.getHeaderNames() = " + request.getHeaderNames().nextElement());
        response.setContentType("text/html");
        PrintWriter printWriter = response.getWriter();
        printWriter.write("<i>Hello!</i>");
        printWriter.close();
    }
}
