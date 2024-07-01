package com.dacs.HoiThaoHutech.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Location")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idLocation;
    @Column(name = "name_location")
    private String locationName;
    @Column(name = "address")
    private String address;
    @ManyToOne
    @JoinColumn(name="id_sport")
    private Sport sport;

}
