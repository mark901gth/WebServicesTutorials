package javabrains;

import java.util.Iterator;
import java.util.List;

import javabrains.dao.JdbcDaoImpl;
import javabrains.model.Circle;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class jdbcDemo
{

    public static void main(String[] args)
    {
        ApplicationContext ctx = new ClassPathXmlApplicationContext( "spring.xml" );
        JdbcDaoImpl dao = ctx.getBean( "jdbcDaoImpl", JdbcDaoImpl.class );

        //Circle circle = dao.getCircle( 1 );
        //System.out.println( circle.getName() );
        System.out.println( "Circle count     : " + dao.getCircleCount() );
        System.out.println( "Circle Name id:1 : " + dao.getCircleName( 1 ) );

        System.out.println( "using getCircleforId : " + dao.getCircleforId( 1 ).getName() );

        dao.insertCircle( new Circle(4,"4th circle") );
        
        List<Circle> listOfCircles = dao.getAllCircles();
        Circle c;
        System.out.println( "getAllCircles .size = number of circles : " + listOfCircles.size() );
        System.out.println( "Iterate thru all circles" );
        Iterator<Circle> iteratorCircle = listOfCircles.iterator();
        while ( iteratorCircle.hasNext() )
        {
            c = iteratorCircle.next();
            System.out.printf( "  Circle ID:%d NAME:%s\n", c.getId(), c.getName() );
        }

        //dao.createTriangleTable();
    }

}
