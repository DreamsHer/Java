package com.qx.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class DbUtil {
	private static String driver = "";
	private static String url = "";
	private static String username = "";
	private static String password = "";
	
	static {
		Properties properties = new Properties();
		try {
			InputStream in = DbUtil.class.getClassLoader().getResourceAsStream(
					"jdbc.properties");
			properties.load(in);
			driver = properties.getProperty("driver");
			url = properties.getProperty("url");
			username = properties.getProperty("username");
			password = properties.getProperty("password");

			Class.forName(driver);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 连接数据
	 * 
	 * @return
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException {
		// 获取连接数据
		return DriverManager.getConnection(url, username, password);
	}

	/**
	 * 关闭资源
	 * 
	 * @param conn
	 * @param ps
	 * @param rs
	 */
	public static void close(Connection conn, PreparedStatement ps, ResultSet rs) {
		try {
			if (conn != null) {
				conn.close();
			}
			if (ps != null) {
				ps.close();
			}
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
