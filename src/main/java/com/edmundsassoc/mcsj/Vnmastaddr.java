package com.edmundsassoc.mcsj;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;

/**
 * The persistent class for the vnmastaddr database table.
 * 
 */
@Entity
@NamedQuery(name = "Vnmastaddr.findAll", query = "SELECT v FROM Vnmastaddr v")
public class Vnmastaddr implements Serializable {
  private static final long serialVersionUID = 1L;

  @EmbeddedId
  private VnmastaddrPK id;

  private String addr2_City;

  private String addr2_Country;

  private String addr2_Option;

  private String addr2_St;

  private String addr2_Street1;

  private String addr2_Street2;

  private String addr2_Zip;

  private String city;

  private String country;

  private String county_Id;

  private String email;

  private String fax;

  private String phone;

  private String phone_Ext;

  private String phone_Ext2;

  private String phone2;

  private String st;

  private String street1;

  private String street2;

  private String zip;

  public Vnmastaddr() {
  }

  public VnmastaddrPK getId() {
    return this.id;
  }

  public void setId(VnmastaddrPK id) {
    this.id = id;
  }

  public String getAddr2_City() {
    return this.addr2_City;
  }

  public void setAddr2_City(String addr2_City) {
    this.addr2_City = addr2_City;
  }

  public String getAddr2_Country() {
    return this.addr2_Country;
  }

  public void setAddr2_Country(String addr2_Country) {
    this.addr2_Country = addr2_Country;
  }

  public String getAddr2_Option() {
    return this.addr2_Option;
  }

  public void setAddr2_Option(String addr2_Option) {
    this.addr2_Option = addr2_Option;
  }

  public String getAddr2_St() {
    return this.addr2_St;
  }

  public void setAddr2_St(String addr2_St) {
    this.addr2_St = addr2_St;
  }

  public String getAddr2_Street1() {
    return this.addr2_Street1;
  }

  public void setAddr2_Street1(String addr2_Street1) {
    this.addr2_Street1 = addr2_Street1;
  }

  public String getAddr2_Street2() {
    return this.addr2_Street2;
  }

  public void setAddr2_Street2(String addr2_Street2) {
    this.addr2_Street2 = addr2_Street2;
  }

  public String getAddr2_Zip() {
    return this.addr2_Zip;
  }

  public void setAddr2_Zip(String addr2_Zip) {
    this.addr2_Zip = addr2_Zip;
  }

  public String getCity() {
    return this.city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getCountry() {
    return this.country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public String getCounty_Id() {
    return this.county_Id;
  }

  public void setCounty_Id(String county_Id) {
    this.county_Id = county_Id;
  }

  public String getEmail() {
    return this.email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getFax() {
    return this.fax;
  }

  public void setFax(String fax) {
    this.fax = fax;
  }

  public String getPhone() {
    return this.phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getPhone_Ext() {
    return this.phone_Ext;
  }

  public void setPhone_Ext(String phone_Ext) {
    this.phone_Ext = phone_Ext;
  }

  public String getPhone_Ext2() {
    return this.phone_Ext2;
  }

  public void setPhone_Ext2(String phone_Ext2) {
    this.phone_Ext2 = phone_Ext2;
  }

  public String getPhone2() {
    return this.phone2;
  }

  public void setPhone2(String phone2) {
    this.phone2 = phone2;
  }

  public String getSt() {
    return this.st;
  }

  public void setSt(String st) {
    this.st = st;
  }

  public String getStreet1() {
    return this.street1;
  }

  public void setStreet1(String street1) {
    this.street1 = street1;
  }

  public String getStreet2() {
    return this.street2;
  }

  public void setStreet2(String street2) {
    this.street2 = street2;
  }

  public String getZip() {
    return this.zip;
  }

  public void setZip(String zip) {
    this.zip = zip;
  }

}