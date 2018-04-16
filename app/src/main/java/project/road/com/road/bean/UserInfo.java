package project.road.com.road.bean;

/**
 * Created by suyufan on 2018/4/3.
 */

import java.util.Date;

/**
 * Created by Administrator on 2018/3/6.
 *
 * 用户信息的bean
 */

public class UserInfo {

    /**
     * 用户ID
     */
    private int user_id;

    /**
     * 登陆账户
     */
    private String account;

    /**
     * 密码
     */
    private String password;

    /**
     * 用户名
     */
    private String username;

    /**
     * 头像地址
     */
    private String picture;

    /**
     * 性别
     */
    private int sex;

    /**
     * 生日
     */
    private Date birthday;

    /**
     * 电子邮箱
     */
    private int email;


    /**
     * 个性签名
     */
    private int signature;


    public int getUser_id() {
        return user_id;
    }

    public String getAccount() {
        return account;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public String getPicture() {
        return picture;
    }

    public int getSex() {
        return sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public int getEmail() {
        return email;
    }

    public int getSignature() {
        return signature;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void setEmail(int email) {
        this.email = email;
    }

    public void setSignature(int signature) {
        this.signature = signature;
    }
}
