package ftcApp.repository;

import ftcApp.model.Customer;

public interface CustomerRepository extends UserRepository<Customer, Integer> {
    void updateRequiredPrepaymentShare(Integer id, double prepaymentShare);
}
