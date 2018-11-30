package cmpe275.dos.service.impl;

import cmpe275.dos.dao.UserDao;
import cmpe275.dos.dto.ParamCreateUserDto;
import cmpe275.dos.dto.ParamLoginDto;
import cmpe275.dos.dto.UserDto;
import cmpe275.dos.entity.User;
import cmpe275.dos.exception.AppException;
import cmpe275.dos.lib.Validate;
import cmpe275.dos.mapper.UserMapper;
import cmpe275.dos.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import static cmpe275.dos.exception.ErrorCode.ERR_INVALID_ZIPCODE;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    private UserMapper userMapper = new UserMapper();

    @Override
    public UserDto createUser(ParamCreateUserDto paramCreateUser) {
        paramCreateUser.setPassword(passwordEncoder.encode(paramCreateUser.getPassword()));
        User user = userMapper.toPojo(paramCreateUser);
        user = userDao.save(user);
        return userMapper.toDto(user);
    }

    @Override
    public Boolean deleteUser(Integer userId) {
        if (userDao.findUserByUserId(userId) == null)
            return false;
        userDao.deleteById(userId);
        return true;
    }

    @Override
    public UserDto updateUser(Integer userId, UserDto userDto) throws AppException {
        User user = userDao.findUserByUserId(userId);
        if (user != null) {

            if ( userDto.getZipcode() != null) {
                if (! Validate.isValidZipcode(userDto.getZipcode()))
                    throw new AppException(ERR_INVALID_ZIPCODE, "Invalid Zipcode. Failed to update user");
                userDto.setZipcode(Validate.getMainZipcode(userDto.getZipcode()));
            }

            user = userMapper.updPojo(userDto, user);
            userDao.save(user);
            return userMapper.toDto(user);
        }
        return null;
    }

    @Override
    public UserDto getUser(Integer userId) {
        return userMapper.toDto(userDao.findUserByUserId(userId));
    }

    @Override
    public User getUserByUsername(String username) {
        return userDao.findUserByUsername(username);
    }

    @Override
    public UserDto loginUser(ParamLoginDto paramLogin) {
        User user = userDao.findUserByUsername(paramLogin.getUsername());
        if (user == null)
            return null;
        if (passwordEncoder.matches(paramLogin.getPassword(), user.getPassword()))
            return userMapper.toDto(user);
        else
            return null;
    }

    @Override
    public Page<User> getAllUsers(Pageable pageable) {
        Page<User> users = userDao.findAllBy(pageable);
        return users;
    }
}
