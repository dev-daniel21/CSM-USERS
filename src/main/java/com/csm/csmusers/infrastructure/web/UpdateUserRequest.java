package com.csm.csmusers.infrastructure.web;

import java.io.Serializable;

public record UpdateUserRequest(
        String newLogin,
        String userPassword,
        String firstName,
        String lastName
) implements Serializable {

}
