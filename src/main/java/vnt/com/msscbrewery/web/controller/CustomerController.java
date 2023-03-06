package vnt.com.msscbrewery.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import vnt.com.msscbrewery.services.CustomerService;
import vnt.com.msscbrewery.web.model.CustomerDto;

import java.util.UUID;

@RestController
@RequestMapping("api/v1/customer")
@RequiredArgsConstructor
public class CustomerController {
    private CustomerService service;

    @GetMapping("/{customerId}")
    public ResponseEntity<CustomerDto> getCustomer(@PathVariable("customerId") UUID customerId){

        return new ResponseEntity<>(service.getCustomerById(customerId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity handlePost(@RequestBody @Validated CustomerDto customerDto){
        CustomerDto savedDto = service.saveNewCustomer(customerDto);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Location", "/api/v1/customer/" + savedDto.getId().toString());

        return new ResponseEntity(httpHeaders, HttpStatus.CREATED);
    }

    @PutMapping("/{customerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void handleUpdate(@PathVariable("customerId") UUID customerId, @Validated @RequestBody CustomerDto customerDto){
        service.updateCustomer(customerId, customerDto);
    }

    @DeleteMapping("/{customerId}")
    public void deleteById(@PathVariable("customerId")  UUID customerId){
        service.deleteById(customerId);
    }
}
