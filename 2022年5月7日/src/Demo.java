import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

public class Demo {
    public static void main(String[] args) throws Exception {
        //获取当前项目路径
        //System.out.println(System.getProperty("user.dir"));

        //使用德鲁伊数据库连接池
        //导入jar包
        //修改配置文件 druid.properties
        //加载配置文件
        Properties ps = new Properties();
        ps.load(new FileReader("2022年5月7日/src/druid.properties"));
        DataSource dataSource = DruidDataSourceFactory.createDataSource(ps);
        //获取连接对象
        Connection conn = dataSource.getConnection();
        //获取PreparedStatement
        PreparedStatement pps = conn.prepareStatement("select * from user where id = ? and name = ?");
        pps.setString(1,"1");
        pps.setString(2,"1");
        ResultSet rs = pps.executeQuery();
        if (rs.next()) System.out.println("查询成功");
        else System.out.println("查询失败");
    }
}
