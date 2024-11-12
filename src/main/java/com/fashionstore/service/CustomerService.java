package com.fashionstore.service;

import com.fashionstore.request.CustomerDTO;
import com.fashionstore.respone.CustomerResponeDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CustomerService {
    public Page<CustomerResponeDTO> getAllCustomer(int page, int size);
    public CustomerResponeDTO saveCustomer(CustomerDTO requestDTO);
    public CustomerResponeDTO updateCustomer(Long customerId,CustomerDTO requestDTO);
    public CustomerResponeDTO getCustomerById(Long customerId);
    Page<CustomerResponeDTO> getCustomerFromFilter(String nameCustomer, String email, String phoneNumber, String address,
                                                 Pageable pageable);
}
