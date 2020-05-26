/*
* DBContext.java
*
* All Right Reserved
* Copyright (c) 2019 FPT University
 */
package context;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * DBContext.<br>
 *
 * <pre>
 * Class mở kết nối đến SQLServer
 * Trong class này sẽ tiến hành các xử lí dưới đây
 *
 * 1 hàm getConnection() trả về Connection để lấy kết nối đến server
 *
 * </pre>
 *
 * @author FU Kiennthe130540
 * @version 1.0
 */
public class DBContext {

    /*
    * Store connection.
    */
    private Connection connection;

    /**
     * getConnection <br>
     * 
     * Mở kết nối tới SQLServer
     * 
     * @return connection
     */
    public Connection getConnection() {
        try {
            // Edit URL , username, password to authenticate with your MS SQL Server
            String url = "jdbc:sqlserver://localhost:1433;databaseName=Digital";
            String username = "sa";
            String password = "123456789";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            return connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
