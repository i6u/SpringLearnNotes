package zyr.learn.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import zyr.learn.model.Group;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by zhouweitao on 2016/11/9.
 */
@Repository("groupDao")
public class GroupDao implements IGroupDao {
    private JdbcTemplate jdbcTemplate;

    @Resource(name = "dataSource") //注入dataSource数据源
    public void setDateSource(DataSource dataSource) {
        //通过数据源得到JdbcTemplate对象，JdbcTemplate对象就可以实现对数据的CRUD
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void add(final Group group) {

        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
                    public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                        String sql = "insert into t_group (name) values(?)";
                        PreparedStatement ps = connection.prepareStatement(sql,new String[]{"id"});
                        ps.setString(1, group.getName());
                        return ps;
                    }
                }, keyHolder);
        group.setId(keyHolder.getKey().intValue());
    }

    public void executeSql(String sql) {
        jdbcTemplate.execute(sql);
    }
}
