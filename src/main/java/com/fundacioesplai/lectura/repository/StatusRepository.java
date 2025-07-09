package com.fundacioesplai.lectura.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fundacioesplai.lectura.model.Status;

public interface StatusRepository extends JpaRepository<Status, Integer> {
}

