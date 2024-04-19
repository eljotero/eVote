package org.evote.backend.dtos.user;

import org.evote.backend.dtos.user.UserDTO;
import org.evote.backend.users.user.entity.User;

public class UserMapper {

    public static UserDTO toUserDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setUser_id(user.getUser_id());
        userDTO.setName(user.getName());
        userDTO.setSurname(user.getSurname());
        userDTO.setEmail(user.getEmail());
        userDTO.setPersonalIdNumber(user.getPersonalIdNumber());
        userDTO.setHasVoted(user.getHasVoted());
        userDTO.setBirthDate(user.getBirthDate());
        userDTO.setEducation(user.getEducation());
        userDTO.setProfession(user.getProfession());
        userDTO.setSex(user.getSex());
        userDTO.setCityType(user.getCityType());
        return userDTO;
    }

    public static User toUser(UserDTO userDTO) {
        User user = new User();
        user.setUser_id(userDTO.getUser_id());
        user.setName(userDTO.getName());
        user.setSurname(userDTO.getSurname());
        user.setEmail(userDTO.getEmail());
        user.setPersonalIdNumber(userDTO.getPersonalIdNumber());
        user.setHasVoted(userDTO.getHasVoted());
        user.setBirthDate(userDTO.getBirthDate());
        user.setEducation(userDTO.getEducation());
        user.setProfession(userDTO.getProfession());
        user.setSex(userDTO.getSex());
        user.setCityType(userDTO.getCityType());
        return user;
    }
}