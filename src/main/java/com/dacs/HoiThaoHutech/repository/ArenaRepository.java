package com.dacs.HoiThaoHutech.repository;

import com.dacs.HoiThaoHutech.models.Arena;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArenaRepository extends JpaRepository<Arena, Integer> {
}
