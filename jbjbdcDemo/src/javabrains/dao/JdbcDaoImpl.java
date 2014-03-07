package javabrains.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javabrains.model.Circle;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class JdbcDaoImpl
{

    private DataSource                 dataSource;

    private JdbcTemplate               jdbcTemplate;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private SimpleJdbcTemplate         simpleJdbcTemplate;

    /*
        //  Using jdbcTemplate eliminates the need for code like this
        //    public Circle getCircle(int circleId)
        //    {
        //        Connection conn = null;
        //
        //        try
        //        {
        //            conn = dataSource.getConnection();
        //
        //            PreparedStatement ps = conn.prepareStatement( "SELECT * FROM circle where id = ?" );
        //            ps.setInt( 1, circleId );
        //
        //            Circle circle = null;
        //            ResultSet rs = ps.executeQuery();
        //
        //            if ( rs.next() )
        //            {
        //                circle = new Circle( circleId, rs.getString( "name" ) );
        //            }
        //            rs.close();
        //            ps.close();
        //
        //            return circle;
        //        }
        //        catch ( Exception e )
        //        {
        //            throw new RuntimeException( e );
        //        }
        //        finally
        //        {
        //            try
        //            {
        //                conn.close();
        //            }
        //            catch ( SQLException e )
        //            {
        //                e.printStackTrace();
        //            }
        //        }
        //    }
    */

    public int getCircleCount()
    {
        String sql = "SELECT COUNT(*) FROM CIRCLE";
        return jdbcTemplate.queryForObject( sql, Integer.class );
    }


    public String getCircleName(int circleId)
    {
        String sql = "SELECT NAME FROM circle where id = ?";
        return jdbcTemplate.queryForObject( sql, new Object[]
        { circleId }, String.class );
    }


    public Circle getCircleforId(int circleId)
    {
        String sql = "SELECT * FROM circle where id = ?";
        return jdbcTemplate.queryForObject( sql, new Object[]
        { circleId }, new CircleMapper() );
    }


    public List<Circle> getAllCircles()
    {
        String sql = "SELECT * FROM circle";
        return jdbcTemplate.query( sql, new CircleMapper() );
    }

    private static final class CircleMapper implements RowMapper<Circle>
    {

        @Override
        public Circle mapRow(ResultSet resultset, int rowNum) throws SQLException
        {
            Circle circle = new Circle();
            circle.setId( resultset.getInt( "ID" ) );
            circle.setName( resultset.getString( "NAME" ) );
            return circle;
        }

    }


    //    public void insertCircle(Circle circle)
    //    {
    //        String sql = "INSERT INTO CIRCLE (ID, NAME) VALUES (?, ?)";
    //        jdbcTemplate.update( sql, new Object[] {circle.getId(), circle.getName()} );
    //    }

    public void insertCircle(Circle circle)
    {
        String sql = "INSERT INTO CIRCLE (ID, NAME) VALUES (:id, :name)";
        
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        
        namedParameters.addValue( "id", circle.getId() );
        namedParameters.addValue( "name", circle.getName() );
        
        namedParameterJdbcTemplate.update( sql, namedParameters );
    }


    public void createTriangleTable()
    {
        String sql = "CREATE TABLE TRIANGLE (ID INTEGER, NAME VARCHAR(50))";
        jdbcTemplate.execute( sql );
    }


    /////////////////////////////////////////////////////////////////////////////////////////////////

    public DataSource getDataSource()
    {
        return dataSource;
    }


    @Autowired
    public void setDataSource(DataSource dataSource)
    {
        this.jdbcTemplate = new JdbcTemplate( dataSource );
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate( dataSource );
    }


    public JdbcTemplate getJdbcTemplate()
    {
        return jdbcTemplate;
    }


    public void setJdbcTemplate(JdbcTemplate jdbcTemplate)
    {
        this.jdbcTemplate = jdbcTemplate;
    }
}
