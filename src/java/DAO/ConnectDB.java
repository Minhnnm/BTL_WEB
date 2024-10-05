
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author holme
 */
public class ConnectDB {

    Connection connection;

    public ConnectDB() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1443;databasename=sanpham1;"
                    + "username=sa;password=1234" + ";characterEncoding=UTF-8");
            System.out.println("ket noi thanh cong");
        } catch (SQLException e) {
            System.out.println(e);
            System.out.println("lỗi sql");
        } catch (ClassNotFoundException e) {

            System.out.println("lỗi class");
        }
    }
    public static void main(String[] args) {
        ConnectDB connectDB=new ConnectDB();
    }
}
