package com.dacs.HoiThaoHutech.controller.Student;


import com.dacs.HoiThaoHutech.models.*;
import com.dacs.HoiThaoHutech.repository.UserRepository;
import com.dacs.HoiThaoHutech.service.EventService;
import com.dacs.HoiThaoHutech.service.MemberService;
import com.dacs.HoiThaoHutech.service.SportService;
import com.dacs.HoiThaoHutech.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/student/registration")
public class RegistrationController {

    @Autowired
    private EventService eventService;
    @Autowired
    private TeamService teamService;
    @Autowired
    private MemberService memberService;
    @Autowired
    private SportService sportService;
    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public ModelAndView Event() {
        ModelAndView view = new ModelAndView();
        view.setViewName("student/registration");
        Status status = new Status();
        status.setIdStatus(1);
        List<Event> events = eventService.getEventsByStatus(status);
//        events.forEach(event -> System.out.println("Event: " + event.getEventName())); // In log để kiểm tra
        view.addObject("events", events);
        return view;
    }

    @PostMapping("/confirm")
    public String registerForEvent(
            @RequestParam("sport") Integer idSport,
            @RequestParam String teamName,
            @RequestParam String captainName,
            @RequestParam String captainPhone,
            @RequestParam List<String> members,
            @AuthenticationPrincipal UserDetails user
    ) {
        if (user == null) {
            // Xử lý trường hợp user là null
            return "User not authenticated";
        }
        User currentUser = userRepository.findByUsername(user.getUsername());
        // Find the Sport object by its ID
        Sport sport = sportService.getSportById(idSport);
        if (sport == null) {
            // Xử lý khi không tìm thấy môn thể thao
            return "redirect:/registration?error=sport_not_found";
        }
        // Nhật ký đối tượng Sport tìm được
        System.out.println("Found sport: " + sport.getSportName());
        // Tạo và lưu đội
        Team team = new Team();
        team.setUser(currentUser);
        team.setTeamName(teamName);
        team.setCaptainName(captainName);
        team.setNumber(captainPhone);
        team.setSport(sport);
        team.setStatus(1);
        team.setNoFinal(sport.getNumberTeam());
        teamService.saveTeam(team);

        // Lưu đội trưởng
        Member captain = new Member();
        captain.setNameMember(captainName);
        captain.setTeam(team);
        memberService.saveMember(captain);

        // Lưu các thành viên khác
        for (String memberName : members) {
            Member member = new Member();
            member.setNameMember(memberName);
            member.setTeam(team);
            memberService.saveMember(member);
        }

        return "redirect:/student";
    }
}