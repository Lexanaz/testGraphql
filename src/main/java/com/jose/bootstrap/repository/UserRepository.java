package com.jose.bootstrap.repository;


import com.jose.bootstrap.entity.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {
    @Query("select d.iduser, d.info from User d where d.iduser=:iduser")
    String findInfoByIduser(Long iduser);

    @Query("select d.iduser, d.info from User d")
    List<String> findAllInfo();

    @Query("select d.iduser, d.name from User d")
    List<String> findAllName();

    @Transactional
    @Modifying
    @Query
    ("delete from User where info like ?1")
    Integer deleteUserByInfo(String info);

    Optional<User> findByIduser(Long iduser);
}