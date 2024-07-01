package com.dacs.HoiThaoHutech.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Table(name = "Arena")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Arena {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idArena;
    @Column(name = "name_arena")
    private String nameArena;
    @Column(name = "capacity")
    private String capacity;
    @OneToMany(mappedBy = "arena")
    private Set<Match> listMatch;

}
