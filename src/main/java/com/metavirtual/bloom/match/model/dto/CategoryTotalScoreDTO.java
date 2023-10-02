package com.metavirtual.bloom.match.model.dto;

public class CategoryTotalScoreDTO {
    private int depressionTotalScore;
    private int anxietyTotalScore;
    private int bipolarTotalScore;
    private int ocdTotalScore;

    public CategoryTotalScoreDTO() {
    }

    public CategoryTotalScoreDTO(int depressionTotalScore, int anxietyTotalScore, int bipolarTotalScore, int ocdTotalScore) {
        this.depressionTotalScore = depressionTotalScore;
        this.anxietyTotalScore = anxietyTotalScore;
        this.bipolarTotalScore = bipolarTotalScore;
        this.ocdTotalScore = ocdTotalScore;
    }

    public int getDepressionTotalScore() {
        return depressionTotalScore;
    }

    public void setDepressionTotalScore(int depressionTotalScore) {
        this.depressionTotalScore = depressionTotalScore;
    }

    public int getAnxietyTotalScore() {
        return anxietyTotalScore;
    }

    public void setAnxietyTotalScore(int anxietyTotalScore) {
        this.anxietyTotalScore = anxietyTotalScore;
    }

    public int getBipolarTotalScore() {
        return bipolarTotalScore;
    }

    public void setBipolarTotalScore(int bipolarTotalScore) {
        this.bipolarTotalScore = bipolarTotalScore;
    }

    public int getOcdTotalScore() {
        return ocdTotalScore;
    }

    public void setOcdTotalScore(int ocdTotalScore) {
        this.ocdTotalScore = ocdTotalScore;
    }

    @Override
    public String toString() {
        return "CategoryTotalScoreDTO{" +
                "depressionTotalScore=" + depressionTotalScore +
                ", anxietyTotalScore=" + anxietyTotalScore +
                ", bipolarTotalScore=" + bipolarTotalScore +
                ", ocdTotalScore=" + ocdTotalScore +
                '}';
    }
}
