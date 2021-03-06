package ftcApp.repository;

import ftcApp.model.Customer;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerRepositoryImpl extends UserRepositoryImpl<Customer, Integer> implements CustomerRepository {

    public CustomerRepositoryImpl() {
        super(Customer.class);
    }

    @Override
    public void updateRequiredPrepaymentShare(Integer id, double prepaymentShare) {
        Customer customer = this.findOne(id);
        customer.setPrepaymentShareRequired(prepaymentShare);
        this.update(customer);
    }
}
