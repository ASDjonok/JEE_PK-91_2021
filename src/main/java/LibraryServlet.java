import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

public class LibraryServlet extends HttpServlet {
//    todo make one common place for init connection
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        todo check JCC (is block needed)
        if (isTokenNotValidAndRefreshItIfValid(request, response)) return;

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("!!!!!!!!!!!! :(");
            e.printStackTrace();
        }

        try {
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/java_ee_db",
                    "postgres", "admin");

            Statement statement = connection.createStatement();
            BufferedReader reader = request.getReader();
            String title = reader.readLine();
            String author = reader.readLine();
            int quantity = Integer.parseInt(reader.readLine());

            statement.executeUpdate("insert into books (title, author, quantity) " +
                    "values ('" + title + "', '" + author + "', " + quantity +");");

            /*StringBuffer jb = new StringBuffer();
            String line = null;
            try {
                BufferedReader reader = request.getReader();
                while ((line = reader.readLine()) != null)
                    jb.append(line);
            } catch (Exception e) { *//*report an error*//* }

            try {
                JSONObject jsonObject =  HTTP.toJSONObject(jb.toString());

                String title = jsonObject.getString("title");
                String author = jsonObject.getString("author");
                int quantity = jsonObject.getInt("quantity");

                statement.executeUpdate("insert into books (title, author, quantity) " +
                        "values ('" + title + "', '" + author + "', " + quantity +");");
                *//*statement.executeUpdate("insert into books (title, author, quantity) " +
                        "values ('War and Peace 3', 'Leo Tolstoy', 1);");*//*

            } catch (JSONException e) {
                // crash and burn
                throw new IOException("Error parsing JSON request string");
            }*/


            /*ResultSet resultSet = statement.executeQuery("select * from books");

            PrintWriter writer = response.getWriter();
            while (resultSet.next()) {
                writer.println(resultSet.getString("title"));
            }*/

            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

//    todo think about name
    private boolean isTokenNotValidAndRefreshItIfValid(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Cookie[] cookies = request.getCookies();
        boolean isTokenValid = false;
        for (Cookie cookie : cookies) {
            if ("token".equals(cookie.getName())) {
                if (DataBaseDeputy.getToken().equals(cookie.getValue())) {
                    isTokenValid = true;
                    cookie.setMaxAge(LoginServlet.TOKEN_LIFE);
                    response.addCookie(cookie);
                    break;
                }
            }
        }
        if (!isTokenValid) {
            response.sendError(HttpServletResponse.SC_FORBIDDEN, ":P");
        }
        return !isTokenValid;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //        todo check JCC (is block needed)
        if (isTokenNotValidAndRefreshItIfValid(request, response)) return;

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("!!!!!!!!!!!! :(");
            e.printStackTrace();
        }

        try {
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/java_ee_db",
                    "postgres", "admin");

            Statement statement = connection.createStatement();
//            /*ResultSet resultSet = */statement.executeUpdate("insert into books (title, author, quantity) values ('War and Peace 3', 'Leo Tolstoy', 1);");
            ResultSet resultSet = statement.executeQuery("select * from books");

            PrintWriter writer = response.getWriter();
            while (resultSet.next()) {
                writer.println("'" + resultSet.getString("title") + "' '" + resultSet.getString("author") +
                        "' '" + resultSet.getString("quantity") + "'");
            }

            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
