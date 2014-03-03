package javabrains;

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

        Circle circle = dao.getCircle( 1 );
        System.out.println( circle.getName() );
    }

}
