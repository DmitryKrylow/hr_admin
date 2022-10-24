package com.example.hr_admin;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepos extends JpaRepository<User,Long> {
    List<User> findAllBy();
    List<User> findAllById(Long id);
}
