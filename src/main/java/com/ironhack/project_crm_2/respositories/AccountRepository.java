package com.ironhack.project_crm_2.respositories;

import com.ironhack.project_crm_2.models.Account;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
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
    @Query("SELECT id, AVG(employeeCount) FROM Account GROUP BY id;")
    List<Object[]> averageEmployeeCountByAccount();

  /*  @Query("SELECT id, PERCENTILE_CONT(.5) WITHIN GROUP (ORDER BY employeeCount) OVER() MedianEmployeeCount FROM Account GROUP BY id;")
    List<Object[]> medianEmployeeCountByAccount(); */

    @Query("SELECT id, MAX(employeeCount) FROM Account GROUP BY id ORDER BY MAX(employeeCount) DESC;")
    List<Object[]> maxEmployeeCountByAccount();

    @Query("SELECT id, MIN(employeeCount) FROM Account GROUP BY id ORDER BY MIN(employeeCount) ASC;")
    List<Object[]> minEmployeeCountByAccount();

    @Query("SELECT id, AVG(quantity) FROM Account GROUP BY id;")
    List<Object[]> averageQuantityByAccount();

    /*  @Query("SELECT id, PERCENTILE_CONT(.5) WITHIN GROUP (ORDER BY quantity) OVER() MedianQuantity FROM Account GROUP BY id;")
     List<Object[]> medianQuantityByAccount(); */

    @Query("SELECT id, MAX(quantity) FROM Account GROUP BY id ORDER BY MAX(quantity) DESC;")
    List<Object[]> maxQuantityByAccount();

    @Query("SELECT id, MIN(quantity) FROM Account GROUP BY id ORDER BY MIN(quantity) ASC;")
    List<Object[]> minQuantityByAccount();


}
