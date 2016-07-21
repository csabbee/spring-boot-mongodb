package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@EnableAutoConfiguration
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;
    
    @RequestMapping("/")
    @ResponseBody
    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    @RequestMapping("/{id}")
    @ResponseBody
    public Customer getCustomer(@PathVariable("id") String id) {
        return customerRepository.findOne(id);
    }
    
    @RequestMapping(value = "/", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        customerRepository.save(customer);
        HttpHeaders responseHeaders = new HttpHeaders();
        
        return new ResponseEntity<Customer>(customer, responseHeaders, HttpStatus.CREATED);
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<String> updateCustomer(@RequestBody Customer customer, @PathVariable("id") String id) {
        Customer savedCustomer = customerRepository.findOne(id);
        savedCustomer.updateCustomer(customer);        
        customerRepository.save(savedCustomer);
        HttpHeaders responseHeaders = new HttpHeaders();

        return new ResponseEntity<String>("Updated", responseHeaders, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteCustomerById(@PathVariable("id") String id) {
        customerRepository.delete(id);

        return deleteResponse();
    }
    
    @RequestMapping(value = "/", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteCustomer(@RequestBody Customer customer) {
        customerRepository.delete(customer);

        return deleteResponse();
    }
    
    private ResponseEntity<String> deleteResponse() {
        HttpHeaders responseHeaders = new HttpHeaders();
        return new ResponseEntity<String>("Deleted", responseHeaders, HttpStatus.OK);
    }
}
