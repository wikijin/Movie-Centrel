package cmpe275.dos.service.impl;

import cmpe275.dos.dao.UserDao;
import cmpe275.dos.entity.User;
import cmpe275.dos.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;

    @Override
    public Page<User> getAllUsers(Pageable pageable) {
        Page<User> users = userDao.findAllBy(pageable);
        return users;
    }
}
