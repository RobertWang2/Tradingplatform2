package dao;

import javax.servlet.http.HttpServletRequest;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @program: tradingplatform
 * @description: 用户DAO
 * @author: Robert_Wang
 * @create: 2018-08-17 08:39
 **/
public interface UserDAO {

    public void addUser(User user);

    public  void deleteUserById(Integer id);
    public  void deleteUserByUsername(Integer id, String username);

    public User queryById(Integer id);
    public User queryByUsername(String username);

    public void updatePasswordById(Integer id, String password);
    public void updatePasswordByUsername(String username, String password);

    public void updateRemarkById(Integer id, String remark);
    public void updateRemarkByUsername(String remark, String username);

    public void outmoney(String username, Double money);

    public void inmoney(String username, Double money);

    public ResultSet usernameIsEmpty(HttpServletRequest request) throws SQLException;
}
