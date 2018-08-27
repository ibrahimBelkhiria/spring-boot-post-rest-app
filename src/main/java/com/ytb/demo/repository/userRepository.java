package com.ytb.demo.repository;

import com.ytb.demo.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface userRepository extends CrudRepository<User,Long> {

    User findByUsername(String username);
}
