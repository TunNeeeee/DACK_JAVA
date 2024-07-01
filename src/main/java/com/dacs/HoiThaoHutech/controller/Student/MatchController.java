package com.dacs.HoiThaoHutech.controller.Student;

import com.dacs.HoiThaoHutech.models.Match;
import com.dacs.HoiThaoHutech.models.Sport;
import com.dacs.HoiThaoHutech.service.MatchService;
import com.dacs.HoiThaoHutech.service.SportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/student")
public class MatchController {
    @Autowired
    private MatchService matchService;
    @Autowired
    private SportService sportService;
    @GetMapping("/showListMatch")
    public String showListMatches(Model model) {
        List<Sport> sports =sportService.getAllSports();
        List<Match> matches = matchService.findAll();
        model.addAttribute("matches", matches);
        model.addAttribute("sports", sports);
        return "student/listMatches";
    }
}
