package com.Chrisxin;

import com.Chrisxin.entity.User;
import org.junit.jupiter.api.Test;

import java.sql.*;

public class jdbcTest {

    /*
     * jabc入门程序
     */
    @Test
    public void testUpdate() throws Exception {
        //1.注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        //2.获取数据库连接
        String url = "jdbc:mysql://localhost:3306/web01";
        String username = "root";
        String password = "123456";
        Connection connection = DriverManager.getConnection(url, username, password);
        //3.获取SQL语句执行对象
        Statement statement = connection.createStatement();
        //4.执行SQL
        int i = statement.executeUpdate("update user set age=25 where id=1");
        System.out.println("执行语句影响行数为:" + i);
        //5.释放资源
        statement.close();
        connection.close();
    }

    @Test
    public void testQuery() {

        String url = "jdbc:mysql://localhost:3306/web01";
        String username = "root";
        String password = "123456";
        Connection con = null;
        PreparedStatement pstmt=null;
        ResultSet rs=null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection(url, username, password);
            pstmt=con.prepareStatement("select id,username,password,name,age from user where username=? and password=?");
            pstmt.setString(1,"daqiao");
            pstmt.setString(2,"123456");
            rs=pstmt.executeQuery();
            while(rs.next()){
                User user=new User(
                        rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("name"),
                        rs.getInt("age")
                );
                System.out.println(user);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            try{
                if(rs!=null)rs.close();
                if(pstmt!=null)pstmt.close();
                if(con!=null)con.close();
            }catch (Exception e){
                e.printStackTrace();
            }

        }
    }
}
