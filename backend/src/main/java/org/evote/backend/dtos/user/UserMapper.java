package org.evote.backend.dtos.user;

import org.evote.backend.users.user.entity.User;

public class UserMapper {

    public static UserDTO toUserDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setUser_id(user.getUser_id());
        userDTO.setName(user.getName());
        userDTO.setSurname(user.getSurname());
        userDTO.setEmail(user.getEmail());
        userDTO.setPersonalIdNumber(user.getPersonalIdNumber());
        userDTO.setBirthDate(user.getBirthDate());
        userDTO.setEducation(user.getEducation());
        userDTO.setProfession(user.getProfession());
        userDTO.setSex(user.getSex());
        userDTO.setCityType(user.getCityType());
        return userDTO;
    }

    public static User toUser(UserCreateDTO userCreateDTO) {
        User user = new User();
        user.setName(userCreateDTO.getName());
        user.setSurname(userCreateDTO.getSurname());
        user.setEmail(userCreateDTO.getEmail());
        user.setPassword(userCreateDTO.getPassword());
        user.setPersonalIdNumber(userCreateDTO.getPersonalIdNumber());
        user.setCode(userCreateDTO.getCode());
        user.setHasVoted(userCreateDTO.getHasVoted());
        user.setBirthDate(userCreateDTO.getBirthDate());
        user.setEducation(userCreateDTO.getEducation());
        user.setProfession(userCreateDTO.getProfession());
        user.setSex(userCreateDTO.getSex());
        user.setCityType(userCreateDTO.getCityType());
        return user;
    }

    public static UserLoginResponseDTO toUserLoginResponseDTO(User user) {
        UserLoginResponseDTO userLoginResponseDTO = new UserLoginResponseDTO();
        userLoginResponseDTO.setUser_id(user.getUser_id());
        userLoginResponseDTO.setEmail(user.getEmail());
        return userLoginResponseDTO;
    }

}