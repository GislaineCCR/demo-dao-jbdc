package application;

import model.entities.Department;
import model.entities.Seller;

import java.util.Date;

public class Program {
    public static void main(String[] args) {


        Department obj = new Department(1 , "Books");

        Seller obj1 = new Seller(21 , "John","john@gmail.com", new Date(),3000.00, obj  );

        System.out.println(obj.toString());
        System.out.println(obj1.toString());




    }
}
