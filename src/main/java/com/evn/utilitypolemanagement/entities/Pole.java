package com.evn.utilitypolemanagement.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
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
