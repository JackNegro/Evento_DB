package Interface;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.table.AbstractTableModel;

public class ResultSetTableModel extends AbstractTableModel{
    private ResultSet resultSet;
    private ResultSetMetaData metaData;
    private int rowCount;

    public ResultSetTableModel(ResultSet resultSet) throws SQLException {
        this.setResultSet(resultSet);
    }

    public Class<?> getColumnClass(int column) throws IllegalStateException {
        try {
            String className = this.metaData.getColumnClassName(column + 1);
            return Class.forName(className);
        } catch (Exception var3) {
            Exception exception = var3;
            exception.printStackTrace();
            return Object.class;
        }
    }

    public int getColumnCount() throws IllegalStateException {
        try {
            return this.metaData.getColumnCount();
        } catch (SQLException var2) {
            SQLException sqlException = var2;
            sqlException.printStackTrace();
            return 0;
        }
    }

    public String getColumnName(int column) throws IllegalStateException {
        try {
            return this.metaData.getColumnName(column + 1);
        } catch (SQLException var3) {
            SQLException sqlException = var3;
            sqlException.printStackTrace();
            return "";
        }
    }

    public int getRowCount() throws IllegalStateException {
        return this.rowCount;
    }

    public Object getValueAt(int row, int col) throws IllegalStateException {
        try {
            this.resultSet.absolute(row + 1);
            return this.resultSet.getObject(col + 1);
        } catch (SQLException var4) {
            SQLException sqlException = var4;
            sqlException.printStackTrace();
            return "";
        }
    }

    public void setResultSet(ResultSet resultSet) throws SQLException {
        this.resultSet = resultSet;
        this.metaData = resultSet.getMetaData();
        resultSet.last();
        this.rowCount = resultSet.getRow();
        this.fireTableStructureChanged();
    }
}
