package com.ironhack.project_crm_2.respositories;

import com.ironhack.project_crm_2.models.Opportunity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OpportunityRepository extends JpaRepository<Opportunity, Integer> {



    //By product
    @Query(value="SELECT product, COUNT(id) FROM Opportunity GROUP BY product;", nativeQuery = true)
    List<Object[]> reportOppByProduct();

    @Query(value="SELECT product, COUNT(id) FROM Opportunity WHERE status = 'CLOSED_WON' GROUP BY product;", nativeQuery = true)
    List<Object[]> reportOppClosedWonByProduct();


    @Query(value="SELECT product, COUNT(id) FROM Opportunity WHERE status = 'CLOSED_LOST' GROUP BY product;", nativeQuery = true)
    List<Object[]> reportOppClosedLostByProduct();

    @Query(value="SELECT product, COUNT(id) FROM Opportunity WHERE status = 'OPEN' GROUP BY product;", nativeQuery = true)
    List<Object[]> reportOppOpenByProduct();


    //By country

    @Query(value="SELECT country, COUNT(Opportunity.id) FROM Opportunity JOIN Account ON Opportunity.account_id = Account.id GROUP BY country;", nativeQuery = true)
    List<Object[]> reportOppByCountry();

    @Query(value="SELECT country, COUNT(Opportunity.id) FROM Opportunity JOIN Account ON Account.id = Opportunity.account_id WHERE status = 'CLOSED_WON' GROUP BY country;", nativeQuery = true)
    List<Object[]> reportOppClosedWonByCountry();

    @Query(value = "SELECT country, COUNT(Opportunity.id) FROM Opportunity JOIN Account ON Opportunity.account_id = Account.id WHERE status = 'CLOSED_LOST' GROUP BY country;", nativeQuery = true)
    List<Object[]> reportOppClosedLostByCountry();

    @Query(value = "SELECT country, COUNT(Opportunity.id) FROM Opportunity JOIN Account ON Opportunity.account_id = Account.id WHERE status = 'OPEN' GROUP BY country;", nativeQuery = true)
    List<Object[]> reportOppOpenByCountry();

    //By city
    @Query(value = "SELECT city, COUNT(Opportunity.id) FROM Opportunity JOIN Account ON Opportunity.account_id = Account.id GROUP BY city;", nativeQuery = true)
    List<Object[]> reportOppByCity();

    @Query(value = "SELECT city, COUNT(Opportunity.id) FROM Opportunity JOIN Account ON Opportunity.account_id = Account.id WHERE status = 'CLOSED_WON' GROUP BY city;", nativeQuery = true)
    List<Object[]> reportOppClosedWonByCity();

    @Query(value = "SELECT city, COUNT(Opportunity.id) FROM Opportunity JOIN Account ON Opportunity.account_id = Account.id WHERE status = 'CLOSED_LOST' GROUP BY city;", nativeQuery = true)
    List<Object[]> reportOppClosedLostByCity();

    @Query(value = "SELECT city, COUNT(Opportunity.id) FROM Opportunity JOIN Account ON Opportunity.account_id = Account.id WHERE status = 'OPEN' GROUP BY city;", nativeQuery = true)
    List<Object[]> reportOppOpenByCity();

    @Query(value = "SELECT AVG(`count`) FROM (SELECT COUNT(Opportunity.id) AS `count` FROM Account JOIN Opportunity ON Opportunity.account_id = Account.id GROUP BY account_id) nested;", nativeQuery = true)
    List<Object[]> averageOppByAccount();

    /*  @Query("SELECT id, PERCENTILE_CONT(.5) WITHIN GROUP (ORDER BY quantity) OVER() MedianQuantity FROM Account GROUP BY id;")
     List<Object[]> medianOppByAccount(); */

   @Query(value = "SELECT MAX(`count`) FROM (SELECT COUNT(Opportunity.id) AS `count` FROM Account JOIN Opportunity ON Opportunity.account_id = Account.id GROUP BY account_id) nested;", nativeQuery = true)
    List<Object[]> maxOppByAccount();

    @Query(value = "SELECT MIN(`count`) FROM (SELECT COUNT(Opportunity.id) AS `count` FROM Opportunity JOIN Account ON Opportunity.account_id = Account.id GROUP BY Account.id) nested;", nativeQuery = true)
    List<Object[]> minOppByAccount();


}
