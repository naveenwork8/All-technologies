import java.sql.*;
public class JdbcPreparedStmtExample {
    static final String DB_URL = "jdbc:mysql://localhost:3306/test-schema";
    static final String USERNAME = "root";
    static final String PWD = "xxxxx";
    static final String QUERY = "select * from test where test_id = ?";

    public static void main(String[] args) {
        try(Connection connection = DriverManager.getConnection(DB_URL, USERNAME, PWD);
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY)
            ){
            preparedStatement.setInt(1, 1);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                System.out.println("test_id : " +resultSet.getInt("test_id"));
                System.out.println("test_name : " +resultSet.getString("test_name"));
            }

        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

}
