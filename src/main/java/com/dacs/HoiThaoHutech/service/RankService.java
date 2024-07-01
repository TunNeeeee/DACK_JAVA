package com.dacs.HoiThaoHutech.service;

import com.dacs.HoiThaoHutech.models.Rank;
import com.dacs.HoiThaoHutech.models.Team;
import com.dacs.HoiThaoHutech.repository.RankRepository;
import com.dacs.HoiThaoHutech.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RankService {
    @Autowired
    private RankRepository rankRepository;
    @Autowired
    private SportService sportService;
    @Autowired
    private TeamRepository teamRepository;
    public List<Rank> getAllRank(){
        return rankRepository.findAll();
    }
    public List<Rank> findAllRanks() {
        List<Rank> ranks = rankRepository.findAll();
        for (Rank rank : ranks) {
            List<Team> sortedTeams = teamRepository.findByRankOrderByPointDesc(rank);
            rank.setListTeam(sortedTeams);
        }
        return ranks;
    }
    public void save(Rank rank) {
        rankRepository.save(rank);
    }
    public Rank createRankWithTeams(String nameRank, Integer idSport) {
        Rank rank = new Rank();
        rank.setNameRank(nameRank);

        List<Team> teams = teamRepository.findBySport_IdSport(idSport);
        rank.setListTeam(teams);

        Rank savedRank = rankRepository.save(rank);

        teams.forEach(team -> {
            team.setRank(savedRank);
            teamRepository.save(team);
        });

        return savedRank;
    }
    public Rank getRankById(int id) {
        return rankRepository.findById(id).orElse(null);
    }
}
