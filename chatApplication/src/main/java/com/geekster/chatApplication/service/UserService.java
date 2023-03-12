package com.geekster.chatApplication.service;

import com.geekster.chatApplication.dao.UserRepository;
import com.geekster.chatApplication.model.Users;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class UserService {


    @Autowired
    UserRepository userRepository;

    public JSONArray getUsers(String userId) {
        JSONArray response = new JSONArray();
        if(null != userId){
            List<Users> userList = userRepository.getUserByUserId(Integer.parseInt(userId));
            for (Users user: userList) {
                JSONObject userObj = createResponse(user);
                response.put(userObj);
            }
        }
        else{
            List<Users> userList = userRepository.getAllUsers();
            for (Users user: userList) {
                JSONObject userObj = createResponse(user);
                response.put(userObj);
            }
        }
        return response;
    }

    private  JSONObject createResponse(Users user) {

        JSONObject jsonObj = new JSONObject();

        jsonObj.put("userId",user.getUserId());
        jsonObj.put("username",user.getUsername());
        jsonObj.put("firstName",user.getFirstName());
        jsonObj.put("lastName",user.getLastName());
        jsonObj.put("age",user.getAge());
        jsonObj.put("email",user.getEmail());
        jsonObj.put("phoneNumber",user.getPhoneNumber());
        jsonObj.put("gender",user.getGender());
        jsonObj.put("createdDate",user.getCreatedDate());

        return jsonObj;

    }

    public void deleteUserByUserId(int userId) {
        userRepository.deleteUserByUserId(userId);
    }

    public int saveUser(Users user) {
        Users userObj = userRepository.save(user);
        return userObj.getUserId();
    }

    public JSONObject login(String username, String password) {
        JSONObject response = new JSONObject();
        List<Users> user = userRepository.findByUsername(username);
        if(user.isEmpty()){
            response.put("errorMessage","Username doesn't exist");
        }
        else{
            Users userObj = user.get(0);
            if(password.equals(userObj.getPassword())){
                response = createResponse(userObj);
            }
            else{
                response.put("errorMessage","password is not valid");
            }
        }
        return response;
    }

    public JSONObject updateUser(Users newUser, String userId) {
         List<Users> usersList = userRepository.getUserByUserId(Integer.valueOf(userId));
        JSONObject obj = new JSONObject();
         if(!usersList.isEmpty()){
             Users oldUser = usersList.get(0);
             newUser.setUserId(oldUser.getUserId());
             newUser.setCreatedDate(oldUser.getCreatedDate());
             newUser.setPassword(oldUser.getPassword());
             Timestamp updatedTime = new Timestamp(System.currentTimeMillis());
             newUser.setUpdatedDate(updatedTime);
             userRepository.save(newUser);
         }
         else{
             obj.put("errorMessage","user doesn't exist");
         }
         return obj;
    }
}