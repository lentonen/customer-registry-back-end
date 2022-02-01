
package sitowise.registry;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Customer extends AbstractPersistable<Long> {
    private String firstName;
    private String lastName;
    private String address;
    
    @ManyToOne
    private Company company;
}
