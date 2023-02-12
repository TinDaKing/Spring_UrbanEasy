package com.example.demospring.repository;

import com.example.demospring.entity.User;
import com.example.demospring.model.UserInterface;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query(
            value="select u.id, u.user_name as userName, u.password, u.email, u.avatar_url as url, " +
                    "u.date as dateCreated, count(p.id) as totalOwnedProperty from user u join property p " +
                    "on u.id = p.user_id group by u.id, u.user_name , u.password, u.email, u.avatar_url, u.date",
            nativeQuery = true
    )
    @Transactional
    List<UserInterface> selectAllUsers();

    @Query(
            value="select u.id, u.user_name as userName, u.password, u.email, u.avatar_url as url, " +
                    "u.date as dateCreated, count(p.id) as totalOwnedProperty from user u left join property p " +
                    "on u.id = p.user_id where u.id =:id group by u.id, u.user_name , u.password, u.email, u.avatar_url, u.date",
            nativeQuery = true
    )
    @Transactional
    UserInterface selectUser(String id);

    @Modifying
    @Query(
            value="UPDATE user " +
                    "SET user_name=:userName, email=:email, password=:password " +
                    "WHERE id=:id",
            nativeQuery = true
    )
    @Transactional
    void updateUser(String id, String userName, String email, String password);



}
