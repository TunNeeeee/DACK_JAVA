package com.dacs.HoiThaoHutech.controller.Admin;

import com.dacs.HoiThaoHutech.models.Event;
import com.dacs.HoiThaoHutech.models.Status;
import com.dacs.HoiThaoHutech.repository.StatusRepository;
import com.dacs.HoiThaoHutech.service.EventService;
import com.dacs.HoiThaoHutech.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class EventController {
    @Autowired
    private EventService eventService;
    @Autowired
    private StatusService statusService;

    @GetMapping("/event")
    public String index(Model model, @Param("keyword") String keyword){
       List<Event> list = this.eventService.getAllEvents();
       if(keyword != null){
           list = this.eventService.searchEventsByKeyword(keyword);
           model.addAttribute("keyword",keyword);
       }
       model.addAttribute("list",list);
        return "admin/event/index";
    }
    @GetMapping("/add-event")
    public String add_event(Model model){
       Event event = new Event();
       model.addAttribute("status",statusService.getAll());
       model.addAttribute("event",event);
       return "admin/event/add";
    }
    @PostMapping("/add-event")
    public String add_event(@ModelAttribute("event") Event event){
        eventService.addEvent(event);
        return "redirect:/admin/event";
    }
    @GetMapping("/edit-event/{id}")
    public String edit(Model model, @PathVariable("id") Integer idEvent){
        Event event =this.eventService.findById(idEvent);
        model.addAttribute("statuses", statusService.getAll());
        model.addAttribute("event",event);
        return "/admin/event/edit";
    }
    @PostMapping("/edit-event/{id}")
    public String update(@PathVariable Integer id, @ModelAttribute("event")Event event){
        eventService.updateEvent(id,event);
        return "redirect:/admin/event";
    }
    @PostMapping("/delete-event/{id}")
    public String deleteEvent(@PathVariable Integer id) {
        Event event =this.eventService.findById(id);
        Status status = this.statusService.getById(4);
        event.setStatus(status);
        eventService.updateEvent(id,event);
        return "redirect:/admin/event";
    }

    @GetMapping("/search")
    public List<Event> searchEventsByKeyword(@RequestParam String keyword) {
        return eventService.searchEventsByKeyword(keyword);
    }

}
