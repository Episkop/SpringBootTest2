package com.example.springboottest2.repositories;

import com.example.springboottest2.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository <Image,Long> {
}
