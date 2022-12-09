package com.niit.jdp.UserAuthentication.service;

import com.niit.jdp.UserAuthentication.domain.UserModel;

import java.util.Map;

public interface SecurityTokenGenerator
{
    public abstract Map<String, String> generateToken(UserModel user);


}
