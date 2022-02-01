package sitowise.registry;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;


@CrossOrigin("https://optimistic-hawking-fc10c8.netlify.app")
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    List<Customer> findByCompanyIdOrderByLastNameAscFirstNameAsc(Long id);
    
}

