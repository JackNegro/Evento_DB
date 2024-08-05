package BD_Tables;

import BD_Connect.BD_Locator;

import java.sql.*;

public class ProveedorBD {

    public void CreateProveedor(String code, String nombre, String primerApellido,
                                String segundoApellido,
                                String direccion, String telefono,
                                String email, String codeServicio)
                                throws SQLException,ClassNotFoundException{
        Connection connection= BD_Locator.getConnection();

        String stat = "";
        CallableStatement callStat = connection.prepareCall(stat, ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);

        callStat.setString(1,code);
        callStat.setString(2,nombre);
        callStat.setString(3,primerApellido);
        callStat.setString(4,segundoApellido);
        callStat.setString(5,direccion);
        callStat.setString(6,telefono);
        callStat.setString(7,email);
        callStat.setString(8,codeServicio);

        callStat.execute();
        callStat.close();

    }


    public void UpdateProveedor(String code, String nombre, String primerApellido,
                                String segundoApellido,
                                String direccion, String telefono,
                                String email, String codeServicio)
            throws SQLException,ClassNotFoundException{
        Connection connection= BD_Locator.getConnection();

        String stat = "";
        CallableStatement callStat = connection.prepareCall(stat, ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);

        callStat.setString(1,code);
        callStat.setString(2,nombre);
        callStat.setString(3,primerApellido);
        callStat.setString(4,segundoApellido);
        callStat.setString(5,direccion);
        callStat.setString(6,telefono);
        callStat.setString(7,email);
        callStat.setString(8,codeServicio);

        callStat.execute();
        callStat.close();

    }
    public void DeleteProveedor(String code)throws SQLException,ClassNotFoundException{
        Connection connection=BD_Locator.getConnection();
        String stat = "";

        CallableStatement callStat = connection.prepareCall(stat,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        callStat.setString(1,code);

        callStat.execute();
        callStat.close();
    }
    public ResultSet SelectProveedor()throws SQLException,ClassNotFoundException{
        ResultSet result = null;

        Connection connection = BD_Locator.getConnection();
        String stat = "";
        CallableStatement callStat = connection.prepareCall(stat,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);

        connection.setAutoCommit(false);
        callStat.registerOutParameter(1, Types.OTHER);

        callStat.execute();
        result = (ResultSet) callStat.getObject(1);

        callStat.close();
        return result;
    }
}
