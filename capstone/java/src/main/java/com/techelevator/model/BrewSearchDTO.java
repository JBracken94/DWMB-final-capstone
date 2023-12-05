package com.techelevator.model;

public class BrewSearchDTO {
    private String city = null;
    private String state = null;
    private Integer zipCode = null;
    public BrewSearchDTO(String city, String state, int zipCode) {
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }
}
