package com.philips.workshopcassandra.repositories;

import com.philips.workshopcassandra.model.entities.Department;
import com.philips.workshopcassandra.model.entities.Product;
import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.CassandraRepository;

import java.util.List;
import java.util.UUID;

public interface ProductRepository extends CassandraRepository<Product, UUID> {

    @AllowFiltering
    List<Product> findByDepartment(String department);

}
