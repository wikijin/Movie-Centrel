package cmpe275.dos.service;

import cmpe275.dos.dto.ParamCreateUserDto;
import cmpe275.dos.dto.ParamLoginDto;
import cmpe275.dos.dto.UserDto;
import cmpe275.dos.dto.UserSimpleDto;
import cmpe275.dos.exception.AppException;
import org.springframework.data.domain.Page;
import cmpe275.dos.entity.User;
import org.springframework.data.domain.Pageable;

public interface UserService {

    UserDto createUser(ParamCreateUserDto paramCreateUser);

    Boolean deleteUser(Integer userId);

    UserDto updateUser(Integer userId, UserDto userDto) throws AppException;

    UserDto getUser(Integer userId);

    User getUserByUsername(String username);

    UserDto loginUser(ParamLoginDto paramLogin);

    Page<UserSimpleDto> getAllUsers(Pageable pageable);
}
