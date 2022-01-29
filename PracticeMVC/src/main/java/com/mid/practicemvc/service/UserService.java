package com.mid.practicemvc.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mid.practicemvc.dto.UserDto;
import com.mid.practicemvc.entity.User;
import com.mid.practicemvc.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public String genId(){

        String alpahabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random rnd = new Random();
        String id = "";
        for (int i = 0; i < 3; i++) {
            id += alpahabet.charAt(rnd.nextInt(alpahabet.length()));
        }
         id +=  rnd.nextInt(999);

        return id;
    }

    public boolean checkAge(int age){
       return age > 0 ? true : false;
    }
    public boolean checkDistance(Double dis){
        return dis > 0 && dis <=10 ? true : false;
    }

    public List<UserDto> showAll(){
        ObjectMapper objectMapper = new ObjectMapper();
        List<User> users = userRepository.findAll();
        List<UserDto> userDtoList = new ArrayList<>();
        for (User user:users) {
            UserDto userDto = objectMapper.convertValue(user,UserDto.class);
            userDtoList.add(userDto);
        }
        return userDtoList;
    }


    public User addUser(UserDto userDtoReq) throws Exception {
        User user = new User();
        user.setId(genId());
        user.setFullName(userDtoReq.getFullName());
        user.setLastName(userDtoReq.getLastName());
       // checkAge(userDtoReq.getAge()) ==  true ? user.setAge(userDtoReq.getAge()) ;
        if(checkAge(userDtoReq.getAge())){
            user.setAge(userDtoReq.getAge());
            return userRepository.save(user);
        }
        throw new Exception("Age must be more than zero");
    }

    public User addDistanceFromId(String id, Double distance) throws Exception {
        User user;
        try {
            if (checkDistance(distance)) {
                user = userRepository.findById(id).get();
                user.setDistance(user.getDistance() + distance);
                return userRepository.save(user);
            } throw new Exception();
        } catch (Exception e) {
            throw new Exception("Distance must not more than 10 or Id is null");
        }
    }
    public List<UserDto> showUserPrice() throws Exception{


    }
}
