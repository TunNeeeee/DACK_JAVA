package com.dacs.HoiThaoHutech.service;


import com.dacs.HoiThaoHutech.models.Member;
import com.dacs.HoiThaoHutech.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
    @Autowired
    private MemberRepository memberRepository;
    public void saveMember(Member member) {
        memberRepository.save(member);
    }
}
