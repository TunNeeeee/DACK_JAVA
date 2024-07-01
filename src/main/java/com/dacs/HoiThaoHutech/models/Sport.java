package com.dacs.HoiThaoHutech.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "Sport")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Sport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idSport;
    @Column(name = "sport_name")
    private String sportName;
    @Column(name = "time_start")
    private LocalDate startDate;
    @Column(name = "time_end")
    private LocalDate endDate;
    @Column(name = "number_team")
    private Integer numberTeam;
    @Column(name = "number_member")
    private Integer numberMember;
    @Column(name = "PhiKyQuy")
    private Integer phiKyQuy;
    @Column(name = "PhiThamGia")
    private Integer phiThamGia;
    @ManyToOne
    @JoinColumn(name="idEvent")
    private Event event;
    @OneToMany(mappedBy = "sport")
    private Set<Location> listLocation;
    @OneToMany(mappedBy = "sport")
    private Set<Team> listTeam;
    @ManyToOne
    @JoinColumn(name="idFormat")
    private CompetitionFormat format;
    @Column
    private Integer status;

}
