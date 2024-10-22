package com.evn.utilitypolemanagement.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "cable_type")
public class CableType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cableTypeId;

    @Column(nullable = false,unique = true)
    private String cableTypeName;
}
