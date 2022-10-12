package com.ironhack.project_crm_2.respositories;

import com.ironhack.project_crm_2.models.SalesRep;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SalesRepRepository extends JpaRepository<SalesRep, Integer> {


 /*   @Query("SELECT name, COUNT(Lead) FROM SalesRep GROUP BY name;")
    List<Object[]> reportLeadBySalesRep();

    @Query("SELECT name, COUNT(Opportunity) FROM SalesRep GROUP BY name;")
    List<Object[]> reportOppBySalesRep();

    @Query("SELECT name, COUNT(status) FROM SalesRep JOIN Opportunity ON SalesRep.id = Opportunity.salesRep WHERE Opportunity.status='CLOSED_WON' GROUP BY SalesRep.name;")
    List<Object[]> reportClosedWonBySalesRep();

    @Query("SELECT name, COUNT(status) FROM SalesRep JOIN Opportunity ON SalesRep.id = Opportunity.salesRep WHERE Opportunity.status='CLOSED_LOST' GROUP BY SalesRep.name;")
    List<Object[]> reportClosedLOSTBySalesRep();

    @Query("SELECT name, COUNT(status) FROM SalesRep JOIN Opportunity ON SalesRep.id = Opportunity.salesRep WHERE Opportunity.status='OPEN' GROUP BY SalesRep.name;")
    List<Object[]> reportOpenBySalesRep();*/

}
