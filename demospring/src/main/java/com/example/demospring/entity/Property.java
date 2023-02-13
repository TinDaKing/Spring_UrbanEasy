package com.example.demospring.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Property {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String description;
    @Column(name = "neighborhood_overview")
    private String neighborhoodOverview;
    @Column(name = "total_guest")
    private int totalGuest;
    private int bedroom;
    private int bed;
    private double bath;
    @Column(name = "user_id")
    private long userId;
    private String district;
    private String city;
    private String country;
    @Column(name = "street_address")
    private String streetAddress;

    public Property() {

    }
    public Property(long id, String name, String description, String neighborhoodOverview, int totalGuest, int bedroom, int bed, double bath, long userId, String district, String city, String country, String streetAddress, double lng, double lat, double defaultPrice, int categoryId, long view) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.neighborhoodOverview = neighborhoodOverview;
        this.totalGuest = totalGuest;
        this.bedroom = bedroom;
        this.bed = bed;
        this.bath = bath;
        this.userId = userId;
        this.district = district;
        this.city = city;
        this.country = country;
        this.streetAddress = streetAddress;
        this.lng = lng;
        this.lat = lat;
        this.defaultPrice = defaultPrice;
        this.categoryId = categoryId;
        this.view = view;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    private double lng;
    private double lat;
    @Column(name = "default_price")
    private double defaultPrice;
    @Column(name = "category_id")
    private int categoryId;
    private long view;



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNeighborhoodOverview() {
        return neighborhoodOverview;
    }

    public void setNeighborhoodOverview(String neighborhoodOverview) {
        this.neighborhoodOverview = neighborhoodOverview;
    }

    public int getTotalGuest() {
        return totalGuest;
    }

    public void setTotalGuest(int totalGuest) {
        this.totalGuest = totalGuest;
    }

    public int getBedroom() {
        return bedroom;
    }

    public void setBedroom(int bedroom) {
        this.bedroom = bedroom;
    }

    public int getBed() {
        return bed;
    }

    public void setBed(int bed) {
        this.bed = bed;
    }

    public double getBath() {
        return bath;
    }

    public void setBath(double bath) {
        this.bath = bath;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }



    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getDefaultPrice() {
        return defaultPrice;
    }

    public void setDefaultPrice(double defaultPrice) {
        this.defaultPrice = defaultPrice;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public long getView() {
        return view;
    }

    public void setView(long view) {
        this.view = view;
    }

    @Override
    public String toString() {
        return "Property{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", neighborhoodOverview='" + neighborhoodOverview + '\'' +
                ", totalGuest=" + totalGuest +
                ", bedroom=" + bedroom +
                ", bed=" + bed +
                ", bath=" + bath +
                ", userId=" + userId +
                ", district='" + district + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", streetAddress='" + streetAddress + '\'' +
                ", lng=" + lng +
                ", lat=" + lat +
                ", defaultPrice=" + defaultPrice +
                ", categoryId=" + categoryId +
                ", view=" + view +
                '}';
    }
}
