package com.dacs.HoiThaoHutech.controller.Admin;

import com.dacs.HoiThaoHutech.models.*;
import com.dacs.HoiThaoHutech.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin")
public class AdminMatchController {
    @Autowired
    private MatchService matchService;
    @Autowired
    private TeamService teamService;
    @Autowired
    private RoundService roundService;
    @Autowired
    private ArenaService arenaService;
    @Autowired
    private SportService sportService;
    @GetMapping("/match")
    public  String index(Model model){
        List<Sport> sports =sportService.getAllSports();
        List<Match> matches = matchService.findAll();
        model.addAttribute("matches", matches);
        model.addAttribute("sports", sports);
        return "admin/match/index";
    }

//    @GetMapping("/add-match")
//    public String add(Model model){
//        Match match= new Match();
//        List<Team> teams = teamService.getAllTeamsINF();
//        List<Round> rounds = roundService.getAllRound();
//        List<Arena> arenas  = arenaService.getAllArena();
//        model.addAttribute("match",match);
//        model.addAttribute("teams", teams);
//        model.addAttribute("rounds",rounds);
//        model.addAttribute("arenas", arenas);
//        return "admin/match/add";
//    }
    @GetMapping("/add-match")
    public String showAddMatchForm(Model model) {
        List<Sport> sports = sportService.getAllSports();
        List<Round> rounds = roundService.getAllRound();
        List<Arena> arenas = arenaService.getAllArena();
        model.addAttribute("sports", sports);
        model.addAttribute("rounds", rounds);
        model.addAttribute("arenas", arenas);
        model.addAttribute("match", new Match());
        return "admin/match/add";
    }
    @PostMapping("/add-match")
    public String save(@ModelAttribute("match")Match match){
        match.setPoint1(-1);
        match.setPoint2(-1);
        matchService.saveMatch(match);
        return "redirect:/admin/match";
    }
    @GetMapping("/teams-by-sport/{sportId}")
    @ResponseBody
    public List<Map<String, Object>> getTeamsBySport(@PathVariable int sportId) {
        int status = 2; // Chỉ lấy các đội có status là 2
        List<Team> teams = teamService.findTeamsBySportIdAndStatus(sportId, status);
        List<Map<String, Object>> teamList = new ArrayList<>();
        for (Team team : teams) {
            Map<String, Object> teamMap = new HashMap<>();
            teamMap.put("id", team.getIdTeam()); // Thêm ID của đội
            teamMap.put("name", team.getTeamName()); // Thêm tên của đội
            teamList.add(teamMap);
        }
        return teamList;
    }

    @GetMapping("/updateMatchResult/{id}")
    public String showUpdateForm(@PathVariable int id, Model model) {
        Match match = matchService.findById(id);
        model.addAttribute("match", match);
        return "admin/match/edit";
    }

