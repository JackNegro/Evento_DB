package BD_Connect;
import java.sql.*;

public class BD_Connect {
    private String databaseURL;
    private String user;
    private String password;

    public BD_Connect(String serverAddress, String database, String userName,String password){
        this.databaseURL = "jdbc:postgresql://"+serverAddress+":5432/"+database;
        this.user = userName;
        this.password = password;
    }
    public Connection getDbConnection()throws SQLException, ClassNotFoundException{
        Class.forName("org.postgresql.Driver");
        Connection dbConnection = DriverManager.getConnection(databaseURL,user,password);
        System.out.println("Connected");
        return dbConnection;
    }
}
