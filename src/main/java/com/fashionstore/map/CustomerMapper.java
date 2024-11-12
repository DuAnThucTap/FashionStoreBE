package com.fashionstore.map;

import com.fashionstore.entity.Customer;
import com.fashionstore.request.CustomerDTO;
import com.fashionstore.respone.CustomerResponeDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    Customer toCustomer(CustomerDTO customerDTO);
    CustomerResponeDTO toCustomerResponeDTO(Customer customer);
}
