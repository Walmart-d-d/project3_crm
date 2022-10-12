package com.ironhack.project_crm_2.models;

import javax.persistence.*;
import java.util.Set;

@Entity
public class SalesRep {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
private String name;

@OneToMany(mappedBy = "salesRep")
private Set<Lead> leadSet;
@OneToMany(mappedBy = "salesRep")
private Set<Opportunity> oppSet;

    public SalesRep() {
    }

    public SalesRep(String name) {
        this.name = name;
    }

    public SalesRep(String name, Set<Lead> leadSet, Set<Opportunity> oppSet) {
        setName(name);
        setLeadSet(leadSet);
        setOppSet(oppSet);
    }

    public Set<Opportunity> getOppSet() {
        return oppSet;
    }

    public void setOppSet(Set<Opportunity> oppSet) {
        this.oppSet = oppSet;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Lead> getLeadSet() {
        return leadSet;
    }

    public void setLeadSet(Set<Lead> leadSet) {
        this.leadSet = leadSet;
    }

    @Override
    public String toString() {
        return "Sales Representative " +this.getId()+":\n"+
                "Name: " + this.getName() +"\n"+
                "==========================================";
            }
        }
