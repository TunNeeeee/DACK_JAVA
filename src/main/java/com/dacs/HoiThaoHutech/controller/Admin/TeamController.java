package com.dacs.HoiThaoHutech.controller.Admin;

import com.dacs.HoiThaoHutech.models.Rank;
import com.dacs.HoiThaoHutech.models.Sport;
import com.dacs.HoiThaoHutech.models.Team;
import com.dacs.HoiThaoHutech.service.RankService;
import com.dacs.HoiThaoHutech.service.SportService;
import com.dacs.HoiThaoHutech.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class TeamController {
    @Autowired
    private TeamService teamService;
    @Autowired
    private SportService sportService;
    @Autowired
    private RankService rankService;

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

        return "admin/team/list";
    }

    @GetMapping("/teams")
    public String showTeamReg(Model model) {
        List<Team> teams = teamService.getAllTeamsReg();
        model.addAttribute("teams", teams);
        return "admin/team/index";
    }
    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
        Team team = teamService.getTeamById(id);
        model.addAttribute("sports",sportService.getAllSports());
        model.addAttribute("team", team);
        return "admin/team/edit";
    }

    @GetMapping("/edit-team/{id}")
    public String updateTeam(@PathVariable("id") Integer id, @ModelAttribute("team") Team teamDetails) {
        teamService.updateTeam(id, teamDetails);
        return "redirect:/admin/teams";
    }
    @PostMapping("/approve/{id}")
    public String approveTeam(@PathVariable("id") Integer id) {
        Team team = teamService.getTeamById(id);
        team.setStatus(2); // Chuyển status từ 1 sang 2
        team.setNumberGame(0);
        team.setPoint(0);
        team.setHs(0);
        teamService.saveTeam(team); // Lưu thông tin đội vào cơ sở dữ liệu
        return "redirect:/admin/teams"; // Chuyển hướng về trang danh sách đội
    }
    @PostMapping("/remove/{id}")
    public String removeTeam(@PathVariable("id") Integer id) {
        Team team = teamService.getTeamById(id);
        team.setStatus(-1); // Chuyển status từ 1 sang -1
        teamService.saveTeam(team); // Lưu thông tin đội vào cơ sở dữ liệu
        return "redirect:/admin/teams"; // Chuyển hướng về trang danh sách đội
    }
    @PostMapping("/delete/{id}")
    public String deleteTeam(@PathVariable("id") Integer id) {
        teamService.deleteTeam(id);
        return "redirect:/admin/teams";
    }
    @GetMapping("/eliminate-team/{idTeam}")
    public String eliminateTeam(@PathVariable Integer idTeam, RedirectAttributes redirectAttributes) {
        // Gọi service để cập nhật status của đội
        teamService.eliminateTeam(idTeam);
        redirectAttributes.addFlashAttribute("message", "Đội đã bị loại thành công.");
        return "redirect:/admin/rank";
    }
    @GetMapping("/team-add-rank/{id}")
    public String addRank(@PathVariable("id") Integer id, Model model) {
        Team team = teamService.getTeamById(id);
        model.addAttribute("ranks",rankService.getAllRank());
        model.addAttribute("team", team);
        return "admin/team/add-rank";
    }
    @PostMapping("/team-add-rank")
    public String addRank(@RequestParam("idTeam") int idTeam, @RequestParam("idRank") int idRank) {
        Team team = teamService.getTeamById(idTeam);
        Rank rank = rankService.getRankById(idRank);
        team.setRank(rank);
        teamService.saveTeam(team);
        return "redirect:/admin/list-team";
    }
}
