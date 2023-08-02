package cn.bnm.league_of_legends_universe_backend.entity;

import java.util.Date;

public class Hero {
    /**
    * 原名
    */
    private String formerly;

    /**
    * 发布日期
    */
    private String releaseDate;

    /**
    * 译名
    */
    private String translation;

    /**
    * 称号
    */
    private String title;

    /**
    * 种族
    */
    private String races;

    /**
    * 相关地区
    */
    private String relevantRegion;

    /**
    * 位置
    */
    private String role;

    /**
    * 传记
    */
    private String biography;

    /**
    * 简介
    */
    private String synopsis;

    /**
    * 座右铭、口头禅
    */
    private String quote;

    /**
    * 相关人物
    */
    private String relatedPeople;

    /**
    * 海报文件名
    */
    private String posters;

    /**
    * 海报宽
    */
    private Integer width;

    /**
    * 海报高
    */
    private Integer height;

    /**
    * 海报中心坐标x
    */
    private Integer x;

    /**
    * 海报中心坐标y
    */
    private Integer y;

    public String getFormerly() {
        return formerly;
    }

    public void setFormerly(String formerly) {
        this.formerly = formerly;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRaces() {
        return races;
    }

    public void setRaces(String races) {
        this.races = races;
    }

    public String getRelevantRegion() {
        return relevantRegion;
    }

    public void setRelevantRegion(String relevantRegion) {
        this.relevantRegion = relevantRegion;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    public String getRelatedPeople() {
        return relatedPeople;
    }

    public void setRelatedPeople(String relatedPeople) {
        this.relatedPeople = relatedPeople;
    }

    public String getPosters() {
        return posters;
    }

    public void setPosters(String posters) {
        this.posters = posters;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }
}