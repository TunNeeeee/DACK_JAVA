package com.dacs.HoiThaoHutech.repository;

import com.dacs.HoiThaoHutech.models.Round;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoundRepository extends JpaRepository<Round, Integer> {
}
