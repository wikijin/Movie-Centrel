package cmpe275.dos.service;

import org.springframework.data.domain.Page;
import cmpe275.dos.entity.User;
import org.springframework.data.domain.Pageable;

public interface UserService {
    Page<User> getAllUsers(Pageable pageable);
}
