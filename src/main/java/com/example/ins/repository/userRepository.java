package com.example.ins.repository;

import com.example.ins.entity.users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface userRepository extends JpaRepository<users,Integer> {
}
