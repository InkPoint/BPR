package com.ruoyi.common.utils.sql;

import java.sql.*;

/**
 * 连接 SQL Server
 *
 * @author ChungWe
 */
public class DBUtil {

    private final static String URL = "jdbc:sqlserver://10.68.90.2:1433;DatabaseName=TLZG_VAM";
    private static final String USER = "sa";
    private static final String PASSWORD = "admin@123";

    private static Connection conn = null;

    static {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() { return conn; }

}
