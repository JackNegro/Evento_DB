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
        callStat.setString(8,departamento);

        callStat.execute();
        connection.close();
    }

    public void UpdateEmpleado(String nombre, String primerApellido,
                               String segundoApellido, String direccion,
                               String telefono, String email,
                               String cargo, String departamento)throws SQLException,ClassNotFoundException{
        Connection connection = BD_Locator.getConnection();

        String stat = "";
        CallableStatement callStat = connection.prepareCall(stat, ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY);

        callStat.setString(1,nombre);
        callStat.setString(2,primerApellido);
        callStat.setString(3,segundoApellido);
        callStat.setString(4,direccion);
        callStat.setString(5,telefono);
        callStat.setString(6,email);
        callStat.setString(7,cargo);
        callStat.setString(8,departamento);

        callStat.execute();
        connection.close();
    }

    public void DeleteEmpleado(String codigo)throws SQLException,ClassNotFoundException{
        Connection connection = BD_Locator.getConnection();
        String stat = "";
        CallableStatement callStat = connection.prepareCall(stat,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        callStat.setString(1,codigo);

        callStat.execute();
        callStat.close();
    }

    public Empleado getEmpleadoCodigo(String codigo)throws SQLException,ClassNotFoundException{
        Empleado empleado = null;
        ResultSet result = null;

        Connection connection = BD_Locator.getConnection();
        String stat = "";
        CallableStatement callStat = connection.prepareCall(stat,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);

        connection.setAutoCommit(false);
        callStat.setString(1,codigo);
        callStat.registerOutParameter(2,Types.OTHER);
        callStat.execute();

        result = (ResultSet) callStat.getObject(2);

        if(result.next()){
            empleado = new Empleado(result.getString(1),result.getString(2),
                                result.getString(3),result.getString(4),
                                result.getString(5),result.getString(6),
                                result.getString(7),result.getString(8) );
        }
        connection.close();

        return empleado;
    }

    public ResultSet SelectAllEmpleados() throws SQLException, ClassNotFoundException {
        ResultSet results = null;

        Connection connection = BD_Locator.getConnection ();
        String stat = "{?= call public.select_all_users () }";
        CallableStatement callStat = connection.prepareCall (stat, ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY);

        connection.setAutoCommit (false);
        callStat.registerOutParameter (1, Types.OTHER);
        callStat.execute ();

        results = (ResultSet) callStat.getObject (1);

        connection.close ();

        return results;
    }
}
