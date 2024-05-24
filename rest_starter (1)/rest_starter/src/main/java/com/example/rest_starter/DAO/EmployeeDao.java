package com.example.rest_starter.DAO;

import com.example.rest_starter.Entity.Professors;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Transactional
@Repository
@RepositoryRestResource(path = "teachers")
public interface EmployeeDao extends JpaRepository<Professors,Integer>
{
}
