package com.dacs.HoiThaoHutech.repository;


import com.dacs.HoiThaoHutech.models.Event;
import com.dacs.HoiThaoHutech.models.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface EventRepository extends JpaRepository<Event, Integer> {
    List<Event> findByEventNameContainingIgnoreCase(String keyword);
    List<Event> findByStatus(Status status);
}
