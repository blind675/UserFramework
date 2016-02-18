package com.framework.simple.userframework.response;

import com.framework.simple.userframework.entity.User;

/**
 * Created by blind675 on 2/5/16.
 *
 */

public class UserLightResponse extends GenericResponse {

    Long id;
    String name;
    String picture_url;
    double score;
    double scorePerMonth;

    public UserLightResponse(User user){
        this.id = user.getId();
        this.name = user.getName();
        this.picture_url = user.getPicture_url();
        this.score = user.getScore();
        this.scorePerMonth = user.getScorePerMonth();
    }

    public UserLightResponse() {

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
