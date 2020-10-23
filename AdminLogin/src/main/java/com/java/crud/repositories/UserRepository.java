package com.java.crud.repositories;

import com.java.crud.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
 

@Repository
public interface UserRepository extends JpaRepository<User, Integer>, JpaSpecificationExecutor<User>{
    @Query(value = "FROM User WHERE email = :email", nativeQuery = false)
    public User findByEmail(@Param("email") String email);
}