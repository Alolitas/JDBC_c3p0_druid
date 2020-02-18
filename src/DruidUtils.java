import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * @ClassName: DruidUtils
 * @Description: TODO
 * @author: Doge_fang
 * @date: 2020/2/17  12:52
 *
 * druid工具类
 */
public class DruidUtils {
    private static DataSource dataSource = null;

    static{
        try {
            //加载配置文件
            Properties pro = new Properties();
            InputStream is = DruidUtils.class.getClassLoader().getResourceAsStream("druid.properties");
            pro.load(is);
            //获取连接池对象
            dataSource = DruidDataSourceFactory.createDataSource(pro);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取连接
     * @return
     * @throws SQLException
     */
    public static Connection getconnection() throws SQLException {
        return dataSource.getConnection();
    }

    /**
     * 释放资源
     * @param rs
     * @param conn
     * @param stm
     */
    public static void close(ResultSet rs, Connection conn,Statement stm){
        if(rs != null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(stm != null){
            try {
                stm.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(conn != null){
            try {
                conn.close();//归还连接
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void close2(Connection conn,Statement stm){
        if(conn != null) {
            try {
                conn.close();//归还连接
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(stm != null){
            try {
                stm.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
