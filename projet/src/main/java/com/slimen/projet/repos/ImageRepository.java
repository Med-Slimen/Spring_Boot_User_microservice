package com.slimen.projet.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.slimen.projet.entities.Image;

public interface ImageRepository extends JpaRepository<Image , Long> {
}

