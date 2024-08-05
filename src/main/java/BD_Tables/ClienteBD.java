package BD_Tables;
import BD_Connect.BD_Locator;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClienteBD {
    public void CreateCliente(String code,String nombre, String primerApellido, String segundoApellido, String direccion,
                              String telefono, String email, boolean tratoPreferencial)
            throws SQLException,ClassNotFoundException{
        Connection connection = BD_Locator.getConnection();
        String stat = "";
        CallableStatement callStat = connection.prepareCall(stat,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);

        callStat.setString(1,code);
        callStat.setString(2,nombre);
        callStat.setString(3,primerApellido);
        callStat.setString(4,segundoApellido);
        callStat.setString(5,direccion);
        callStat.setString(6,telefono);
        callStat.setString(7,email);
        callStat.setBoolean(8,tratoPreferencial);

        callStat.execute();
        callStat.close();
    }

    public void UpdateCliente(String code,String nombre, String primerApellido, String segundoApellido, String direccion,
                              String telefono, String email, boolean tratoPreferencial)
                              throws SQLException,ClassNotFoundException{
        Connection connection = BD_Locator.getConnection();
        String stat = "";
        CallableStatement callStat = connection.prepareCall(stat,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);

        callStat.setString(1,code);
        callStat.setString(2,nombre);
        callStat.setString(3,primerApellido);
        callStat.setString(4,segundoApellido);
        callStat.setString(5,direccion);
        callStat.setString(6,telefono);
        callStat.setString(7,email);
        callStat.setBoolean(8,tratoPreferencial);

        callStat.execute();
        callStat.close();
    }

    public void DeleteCliente(String code)throws SQLException,ClassNotFoundException {
        Connection connection = BD_Locator.getConnection();
        String stat = "";
        CallableStatement callStat = connection.prepareCall(stat, ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);

        callStat.setString(1,code);

        callStat.execute();
        callStat.close();
    }


}
