package com.dacs.HoiThaoHutech.repository;

import com.dacs.HoiThaoHutech.models.Rank;
import com.dacs.HoiThaoHutech.models.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TeamRepository extends JpaRepository<Team, Integer> {
    List<Team> findBySport_IdSport(Integer idSport);
    List<Team> findTeamsByRank_IdRank(Integer idRank);
    List<Team> findByRankOrderByPointDesc(Rank rank);
    List<Team> findTeamByStatus(Integer status);
    List<Team> findBySport_IdSportAndStatus(Integer sportId, Integer status);
    List<Team> findAllByOrderByNoFinalAsc();
    List<Team> findBySport_IdSportOrderByNoFinalAsc(Integer sportId);


}
