package com.dacs.HoiThaoHutech.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "`Rank`")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Rank {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idRank;
    @Column
    private String nameRank;
    @OneToMany(mappedBy = "rank")
    private List<Team> listTeam;
    @ManyToOne
    @JoinColumn(name = "id_achievement")
    private Achievement achievement;
}
