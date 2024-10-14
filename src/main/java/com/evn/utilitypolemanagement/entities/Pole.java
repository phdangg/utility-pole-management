package com.evn.utilitypolemanagement.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Pole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer poleId;

    @Column(nullable = false)
    private String poleName;

    @Column(nullable = false)
    private Boolean status;

    @CreationTimestamp
    private Timestamp created;

    @UpdateTimestamp
    private Timestamp updated;

}
