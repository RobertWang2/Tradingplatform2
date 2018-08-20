package dao;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @program: tradingplatform
 * @description: 用户的映射
 * @author: Robert_Wang
 * @create: 2018-08-17 08:46
 **/
public class UserMapper implements RowMapper<User> {

    /**
     * Implementations must implement this method to map each row of data
     * in the ResultSet. This method should not call {@code next()} on
     * the ResultSet; it is only supposed to map values of the current row.
     *
     * @param rs     the ResultSet to map (pre-initialized for the current row)
     * @param rowNum the number of the current row
     * @return the result object for the current row
     * @throws SQLException if a SQLException is encountered getting
     *                      column values (that is, there's no need to catch SQLException)
     */
    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {

        User user = new User();
        user.setId(rs.getInt("id"));
        user.setUsername(rs.getString("username"));
        user.setPassword(rs.getString("password"));
        user.setEmail(rs.getString("email"));
        user.setBalance(rs.getDouble("balance"));
        user.setCredit(rs.getInt("credit"));
        user.setBirthday(rs.getString("birthday"));
        user.setRemark(rs.getString("remark"));
        user.setAge(rs.getInt("age"));
        return user;
    }
}
