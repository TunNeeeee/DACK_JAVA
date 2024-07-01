package com.dacs.HoiThaoHutech.repository;


import com.dacs.HoiThaoHutech.models.Sport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SportRepository extends JpaRepository<Sport, Integer> {
    List<Sport> findByEvent_IdEvent(Integer idEvent);
    List<Sport> findBySportNameContaining(String keyword);
}