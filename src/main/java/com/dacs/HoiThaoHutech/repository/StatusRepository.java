package com.dacs.HoiThaoHutech.repository;

import com.dacs.HoiThaoHutech.models.Status;
import com.dacs.HoiThaoHutech.models.Team;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StatusRepository extends JpaRepository<Status, Integer> {
    Status findByIdStatus(int id);
}
