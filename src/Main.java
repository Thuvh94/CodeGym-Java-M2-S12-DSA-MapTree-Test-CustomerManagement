import management.CustomerService;
import model.Customer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {
    static void display(List list){
        Iterator<Customer> customerIterator = list.iterator();
        while (customerIterator.hasNext())
            System.out.println(customerIterator.next());

//        for (int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i));
//        }
    }
    public static void main(String[] args) {
        CustomerService customerService = new CustomerService();
        // Test findAll()
        System.out.printf("===Test find all===\n");
        display(customerService.findAll());

        // Test add()
        System.out.printf("===Test add===\n");
       customerService.add(new Customer(6L,"Thu","TPHCM"));
       customerService.add(new Customer(7L,"Nam","Lao Cai"));
        display(customerService.findAll());

        // Test update()
        System.out.println("=== Test Update ===\n");
        customerService.update(1L,new Customer(1L,"Hoang","Nam Dinh"));
        display(customerService.findAll());

        // Test delete()
        System.out.println("=== Test delete ===\n");
        customerService.delete(3);
        display(customerService.findAll());

        // Test findById ( )
        System.out.println("=== Test find by ID ===\n");
        System.out.println(customerService.findById(4));

        // Test findByName()
        System.out.println("=== Test find by name ===\n");
        List<Customer> foundedCustomer = new ArrayList<>();
        foundedCustomer = customerService.findByName("Quan");
        display(foundedCustomer);

    }
}
