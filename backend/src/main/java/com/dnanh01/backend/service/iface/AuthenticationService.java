package com.dnanh01.backend.service.iface;

import com.dnanh01.backend.dto.request.AuthenticationRequest;
import com.dnanh01.backend.dto.response.AuthenticationResponse;

public interface AuthenticationService {
    AuthenticationResponse authenticate(AuthenticationRequest authenticationRequest);
}
