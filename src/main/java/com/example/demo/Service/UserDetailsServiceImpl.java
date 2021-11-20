package com.example.demo.Service;


import com.example.demo.Authentication.MyUserDetails;
import com.example.demo.Model.User;
import com.example.demo.Repository.UserRepository;
import com.example.demo.dto.request.UserRegisterRequest;
import com.example.demo.enums.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService ,UserService{

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
  public static  Long userId;

    public UserDetailsServiceImpl() {
    }

 
    @Override
    public UserDetails loadUserByUsername(String user_name)
            throws UsernameNotFoundException {
        User user = userRepository.getUserByUsername(user_name);
        userId=user.getId();

        if (user == null) {
            throw new UsernameNotFoundException("Could not find user");
        }

        return new MyUserDetails(user);
    }


    @Override
    public void registerUser(UserRegisterRequest userRegisterRequest) throws Exception {
try {
    User user = new User();
    if (checkIfUserExist(userRegisterRequest.getUser_name()))
        throw new Exception("User with " + userRegisterRequest.getUser_name() + " is already exist");
    user.setUsername(userRegisterRequest.getUser_name());
    user.setPassword(passwordEncoder.encode(userRegisterRequest.getPassword()));
    user.setEnabled(true);
    user.setUserRole(UserRole.VISITOR);//defualtRule
    userRepository.save(user);

}catch ( Exception e){

throw  e;
}


    }

    @Override
    public boolean checkIfUserExist(String user_name) {
        return userRepository.findByUsername(user_name) != null;
    }

}