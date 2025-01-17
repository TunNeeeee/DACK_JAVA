package com.dacs.HoiThaoHutech.service;


import com.dacs.HoiThaoHutech.models.Role;
import com.dacs.HoiThaoHutech.repository.IRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    @Autowired
    private IRoleRepository roleRepository;

    public Role findByRoleID(Integer idRole) {
        return roleRepository.findByIdRole(idRole);
    }

    public Role saveRole(Role role) {
        return roleRepository.save(role);
    }
}
