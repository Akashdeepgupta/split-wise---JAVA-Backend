package dev.akash.splitwise.dto;

import dev.akash.splitwise.model.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserGroupRequestDTO {
    private int id;
    private String GroupName;
    private User AdminName;
}
