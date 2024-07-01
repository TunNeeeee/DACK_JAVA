package com.dacs.HoiThaoHutech.repository;


import com.dacs.HoiThaoHutech.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRoleRepository extends JpaRepository<Role, Integer> {

    Role findByIdRole(Integer idRole);
}
