package com.evn.utilitypolemanagement.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "pricelist_pole")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PriceListPole {
    @Embeddable
    public static class Id implements Serializable {
        @Column(name = "PRICELIST_ID")
        private Integer priceListId;
        @Column(name = "POLE_ID")
        private Integer poleId;
        public Id(){}

        public Id(Integer priceListId, Integer poleId) {
            this.priceListId = priceListId;
            this.poleId = poleId;
        }

        public Integer getPriceListId() {
            return priceListId;
        }

        public Integer getPoleId() {
            return poleId;
        }
    }
    @EmbeddedId
    private Id id = new Id();

    @Column(name = "unit_price")
    private Double unitPrice;

    @CreationTimestamp
    private Timestamp created;

    @UpdateTimestamp
    private Timestamp updated;

    @ManyToOne
    @JoinColumn(
            name = "PRICELIST_ID",
            insertable = false, updatable = false)
    private PriceList priceList;

    @ManyToOne
    @JoinColumn(
            name = "POLE_ID",
            insertable = false, updatable = false)
    private Pole pole;


    public PriceListPole(PriceList priceList, Pole pole, Double unitPrice) {
        this.id.priceListId = priceList.getPriceListId();
        this.id.poleId = pole.getPoleId();
        this.priceList = priceList;
        this.pole = pole;
        this.unitPrice = unitPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PriceListPole that = (PriceListPole) o;
        return Objects.equals(id.getPoleId(), that.id.getPoleId())
                && Objects.equals(id.getPriceListId(), that.id.getPriceListId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
