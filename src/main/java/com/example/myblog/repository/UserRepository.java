package com.example.myblog.repository;

import com.example.myblog.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//DAO
//자동으로 bean 등록이 된다.
// @Repository // 생략 가능하다
public interface UserRepository extends JpaRepository<User, Integer> {

}
