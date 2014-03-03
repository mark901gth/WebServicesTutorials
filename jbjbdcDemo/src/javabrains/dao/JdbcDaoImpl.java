package javabrains.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javabrains.model.Circle;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JdbcDaoImpl
{
    public DataSource getDataSource()
    {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource)
    {
        this.dataSource = dataSource;
    }

    @Autowired
    private DataSource dataSource;
    
    public Circle getCircle(int circleId)
    {
        Connection conn = null;

        try
        {
            conn = dataSource.getConnection();
            
            PreparedStatement ps = conn.prepareStatement( "SELECT * FROM circle where id = ?" );
            ps.setInt( 1, circleId );

            Circle circle = null;
            ResultSet rs = ps.executeQuery();

            if ( rs.next() )
            {
                circle = new Circle( circleId, rs.getString( "name" ) );
            }
            rs.close();
            ps.close();

            return circle;
        }
        catch ( Exception e )
        {
            throw new RuntimeException( e );
        }
        finally
        {
            try
            {
                conn.close();
            }
            catch ( SQLException e )
            {
                e.printStackTrace();
            }
        }
    }
}
