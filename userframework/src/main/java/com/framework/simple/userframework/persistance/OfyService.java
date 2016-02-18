package com.framework.simple.userframework.persistance;

import com.framework.simple.userframework.entity.User;
import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyFactory;
import com.googlecode.objectify.ObjectifyService;

/**
 * Created by blind675 on 2/8/16.
 *
 * Objectify service wrapper so we can statically register our persistence classes
 * More on Objectify here : https://code.google.com/p/objectify-app engine/
 */

public class OfyService {

    static {
        ObjectifyService.register(User.class);
        init();
    }

    public static Objectify ofy() {
        return ObjectifyService.ofy();
    }

    public static ObjectifyFactory factory() {
        return ObjectifyService.factory();
    }

    public static void init() {
        System.out.println("---INIT---");

    }
}
