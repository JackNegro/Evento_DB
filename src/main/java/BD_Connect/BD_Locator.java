package BD_Connect;

import java.sql.Connection;
import java.sql.SQLException;
import BD_Tables.*;

public class BD_Locator {
    private static BD_Connect connection = null;
    private static EmpresaBD empresaBD = null;
    private static EmpleadoBD empleadoBD = null;

    /////////////////DataBase Services///////////////////////////////
    public static EmpresaBD getEmpresaBD(){
        if(empresaBD == null)
            empresaBD = new EmpresaBD();
        return empresaBD;
    }

    public static EmpleadoBD getEmpleadoBD(){
        if(empleadoBD == null)
            empleadoBD = new EmpleadoBD();
        return empleadoBD;
    }

    ////////////////////////////////////////////////////////////////
    public static void configureConnection (String serverAddress, String database, String userName, String password) throws SQLException, ClassNotFoundException {
        connection = new BD_Connect(serverAddress, database, userName, password);
    }

    public static Connection getConnection () throws SQLException, ClassNotFoundException {
        if (connection == null) {
            connection = new BD_Connect ("localhost", "Eventos_BD", "chris", "0927");
        }
        return connection.getDbConnection();
    }

}
