package BD_Tables;

import BD_Connect.BD_Locator;
import Logica.User;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserBD {
    public void createUser(int dni, String userName, String password) throws SQLException, ClassNotFoundException {
        Connection connection = BD_Locator.getConnection();
        String stat = "";
        CallableStatement callStat = connection.prepareCall(stat, 1004, 1007);
        callStat.setInt(1, dni);
        callStat.setString(2, userName);
        callStat.setString(6, password);

        callStat.execute();
        connection.close();
    }

    public void updateUser(int code, String userName,String password) throws SQLException, ClassNotFoundException {
        Connection connection = BD_Locator.getConnection();
        String stat = "";
        CallableStatement callStat = connection.prepareCall(stat, 1004, 1007);

        callStat.setInt(1, code);
        callStat.setString(2, userName);
        callStat.setString(3, password);

        callStat.execute();
        connection.close();
    }

    public User getUserByCode(int code) throws SQLException, ClassNotFoundException, Exception {
        User user = null;
        ResultSet results = null;
        Connection connection = BD_Locator.getConnection();
        String stat = "";
        CallableStatement callStat = connection.prepareCall(stat, 1004, 1007);
        connection.setAutoCommit(false);
        callStat.setInt(1,code);
        callStat.registerOutParameter(2, 1111);
        callStat.execute();
        results = (ResultSet)callStat.getObject(2);
        if (results.next()) {
            user = new User (results.getInt(1), results.getString(2),results.getString(3),results.getInt(4) );
        }

        connection.close();
        return user;
    }

    public void deleteUser(int code) throws SQLException, ClassNotFoundException {
        Connection connection = BD_Locator.getConnection();
        String stat = "";
        CallableStatement callStat = connection.prepareCall(stat, 1004, 1007);
        callStat.setInt(1, code);
        callStat.execute();
        connection.close();
    }

    public ResultSet userAll() throws SQLException, ClassNotFoundException {
        ResultSet results = null;
        Connection connection = BD_Locator.getConnection();
        String stat = "";
        CallableStatement callStat = connection.prepareCall(stat, 1004, 1007);
        connection.setAutoCommit(false);
        callStat.registerOutParameter(1, 1111);
        callStat.execute();
        results = (ResultSet)callStat.getObject(1);
        connection.close();
        return results;
    }

}
