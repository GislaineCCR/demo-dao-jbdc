package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.dao.impl.SellerDaoJDBC;
import model.entities.Department;
import model.entities.Seller;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        SellerDao sellerDao =  DaoFactory.createSellerDao();

        System.out.println("=== Test 1: seller findbyId ===");
        Seller seller = sellerDao.findById(3);
        System.out.println(seller);

        System.out.println("\n=== Test 2: seller findbyId ===");
        Department department = new Department(2, null);

        List<Seller> list = sellerDao.findByDepartmentId(department);
        for (Seller obj : list) {
            System.out.println(obj);
        }

        System.out.println("\n=== Test 3: seller findAll===");

        list = sellerDao.findAll();
        for (Seller obj : list) {
            System.out.println(obj);
        }

        System.out.println("\n=== Test 4: seller insert ===");
        Seller newSeller = new Seller(null , "Greg" , "greg@gmail.com", new Date(), 4000.00, department);
        sellerDao.insert(newSeller);
        System.out.println("Inserted! New Seller Id: " + newSeller.getId());

        System.out.println("\n=== Test 5: seller Update ===");
        seller = sellerDao.findById(1);
        seller.setName("Martha Waine");
        sellerDao.update(seller);
        System.out.println("Updated!  " + seller.getId());

        System.out.println("\n=== Test 6: seller Delete ===");
        System.out.println("Enter id for delete seller : ");
        int id = sc.nextInt();
        sellerDao.delete(id);
        System.out.print("Deleted!  " );

        sc.close();

    }
}
