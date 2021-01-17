package com.siddiqui.recommendations.android;

public class Business {

    private String name, address, phone, discounts;
    private Long id;

    public Business(String name, String address, String phone, String discounts, Long id) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.discounts = discounts;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDiscounts() {
        return discounts;
    }

    public void setDiscounts(String discounts) {
        this.discounts = discounts;
    }
}
