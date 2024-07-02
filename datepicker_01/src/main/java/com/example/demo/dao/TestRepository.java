package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.TestEntity;

public interface TestRepository extends JpaRepository<TestEntity,Long>{

}
