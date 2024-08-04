package BD_Tables;
import BD_Connect.BD_Locator;
import Logica.Empleado;
import java.sql.*;

public class EmpleadoBD {

    public void CreateEmpleado(String nombre, String primerApellido,
                               String segundoApellido, String direccion,
                               String telefono, String email,
                               String cargo, String departamento) throws SQLException,ClassNotFoundException{
        Connection connection = BD_Locator.getConnection();
        String stat = "{call pubblic.empleoyesInsert( ?, ?, ?, ?, ?, ?, ?, ? ) }";
        CallableStatement callStat = connection.prepareCall (stat, ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY);
        callStat.setString(1,nombre);
        callStat.setString(2,primerApellido);
        callStat.setString(3,segundoApellido);
        callStat.setString(4,direccion);
        callStat.setString(5,telefono);
        callStat.setString(6,email);
        callStat.setString(7,cargo);

        callStat.execute();
        connection.close();
    }
    public void UpdateEmpleado()throws SQLException,ClassNotFoundException{
        Connection connection = BD_Locator.getConnection();
        String stat;
    }
}
