package com.ironhack.project_crm_2.respositories;

import com.ironhack.project_crm_2.models.Lead;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LeadRepository extends JpaRepository<Lead, Integer> {

    List<Lead> findByName(String name);
}
