package sitowise.registry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("https://optimistic-hawking-fc10c8.netlify.app")
public interface CompanyRepository extends JpaRepository<Company, Long> {
    
}
