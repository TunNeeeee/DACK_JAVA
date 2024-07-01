package com.dacs.HoiThaoHutech.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "Event")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEvent;
    @Column(name = "eventName")
    private String eventName;
    @Column(name = "time_start")
    private LocalDate timeStart;
    @Column(name = "time_end")
    private LocalDate timeEnd;
    @Column(name = "number_sport")
    private Integer numberSport;
    @ManyToOne
    @JoinColumn(name="id_status")
    private Status status;
    @OneToMany(mappedBy = "event")
    private Set<Sport> listSport;
}
