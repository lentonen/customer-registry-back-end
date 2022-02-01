package sitowise.registry;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Company extends AbstractPersistable<Long> {

    
    @OneToMany(mappedBy = "company")
    private List<Customer> customers;
    private String name;
    private String phone;
}
