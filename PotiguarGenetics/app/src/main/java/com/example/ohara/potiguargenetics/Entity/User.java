package com.example.ohara.potiguargenetics.Entity;

public class User {
    private String id;
    private String name;
    private String origin_city;
    private String birth;
    private char   genre;
    private String school_degree;
    private String cell_phone;
    private String street;
    private String cep;
    private int    house_number;
    private String neighborhood;
    private String city;
    private String email;
    private String psw;

    public User (String id, String name, String origin_city, String birth, char genre, String school_degree,
                  String cell_phone, String street, String cep, int house_number, String neighborhood,
                  String city, String email, String psw) {
        this.id            = id;
        this.name          = name;
        this.origin_city   = origin_city;
        this.birth         = birth;
        this.genre         = genre;
        this.school_degree = school_degree;
        this.cell_phone    = cell_phone;
        this.street        = street;
        this.cep           = cep;
        this.house_number  = house_number;
        this.neighborhood  = neighborhood;
        this.city          = city;
        this.email         = email;
        this.psw           = psw;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getOrigin_city() {
        return origin_city;
    }

    public String getBirth() {
        return birth;
    }

    public char getGenre() {
        return genre;
    }

    public String getSchool_degree() {
        return school_degree;
    }

    public String getCell_phone() {
        return cell_phone;
    }

    public String getStreet() {
        return street;
    }

    public String getCep() {
        return cep;
    }

    public int getHouse_number() {
        return house_number;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public String getCity() {
        return city;
    }

    public String getEmail() {
        return email;
    }

    public String getPsw() {
        return psw;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOrigin_city(String origin_city) {
        this.origin_city = origin_city;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public void setGenre(char genre) {
        this.genre = genre;
    }

    public void setSchool_degree(String school_degree) {
        this.school_degree = school_degree;
    }

    public void setCell_phone(String cell_phone) {
        this.cell_phone = cell_phone;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public void setHouse_number(int house_number) {
        this.house_number = house_number;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPsw(String psw) {
        this.psw = psw;
    }
}
