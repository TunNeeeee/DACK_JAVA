package com.dacs.HoiThaoHutech.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Table(name = "round")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Round {
    @Id
    private Integer idRound;
    private String roundName;
    @OneToMany(mappedBy = "round")
    private Set<Match> listMatch;
}
