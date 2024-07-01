package com.dacs.HoiThaoHutech.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Table(name = "Achievement")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Achievement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAchievement;
    @OneToMany(mappedBy = "achievement")
    private Set<Rank> listrank;
    @Column(name = "award_name")
    private String awardName;
}
