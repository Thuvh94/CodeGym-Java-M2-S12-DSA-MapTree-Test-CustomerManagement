package management;

import model.Customer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CustomerService implements IService<Customer> {
    static List<Customer> customers;

    static {
        customers = new ArrayList<>();
        customers.add(new Customer(1L, "The Anh", "Ha Noi"));
        customers.add(new Customer(2L, "Quan", "Ha Noi"));
        customers.add(new Customer(3L, "Quan", "Ha Noi"));
        customers.add(new Customer(4L, "Tuan Anh", "Ha Noi"));
        customers.add(new Customer(5L, "The Anh", "Ha Noi"));
    }

    @Override
    public void add(Customer object) {
        if(!customers.contains(object))
            customers.add(object);
    }

    @Override
    public void update(long id, Customer newObject) {
        if(isExisted(id))
                customers.set((int) (id-1), newObject);
    }

    @Override
    public void delete(long id) {
        if(isExisted(id))
            customers.remove(id);
    }

    @Override
    public Customer findById(long id) {
        Customer outputCustomer = null;
        for(int i=0;i<customers.size();i++){
            if(id==customers.get(i).getId()){
                outputCustomer = customers.get(i);
            }
        }
        return outputCustomer;
    }

    @Override
    public List<Customer> findByName(String name) {
        List<Customer> outputCustomers = new ArrayList<>();
        for(Customer customer: customers){
            if(customer.getName().equals(name)){
                outputCustomers.add(customer);
            }
        }
        return outputCustomers;
    }

    @Override
    public List<Customer> findAll() {
        List<Customer> list = new ArrayList<>();
        Iterator<Customer> iterator = customers.iterator();
        while (iterator.hasNext())
            list.add(iterator.next());
        return list;
    }

    public boolean isExisted(long id){
        for (int i = 0; i < customers.size(); i++) {
            if(customers.get(i).getId() == id)
                return true;
        }
        return false;
    }
}
