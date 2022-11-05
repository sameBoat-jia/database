import java.sql.Connection;
import java.sql.DriverManager;

public class JdbcMysql {

	//四个参数
			static String userName="root";//数据库 用户名
			static String passWord="card1366";//数据库 密码
			static String url="jdbc:mysql://localhost:3306/keshe";//keshe 为数据库名
			static String driver="com.mysql.cj.jdbc.Driver";
			//工具方法 获得数据库的连接
			 
			public static Connection getconnection() throws Exception{
				Connection connection = null;
				try {
					//加载驱动
					Class.forName(driver);
					//通过 用户名 密码 url  连接数据库
					connection=DriverManager.getConnection(url, userName, passWord);
				} catch (Exception e) {
					e.printStackTrace();
					throw e;//向上抛出异常
				}
				return connection;
	}
	
}
