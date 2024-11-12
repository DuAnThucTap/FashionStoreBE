package com.fashionstore.controller;

import com.fashionstore.repository.CustomerRepository;
import com.fashionstore.request.CustomerDTO;
import com.fashionstore.respone.ApiRespone;
import com.fashionstore.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/products")
@CrossOrigin("http://localhost:4200")
public class CustomerController {

    @Autowired
    private CustomerService customerService;
    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping
    public ApiRespone<?> getAllCustomers(@RequestParam(required = false, defaultValue = "0") int page,
                                     @RequestParam(required = false, defaultValue = "20") int size  ) {
        return ApiRespone.builder()
                .result(customerService.getAllCustomer(page,size))
                .build();
    }

    @GetMapping("{customerId}")
    public ApiRespone<?> getCustomerById(@PathVariable("customerId") Long customerId) {
        return ApiRespone.builder()
                .result(customerService.getCustomerById(customerId))
                .build();
    }

    @PostMapping
    public ApiRespone<?> postCustomer(@ModelAttribute @Valid CustomerDTO requestDTO) {
        return ApiRespone.builder()
                .result(customerService.saveCustomer(requestDTO))
                .build();

    }

    @PutMapping("/{id}")
    public ApiRespone<?> putCustomer(@PathVariable("id") Long customerId ,@ModelAttribute @Valid CustomerDTO requestDTO) {
        return ApiRespone.builder()
                .result(customerService.updateCustomer(customerId,requestDTO))
                .build();
    }

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable Long id) {
        customerRepository.deleteById(id);
    }

    @GetMapping("filter")
    public ApiRespone<?>getCustomerFromFilter(@RequestParam(required = false) String  nameCustomer,
                                          @RequestParam(required = false) String email,
                                          @RequestParam(required = false) String phoneNumber,
                                          @RequestParam(required = false) String address,
                                          @RequestParam(value = "page", defaultValue = "0") int page,
                                          @RequestParam(value = "size", defaultValue = "10") int size){
        System.out.println(page);
        System.out.println(size);
        Pageable pageable = PageRequest.of(page, size);
        return ApiRespone.builder()
                .result(customerService.getCustomerFromFilter(nameCustomer,email,phoneNumber,address,pageable))
                .build();
    }


}
