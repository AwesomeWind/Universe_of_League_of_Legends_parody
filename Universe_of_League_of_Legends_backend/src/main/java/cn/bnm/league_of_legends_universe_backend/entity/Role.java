package cn.bnm.league_of_legends_universe_backend.entity;

public class Role {
    /**
    * 角色定位原名
    */
    private String title;

    /**
    * 角色定位译名
    */
    private String name;

    /**
    * icon标签名称

    */
    private String icon;

    /**
    * 职业介绍
    */
    private String briefly;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getBriefly() {
        return briefly;
    }

    public void setBriefly(String briefly) {
        this.briefly = briefly;
    }
}