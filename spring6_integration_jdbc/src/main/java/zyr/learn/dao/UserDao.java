package zyr.learn.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import zyr.learn.model.Group;
import zyr.learn.model.User;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by zhouweitao on 2016/11/6.
 */
@Repository("userDao")
public class UserDao implements IUserDao {
    private JdbcTemplate jdbcTemplate;

    @Resource(name = "dataSource") //注入dataSource数据源
    public void setDateSource(DataSource dataSource) {
        //通过数据源得到JdbcTemplate对象，JdbcTemplate对象就可以实现对数据的CRUD
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void add(User user) {
        jdbcTemplate.update("insert into t_user(username,password) values(?,?)", user.getUsername(), user.getPassword());
    }

    public void update(User user) {
        jdbcTemplate.update("update t_user set username=?,password=? where id = ?", user.getUsername(), user.getPassword(), user.getId());
    }

    public void delete(int id) {
        jdbcTemplate.update("delete from t_user where id = ?", id);
    }

    public User load(int id) {
        String sql = "select * from t_user u join t_group g on u.gid = g.id where u.id = ? ";
        User user = (User) jdbcTemplate.queryForObject(sql, new Object[]{id}, new UserMapper());
        return user;
    }

    public List<User> list(String sql) {
        return jdbcTemplate.query(sql, new UserMapper());
    }

    private class UserMapper implements RowMapper<User> {

        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            User user = new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            Group group = new Group();
            //group.setId(rs.getInt(4));
            group.setName(rs.getString("name"));
            user.setGroup(group);
            return user;
        }
    }
}
