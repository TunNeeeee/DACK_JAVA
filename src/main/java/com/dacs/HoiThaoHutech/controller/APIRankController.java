package com.dacs.HoiThaoHutech.controller;

import com.dacs.HoiThaoHutech.models.Rank;
import com.dacs.HoiThaoHutech.service.RankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/rank")
public class APIRankController {
    @Autowired
    private RankService rankService;

    @PostMapping("/create")
    public Rank createRankWithTeams(@RequestParam String nameRank, @RequestParam Integer idSport) {
        return rankService.createRankWithTeams(nameRank, idSport);
    }
}
