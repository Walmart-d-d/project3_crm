package com.ironhack.project_crm_2.respositories;

import com.ironhack.project_crm_2.models.Opportunity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OpportunityRepository extends JpaRepository<Opportunity, Integer> {

   /* @Query("SELECT product, COUNT(id) FROM Opportunity GROUP BY product;")
    List<Object[]> reportOppByProduct();*/

    @Query(value= "SELECT product FROM Opportunity", nativeQuery = true)
    List<Object[]> reportOppByProduct();



}
