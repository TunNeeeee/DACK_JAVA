package com.dacs.HoiThaoHutech.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "RuleDetail")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RuleDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idRuleDetail;
    @ManyToOne
    @JoinColumn(name="id_team")
    private Team team;
    @ManyToOne
    @JoinColumn(name="id_rule")
    private Rule rule;
    @Column(name = "count_vp")
    private Integer countVP;

}
