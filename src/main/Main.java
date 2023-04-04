package main;

import model.entity.Customers;
import model.entity.Employee;
import model.entity.Offices;
import model.entity.Orders;
import repository.impl.CustomerRepository;
import repository.impl.EmployeeRepository;
import repository.impl.OfficesRepository;
import repository.impl.OrdersRepository;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        EmployeeRepository employeeRepository = new EmployeeRepository();
        System.out.println("EmployeeRepository class");
        // findAll method
        List<Employee> employees = employeeRepository.findAll();
        for (Employee employee : employees) {
            System.out.println(employee);
        }

        //findById method
        Employee employee = employeeRepository.findById(1286);
        System.out.println("This is the employee you wanted: " + employee);

        // exists method
        boolean exists = employeeRepository.exists(1286);
        System.out.println("Employee with ID 1286 exists: " + exists);

        // Save method
        Employee newEmployee = new Employee(2002, "Elio", "Sinaj", "x55225", "elsin@yahoo.com", "tirana", "Manager",4);
        boolean saved = employeeRepository.save(newEmployee);
        System.out.println("New employee saved: " + saved);

        // update method
        Employee updatedEmployee = new Employee(2002, "Filan", "Ff", "x125", "ff@gmail.com", "tirana", "Software DEV",1);
        int updatedCount = employeeRepository.update(updatedEmployee);
        System.out.println("Number of updated employees: " + updatedCount);

        //--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

        System.out.println("************************************************************************************");
        System.out.println("Customer class");

        CustomerRepository customerRepository = new CustomerRepository();

        //findAll method
        List<Customers> customer = customerRepository.findAll();
        for (Customers customers : customer){
            System.out.println(customers);
        }
        //findById method
        Customers customers = customerRepository.findById(103);
        System.out.println(customers);

        // exists method
        boolean exists1 = customerRepository.exists(1286);
        System.out.println("Customer with ID 1286 exists: " + exists1);

        // Save method
        Customers newCustomer = new Customers(2002, "Xhek", "Gola", "x51", "xhek@yahoo.com", "tirana", "social media manager",14.2);
        boolean saved1 = customerRepository.save(newCustomer);
        System.out.println("New Customer saved: " + saved1);

        // update method
        Customers updatedCustomer = new Customers(2002, "Beni", "Bb", "x12", "Bb@gmail.com", "tirana", "Artist",22.2);
        int updatedCount1 = customerRepository.update(updatedCustomer);
        System.out.println("Number of updated customers: " + updatedCount1);

        //----------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        System.out.println("*******************************************************************************");
        System.out.println("Offices class");

        //findAll method
        OfficesRepository officesRepository = new OfficesRepository();
        List<Offices> offices = officesRepository.findAll();
        for (Offices office : offices){
            System.out.println(office);
        }

        //findById method
        Offices office = officesRepository.findById("101");
        System.out.println(office);

        // exists method
        boolean exists2 = officesRepository.exists("1236");
        System.out.println("Office with officeCode 1286 exists: " + exists2);

        // Save method
        Offices newOffices = new Offices("202","tirana","1234567","street keko","10001");
        boolean saved2 = officesRepository.save(newOffices);
        System.out.println("New office saved: " + saved2);

        // update method
        Offices updatedOffices = new Offices("2002", "tirana", "10011112", "street city", "tir2002");
        int updatedCount2 = officesRepository.update(updatedOffices);
        System.out.println("Number of updated offices: " + updatedCount2);

        //----------------------------------------------------------------------------------------------------------------------------------------
        System.out.println("**********************************************************************************");
        System.out.println("Order class");

        //findALL method
        OrdersRepository ordersRepository = new OrdersRepository();
        List<Orders> orders = ordersRepository.findAll();
        for (Orders order : orders){
            System.out.println(order);
        }

        //findById method
        Orders order = ordersRepository.findById(10100);
        System.out.println("this is the order you wanted:" + order);

        // exists method
        boolean exists3 = ordersRepository.exists(10100);
        System.out.println("Order with ID 1286 exists: " + exists3);

        // Save method
        Orders newOrders = new Orders(401,"delivered","on its way");
        boolean saved4 = ordersRepository.save(newOrders);
        System.out.println("New order saved: " + saved4);

        // update method
        Orders updateOrder = new Orders(1001,"delivered","on its way");
        int updatedCount3 = ordersRepository.update(updateOrder);
        System.out.println("Number of updated orders: " + updatedCount3);
    }
}