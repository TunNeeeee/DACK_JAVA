package com.dacs.HoiThaoHutech.service;

import com.dacs.HoiThaoHutech.models.Status;
import com.dacs.HoiThaoHutech.repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatusService {
    @Autowired
    private StatusRepository statusRepository;
    public List<Status> getAll() {
        return statusRepository.findAll();
    }
    public Status getById(int id) {
        return statusRepository.findByIdStatus(id);
    }
}
