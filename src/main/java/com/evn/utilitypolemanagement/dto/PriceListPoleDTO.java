package com.evn.utilitypolemanagement.dto;

public class PriceListPoleDTO {
    private Integer priceListId;
    private Integer poleId;
    private Double unitPrice;

    public PriceListPoleDTO() {}

    public PriceListPoleDTO(Integer priceListId, Integer poleId, Double unitPrice) {
        this.priceListId = priceListId;
        this.poleId = poleId;
        this.unitPrice = unitPrice;
    }

    public Integer getPriceListId() {
        return priceListId;
    }

    public void setPriceListId(Integer priceListId) {
        this.priceListId = priceListId;
    }

    public Integer getPoleId() {
        return poleId;
    }

    public void setPoleId(Integer poleId) {
        this.poleId = poleId;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }
}
