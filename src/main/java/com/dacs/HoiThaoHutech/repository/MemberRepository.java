package com.dacs.HoiThaoHutech.repository;


import com.dacs.HoiThaoHutech.models.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Integer> {
}
