package dao;


import entity.User;
import util.DBHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class UserDao {



    public boolean userRegin(User user)
    {

        try {
            Connection con=DBHelper.getConnection();

            PreparedStatement psql;
            ResultSet res;
            psql = con.prepareStatement("insert into user (username,password,city) "
                    + "values(?,?,?)");
            psql.setString(1, user.getUsername());              //设置参数1，创建id为3212的数据
            psql.setString(2, user.getPassword());      //设置参数2，name 为王刚
            psql.setString(3, user.getCity());

            psql.executeUpdate();           //执行更新
            return true;
        }catch (Exception ex)
        {
            ex.printStackTrace();
            return false;
        }
    }
    public boolean IsUser(User user)
    {
        try {
            Connection con=DBHelper.getConnection();
            String username=user.getUsername();
            String password=user.getPassword();

            String sql="SELECT username,password FROM user WHERE username=? AND password=?";
            try {
                PreparedStatement pre;
                pre=con.prepareStatement(sql);
                pre.setString(1, username);
                pre.setString(2, password);
                ResultSet rs=pre.executeQuery();
                while(rs.next()){
                    return true;
                }
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
            return false;
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return false;
    }

    public static void main(String[] args) {
        User user=new User();
        user.setUsername("admin");
        user.setPassword("6666");
        user.setCity("武汉");

        UserDao userDao=new UserDao();

        if(userDao.userRegin(user))
        {
            System.out.println("注册成功！");
        }
        else
        {
            System.out.println("注册失败！");
        }
    }
}
