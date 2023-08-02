package cn.bnm.league_of_legends_universe_backend.entity;

public class Races {
    /**
    * 原名
    */
    private String formerly;

    /**
    * 译名
    */
    private String translation;

    /**
    * 简介
    */
    private String synopsis;

    public String getFormerly() {
        return formerly;
    }

    public void setFormerly(String formerly) {
        this.formerly = formerly;
    }

    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }
}