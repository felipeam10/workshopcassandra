package com.philips.workshopcassandra.repositories;

import com.philips.workshopcassandra.model.entities.Department;
import org.springframework.data.cassandra.repository.CassandraRepository;

import java.util.UUID;

public interface DepartmentRepository extends CassandraRepository<Department, UUID> {
}
