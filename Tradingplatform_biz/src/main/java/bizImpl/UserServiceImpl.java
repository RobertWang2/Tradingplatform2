package bizImpl;


import biz.UserService;
import dao.User;
import dao.UserDAO;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * @program: tradingplatform
 * @description: 用户业务的实现
 * @author: Robert_Wang
 * @create: 2018-08-17 09:12
 **/
@Transactional
public class UserServiceImpl implements UserService {


    private UserDAO userDAO;

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public void addUser(User user) {
        userDAO.addUser(user);
    }

    @Override
    public void deleteUserById(Integer id) {
        userDAO.deleteUserById(id);
    }

    @Override
    public void deleteUserByUsername(Integer id, String username) {
        userDAO.deleteUserByUsername(id,username);
    }

    @Override
    public User queryById(Integer id) {
        return userDAO.queryById(id);
    }

    @Override
    public User queryByUsername(String username) {
        return userDAO.queryByUsername(username);
    }

    @Override
    public void updatePasswordById(Integer id, String password) {
        userDAO.updatePasswordById(id,password);
    }

    @Override
    public void updatePasswordByUsername(String username, String password) {
        userDAO.updatePasswordByUsername(username,password);
    }

    @Override
    public void updateRemarkById(Integer id, String remark) {
        userDAO.updateRemarkById(id,remark);
    }

    @Override
    public void updateRemarkByUsername(String remark, String username) {
        userDAO.updateRemarkByUsername(remark,username);
    }

    @Override
    public ResultSet usernameIsEmpty(HttpServletRequest request) throws SQLException {
        return userDAO.usernameIsEmpty(request);
    }


    /**
     * @Description:
     * @Param: [org, des, money]转出方、接收方、转账金额
     * @return: void
     * @Author: Robert_Wang
     * @Date: 2018/8/17
     */
    @Override
    public void transfer(String org, String des, Double money) {

        userDAO.outmoney(org,money);
        userDAO.inmoney(des,money);
        System.out.println("Transfer successfully!");
    }
}
