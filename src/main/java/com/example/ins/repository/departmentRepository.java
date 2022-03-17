package com.example.ins.repository;

import com.example.ins.entity.department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface departmentRepository extends JpaRepository<department, Integer> {

    department findByBusinessUnitId(int businessUnitId);

}
