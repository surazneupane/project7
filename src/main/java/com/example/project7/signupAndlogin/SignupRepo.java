package com.example.project7.signupAndlogin;

import org.springframework.data.repository.CrudRepository;

public interface SignupRepo  extends CrudRepository<SignupData,Integer> {

SignupData findByUsername(String userName );
SignupData findByEmail(String email);
SignupData findByUsernameAndUserpassword(String userName,String userpassword);


}
