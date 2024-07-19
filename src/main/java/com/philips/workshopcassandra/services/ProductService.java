package com.philips.workshopcassandra.services;

import com.philips.workshopcassandra.model.dto.ProductDTO;
import com.philips.workshopcassandra.model.entities.Product;
import com.philips.workshopcassandra.repositories.ProductRepository;
import com.philips.workshopcassandra.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;
    public ProductDTO findById(UUID id) {
        Product entity = getById(id);
        return new ProductDTO(entity);
    }
    private Product getById(UUID id) {
        Optional<Product> result = repository.findById(id);
        return result.orElseThrow(() -> new ResourceNotFoundException("Id not found"));
    }

    public List<ProductDTO> findByDepartment(String department) {
        List<Product> list;
        if (department == null || department.isEmpty()) {
            list = repository.findAll();
        } else {
            list = repository.findByDepartment(department);
        }
        return list.stream().map(x -> new ProductDTO(x)).collect(Collectors.toList());
    }
}
