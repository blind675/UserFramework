package com.framework.simple.userframework.entity;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;

/**
 * Created by blind675 on 2/4/16.
 *
 */
@Entity
public class User implements Comparable<User> {

    @Id
    Long id;

    @Index
    String email;

    String name;
    String password;
    String facebook_id;
    String googlePlus_id;
    String picture_url;
    double score;
    double scorePerMonth;

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

    @Override
    public int compareTo(User other) {
        if (score < other.score) {
            return -1;
        } else if (score > other.score) {
            return 1;
        } else {
            return 0;
        }
    }

}
