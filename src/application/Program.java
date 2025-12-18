package application;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        SellerDao sellerDao = DaoFactory.createSellerDao();

        System.out.println("=== Test 1: seller findById ===");
        Seller seller = sellerDao.findById(3);
        System.out.println(seller);

        System.out.println("\n=== Test 2: seller findByDepartment ===");
        Department department = new Department(2, null);
        List<Seller> list = sellerDao.findByDepartmentId(department);
        for (Seller obj : list) {
            System.out.println(obj);
        }

        System.out.println("\n=== Test 3: seller findAll ===");
        list = sellerDao.findAll();
        for (Seller obj : list) {
            System.out.println(obj);
        }

        System.out.println("\n=== Test 4: seller insert ===");
        Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.00, department);
        sellerDao.insert(newSeller);
        System.out.println("Inserted! New Seller Id: " + newSeller.getId());

        System.out.println("\n=== Test 5: seller update ===");
        seller = sellerDao.findById(1);
        seller.setName("Martha Waine");
        sellerDao.update(seller);
        System.out.println("Updated! " + seller.getId());

        System.out.println("\n=== Test 6: seller delete ===");
        System.out.println("Enter id for delete seller: ");
        int id = sc.nextInt();
        sellerDao.delete(id);
        System.out.println("Deleted!");

        System.out.println("\n----------------------------------------------------");
        System.out.println("----------------- DEPARTMENT TESTS -----------------");
        System.out.println("----------------------------------------------------");

        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

        System.out.println("\n=== Test 1: Department findById ===");
        Department dep = departmentDao.findById(1);
        System.out.println(dep);

        System.out.println("\n=== Test 2: Department findAll ===");
        List<Department> listDep = departmentDao.findAll();
        for (Department obj : listDep) {
            System.out.println(obj);
        }

        System.out.println("\n=== Test 3: Department insert ===");
        Department newDepartment = new Department(null, "Music");
        departmentDao.insert(newDepartment);
        System.out.println("Inserted! New id: " + newDepartment.getId());

        System.out.println("\n=== Test 4: Department update ===");
        Department dep2 = departmentDao.findById(1);
        dep2.setName("Food");
        departmentDao.update(dep2);
        System.out.println("Update completed");

        System.out.println("\n=== Test 5: Department delete ===");
        System.out.print("Enter id for delete test: ");
        int idDep = sc.nextInt();
        departmentDao.delete(idDep);
        System.out.println("Delete completed");

        sc.close();
    }
}
