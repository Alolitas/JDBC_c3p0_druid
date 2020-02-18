import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @ClassName: Druid_Demo2
 * @Description: TODO
 * @author: Doge_fang
 * @date: 2020/2/17  14:48
 *
 * 使用druid工具类演示
 */
public class Druid_Demo2   {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pre = null;
        try {
            //获取连接
            conn = DruidUtils.getconnection();
            //定义sql
            String sql = "insert into userinfo values(?,?,?,null)";
            //获取执行sql对象
            pre = conn.prepareStatement(sql);
            //赋值
            pre.setInt(1,202006);
            pre.setString(2,"酷狗音乐");
            pre.setInt(3,152434567);
            //执行sql
            int count = pre.executeUpdate();
            System.out.println(count);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DruidUtils.close2(conn,pre);
        }
    }
}
