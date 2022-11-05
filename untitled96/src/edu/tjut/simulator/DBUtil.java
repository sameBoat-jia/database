package edu.tjut.simulator;

//数据库操作工具类

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

public class DBUtil {
	// 1.定义并声明常用字段
	private static final String JDBC_DRIVER = "org.mariadb.jdbc.Driver";
	private static String url = "jdbc:mysql://localhost:3306/java_exp";
	private static String user = "root";
	private static String pwd = "card1366";
	// 2.定义并声明SQL操作对象
	private static Connection conn = null;
	private static Statement st = null;
	private static ResultSet rs = null;

	// 3.获取连接
	private static Connection getConn() {
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(url, user, pwd);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	// 4.SQL查询
	public static ArrayList<HashMap<String, String>> getDataSet(String sql) {
		HashMap<String, String> hash = null;
		ArrayList<HashMap<String, String>> list = new ArrayList<>();
		ResultSetMetaData rsma = null;
		int columncount = 0;

		try {
			conn = DBUtil.getConn();
			st = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			rs = st.executeQuery(sql);
			rsma = rs.getMetaData();
			while (rs.next()) {
				hash = new HashMap<>();
				columncount = rsma.getColumnCount();
				for (int i = 1; i <= columncount; i++) {
					hash.put(rsma.getColumnName(i), rs.getString(i));
				}
				list.add(hash);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			finallyHandle(conn, st, rs);
		}
		return list;
	}

	// 5.SQL控制
	public static boolean executeBatch(String sql) {
		boolean flag = true;// 返回值默认为true
		try {
			conn = getConn();// 调用getConn()方法，初始化数据库连接
			conn.setAutoCommit(false);
			st = conn.createStatement();
			st.addBatch(sql);
			st.executeBatch();
			conn.commit();// 执行事务
			conn.setAutoCommit(true);

		} catch (Exception ex) {
			try {
				conn.rollback();// 事务回滚
			} catch (SQLException e) {
				e.printStackTrace();
			}
			flag = false;// 执行失败，返回false
			ex.printStackTrace();
		} finally {
			finallyHandle(conn, st, rs);// 关闭数据库连接
		}
		return flag;
	}

	// 6.最终处理（关闭数据库连接）
	private static void finallyHandle(Connection conn, Statement st, ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
				rs = null;
			}
			if (st != null) {
				st.close();
				st = null;
			}
			if (conn != null) {
				conn.close();
				conn = null;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
