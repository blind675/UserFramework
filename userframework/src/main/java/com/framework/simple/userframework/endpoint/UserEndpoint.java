package com.framework.simple.userframework.endpoint;

/**
 * Created by blind675 on 2/8/16.
 *
 */

import com.framework.simple.userframework.entity.User;
import com.framework.simple.userframework.persistance.OfyService;
import com.framework.simple.userframework.response.UserLightResponse;
import com.framework.simple.userframework.response.UserResponse;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.inject.Named;

/** An endpoint class we are exposing */
@Api(
        name = "userAPI",
        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "userframework.simple.framework.com",
                ownerName = "userframework.simple.framework.com",
                packagePath=""
        )
)
public class UserEndpoint {

    @ApiMethod(name = "createUser")
    public UserResponse createUser(@Named("email") String email, @Named("name") String name, @Named("password") String password) {

        UserResponse response;

        User user = OfyService.ofy().load().type(User.class).filter("email ==", email).first().now();

        if (user == null) {

            User newUser = new User();
            newUser.setName(name);
            newUser.setEmail(email);
            newUser.setPassword(password);

            OfyService.ofy().save().entity(newUser).now();

            response = new UserResponse(newUser);
            response.setStatusCode(0);
            response.setStatusMessage("ok");

        } else {

            response = new UserResponse();
            response.setStatusCode(1);
            response.setStatusMessage("User with same email already exists.");
        }

        return response;
    }

    @ApiMethod(name = "linkWithFacebook")
    public UserResponse linkWithFacebook(@Named("id")Long id, @Named("name") String name, @Named("facebook_id") String facebook_id, @Named("picture_url") String picture_url) {

        UserResponse response;

        User user = OfyService.ofy().load().type(User.class).filter("id ==", id).first().now();

        if (user != null) {

            User newUser = new User();
            newUser.setName(name);
            newUser.setFacebook_id(facebook_id);
            newUser.setPicture_url(picture_url);

            OfyService.ofy().save().entity(newUser).now();

            response = new UserResponse(newUser);
            response.setStatusCode(0);
            response.setStatusMessage("ok");

        } else {

            response = new UserResponse();
            response.setStatusCode(1);
            response.setStatusMessage("No user with id found.");
        }

        return response;
    }

    @ApiMethod(name = "loginUser")
    public UserResponse loginUser(@Named("email")String email, @Named("password") String password) {

        UserResponse response;

        User user = OfyService.ofy().load().type(User.class).filter("email ==", email).first().now();

        if (user != null) {

            if (user.getPassword().equals(password)) {

                response = new UserResponse(user);
                response.setStatusCode(0);
                response.setStatusMessage("ok");

            } else {

                response = new UserResponse();
                response.setStatusCode(2);
                response.setStatusMessage("Wrong password.");
            }

        } else {

            response = new UserResponse();
            response.setStatusCode(1);
            response.setStatusMessage("No user with email found.");
        }

        return response;
    }

    @ApiMethod(name = "getScoreList")
    public List<UserLightResponse> getScoreList(@Named("id")Long id) {

        List<User> users = OfyService.ofy().load().type(User.class).list();
        List<UserLightResponse> resultList = new ArrayList<>();

        // sort the array
        Collections.sort(users);

        for (User user : users) {
            UserLightResponse userLight = new UserLightResponse(user);
            resultList.add(userLight);

            userLight.setStatusCode(0);
            userLight.setStatusMessage("ok");
        }

        return resultList;
    }

    @ApiMethod(name = "addPoints")
    public UserResponse addPoints(@Named("id") Long id ,@Named("points") double points) {

        UserResponse response;

        User user = OfyService.ofy().load().type(User.class).filter("id ==", id).first().now();

        if (user != null) {

            user.setScore(user.getScore() + points);
            user.setScorePerMonth(user.getScorePerMonth() + points);

            OfyService.ofy().save().entity(user).now();

            response = new UserResponse(user);
            response.setStatusCode(0);
            response.setStatusMessage("ok");

        } else {

            response = new UserResponse();
            response.setStatusCode(1);
            response.setStatusMessage("No user with id found.");
        }

        return response;
    }
}
