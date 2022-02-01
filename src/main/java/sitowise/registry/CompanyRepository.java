package sitowise.registry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("https://xenodochial-kepler-957fa3.netlify.app/")
public interface CompanyRepository extends JpaRepository<Company, Long> {
    
}
