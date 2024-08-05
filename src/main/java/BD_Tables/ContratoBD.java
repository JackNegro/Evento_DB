package BD_Tables;

import BD_Connect.BD_Locator;

import java.sql.*;
import java.util.Date;

public class ContratoBD {
    public void CreateContrato(String  codeEvento, String codeServicio, float precioNegociado,
                               Date cronogramaPago, String condiciones)
                               throws SQLException,ClassNotFoundException {

        Connection connection = BD_Locator.getConnection();
        String stat="";
        CallableStatement callStat = connection.prepareCall(stat, ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);

        callStat.setString(1,codeEvento);
        callStat.setString(2,codeServicio);
        callStat.setFloat(3,precioNegociado);
        callStat.setDate(4, (java.sql.Date) cronogramaPago);
        callStat.setString(5,condiciones);

        callStat.execute();
        callStat.close();
    }

    public void UpdateContrato(String  codeEvento, String codeServicio, float precioNegociado,
                               Date cronogramaPago, String condiciones)
            throws SQLException,ClassNotFoundException {

        Connection connection = BD_Locator.getConnection();
        String stat="";
        CallableStatement callStat = connection.prepareCall(stat, ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);

        callStat.setString(1,codeEvento);
        callStat.setString(2,codeServicio);
        callStat.setFloat(3,precioNegociado);
        callStat.setDate(4, (java.sql.Date) cronogramaPago);
        callStat.setString(5,condiciones);

        callStat.execute();
        callStat.close();
    }

    public void DeleteEmpresa(String code)throws SQLException,ClassNotFoundException{
        Connection connection=BD_Locator.getConnection();
        String stat = "";
        CallableStatement callStat = connection.prepareCall(stat,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        callStat.setString(1,code);

        callStat.execute();
        callStat.close();
    }

    public ResultSet SelectContrato() throws SQLException,ClassNotFoundException{
        ResultSet result = null;

        Connection connection= BD_Locator.getConnection();
        String stat="";

        CallableStatement callStat = connection.prepareCall(stat,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        connection.setAutoCommit(false);

        callStat.registerOutParameter(1, Types.OTHER);

        callStat.execute();
        result = (ResultSet) callStat.getObject(1);
        connection.close();

        return  result;
    }
}
