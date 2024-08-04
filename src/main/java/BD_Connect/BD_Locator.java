package BD_Connect;

import java.sql.Connection;
import java.sql.SQLException;

public class BD_Locator {
    private static BD_Connect connection = null;

    /////////////////DataBase Services///////////////////////////////
    /*private static EmpresaBD empresaBD = null;

    public static EmpresaBD getEmpresaBD(){
        if(empresaBD == null)
            empresaBD = new EmpresaBD;
        return empresaBD;
    }
*/
    ////////////////////////////////////////////////////////////////
    public static void configureConnection (String serverAddress, String database,
                                            String userName, String password) throws SQLException, ClassNotFoundException {
        connection = new BD_Connect(serverAddress, database, userName, password);
    }

    public static Connection getConnection () throws SQLException, ClassNotFoundException {
        if (connection == null) {
            connection = new BD_Connect ("localhost", "Eventos_BD", "chris", "0927");
        }
        return connection.getDbConnection();
    }

}
