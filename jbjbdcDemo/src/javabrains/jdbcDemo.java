package javabrains;

import javabrains.dao.jdbcDaoImpl;
import javabrains.model.Circle;

public class jdbcDemo
{

    public static void main(String[] args)
    {
            Circle circle = new jdbcDaoImpl().getCircle( 1 );
            System.out.println(circle.getName());
    }

}