    @PostMapping("/updateMatchResult")
    public String updateMatchResult(@RequestParam("idMatch") int idMatch,
                                    @RequestParam("point1") int point1,
                                    @RequestParam("point2") int point2) {
        matchService.updateMatchResult(idMatch, point1, point2);
        // Lấy thông tin trận đấu sau khi cập nhật
        Match match = matchService.findById(idMatch);
        // Nếu trận đấu thuộc vòng loai tt
        if(match.getRound().getIdRound() != 1){
            Team team1 = match.getTeam1();
            Team team2 = match.getTeam2();
            if (point1 > point2) {
                team2.setStatus(0);
                if(match.getRound().getIdRound() == 2) {
                    team2.setNoFinal(16);
                    team1.setNoFinal(8);
                }
                else if(match.getRound().getIdRound() == 3) {
                    team2.setNoFinal(8);
                    team1.setNoFinal(4);
                }
                else if(match.getRound().getIdRound() == 4){
                    team2.setNoFinal(3);
                    team1.setNoFinal(2);
                }
                else if(match.getRound().getIdRound() == 5)
                    team2.setNoFinal(4);
                else{
                    team2.setNoFinal(2);
                    team1.setNoFinal(1);
                    team1.setStatus(10);
                }
            }else {
                team1.setStatus(0);
                if(match.getRound().getIdRound() == 2)
                    team1.setNoFinal(16);
                else if(match.getRound().getIdRound() == 3){
                    team1.setNoFinal(8);
                    team2.setNoFinal(4);
                }

                else if(match.getRound().getIdRound() == 4) {
                    team1.setNoFinal(3);
                    team2.setNoFinal(2);
                }
                else if(match.getRound().getIdRound() == 5)
                    team1.setNoFinal(4);
                else {
                    team1.setNoFinal(2);
                    team2.setNoFinal(1);
                    team2.setStatus(10);
                }
            }
            // Lưu các thay đổi
            teamService.updateTeams(team1);
            teamService.updateTeams(team2);
        }
        else
        // Cập nhật thông tin đội 1 và đội 2
        {
            Team team1 = match.getTeam1();
            Team team2 = match.getTeam2();

            // Tăng số trận đấu đã chơi
            team1.setNumberGame(team1.getNumberGame() + 1);
            team2.setNumberGame(team2.getNumberGame() + 1);

            // Cập nhật điểm số dựa trên kết quả trận đấu
            if (point1 > point2) {
                team1.setPoint(team1.getPoint() + 3); // Đội 1 thắng
            } else if (point1 < point2) {
                team2.setPoint(team2.getPoint() + 3); // Đội 2 thắng
            } else {
                team1.setPoint(team1.getPoint() + 1); // Hòa
                team2.setPoint(team2.getPoint() + 1); // Hòa
            }
            team1.setHs(team1.getHs()+(point1-point2));
            team2.setHs(team2.getHs()+point2-point1);
            // Lưu các thay đổi
            teamService.updateTeams(team1);
            teamService.updateTeams(team2);
            // Cập nhật thứ hạng của các đội trong cùng một rank
            int rankId = team1.getRank().getIdRank(); // Giả sử cả hai đội đều ở cùng một rank
            teamService.updateTeamRankings(rankId);
        }

        return "redirect:/admin/match"; // Chuyển hướng đến trang danh sách trận đấu hoặc bất kỳ trang nào khác
    }
    @GetMapping("/resetMatchResult/{id}")
    public String resetMatchResult(@PathVariable int id) {
        Match match = matchService.findById(id);
        // Nếu trận đấu thuộc vòng loại tt
        if (match.getRound().getIdRound() != 1) {
            Team team1 = match.getTeam1();
            Team team2 = match.getTeam2();
            if (match.getPoint1() > match.getPoint2()) {
                team1.setStatus(2);
                team2.setStatus(2);
            } else {
                team1.setStatus(2);
                team2.setStatus(2);
            }
            // Lưu các thay đổi
            teamService.updateTeams(team1);
            teamService.updateTeams(team2);
            // Reset the match result
            match.setPoint1(-1);
            match.setPoint2(-1);
            matchService.updateMatch(match);
        } else {

            // Reverse the previous updates to the teams
            Team team1 = match.getTeam1();
            Team team2 = match.getTeam2();

            // Decrement the number of games played
            team1.setNumberGame(team1.getNumberGame() - 1);
            team2.setNumberGame(team2.getNumberGame() - 1);

            // Reverse the points based on the previous match result
            int point1 = match.getPoint1();
            int point2 = match.getPoint2();

            if (point1 > point2) {
                team1.setPoint(team1.getPoint() - 3); // Reverse team 1's win
            } else if (point1 < point2) {
                team2.setPoint(team2.getPoint() - 3); // Reverse team 2's win
            } else if (point1 == point2 && point1 != -1 && point2 != -1) {
                team1.setPoint(team1.getPoint() - 1); // Reverse draw
                team2.setPoint(team2.getPoint() - 1); // Reverse draw
            }

            // Reverse the goal difference
            team1.setHs(team1.getHs() - (point1 - point2));
            team2.setHs(team2.getHs() - (point2 - point1));

            // Update the teams in the database
            teamService.updateTeams(team1);
            teamService.updateTeams(team2);

            // Update team rankings if necessary
            if (match.getRound().getIdRound() == 1) {
                int rankId = team1.getRank().getIdRank(); // Assuming both teams are in the same rank
                teamService.updateTeamRankings(rankId);
            }
            // Reset the match result
            match.setPoint1(-1);
            match.setPoint2(-1);
            matchService.updateMatch(match);
        }
            return "redirect:/admin/match"; // Redirect to the match list page
        }

}
