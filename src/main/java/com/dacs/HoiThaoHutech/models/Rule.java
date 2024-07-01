package com.dacs.HoiThaoHutech.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Table(name = "Rule")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Rule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idRule;
    @Column(name = "name_rule")
    private String nameRule;
    @Column(name = "fines")
    private Integer fines;
    @OneToMany(mappedBy = "rule")
    private Set<RuleDetail> listRuleDetails;

}
