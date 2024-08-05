package BD_Tables;

import BD_Connect.BD_Locator;

import java.sql.*;

public class ServicioBD {
    public void CreateServicio(String code, String nombre, String descripcion, String categoria,
                              float precio, String tipoServicio)throws SQLException,ClassNotFoundException{

        Connection connection = BD_Locator.getConnection();

        String stat = "";
        CallableStatement callStat = connection.prepareCall(stat, ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY);

        callStat.setString(1,code);
        callStat.setString(2,nombre);
        callStat.setString(3,descripcion);
        callStat.setString(4,categoria);
        callStat.setFloat(5,precio);
        callStat.setString(6,tipoServicio);

        callStat.execute();
        callStat.close();
    }

    public void UpdateServicio(String code, String nombre, String descripcion, String categoria,
                               float precio, String tipoServicio)throws SQLException,ClassNotFoundException{
        Connection connection = BD_Locator.getConnection();

        String stat = "";
        CallableStatement callStat = connection.prepareCall(stat,ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY);

        callStat.setString(1,code);
        callStat.setString(2,nombre);
        callStat.setString(3,descripcion);
        callStat.setString(4,categoria);
        callStat.setFloat(5,precio);
        callStat.setString(6,tipoServicio);

        callStat.execute();
        callStat.close();
    }

    public void DeleteServicio(String code)throws SQLException,ClassNotFoundException{
        Connection connection = BD_Locator.getConnection();
        String stat = "";
        CallableStatement callStat = connection.prepareCall(stat,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        callStat.setString(1,code);

        callStat.execute();
        callStat.close();
    }

    public ResultSet SelectServicio()throws SQLException,ClassNotFoundException{
        ResultSet result = null;

        Connection connection = BD_Locator.getConnection();
        String stat = "";
        CallableStatement callStat = connection.prepareCall(stat,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);

        connection.setAutoCommit(false);
        callStat.registerOutParameter(1, Types.OTHER);

        callStat.execute();

        result = (ResultSet) callStat.getObject(1);
        connection.close();

        return result;

    }
}
