package com.fashionstore.service.impl;

import com.fashionstore.Specification.CustomerSpecs;
import com.fashionstore.entity.Customer;
import com.fashionstore.map.CustomerMapper;
import com.fashionstore.repository.CustomerRepository;
import com.fashionstore.request.CustomerDTO;
import com.fashionstore.respone.CustomerResponeDTO;
import com.fashionstore.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public Page<CustomerResponeDTO> getAllCustomer(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return customerRepository.findAll(pageable).map(customerMapper::toCustomerResponeDTO);
    }

    @Transactional
    @Override
    public CustomerResponeDTO saveCustomer(CustomerDTO requestDTO) {
        Customer customer = customerRepository.findByEmail(requestDTO.getEmail().trim());
        if (customer != null) {
            throw new RuntimeException("CUSTOMER_ALREADY_EXISTS");
        }
        customer = customerMapper.toCustomer(requestDTO);
        return customerMapper.toCustomerResponeDTO(customerRepository.save(customer));
    }

    @Transactional
    @Override
    public CustomerResponeDTO updateCustomer(Long customerId, CustomerDTO requestDTO) {
        Customer customer = customerRepository.findById(customerId).orElseThrow(() -> new RuntimeException("CUSTOMER_NOT_EXISTS"));
        customer = customerMapper.toCustomer(requestDTO);
        customer.setCustomerId(customerId);
        customerRepository.save(customer);
        return customerMapper.toCustomerResponeDTO(customer);
    }

    @Override
    public CustomerResponeDTO getCustomerById(Long customerId) {
        Customer customer = customerRepository.findById(customerId).orElseThrow(() -> new RuntimeException("CUSTOMER_NOT_EXISTS"));
        CustomerResponeDTO responeDTO = customerMapper.toCustomerResponeDTO(customer);
        return responeDTO;
    }

    @Override
    public Page<CustomerResponeDTO> getCustomerFromFilter(String nameCustomer, String email, String phoneNumber, String address, Pageable pageable) {
        Specification<Customer> specsCustomer =  Specification.where(
                CustomerSpecs.hasNameCustomer(nameCustomer)
                        .and(CustomerSpecs.hasEmail(email))
                        .and(CustomerSpecs.hasPhoneNumber(phoneNumber))
                        .and(CustomerSpecs.hasAddress(address))
        );
        return customerRepository.findAll(specsCustomer, pageable).map(customerMapper::toCustomerResponeDTO);
    }
}
