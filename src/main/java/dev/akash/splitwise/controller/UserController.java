package dev.akash.splitwise.controller;

import dev.akash.splitwise.dto.UserRegistrationRequestDTO;
import dev.akash.splitwise.exception.UserRegistrationInvalidDataException;
import dev.akash.splitwise.mapper.user.EntityDTOMapper;
import dev.akash.splitwise.model.User;
import dev.akash.splitwise.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    UserServiceImpl userService;
    @PostMapping("/signup")
    public ResponseEntity signUp(@RequestBody UserRegistrationRequestDTO userRegistrationRequestDTO){
         validateUserRegistrationRequestDTO(userRegistrationRequestDTO);
         User savedUser = userService.SignUp(userRegistrationRequestDTO.getName(), userRegistrationRequestDTO.getEmail(), userRegistrationRequestDTO.getPassword());
         return ResponseEntity.ok(
                 EntityDTOMapper.toDTO(savedUser)
         );
    }

    public void validateUserRegistrationRequestDTO(UserRegistrationRequestDTO userRegistrationRequestDTO){
        // TODO : VALIDATE EMAIL
        // TODO : VALIDATE IF PASSWORD HAS ATLEADT 8 CHAR INCLUDING SMALL, CAPITAL,NUMERIC AND A SPECIAL CHARACTER
        // DO BOTH USING REGEX
        if(userRegistrationRequestDTO.getEmail() == null ||
                userRegistrationRequestDTO.getName() == null ||
                userRegistrationRequestDTO.getPassword() == null ){
            throw new UserRegistrationInvalidDataException("Invalid User Details");
        }
    }
}
