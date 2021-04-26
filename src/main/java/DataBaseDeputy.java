import java.sql.*;

public class DataBaseDeputy {
    private static String token;

    public static String getToken() {
        return token;
    }

    public static void setToken(String token) {
        DataBaseDeputy.token = token;
    }

    public static boolean areUserCredentialsValid(String username, String password) {
        try (Statement statement = getDBStatement()) {
            ResultSet resultSet = statement.executeQuery("select * from users");

            while (resultSet.next()) {
                if (resultSet.getString("name").equals(username) &&
//                        todo add password cashing
                        resultSet.getString("password").equals(password)) {
                    return true;
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static Statement getDBStatement() throws ClassNotFoundException, SQLException {
        /*try {

        } catch (ClassNotFoundException e) {
            System.out.println("!!!!!!!!!!!! :(");
            e.printStackTrace();
        }*/

        Class.forName("org.postgresql.Driver");

        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/java_ee_db",
                "postgres", "admin");

        return connection.createStatement();
    }
}
