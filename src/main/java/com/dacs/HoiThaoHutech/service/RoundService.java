package com.dacs.HoiThaoHutech.service;

import com.dacs.HoiThaoHutech.models.Round;
import com.dacs.HoiThaoHutech.repository.RoundRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoundService {
    @Autowired
    private RoundRepository roundRepository;
    public List<Round> getAllRound() {
        return roundRepository.findAll();
    }
}
