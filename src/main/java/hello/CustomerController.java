package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@EnableAutoConfiguration
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;
    
    @RequestMapping("/")
    @ResponseBody
    public List<Customer> customer() {
        return customerRepository.findAll();
    }
    
}
