package com.cs.ln.user.model;

import java.io.Serializable;

/**
 * 用户模型
 *
 * @Author liuchsh
 * @date 2018/9/22
 */
public class User implements Serializable {

    private static final long serialVersionUID = -9069174476215821354L;
    private long id;

    private String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("User{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
