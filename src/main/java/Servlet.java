import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.stream.Collectors;

@WebServlet(name = "Servlet")
public class Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("In POST");
        System.out.println(request.getReader().lines().collect(Collectors.joining(System.lineSeparator())));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("!!!!!!!!!!! request.getHeaderNames() = " + request.getHeaderNames().nextElement());
        response.setContentType("text/html");
        PrintWriter printWriter = response.getWriter();
//        printWriter.write("<i>Hello!4</i>");
        printWriter.write("Hello!");
        printWriter.close();
//        response.addHeader("Access-Control-Allow-Origin", "*");
        /*response.addHeader("Access-Control-Allow-Origin", "*");
        response.addHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE, HEAD");
        response.addHeader("Access-Control-Allow-Headers", "X-PINGOTHER, Origin, X-Requested-With, Content-Type, Accept");
        response.addHeader("Access-Control-Max-Age", "1728000");*/
    }
}
