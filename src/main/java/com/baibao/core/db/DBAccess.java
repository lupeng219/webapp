package com.baibao.core.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.baibao.core.cache.LoadSystemConfigServlet;
import com.esotericsoftware.minlog.Log;

/**
 * <b>功能描述：</b><br>
 * 数据库访问公用方法类<br>
 */
public class DBAccess {
	private static Logger log = LoggerFactory.getLogger(DBAccess.class); 
	/**
	 * 禁用构造函数
	 */
	private DBAccess() {
		// 禁用构造函数
	}
	
	/**
	 * 根据数据源名称，从根Context中取得数据源
	 * 
	 * @param name
	 *            数据源名称
	 */
	private static DataSource getDataSource(){
		try {
            Context context = new InitialContext();
            DataSource ds = (DataSource) context.lookup("java:comp/env/jdbc/yp2p");
            if (ds == null) {
                 throw new Exception(" 'java:comp/env/jdbc/yp2p' can not be found at Context.!");
            }
            return ds;
        } catch (NamingException ne) {
          Log.error("getDataSource", ne);
        } catch (Exception e) {
        	Log.error("getDataSource", e);
        }
		return null;
	}

	/**
	 * 从数据库连接池中取得一个数据库链接
	 * 
	 * @return 可以使用的数据库链接
	 */
	public static Connection getConnection() {
		DataSource dataSource = getDataSource();
		Connection connection = null;
		try {
			connection = dataSource.getConnection();
		} catch (Exception ex) {
			Log.error("getConnection", ex);
		}
		return connection;
	}

	/**
	 * 释放一个数据库链接
	 * 
	 * @param connection
	 *            要释放的链接
	 * @throws TranFailException
	 */
	public static void releaseConnection(Connection connection){
		if (connection == null) {
			return;
		}
		try
        {
            connection.close();
        }
        catch(SQLException e)
        {
           // throw new JDBCException("Failed to release connection: ", e);
        	log.error("Failed to release connection: ", e);
        }finally
		{
        	try {
				connection.close();
			} catch (SQLException e) {
				
				log.error("Failed to release connection: ", e);
			}
		}
	}

	
	

	/**
	 * jdbc资源清理
	 * 
	 * @param statement
	 */
	public static void cleanResources(PreparedStatement statement) {
		if (statement != null) {
			try {
				statement.close();
			} catch (SQLException ex) {
				//Trace.logDebug(Trace.COMPONENT_JDBC,"Exception occurred when close Statement", ex);
				log.error("cleanResources", ex);
			}
		}
	}

	/**
	 * jdbc资源清理
	 * 
	 * @param statement
	 * @param resultSet
	 */
	public static void cleanResources(Statement statement, ResultSet resultSet) {
		if (resultSet != null) {
			try {
				resultSet.close();
			} catch (SQLException ex) {
				//Trace.logDebug(Trace.COMPONENT_JDBC,"Exception occurred when close ResultSet", ex);
				log.error("cleanResources", ex);
			}
		}
		if (statement != null) {
			try {
				statement.close();
			} catch (SQLException ex) {
				//Trace.logDebug(Trace.COMPONENT_JDBC,"Exception occurred when close Statement", ex);
				log.error("cleanResources", ex);
			}
		}
	}

	/**
	 * 记录日志
	 * 
	 * @param ex
	 */
	public static void log(Exception ex) {
		//Trace.logError(Trace.COMPONENT_JDBC, "数据库操作异常", ex);
	}
}
