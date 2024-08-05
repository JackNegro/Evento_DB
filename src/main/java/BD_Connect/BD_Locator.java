package BD_Connect;

import java.sql.Connection;
import java.sql.SQLException;
import BD_Tables.*;
import Logica.Proveedor;

public class BD_Locator {
    private static BD_Connect connection = null;
    private static EmpresaBD empresaBD = null;
    private static EmpleadoBD empleadoBD = null;
    private static ClienteBD clienteBD = null;
    private static ContratoBD contratoBD = null;
    private static EventoBD eventoBD = null;
    private static ProveedorBD proveedorBD = null;
    private static ServicioBD servicioBD = null;
    private static UserBD userBD = null;

    /////////////////DataBase Services///////////////////////////////
    public static ClienteBD getClienteBD(){
        if(clienteBD == null)
            clienteBD = new ClienteBD();
        return clienteBD;
    }

    public static ContratoBD getContratoBD() {
        if (contratoBD == null)
            contratoBD = new ContratoBD();
        return contratoBD;
    }

    public static EventoBD getEventoBD() {
        if (eventoBD==null)
            eventoBD = new EventoBD();
        return eventoBD;
    }

    public static ProveedorBD getProveedorBD() {
        if (proveedorBD == null)
            proveedorBD = new ProveedorBD();
        return proveedorBD;
    }

    public static ServicioBD getServicioBD() {
        if (servicioBD == null)
            servicioBD = new ServicioBD();
        return servicioBD;
    }

    public static UserBD getUserBD() {
        if (userBD  == null)
            userBD = new UserBD();
        return userBD;
    }

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
