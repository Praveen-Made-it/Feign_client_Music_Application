package com.niit.jdp.UserAuthentication.service;

import com.niit.jdp.UserAuthentication.domain.UserModel;
import com.niit.jdp.UserAuthentication.exception.UserAlreadyExistException;
import com.niit.jdp.UserAuthentication.exception.UserNotFoundException;

public interface UserService
{
    public abstract UserModel addUser(UserModel user) throws UserAlreadyExistException;
    public abstract UserModel loginCheck(String email , String userPassword) throws UserNotFoundException;

}
