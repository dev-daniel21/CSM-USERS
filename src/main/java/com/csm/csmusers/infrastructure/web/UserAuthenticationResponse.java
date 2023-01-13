package com.csm.csmusers.infrastructure.web;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.extern.jackson.Jacksonized;

@AllArgsConstructor
@Jacksonized
class UserAuthenticationResponse {
    @JsonProperty
    String userId;
    @JsonProperty
    boolean isAuthenticated;
}
