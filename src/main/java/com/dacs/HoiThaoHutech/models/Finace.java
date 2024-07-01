package com.dacs.HoiThaoHutech.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Finace")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Finace {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idFinace;
    @Column(name = "finace_name")
    private String finaceName;
    @Column(name = "sum_finace")
    private Integer sum;
}
