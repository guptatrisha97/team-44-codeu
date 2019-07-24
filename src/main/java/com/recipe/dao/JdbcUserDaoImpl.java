package com.recipe.dao;

import com.recipe.domain.User;
import com.recipe.util.JdbcUtils;

import java.sql.*;

public class JdbcUserDaoImpl implements UserDao {

    @Override
    public User findByUsername(String username) {
        Connection connection=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        User user=new User();
        try {
            connection = JdbcUtils.getConnection();
            String sql="SELECT * FROM t_user WHERE username=?";
            ps=connection.prepareStatement(sql);
            ps.setString(1,username);
            rs=ps.executeQuery();
            if (rs==null) return null;
            if (rs.next())
            {
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                return user;
            }else
            {
                return null;
            }

        }catch (Exception e)
        {
            throw new RuntimeException(e);
        }finally {
            try
            {
                if (rs!=null) rs.close();
                if (ps!=null) ps.close();
                if (connection!=null) connection.close();
            }catch (Exception e)
            {
                throw new RuntimeException(e);
            }
        }

    }

    @Override
    public void add(User user) {
        Connection connection=null;
        PreparedStatement ps=null;
        try {
            connection = JdbcUtils.getConnection();
            String sql="insert into t_user values(?,?,?,?)";
            ps=connection.prepareStatement(sql);
            ps.setString(1,user.getUsername());
            ps.setString(2,user.getPassword());
            ps.executeUpdate();
        }catch (Exception e)
        {
            throw new RuntimeException(e);
        }finally {
            try
            {
                if (ps!=null) ps.close();
                if (connection!=null) connection.close();
            }catch (Exception e)
            {
                throw new RuntimeException(e);
            }
        }

    }
}
