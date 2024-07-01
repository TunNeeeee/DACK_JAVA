package com.dacs.HoiThaoHutech.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Table(name = "Team")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTeam;
    @Column(name = "team_name")
    private String teamName;
    @Column(name = "number")
    private String number;
    @Column(name = "cap_name")
    private String captainName;
    @Column(name = "status")
    private Integer status;
    @Column(name = "number_game")
    private Integer numberGame;
    @Column(name = "point")
    private Integer point;
    @Column(name = "hs")
    private Integer hs;
    @Column(name = "no_rank")
    private Integer noRank;
    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;
    @ManyToOne
    @JoinColumn(name = "id_sport")
    private Sport sport;
    @OneToMany(mappedBy = "team")
    private Set<Member> listMember;
    @OneToMany(mappedBy = "team1")
    private Set<Match> homeMatches;

    @OneToMany(mappedBy = "team2")
    private Set<Match> awayMatches;
    @OneToMany(mappedBy = "team")
    private Set<RuleDetail> listRuleDetail;
    @ManyToOne
    @JoinColumn(name = "id_rank")
    private Rank rank;
    @Column
    private int noFinal;
}
