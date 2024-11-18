package application;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

import java.util.List;
import java.util.Scanner;

public class Program2 {
    public static void main(String[] args) {
        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
        Scanner sc = new Scanner(System.in);

        System.out.println("--- Test 1: department insert ---");
        Department newDepartment = new Department(null, "Music");
        departmentDao.insert(newDepartment);
        System.out.println("Inserted! New id: " + newDepartment.getId());
        System.out.println();

        System.out.println("--- Test 2: department findById ---");
        Department department = departmentDao.findById(2);
        System.out.println(department);
        System.out.println();

        System.out.println("--- Test 3: department findAll ---");
        List<Department> list = departmentDao.findAll();

        for(Department dep : list){
            System.out.println(dep);
        }
        System.out.println();

        System.out.println("--- Test 4: department update ---");
        department = departmentDao.findById(1);
        department.setName("Food");
        departmentDao.update(department);
        System.out.println("Update completed!");
        System.out.println();

        System.out.println("--- Test 5: department delete ---");
        System.out.print("Enter Id for delete test: ");
        int id = sc.nextInt();
        departmentDao.deleteById(id);
        System.out.println("Delete completed!");

        sc.close();
    }
}
