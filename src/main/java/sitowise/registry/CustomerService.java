package sitowise.registry;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    @Autowired 
    CustomerRepository customerRepository;
    
    /**
     * List all customers from one company
     * @param id company id
     * @return all customers from one company
     */
    public List<Customer> listAllByCompany(Long id) {
        return customerRepository.findByCompanyIdOrderByLastNameAscFirstNameAsc(id) ;
    }
}
