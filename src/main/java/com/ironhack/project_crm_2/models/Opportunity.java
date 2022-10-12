package com.ironhack.project_crm_2.models;


import com.ironhack.project_crm_2.enums.OppStatus;
import com.ironhack.project_crm_2.enums.ProductType;

import javax.persistence.*;

@Entity

public class Opportunity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Enumerated(EnumType.STRING)
    private ProductType product;
    @OneToOne
    private Contact decisionMaker;
    private int quantity;
    @Enumerated(EnumType.STRING)
    private OppStatus status;
    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

    @ManyToOne
    @JoinColumn (name = "sales_rep_id")
    private SalesRep salesRep;

    public Opportunity() {
    }

    public Opportunity(ProductType product, Contact decisionMaker, int quantity, OppStatus status, SalesRep salesRep) {
        setProduct(product);
        setDecisionMaker(decisionMaker);
        setQuantity(quantity);
        setStatus(status);
        setSalesRep(salesRep);
    }

    public Opportunity(ProductType product, Contact decisionMaker, int quantity, OppStatus status, Account account, SalesRep salesRep) {
        setProduct(product);
        setDecisionMaker(decisionMaker);
        setQuantity(quantity);
        setStatus(status);
        setAccount(account);
        setSalesRep(salesRep);
    }


    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public SalesRep getSalesRep() {
        return salesRep;
    }

    public void setSalesRep(SalesRep salesRep) {
        this.salesRep = salesRep;
    }

    public int getId() {
        return id;
    }

    public ProductType getProduct() {
        return product;
    }

    public void setProduct(ProductType product) {
        this.product = product;
    }

    public Contact getDecisionMaker() {
        return decisionMaker;
    }

    public void setDecisionMaker(Contact decisionMaker) {
        this.decisionMaker = decisionMaker;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public OppStatus getStatus() {
        return status;
    }

    public void setStatus(OppStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Opportunity " + this.getId() + ":\n"+
                "Product: " + this.getProduct() + "\n"+
                "Decision maker: " + this.getDecisionMaker().getName() + "\n"+
                "Quantity: " + this.getQuantity() + "\n"+
                "Status: " + this.getStatus() + "\n" +
                "==========================================";
    }
}
