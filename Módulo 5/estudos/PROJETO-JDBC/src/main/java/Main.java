import java.sql.*;

public class Main {
    public static void main(String[] args) {

        String url = "jdbc:postgresql://localhost:5432/TAREFA-1";
        String user = "postgres";
        String password = "postgres";

        try {
            Connection connection = DriverManager.getConnection(url, user, password);

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM employees");

            while (resultSet.next()) {
                String name = resultSet.getString("emp_name");
                String role = resultSet.getString("job_title");
                System.out.printf("%s | Cargo: %s\n", name, role);
            }

        } catch (SQLException e) {
            System.out.println("ERRO: Algo inesperado aconteceu");
        }
    }
}
