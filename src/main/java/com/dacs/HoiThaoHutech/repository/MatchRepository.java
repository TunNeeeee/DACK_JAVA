package com.dacs.HoiThaoHutech.repository;

import com.dacs.HoiThaoHutech.models.Match;
import com.dacs.HoiThaoHutech.models.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MatchRepository extends JpaRepository<Match, Integer> {

}
