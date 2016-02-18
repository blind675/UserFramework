package com.framework.simple.userframework.response;

import com.framework.simple.userframework.entity.User;

/**
 * Created by blind675 on 2/5/16.
 *
 */

public class UserResponse extends UserLightResponse{

    String email;
    String password;
    String facebook_id;
    String googlePlus_id;

    public UserResponse(User user){
        super();

        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.facebook_id = user.getFacebook_id();
        this.googlePlus_id = user.getGooglePlus_id();
        this.picture_url = user.getPicture_url();
        this.score = user.getScore();
        this.scorePerMonth = user.getScorePerMonth();
    }

    public UserResponse(){
        super();
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFacebook_id() {
        return facebook_id;
    }

    public void setFacebook_id(String facebook_id) {
        this.facebook_id = facebook_id;
    }

    public String getGooglePlus_id() {
        return googlePlus_id;
    }

    public void setGooglePlus_id(String googlePlus_id) {
        this.googlePlus_id = googlePlus_id;
    }

    public String getPicture_url() {
        return picture_url;
    }

    public void setPicture_url(String picture_url) {
        this.picture_url = picture_url;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public double getScorePerMonth() {
        return scorePerMonth;
    }

    public void setScorePerMonth(double scorePerMonth) {
        this.scorePerMonth = scorePerMonth;
    }
}
