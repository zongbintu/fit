package com.example.fit.model;

import fit.SharedPreferenceAble;
import java.io.Serializable;

/**
 * @author Tu enum@foxmail.com
 * @date 8/30/16
 */
@SharedPreferenceAble
public class Address implements Serializable {
  private static final long serialVersionUID = 8270860578916375235L;
  private String city;
  private String street;

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getStreet() {
    return street;
  }

  public void setStreet(String street) {
    this.street = street;
  }
}
