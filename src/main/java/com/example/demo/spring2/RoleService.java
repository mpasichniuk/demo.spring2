package com.example.demo.spring2;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleService {
    private final RoleRep roleRep;

    public Role getUserRole() {
        return roleRep.findByName("ROLE_USER").get();
    }
}