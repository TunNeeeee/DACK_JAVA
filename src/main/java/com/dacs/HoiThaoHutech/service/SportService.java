package com.dacs.HoiThaoHutech.service;

import com.dacs.HoiThaoHutech.models.Sport;
import com.dacs.HoiThaoHutech.repository.SportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SportService {
    @Autowired
    private SportRepository sportRepository;

    public List<Sport> getAllSports() {
        return sportRepository.findAll();
    }
    public Sport findById(Integer idSport) {
        return sportRepository.findById(idSport).orElse(null);
    }
    public List<Sport> getSportsByEvent(Integer idEvent) {
        return sportRepository.findByEvent_IdEvent(idEvent);
    }
    public Sport getSportById(Integer idSport) {
        return sportRepository.findById(idSport).orElse(null);
    }
    public List<Sport> searchSport(String keyword) {
        return List.of();
    }
    public Page<Sport> getAll(Integer pageNo) {
        Pageable pageable = PageRequest.of(pageNo - 1, 3);
        return sportRepository.findAll(pageable);
    }

    //add event
    public Boolean create(Sport sport) {
        try {
            sportRepository.save(sport);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    //update sport
    public Boolean update(Sport sport) {
        try {
            sportRepository.save(sport);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    // delete sport
    public boolean delete(Integer id) {
        try {
            sportRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public Page<Sport> searchSportPage(String keyword, Integer pageNo) {
        Pageable pageable = PageRequest.of(pageNo - 1, 3);
        List<Sport> sports = sportRepository.findBySportNameContaining(keyword);
        int start = Math.min((int) pageable.getOffset(), sports.size());
        int end = Math.min((start + pageable.getPageSize()), sports.size());
        return new PageImpl<>(sports.subList(start, end), pageable, sports.size());
    }
}
