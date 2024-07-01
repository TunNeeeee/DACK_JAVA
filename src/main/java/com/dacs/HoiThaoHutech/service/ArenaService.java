package com.dacs.HoiThaoHutech.service;

import com.dacs.HoiThaoHutech.models.Arena;

import com.dacs.HoiThaoHutech.repository.ArenaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArenaService {
    @Autowired
    private ArenaRepository arenaRepository;
    public List<Arena> getAllArena() {
        return arenaRepository.findAll();
    }
}
