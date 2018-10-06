package jpa.repository;

import jpa.model.UserEntity;
import jpa.querydsl.UserRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<UserEntity, Long>, UserRepositoryCustom{
    UserEntity findByUserName(@Param("userName") String userName);
//    List findAllByUserName(@Param("userName") String userName);
}
