package com.dacs.HoiThaoHutech.service;

import com.dacs.HoiThaoHutech.models.Match;
import com.dacs.HoiThaoHutech.models.Sport;
import com.dacs.HoiThaoHutech.models.Team;
import com.dacs.HoiThaoHutech.repository.MatchRepository;
import com.dacs.HoiThaoHutech.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatchService {
    @Autowired
    private MatchRepository matchRepository;
    @Autowired
    private TeamRepository teamRepository;
    public List<Match> findAll() {
        return matchRepository.findAll();
    }

    public Match findById(int id) {
        return matchRepository.findById(id).orElse(null);
    }
    public void updateMatchResult(int idMatch, int point1, int point2) {
        Match match = matchRepository.findById(idMatch).orElseThrow(() -> new IllegalArgumentException("Invalid match Id:" + idMatch));
        match.setPoint1(point1);
        match.setPoint2(point2);
        matchRepository.save(match);
    }
    public void updateMatch(Match match) {
        matchRepository.save(match);
    }
    public void saveMatch(Match match) {
        matchRepository.save(match);
    }

}
