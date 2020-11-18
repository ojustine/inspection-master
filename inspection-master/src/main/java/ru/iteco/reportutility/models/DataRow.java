package ru.iteco.reportutility.models;

import java.math.BigDecimal;

/**
 * DataRow.
 *
 * @author Ilya_Sukhachev
 */
public class DataRow {

    private String name;
    private BigDecimal volume;
    private BigDecimal weight;
    private BigDecimal cost;
    private BigDecimal count;

    /*
     * Параметры теперь в таком же порядке, как в ресурсных файлах
     */
    public DataRow(String name, BigDecimal volume, BigDecimal weight, BigDecimal cost, BigDecimal count) {
        this.name = name;
        this.volume = volume;
        this.weight = weight;
        this.cost = cost;
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getVolume() {
        return volume;
    }

    public void setVolume(BigDecimal volume) {
        this.volume = volume;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public BigDecimal getCount() {
        return count;
    }

    public void setCount(BigDecimal count) {
        this.count = count;
    }
}
