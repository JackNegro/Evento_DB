package BD_Tables;
import BD_Connect.BD_Locator;

import java.sql.*;

public class EmpresaBD {
    public void CreateEmpresa(String code, String direccion,
                              String nombre, String telefono,
                              String directorG, String gerenteR, String secretarioS)throws SQLException,ClassNotFoundException{

        Connection connection = BD_Locator.getConnection();

        String stat = "{call public.empresa_insert (?, ?, ?, ?, ?, ?, ?) }";
        CallableStatement callStat = connection.prepareCall(stat,ResultSet.TYPE_SCROLL_INSENSITIVE,
                                                                 ResultSet.CONCUR_READ_ONLY);

        callStat.setString(1,code);
        callStat.setString(2,direccion);
        callStat.setString(3,nombre);
        callStat.setString(4,telefono);
        callStat.setString(5,directorG);
        callStat.setString(6,gerenteR);
        callStat.setString(7,secretarioS);

        callStat.execute();
        callStat.close();
    }

    public void UpdateEmpresa(String code, String direccion,
                              String nombre, String telefono,
                              String directorG, String gerenteR, String secretarioS)throws SQLException,ClassNotFoundException{
        Connection connection = BD_Locator.getConnection();

        String stat = "{call public.empresa_update (?, ?, ?, ?, ?, ?, ?) }";
        CallableStatement callStat = connection.prepareCall(stat,ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY);

        callStat.setString(1,code);
        callStat.setString(2,direccion);
        callStat.setString(3,nombre);
        callStat.setString(4,telefono);
        callStat.setString(5,directorG);
        callStat.setString(6,gerenteR);
        callStat.setString(7,secretarioS);

        callStat.execute();
        callStat.close();
    }

    public void DeleteEmpresa(String code)throws SQLException,ClassNotFoundException{
        Connection connection = BD_Locator.getConnection();
        String stat = "";
        CallableStatement callStat = connection.prepareCall(stat,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        callStat.setString(1,code);

        callStat.execute();
        callStat.close();
    }

    public ResultSet SelectEmpresa()throws SQLException,ClassNotFoundException{
        ResultSet result = null;

        Connection connection = BD_Locator.getConnection();
        String stat = "{ call public.select_all_empresas() }";
        CallableStatement callStat = connection.prepareCall(stat,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);

        connection.setAutoCommit(false);
        callStat.registerOutParameter(1,Types.OTHER);

        callStat.execute();

        result = (ResultSet) callStat.getObject(1);
        connection.close();

        return result;

    }

}
