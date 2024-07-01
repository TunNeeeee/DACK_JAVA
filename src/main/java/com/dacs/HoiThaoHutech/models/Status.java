package com.dacs.HoiThaoHutech.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Table(name = "status")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Status {
    @Id
    private Integer idStatus;
    private String statusName;
    @OneToMany(mappedBy = "status")
    private Set<Event> listEvent;
}
