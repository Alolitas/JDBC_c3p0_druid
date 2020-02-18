import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.util.Properties;

/**
 * @ClassName: Druid_Demo1
 * @Description: TODO
 * @author: Doge_fang
 * @date: 2020/2/16  16:28
 *
 * Druid演示
 */
public class Druid_Demo1 {

    public static void main(String[] args) throws Exception {
        //加载配置文件
        Properties pro = new Properties();
        InputStream is = Druid_Demo1.class.getClassLoader().getResourceAsStream("druid.properties");
        pro.load(is);
        //获取连接池对象
        DataSource ds = DruidDataSourceFactory.createDataSource(pro);
        //获取连接
        //Connection conn = ds.getConnection();
        for(int i = 1;i<11;i++){
            Connection conn = ds.getConnection();
            System.out.println(i + ":" + conn);
        }

    }
}
