package cn.bnm.league_of_legends_universe_backend.entity;

public class Region {
    /**
    * 地区原名
    */
    private String formerly;

    /**
    * 地区译名
    */
    private String translation;

    /**
    * 地区icon标签储存名
    */
    private String icon;

    /**
    * 地区徽章储存名
    */
    private String emblem;

    /**
    * 地区描述
    */
    private String description;

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

    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }

    public String geticon() {
        return icon;
    }

    public void seticon(String icon) {
        this.icon = icon;
    }

    public String getemblem() {
        return emblem;
    }

    public void setemblem(String emblem) {
        this.emblem = emblem;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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