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
@Table(name = "pole")
public class Pole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer poleId;

    @Column(nullable = false, unique = true)
    private String poleName;

    @Column(nullable = false, unique = true)
    private String poleShortName;

    @Column(nullable = false)
    private Boolean isEnable;

    @CreationTimestamp
    private Timestamp created;

    @UpdateTimestamp
    private Timestamp updated;

}
