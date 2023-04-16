package com.example.security.SpringSecurityJPA.repo;

import com.example.security.SpringSecurityJPA.dao.User;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User,Integer>
{
    Optional<User> findByUserName(String userName);
}
