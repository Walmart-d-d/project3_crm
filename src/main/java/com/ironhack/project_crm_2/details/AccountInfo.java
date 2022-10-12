package com.ironhack.project_crm_2.details;
import com.ironhack.project_crm_2.enums.IndustryOption;


public class AccountInfo {

    public IndustryOption industryOption;
    public int employeeCount;
    public String city;
    public String country;

    public AccountInfo(IndustryOption industryOption, int employeeCount, String city, String country) {
        this.industryOption = industryOption;
        this.employeeCount = employeeCount;
        this.city = city;
        this.country = country;
    }


}
