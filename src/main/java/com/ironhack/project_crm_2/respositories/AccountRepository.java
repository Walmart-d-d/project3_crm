package com.ironhack.project_crm_2.respositories;

import com.ironhack.project_crm_2.models.Account;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {

/*MEDIAN
select OrderDate, TotalSales,
    percentile_cont(.5)  within group (order by TotalSales) over() MedianSales
from (
    select OrderDate, sum(FinalOrderPrice) TotalSales
    from CustomerOrderSummary
    group by OrderDate
) d
*/
    @Query(value = "SELECT id, AVG(employee_count) FROM Account GROUP BY id;", nativeQuery = true)
    List<Object[]> averageEmployeeCountByAccount();

  /*  @Query("SELECT id, PERCENTILE_CONT(.5) WITHIN GROUP (ORDER BY employeeCount) OVER() MedianEmployeeCount FROM Account GROUP BY id;")
    List<Object[]> medianEmployeeCountByAccount(); */

    @Query(value = "SELECT id, MAX(employee_count) FROM Account GROUP BY id;", nativeQuery = true)
    List<Object[]> maxEmployeeCountByAccount();

    @Query(value = "SELECT id, MIN(employee_count) FROM Account GROUP BY id;", nativeQuery = true)
    List<Object[]> minEmployeeCountByAccount();

    @Query(value = "SELECT Account.id, AVG(quantity) FROM Account JOIN Opportunity ON Opportunity.account_id = Account.id GROUP BY Account.id;", nativeQuery = true)
    List<Object[]> averageQuantityByAccount();

    /*  @Query("SELECT id, PERCENTILE_CONT(.5) WITHIN GROUP (ORDER BY quantity) OVER() MedianQuantity FROM Account GROUP BY id;")
     List<Object[]> medianQuantityByAccount(); */

    @Query(value = "SELECT Account.id, MAX(quantity) FROM Account JOIN Opportunity ON Opportunity.account_id = Account.id GROUP BY MAX(quantity);", nativeQuery = true)
    List<Object[]> maxQuantityByAccount();

    @Query(value = "SELECT Account.id, MIN(quantity) FROM Account JOIN Opportunity ON Opportunity.account_id = Account.id GROUP BY MIN(quantity);", nativeQuery = true)
    List<Object[]> minQuantityByAccount();


}
