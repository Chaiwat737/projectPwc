package com.pwc.repository;



import com.pwc.entity.userInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserInfoRepository extends JpaRepository<userInfo, Integer> {
    Optional<userInfo> findByEmail(String email);

//    @Query("SELECT u FROM UserInfo u WHERE u.name = :username")
//    Optional<UserInfo> findByUsername(@Param("username") String username);
}
