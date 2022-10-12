package com.ironhack.project_crm_2.respositories;

import com.ironhack.project_crm_2.models.Opportunity;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OpportunityRepository extends JpaRepository<Opportunity, Integer> {


    //By product
    @Query("SELECT product, COUNT(id) FROM Opportunity GROUP BY product;")
    List<Object[]> reportOppByProduct();


    @Query("SELECT product, COUNT(id) FROM Opportunity WHERE status = 'CLOSED_WON' GROUP BY product;")
    List<Object[]> reportOppClosedWonByProduct();

    @Query("SELECT product, COUNT(id) FROM Opportunity WHERE status = 'CLOSED_LOST' GROUP BY product;")
    List<Object[]> reportOppClosedLostByProduct();

    @Query("SELECT product, COUNT(id) FROM Opportunity WHERE status = 'OPEN' GROUP BY product;")
    List<Object[]> reportOppOpenByProduct();


    //By country

    @Query("SELECT country, COUNT(id) FROM Opportunity JOIN Account ON Opportunity.account = Account.id GROUP BY country;")
    List<Object[]> reportOppByCountry();

    @Query("SELECT country, COUNT(id) FROM Opportunity JOIN Account ON Opportunity.account = Account.id WHERE status = 'CLOSED_WON' GROUP BY country;")
    List<Object[]> reportOppClosedWonByCountry();

    @Query("SELECT country, COUNT(id) FROM Opportunity JOIN Account ON Opportunity.account = Account.id WHERE status = 'CLOSED_LOST' GROUP BY country;")
    List<Object[]> reportOppClosedLostByCountry();

    @Query("SELECT country, COUNT(id) FROM Opportunity JOIN Account ON Opportunity.account = Account.id WHERE status = 'OPEN' GROUP BY country;")
    List<Object[]> reportOppOpenByCountry();

    //By city
    @Query("SELECT city, COUNT(id) FROM Opportunity JOIN Account ON Opportunity.account = Account.id GROUP BY city;")
    List<Object[]> reportOppByCity();

    @Query("SELECT city, COUNT(id) FROM Opportunity JOIN Account ON Opportunity.account = Account.id WHERE status = 'CLOSED_WON' GROUP BY city;")
    List<Object[]> reportOppClosedWonByCity();

    @Query("SELECT city, COUNT(id) FROM Opportunity JOIN Account ON Opportunity.account = Account.id WHERE status = 'CLOSED_LOST' GROUP BY city;")
    List<Object[]> reportOppClosedLostByCity();

    @Query("SELECT city, COUNT(id) FROM Opportunity JOIN Account ON Opportunity.account = Account.id WHERE status = 'OPEN' GROUP BY city;")
    List<Object[]> reportOppOpenByCity();

    @Query("SELECT AVG(COUNT(Opportunity.id)) FROM Opportunity JOIN Account ON Opportunity.account = Account.id;")
    List<Object[]> averageOppByAccount();

    /*  @Query("SELECT id, PERCENTILE_CONT(.5) WITHIN GROUP (ORDER BY quantity) OVER() MedianQuantity FROM Account GROUP BY id;")
     List<Object[]> medianOppByAccount(); */

    @Query("SELECT Account.id, MAX(COUNT(Opportunity.id)) FROM Opportunity JOIN Account ON Opportunity.account = Account.id GROUP BY Account.id ORDER BY MAX(COUNT(Opportunity.id)) DESC;")
    List<Object[]> maxOppByAccount();

    @Query("SELECT Account.id, MIN(COUNT(Opportunity.id)) FROM Opportunity JOIN Account ON Opportunity.account = Account.id GROUP BY Account.id ORDER BY MIN(COUNT(Opportunity.id)) ASC;")
    List<Object[]> minOppByAccount();


}
