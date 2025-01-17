package com.dacs.HoiThaoHutech.controller.Student;

import com.dacs.HoiThaoHutech.models.Rank;
import com.dacs.HoiThaoHutech.models.Sport;
import com.dacs.HoiThaoHutech.models.Team;
import com.dacs.HoiThaoHutech.service.RankService;
import com.dacs.HoiThaoHutech.service.SportService;
import com.dacs.HoiThaoHutech.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/student")
public class UserController {
    @Autowired
    private RankService rankService;
    @Autowired
    private TeamService teamService;
    @Autowired
    private SportService sportService;
    @GetMapping
    public String index(){
        return "redirect:/student/";
    }
    @GetMapping("/")
    public  String student(){
        return "student/index";
    }
    @GetMapping("/logout")
    public String studentlogout() {
        return "login";
    }
    @GetMapping("/list-rank")
    public String showAllRanks(Model model) {
        List<Rank> ranks = rankService.findAllRanks();
        Map<Integer, List<Team>> teamsByRank = new HashMap<>();
        List<Team> unrankedTeams = new ArrayList<>();
        // Fetch teams sorted by noRank and grouped by idRank
        List<Team> teams = teamService.getTeamsSortedByNoRank(); // Ensure this method sorts by noRank

        for (Team team : teams) {
            Rank rank = team.getRank();
            if (rank != null) {
                int idRank = rank.getIdRank(); // Assuming Team has a reference to Rank
                if (!teamsByRank.containsKey(idRank)) {
                    teamsByRank.put(idRank, new ArrayList<>());
                }
                teamsByRank.get(idRank).add(team);
            } else {
                unrankedTeams.add(team);
            }
        }
        model.addAttribute("teamsByRank", teamsByRank);
        model.addAttribute("unrankedTeams", unrankedTeams);
        model.addAttribute("ranks", ranks);
        return "student/listRank";
    }
    @GetMapping("/list-team")
    public String showAllTeams(@RequestParam(required = false) Integer sportId, Model model) {
        List<Sport> sports = sportService.getAllSports();
        List<Team> teams;

        if (sportId != null) {
            teams = teamService.getTeamsBySportIdSortedByNoFinal(sportId);
        } else {
            teams = teamService.getTeamsSortedByNoFinal();
        }

        model.addAttribute("sports", sports);
        model.addAttribute("teams", teams);
        model.addAttribute("selectedSportId", sportId);

        return "student/bxh";
    }
}