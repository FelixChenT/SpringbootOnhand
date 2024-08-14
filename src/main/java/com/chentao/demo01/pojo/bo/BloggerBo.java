package com.chentao.demo01.pojo.bo;

public class BloggerBo {

    private Long id;
    private String name;
    private String pass;

    // 构造函数
    public BloggerBo(Long id, String name, String password) {
        this.id = id;
        this.name = name;
        this.pass = password;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}