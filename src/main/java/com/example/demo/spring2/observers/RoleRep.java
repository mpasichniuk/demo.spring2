package com.example.demo.spring2.observers;

import com.example.demo.spring2.subjects.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRep  extends JpaRepository<Role, Long> {
    Optional<Role> findByName(String name);
}
