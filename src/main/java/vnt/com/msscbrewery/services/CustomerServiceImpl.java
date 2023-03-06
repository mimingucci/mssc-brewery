package vnt.com.msscbrewery.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import vnt.com.msscbrewery.web.model.CustomerDto;

import java.util.UUID;
@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService{
    @Override
    public CustomerDto getCustomerById(UUID customerId) {
        return CustomerDto.builder()
                .id(customerId)
                .name("Vu Nguyen Tien")
                .build();
    }

    @Override
    public CustomerDto saveNewCustomer(CustomerDto customerDto) {
        return CustomerDto.builder()
                .id(customerDto.getId())
                .name(customerDto.getName())
                .build();
    }

    @Override
    public void updateCustomer(UUID customerId, CustomerDto customerDto) {
        log.debug("Updating ...");
    }

    @Override
    public void deleteById(UUID customerId) {
        log.debug("Deleting ...");
    }
}
