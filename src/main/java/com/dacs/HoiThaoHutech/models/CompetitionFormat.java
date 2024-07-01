package com.dacs.HoiThaoHutech.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Table(name = "CompetitionFormat")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompetitionFormat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idFormat;
    @Column(name = "format_name")
    private String formatName;
    @OneToMany(mappedBy = "format")
    private Set<Sport> ListSport;

}
