package com.framework.simple.userframework.response;

/**
 * Created by blind675 on 2/8/16.
 *
 */
public class GenericResponse {

    int statusCode;
    String statusMessage;

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }


}
