package dev.akash.splitwise.mapper.user;

import dev.akash.splitwise.dto.UserFriendResponseDTO;
import dev.akash.splitwise.dto.UserGroupRequestDTO;
import dev.akash.splitwise.dto.UserLogInResponseDTO;
import dev.akash.splitwise.model.Group;
import dev.akash.splitwise.model.User;

import java.util.ArrayList;
import java.util.List;

public class EntityDTOMapper {
    public static UserLogInResponseDTO toDTO(User user){
        UserLogInResponseDTO userLogInResponseDTO = new UserLogInResponseDTO();
        userLogInResponseDTO.setId(user.getId());
        userLogInResponseDTO.setName(user.getName());
        userLogInResponseDTO.setEmail(user.getEmail());
        //conversion of user friends to friendList
        List<UserFriendResponseDTO> friendList = new ArrayList<>();
        for(User friends : user.getFriends()){
            friendList.add(toFriendDTO(friends));
        }
        userLogInResponseDTO.setFriendList(friendList);

        //conversion of Group  to groupList
        List<UserGroupRequestDTO> groupList = new ArrayList<>();
        for(Group group : user.getGroups()){
            groupList.add(toGroupDTO(group));
        }
        return userLogInResponseDTO;
    }
    public static UserFriendResponseDTO toFriendDTO(User user){
        UserFriendResponseDTO userFriendResponseDTO = new UserFriendResponseDTO();
        userFriendResponseDTO.setId(user.getId());
        userFriendResponseDTO.setName(user.getName());
        return userFriendResponseDTO;
    }

    public static UserGroupRequestDTO toGroupDTO(Group group){
        UserGroupRequestDTO userGroupRequestDTO = new UserGroupRequestDTO();
        userGroupRequestDTO.setId(group.getId());
        userGroupRequestDTO.setGroupName(group.getName());
        userGroupRequestDTO.setAdminName(group.getAdmin());
        return userGroupRequestDTO;

    }
}
