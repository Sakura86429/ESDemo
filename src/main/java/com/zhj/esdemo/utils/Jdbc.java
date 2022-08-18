package com.zhj.esdemo.utils;

import com.zhj.esdemo.pojo.Content;

//import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 * Topic
 * Description
 *
 * @author zhouh
 * @version 1.0
 * Create by 2022/8/18 12:44
 */
public class Jdbc {

//    public static DataSource getDataSource(String connectURI){
//        BasicDataSource ds = new BasicDataSource();
//        //MySQL的jdbc驱动
//        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
//        ds.setUsername("root");              //所要连接的数据库名
//        ds.setPassword("000000");                //MySQL的登陆密码
//        ds.setUrl(connectURI);
//        return ds;
//    }
    //通过jdbc连接数据库
    private static Connection getConn() {

//        String driver = "com.mysql.jdbc.Driver";   // 5.x版本的驱动文件jar包对应的是
        String driver = "com.mysql.cj.jdbc.Driver";   // 而我使用的是8.0x版本的数据库驱动文件，对此，需要将加载数据库驱动的语句更改为
        //下面的变量设置根据自己的情况
        String url = "jdbc:mysql://localhost:3306/testmysql?setUnicode=true&characterEncoding=utf8"; //testmysql
        String username = "root";
        String password = "000000";

        Connection conn = null;

        try {
            Class.forName(driver); //classLoader,加载对应驱动
            conn = (Connection) DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return conn;
    }
    //根据自己的数据库地址修改
//    static DataSource ds = Jdbc.getDataSource("jdbc:mysql://127.0.0.1:3306/moviedata");
//    static QueryRunner qr = new QueryRunner(ds);
//
//    //第二类数据库操作方法
//    public static void executeInsert(List<Object> jingdongdata) throws SQLException {
//        /*
//         * 定义一个Object数组，行列
//         * 3表示列数，根据自己的数据定义这里面的数字
//         * params[i][0]等是对数组赋值，这里用到集合的get方法
//         *
//         */
//        Object[][] params = new Object[jingdongdata.size()][3];
//        for ( int i=0; i< params.length; i++ ){
//            params[i][0] = jingdongdata.get(i).getTitle();
//            params[i][1] = jingdongdata.get(i).getPrice();
//            params[i][2] = jingdongdata.get(i).getImg();
//        }
//        qr.batch("insert into my_jd_goods (title, price, img)"
//                + "values (?,?,?)", params);
//        System.out.println("执行数据库完毕！"+"成功插入数据："+jingdongdata.size()+"条");
//
//    }

    static int insert(List<Object> list) {

        Connection conn = getConn();
        int row = 0;

        //往表QQ中添加属性email
        String sql = "insert into my_jd_goods (title, price, img) values(?, ?, ?)";
        PreparedStatement pstmt;

        try {
            //表示预编译的sql对象
            pstmt = (PreparedStatement) conn.prepareStatement(sql);

            for (int j = 0; j < list.size(); j++) {
                pstmt.setObject(j+1, list.get(j));
                row = pstmt.executeUpdate();
                pstmt.close();
                conn.commit();
                conn.close();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return row;    // 返回受影响的行数
    }

    public static void main(String[] args) {
        List<Object> list = new ArrayList<>();
        Content content = new Content();
        content.setTitle("中国");
//        content.get
        content.setPrice("120");
        content.setImg("hajajklsdfjl");
        list.add(content);
        list.add(content);
        Jdbc.insert(list);
    }
}
