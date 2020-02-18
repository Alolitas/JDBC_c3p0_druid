import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @ClassName: C3P0_Demo2
 * @Description: TODO
 * @author: Doge_fang
 * @date: 2020/2/16  15:39
 *
 * c3p0演示
 */
public class C3P0_Demo2 {


    public static void main(String[] args) throws SQLException {
        //获取连接池对象，使用指定名称配置
        ComboPooledDataSource cbp = new ComboPooledDataSource("otherc3p0");
        //获取连接
        for(int i =1;i<9;i++){
            Connection conn = cbp.getConnection();
            System.out.println(i + ":" + conn);
        }
    }
}
