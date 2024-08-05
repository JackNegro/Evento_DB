package BD_Tables;

import BD_Connect.BD_Locator;

import java.sql.*;

public class EventoBD {
    public void CreateEvento(String code, String nombre, String tipo, Date fecha, Time horaInicio,
                             Time horaFin, String ubicacion, int numInvitados,
                             String conceptoDecoracion, String code_responsable)
                             throws SQLException,ClassNotFoundException {
        Connection connection = BD_Locator.getConnection();
        String stat = "";
        CallableStatement callStat = connection.prepareCall(stat, ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);

        callStat.setString(1,code);
        callStat.setString(2,nombre);
        callStat.setString(3,tipo);
        callStat.setDate(4,fecha);
        callStat.setTime(5,horaInicio);
        callStat.setTime(6,horaFin);
        callStat.setString(7,ubicacion);
        callStat.setInt(8,numInvitados);
        callStat.setString(9,conceptoDecoracion);
        callStat.setString(10,code_responsable);

        callStat.execute();
        callStat.close();
    }

    public void UpdateEvento(String code, String nombre, String tipo, Date fecha, Time horaInicio,
                             Time horaFin, String ubicacion, int numInvitados,
                             String conceptoDecoracion, String code_responsable)
            throws SQLException,ClassNotFoundException {
        Connection connection = BD_Locator.getConnection();
        String stat = "";
        CallableStatement callStat = connection.prepareCall(stat, ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);

        callStat.setString(1,code);
        callStat.setString(2,nombre);
        callStat.setString(3,tipo);
        callStat.setDate(4,fecha);
        callStat.setTime(5,horaInicio);
        callStat.setTime(6,horaFin);
        callStat.setString(7,ubicacion);
        callStat.setInt(8,numInvitados);
        callStat.setString(9,conceptoDecoracion);
        callStat.setString(10,code_responsable);

        callStat.execute();
        callStat.close();
    }

    public void DeleteEvento(String code) throws SQLException,ClassNotFoundException{
        Connection connection = BD_Locator.getConnection();

        String stat = "";
        CallableStatement callStat = connection.prepareCall(stat,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        callStat.setString(1,code);

        callStat.execute();
        callStat.close();

    }

    public ResultSet SelectEvento()throws SQLException,ClassNotFoundException{
        ResultSet result = null;
        Connection connection=BD_Locator.getConnection();
        String stat = "";
        CallableStatement callStat = connection.prepareCall(stat,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        connection.setAutoCommit(false);
        callStat.registerOutParameter(1,Types.OTHER);

        callStat.execute();
        result = (ResultSet) callStat.getObject(1);

        return result;
    }
}
