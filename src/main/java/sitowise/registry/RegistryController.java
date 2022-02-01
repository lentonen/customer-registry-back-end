
package sitowise.registry;

import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;
        


@Controller
public class RegistryController {
    
    @Autowired
    private CustomerService customerService;
    
    @GetMapping("/registry")
    public String view() {
        return "registry";
    }

    @GetMapping("/api/companies/{id}/export")
    public void exportCSV(HttpServletResponse response, @PathVariable Long id) throws IOException {
        
        response.setContentType("text/csv");                        // attachment type
        String headerKey = "Content-Disposition";                   // header for attachment
        String headerValue = "attachment; filename=customers.csv";  // name for exported .csv file
        response.setHeader(headerKey, headerValue);
        
        List<Customer> customers = customerService.listAllByCompany(id);
        
        ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(), CsvPreference.STANDARD_PREFERENCE);  // CsvBeanwriter writes data to the response
        String[] csvHeader = {"First name", "Last name", "Address"};     // names for columns
        String[] nameMapping = {"firstName", "lastName", "address"};     // array for mapping with customer class field names                                 
        csvWriter.writeHeader(csvHeader);                                // writing headers
         
        for (Customer customer : customers) {
            csvWriter.write(customer, nameMapping);                      // mapping customer info to CSV
        }
        csvWriter.close();   
    }  
}
