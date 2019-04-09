package dao;

import entity.Items;
import util.DBHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

//商品业务逻辑类
public class ItemsDao {

    //获得所有商品信息
    public ArrayList<Items> getAllItems() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Items> list = new ArrayList<Items>();//商品集合
        try {
            conn = DBHelper.getConnection();
            String sql = "SELECT * FROM items";//sql语句
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Items items = new Items();
                items.setId(rs.getInt("id"));
                items.setName(rs.getString("name"));
                items.setCity(rs.getString("city"));
                items.setNumber(rs.getInt("number"));
                items.setPrice(rs.getInt("price"));
                items.setPicture(rs.getString("picture"));
                list.add(items);//把商品加入集合
            }
            return list;//返回集合


        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        } finally {
            //释放数据集对象
            if (rs != null) {
                try {
                    rs.close();
                    rs = null;
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
            //释放语句对象
            if (stmt != null) {
                try {
                    stmt.close();
                    stmt = null;
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }


        }
    }

    //根据商品编号获得商品资料
    public Items getItemsById(int id) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = DBHelper.getConnection();
            String sql = "SELECT * FROM items WHERE id=?;";//sql语句
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            if (rs.next()) {
                Items items = new Items();
                items.setId(rs.getInt("id"));
                items.setName(rs.getString("name"));
                items.setCity(rs.getString("city"));
                items.setNumber(rs.getInt("number"));
                items.setPrice(rs.getInt("price"));
                items.setPicture(rs.getString("picture"));
                return items;
            }
            else
                return null;


        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        } finally {
            //释放数据集对象
            if (rs != null) {
                try {
                    rs.close();
                    rs = null;
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
            //释放语句对象
            if (stmt != null) {
                try {
                    stmt.close();
                    stmt = null;
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }


        }

    }
    //获取最近浏览的前五条商品信息
    public ArrayList<Items> getViewList(String list) {
        ArrayList<Items> itemlist = new ArrayList<Items>();
        int iCount = 5;
        if (list != null && list.length() > 0) {
            String[] arr = list.split("#");

            if (arr.length >= 5) {
                for (int i = arr.length - 1; i >= arr.length - iCount; i--) {
                    itemlist.add(getItemsById(Integer.parseInt(arr[i])));
                }
            } else {
                for (int i = arr.length - 1; i >= 0; i--) {
                    itemlist.add(getItemsById(Integer.parseInt(arr[i])));
                }
            }
            return itemlist;
        }

            else
                return null;

        }


}
