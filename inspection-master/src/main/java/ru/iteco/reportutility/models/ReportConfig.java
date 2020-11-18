package ru.iteco.reportutility.models;

/**
 * ReportConfig.
 *
 * @author Ilya_Sukhachev
 */
public class ReportConfig {

    private boolean withData;

    private boolean withIndex;
    private boolean withTotalVolume;
    private boolean withTotalWeight;

    private boolean volumeSum;
    private boolean weightSum;
    private boolean costSum;
    private boolean countSum;

    private boolean noVolume;
    private boolean noWeight;
    private boolean noCost;
    private boolean noCount;

    /*
     * Убрал страшный конструктор. Будем присваивать через сеттеры.
     */
    public ReportConfig() {
        this.withData = false;
        this.withIndex = false;
        this.withTotalVolume = false;
        this.withTotalWeight = false;
        this.volumeSum = false;
        this.weightSum = false;
        this.costSum = false;
        this.countSum = false;
        this.noVolume = false;
        this.noWeight = false;
        this.noCost = false;
        this.noCount = false;
    }

    public boolean isWithData() {
        return withData;
    }

    public void setWithData(boolean withData) {
        this.withData = withData;
    }

    public boolean isWithIndex() {
        return withIndex;
    }

    public void setWithIndex(boolean withIndex) {
        this.withIndex = withIndex;
    }

    public boolean isWithTotalVolume() {
        return withTotalVolume;
    }

    public void setWithTotalVolume(boolean withTotalVolume) {
        this.withTotalVolume = withTotalVolume;
    }

    public boolean isWithTotalWeight() {
        return withTotalWeight;
    }

    public void setWithTotalWeight(boolean withTotalWeight) {
        this.withTotalWeight = withTotalWeight;
    }

    public boolean isVolumeSum() {
        return volumeSum;
    }

    public void setVolumeSum(boolean volumeSum) {
        this.volumeSum = volumeSum;
    }

    public boolean isWeightSum() {
        return weightSum;
    }

    public void setWeightSum(boolean weightSum) {
        this.weightSum = weightSum;
    }

    public boolean isCostSum() {
        return costSum;
    }

    public void setCostSum(boolean costSum) {
        this.costSum = costSum;
    }

    public boolean isCountSum() {
        return countSum;
    }

    public void setCountSum(boolean countSum) {
        this.countSum = countSum;
    }

    public boolean isNoVolume() {
        return noVolume;
    }

    public void setNoVolume(boolean noVolume) {
        this.noVolume = noVolume;
    }

    public boolean isNoWeight() {
        return noWeight;
    }

    public void setNoWeight(boolean noWeight) {
        this.noWeight = noWeight;
    }

    public boolean isNoCost() {
        return noCost;
    }

    public void setNoCost(boolean noCost) {
        this.noCost = noCost;
    }

    public boolean isNoCount() {
        return noCount;
    }

    public void setNoCount(boolean noCount) {
        this.noCount = noCount;
    }
}
