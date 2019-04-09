package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBHelper {
    private static String driver="com.mysql.jdbc.Driver";//数据库驱动
    private static String url="jdbc:mysql://localhost:3306/information_system?useUnicode=true&characterEncoding=UTF-8";
    private static String username="root";
    private static String password="0258";

    private static Connection Conn=null;

    //静态代码块加载驱动
    static
    {
        try {
            Class.forName(driver);
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

    //单例模式返回数据库连接对象
    public static Connection getConnection() throws Exception
    {
        if(Conn==null)
        {
            Conn= DriverManager.getConnection(url,username,password);
            return Conn;
        }
        return Conn;
    }

    public static void main(String args[]){

        try {
            Connection conn=DBHelper.getConnection();
            if(conn!=null){
                System.out.println("数据库连接正常！");
            }
            else
            {
                System.out.println("数据库连接异常！");
            }

        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }


}



