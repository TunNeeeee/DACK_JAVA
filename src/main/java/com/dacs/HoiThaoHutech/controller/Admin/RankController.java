package com.dacs.HoiThaoHutech.controller.Admin;

import com.dacs.HoiThaoHutech.models.Rank;
import com.dacs.HoiThaoHutech.models.Sport;
import com.dacs.HoiThaoHutech.models.Team;
import com.dacs.HoiThaoHutech.service.RankService;
import com.dacs.HoiThaoHutech.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/admin")
public class RankController {

    @Autowired
    private RankService rankService;

    @Autowired
    private TeamService teamService;
    @GetMapping("/rank")
    public String showAllRankings(Model model) {
        List<Rank> ranks = rankService.findAllRanks();
        List<Team> teams = teamService.getTeamsSortedByNoFinal();
        Map<Integer, Long> teamCountBySport = teams.stream()
                .collect(Collectors.groupingBy(team -> team.getSport().getIdSport(), Collectors.counting()));

        model.addAttribute("ranks", ranks);
        model.addAttribute("teamCountBySport", teamCountBySport);
        return "admin/rank/list";
    }
    @GetMapping("/add-rank")
    public String addRank(Model model) {
        model.addAttribute("rank", new Rank());
        return "admin/rank/add";
    }
    @PostMapping("/add-rank")
    public String addRank(@ModelAttribute("rank") Rank rank) {
        rankService.save(rank);
        return "redirect:/admin/rank";
    }

}