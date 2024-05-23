package dev.akash.splitwise.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserLogInResponseDTO {
    private int id;
    private String name;
    private String email;
    private List<UserFriendResponseDTO> friendList;
    //TODO : add list of friend DTO
    //TODO : add list of group DTO
}
