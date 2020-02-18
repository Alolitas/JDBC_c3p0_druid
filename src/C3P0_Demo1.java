import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @ClassName: C3P0_Demo1
 * @Description: TODO
 * @author: Doge_fang
 * @date: 2020/2/16  14:59
 *
 * c3p0演示
 */
public class C3P0_Demo1 {
    public static void main(String[] args) throws SQLException {
        //创建数据库连接池对象
        ComboPooledDataSource cpd = new ComboPooledDataSource();
        //获取连接对象
        //Connection conn = cpd.getConnection();
        for(int i = 1 ; i < 11 ; i++){
            Connection conn = cpd.getConnection();
            System.out.println(i+":"+conn);
        }

        //打印
        //System.out.println(conn);
    }
}
