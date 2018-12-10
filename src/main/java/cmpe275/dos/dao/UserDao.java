package cmpe275.dos.dao;

import cmpe275.dos.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

public interface UserDao extends PagingAndSortingRepository <User, Integer> {
    Page<User> findAllBy(Pageable pageable);

    User findUserByUserId(Integer userId);

    User findUserByUsername(String username);

}
