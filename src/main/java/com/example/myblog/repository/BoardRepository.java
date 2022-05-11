package com.example.myblog.repository;

import com.example.myblog.model.Board;
import com.example.myblog.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface BoardRepository extends JpaRepository<Board, Integer> {
}