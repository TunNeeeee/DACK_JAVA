package com.dacs.HoiThaoHutech.service;


import com.dacs.HoiThaoHutech.models.Team;
import com.dacs.HoiThaoHutech.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeamService {
    @Autowired
    private TeamRepository teamRepository;

    public List<Team> getAllTeams() {
        return teamRepository.findAll();
    }
    public List<Team> getAllTeamsINF() {
        return teamRepository.findTeamByStatus(2);
    }
    public List<Team> getAllTeamsReg() {
        return teamRepository.findTeamByStatus(1);
    }
    public List<Team> findTeamsBySportIdAndStatus(int sportId, int status) {
        return teamRepository.findBySport_IdSportAndStatus(sportId, status);
    }
    public Team getTeamById(Integer id) {
        Optional<Team> optionalTeam = teamRepository.findById(id);
        if (optionalTeam.isPresent()) {
            return optionalTeam.get();
        } else {
            throw new RuntimeException("Team not found with id " + id);
        }
    }
    public List<Team> getSportsByIDSport(Integer idSport) {
        return teamRepository.findBySport_IdSport(idSport);
    }
    public void saveTeam(Team team) {
        teamRepository.save(team);
    }
    public void addTeam(Team team) {
        teamRepository.save(team);
    }
    public void updateTeams(Team team) {
        teamRepository.save(team);
    }
    public Team updateTeam(Integer id, Team teamDetails) {
        Optional<Team> optionalTeam = teamRepository.findById(id);
        if (optionalTeam.isPresent()) {
            Team team = optionalTeam.get();
            team.setTeamName(teamDetails.getTeamName());
            team.setNumber(teamDetails.getNumber());
            team.setCaptainName(teamDetails.getCaptainName());
            team.setStatus(teamDetails.getStatus());
            team.setNumberGame(teamDetails.getNumberGame());
            team.setPoint(teamDetails.getPoint());
            team.setHs(teamDetails.getHs());
            team.setNoRank(teamDetails.getNoRank());
            team.setUser(teamDetails.getUser());
            team.setSport(teamDetails.getSport());
            team.setRank(teamDetails.getRank());
            return teamRepository.save(team);
        } else {
            throw new RuntimeException("Team not found with id " + id);
        }
    }
    public void updateTeamRankings(int rankId) {
        List<Team> teams = teamRepository.findTeamsByRank_IdRank(rankId);
        teams.sort((t1, t2) -> {
            int pointComparison = Integer.compare(t2.getPoint(), t1.getPoint());
            if (pointComparison != 0) {
                return pointComparison; // Sort by points in descending order
            }
            return Integer.compare(t2.getHs(), t1.getHs()); // If points are equal, sort by goal difference in descending order
        });

        int xh = 1;
        for (Team team : teams) {
            team.setNoRank(xh++);
            teamRepository.save(team);
        }
        for (int i = 0; i < Math.min(4, teams.size()); i++) {
            Team team = teams.get(i);
            System.out.println((i + 1) + "\t" + team.getTeamName() + "\t" + team.getNumberGame() + "\t" + team.getPoint() + "\t" + team.getHs());
        }
    }

    public void deleteTeam(Integer id) {
        Optional<Team> optionalTeam = teamRepository.findById(id);
        if (optionalTeam.isPresent()) {
            teamRepository.delete(optionalTeam.get());
        } else {
            throw new RuntimeException("Team not found with id " + id);
        }
    }
    public void eliminateTeam(Integer idTeam) {
        Team team = teamRepository.findById(idTeam).orElseThrow(() -> new IllegalArgumentException("Invalid team Id:" + idTeam));
        team.setStatus(0); // Cập nhật status của đội
        teamRepository.save(team);
    }
    public List<Team> getTeamsSortedByNoFinal() {
        return teamRepository.findAllByOrderByNoFinalAsc();
    }
    public List<Team> getTeamsBySportIdSortedByNoFinal(Integer sportId) {
        return teamRepository.findBySport_IdSportOrderByNoFinalAsc(sportId);
    }
}
