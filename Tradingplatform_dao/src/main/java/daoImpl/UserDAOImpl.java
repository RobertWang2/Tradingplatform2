package daoImpl;


import dao.User;
import dao.UserDAO;
import dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;

/**
 * @program: tradingplatform
 * @description: 用户DAO的实现
 * @author: Robert_Wang
 * @create: 2018-08-17 08:45
 **/
@Repository
public class UserDAOImpl extends JdbcDaoSupport implements UserDAO {

    @Autowired
    private DataSource dataSource;

    @Override
    public void addUser(User user) {
            String sql = "insert into user (username, password, email, balance, credit, remark, birthday, age) values(?,?,?,?,?,?,?,?)";
            this.getJdbcTemplate().update(sql,user.getUsername(),user.getPassword(),user.getEmail(),user.getBalance(),user.getCredit(), user.getRemark(),user.getBirthday(),user.getAge());
            System.out.println("Add user successfully!");
    }

    @Override
    public void deleteUserById(Integer id) {
        String sql = "delete from user where id = ?";
        this.getJdbcTemplate().update(sql,id);
        System.out.println("A user was deleted successfully! id:" + id);
    }

    @Override
    public void deleteUserByUsername(Integer id, String username) {
        String sql = "delete from user where username = ?";
        this.getJdbcTemplate().update(sql,username);
        System.out.println("A user was deleted successfully! username: "  + username);
    }

    @Override
    public User queryById(Integer id) {
        String sql = "select * from user where id = ?";
        User user = this.getJdbcTemplate().queryForObject(sql, new Object[]{id}, new UserMapper());
        return user;
    }

    @Override
    public User queryByUsername(String username) {
        String sql = "select * from user where username = ?";
        User user = this.getJdbcTemplate().queryForObject(sql, new Object[]{username}, new UserMapper());

        return user;
    }

    @Override
    public void updatePasswordById(Integer id, String password) {
        String sql = "update user set password = ? where id = ?";
        this.getJdbcTemplate().update(sql,password,id);
        System.out.println("Password update successfully!");
    }

    @Override
    public void updatePasswordByUsername(String username, String password) {
        String sql = "update user set password = ? where usernmae = ?";
        this.getJdbcTemplate().update(sql,password,username);
        System.out.println("Password update successfully!");
    }

    @Override
    public void updateRemarkById(Integer id, String remark) {
        String sql = "update user set remark = ? where id = ?";
        this.getJdbcTemplate().update(sql,remark,id);
        System.out.println("Password update successfully!");
    }

    @Override
    public void updateRemarkByUsername(String remark, String username) {
        String sql = "update user set remark = ? where username = ?";
        this.getJdbcTemplate().update(sql,remark,username);
        System.out.println("Password update successfully!");
    }

    @Override
    public void outmoney(String username, Double money) {
        String sql = "update user set balance = balance - ? where username = ?";
        this.getJdbcTemplate().update(sql,money,username);
    }

    @Override
    public void inmoney(String username, Double money) {
        String sql = "update user set balance = balance + ? where username = ?";
        this.getJdbcTemplate().update(sql,money,username);
    }
    /**
     * @Description: 判断密用户名是否存在， 如果用户名不存在返回错误空，否则返回正确集合
     * @Param: [request]
     * @return: java.lang.String
     * @Author: Robert_Wang
     * @Date: 2018/8/18
     */
    @Override
    public ResultSet usernameIsEmpty(HttpServletRequest request) throws SQLException {

        String username = request.getParameter("username");
        String sql = "select * from user where username = "+ "\'"+username+"\'";
        Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(sql);
        if(!rs.next())  return null;
        else return rs;
    }
}
