package com.example.weddinghotel.dto;

public class Packages {

    private String packageName;
    private String pricePerPerson;
    private String info;
    private String packageImage;

    public Packages() {
    }

    public Packages(String packageName, String pricePerPerson, String info, String packageImage) {
        this.packageName = packageName;
        this.pricePerPerson = pricePerPerson;
        this.info = info;
        this.packageImage = packageImage;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getPricePerPerson() {
        return pricePerPerson;
    }

    public void setPricePerPerson(String pricePerPerson) {
        this.pricePerPerson = pricePerPerson;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getPackageImage() {
        return packageImage;
    }

    public void setPackageImage(String packageImage) {
        this.packageImage = packageImage;
    }
}
