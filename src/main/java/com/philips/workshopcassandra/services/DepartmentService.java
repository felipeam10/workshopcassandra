package com.philips.workshopcassandra.services;

import com.philips.workshopcassandra.model.dto.DepartmentDTO;
import com.philips.workshopcassandra.model.entities.Department;
import com.philips.workshopcassandra.repositories.DepartmentRepository;
import com.philips.workshopcassandra.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository repository;

    public List<DepartmentDTO> findAll() {
        List<Department> list = repository.findAll();
        return list.stream().map(x -> new DepartmentDTO(x)).collect(Collectors.toList());
    }

    public DepartmentDTO findById(UUID id) {
        Optional<Department> result = repository.findById(id);
        Department entity = result.orElseThrow(() -> new ResourceNotFoundException("Id not found"));
        return new DepartmentDTO(entity);

    }
}
