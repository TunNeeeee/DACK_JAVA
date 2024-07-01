package com.dacs.HoiThaoHutech.controller;


import com.dacs.HoiThaoHutech.models.Sport;
import com.dacs.HoiThaoHutech.service.SportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SportApiController {
    @Autowired
    private SportService sportService;

    @GetMapping("/sports")
    public List<Sport> getSportsByEvent(@RequestParam Integer idEvent) {
        return sportService.getSportsByEvent(idEvent);
    }
    @GetMapping("/sports/{idSport}")
    public Sport getSportById(@PathVariable Integer idSport) {
        return sportService.getSportById(idSport);
    }
}