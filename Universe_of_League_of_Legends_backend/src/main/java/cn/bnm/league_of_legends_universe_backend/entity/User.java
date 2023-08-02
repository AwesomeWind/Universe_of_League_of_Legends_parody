package cn.bnm.league_of_legends_universe_backend.entity;

public class User {
    /**
    * 用户名
    */
    private String username;

    /**
    * 用户邮箱
    */
    private String emil;

    /**
    * 用户密码
    */
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmil() {
        return emil;
    }

    public void setEmil(String emil) {
        this.emil = emil;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}