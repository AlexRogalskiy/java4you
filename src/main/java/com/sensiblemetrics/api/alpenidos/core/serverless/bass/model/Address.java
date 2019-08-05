package com.sensiblemetrics.api.alpenidos.core.serverless.bass.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;

/**
 * Address class
 * Created by dheeraj.mummarareddy on 3/4/18.
 */
@Data
@EqualsAndHashCode
@ToString
@DynamoDBDocument
public class Address implements Serializable {

    private static final long serialVersionUID = 6760844284799736970L;

    private String addressLineOne;
    private String addressLineTwo;
    private String city;
    private String state;
    private String zipCode;

    @DynamoDBAttribute(attributeName = "addressLineOne")
    public String getAddressLineOne() {
        return addressLineOne;
    }

    public void setAddressLineOne(String addressLineOne) {
        this.addressLineOne = addressLineOne;
    }

    @DynamoDBAttribute(attributeName = "addressLineTwo")
    public String getAddressLineTwo() {
        return addressLineTwo;
    }

    public void setAddressLineTwo(String addressLineTwo) {
        this.addressLineTwo = addressLineTwo;
    }

    @DynamoDBAttribute(attributeName = "city")
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @DynamoDBAttribute(attributeName = "state")
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @DynamoDBAttribute(attributeName = "zipCode")
    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
}
