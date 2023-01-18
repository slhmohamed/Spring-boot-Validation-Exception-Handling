package org.sid.validationexceptionhandling.service;

import lombok.RequiredArgsConstructor;
import net.bytebuddy.implementation.bytecode.Throw;
import org.sid.validationexceptionhandling.dto.UserRequest;
import org.sid.validationexceptionhandling.entity.User;
import org.sid.validationexceptionhandling.exception.UserNotFoundException;
import org.sid.validationexceptionhandling.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User saveUser(UserRequest userRequest){
        User user=User.build(0,userRequest.getName(),userRequest.getEmail(),userRequest.getMobile(),userRequest.getGender(),
                userRequest.getAge(),userRequest.getNationality());
        return userRepository.save(user);
    }

    public List<User> listUser(){
        return userRepository.findAll();
    }

    public User singleUser(int id)throws UserNotFoundException{

        User user= userRepository.findByUserId(id);
        if(user!=null){
            return user;
        }else{
            throw new UserNotFoundException("user not found with this id:"+id);
        }
    }


}
