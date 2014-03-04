package javabrains.dao;

import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;

public class SimpleJdbcDaoImpl extends SimpleJdbcDaoSupport
{

    public int getCircleCount()
    {
        String sql = "SELECT COUNT(*) FROM CIRCLE";
        return this.getJdbcTemplate().queryForObject( sql, Integer.class );
    }

}
