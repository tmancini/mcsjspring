package com.edmundsassoc.mcsj.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the vnmast database table.
 * 
 */
@Entity
@NamedQuery(name = "Vnmast.findAll", query = "SELECT v FROM Vnmast v")
public class Vnmast implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  private String vnm_Id;

  private String account_Num;

  private String addr1099_City;

  private String addr1099_Country;

  private String addr1099_Fax;

  private String addr1099_Phone;

  private String addr1099_Phone_Ext;

  private String addr1099_St;

  private String addr1099_Street1;

  private String addr1099_Street2;

  private String addr1099_Zip;

  private String addr2_City;

  private String addr2_Country;

  private String addr2_St;

  private String addr2_Street1;

  private String addr2_Street2;

  private String addr2_Zip;

  private String allow_VP_Connect;

  private BigDecimal amt_Paid_Bid;

  private BigDecimal amt_Paid_Exempt;

  private BigDecimal amt_Paid_Other;

  private BigDecimal amt_Paid_State;

  @Temporal(TemporalType.DATE)
  private Date cert_Date;

  private String cert_Num;

  private String city;

  private String contact;

  private String country;

  private String county_Id;

  private String dd_Account_Num;

  private String dd_Acct_Type;

  private String dd_Bank_Dfi;

  private String dd_Disable_Flag;

  private String dd_Prenote;

  private String do_Not_Mail_Flag;

  private String email;

  private String epo_Flag;

  @Temporal(TemporalType.DATE)
  private Date everify_Date;

  private String everify_Num;

  private String fax;

  private String female_Owner;

  @Temporal(TemporalType.DATE)
  private Date last_Pymt_Date;

  private String legal_Name;

  private String name;

  private String note1;

  private String note2;

  private String note3;

  private String pay_Terms;

  private String phone;

  private String phone_Ext;

  private String phone_Ext2;

  private String phone2;

  private String race;

  private String separate_Check_Flag;

  private String small_Business;

  private String st;

  private String st_Contract;

  private String status;

  private String street1;

  private String street2;

  private String tax_Id;

  private String threshold_Flag;

  private String type_1099;

  private String type_TIN;

  private String viatech_Flag;

  private String VP_Password;

  private String VP_Username;

  @Temporal(TemporalType.DATE)
  private Date w9_Date;

  private String website;

  private String zip;

  // bi-directional many-to-one association to Vnmastaddr
  @OneToMany(cascade = CascadeType.ALL)
  @JoinColumns({@JoinColumn(name = "vnm_id", referencedColumnName = "vnm_Id")})
  private List<Vnmastaddr> vnmastaddrs;

  // bi-directional many-to-one association to Vnmastcommodity
  @OneToMany(cascade = CascadeType.ALL)
  @JoinColumns({@JoinColumn(name = "vnm_id", referencedColumnName = "vnm_Id")})
  private List<Vnmastcommodity> vnmastcommodities;

  public Vnmast() {
  }

  public String getVnm_Id() {
    return this.vnm_Id;
  }

  public void setVnm_Id(String vnm_Id) {
    this.vnm_Id = vnm_Id;
  }

  public String getAccount_Num() {
    return this.account_Num;
  }

  public void setAccount_Num(String account_Num) {
    this.account_Num = account_Num;
  }

  public String getAddr1099_City() {
    return this.addr1099_City;
  }

  public void setAddr1099_City(String addr1099_City) {
    this.addr1099_City = addr1099_City;
  }

  public String getAddr1099_Country() {
    return this.addr1099_Country;
  }

  public void setAddr1099_Country(String addr1099_Country) {
    this.addr1099_Country = addr1099_Country;
  }

  public String getAddr1099_Fax() {
    return this.addr1099_Fax;
  }

  public void setAddr1099_Fax(String addr1099_Fax) {
    this.addr1099_Fax = addr1099_Fax;
  }

  public String getAddr1099_Phone() {
    return this.addr1099_Phone;
  }

  public void setAddr1099_Phone(String addr1099_Phone) {
    this.addr1099_Phone = addr1099_Phone;
  }

  public String getAddr1099_Phone_Ext() {
    return this.addr1099_Phone_Ext;
  }

  public void setAddr1099_Phone_Ext(String addr1099_Phone_Ext) {
    this.addr1099_Phone_Ext = addr1099_Phone_Ext;
  }

  public String getAddr1099_St() {
    return this.addr1099_St;
  }

  public void setAddr1099_St(String addr1099_St) {
    this.addr1099_St = addr1099_St;
  }

  public String getAddr1099_Street1() {
    return this.addr1099_Street1;
  }

  public void setAddr1099_Street1(String addr1099_Street1) {
    this.addr1099_Street1 = addr1099_Street1;
  }

  public String getAddr1099_Street2() {
    return this.addr1099_Street2;
  }

  public void setAddr1099_Street2(String addr1099_Street2) {
    this.addr1099_Street2 = addr1099_Street2;
  }

  public String getAddr1099_Zip() {
    return this.addr1099_Zip;
  }

  public void setAddr1099_Zip(String addr1099_Zip) {
    this.addr1099_Zip = addr1099_Zip;
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

  public String getAllow_VP_Connect() {
    return this.allow_VP_Connect;
  }

  public void setAllow_VP_Connect(String allow_VP_Connect) {
    this.allow_VP_Connect = allow_VP_Connect;
  }

  public BigDecimal getAmt_Paid_Bid() {
    return this.amt_Paid_Bid;
  }

  public void setAmt_Paid_Bid(BigDecimal amt_Paid_Bid) {
    this.amt_Paid_Bid = amt_Paid_Bid;
  }

  public BigDecimal getAmt_Paid_Exempt() {
    return this.amt_Paid_Exempt;
  }

  public void setAmt_Paid_Exempt(BigDecimal amt_Paid_Exempt) {
    this.amt_Paid_Exempt = amt_Paid_Exempt;
  }

  public BigDecimal getAmt_Paid_Other() {
    return this.amt_Paid_Other;
  }

  public void setAmt_Paid_Other(BigDecimal amt_Paid_Other) {
    this.amt_Paid_Other = amt_Paid_Other;
  }

  public BigDecimal getAmt_Paid_State() {
    return this.amt_Paid_State;
  }

  public void setAmt_Paid_State(BigDecimal amt_Paid_State) {
    this.amt_Paid_State = amt_Paid_State;
  }

  public Date getCert_Date() {
    return this.cert_Date;
  }

  public void setCert_Date(Date cert_Date) {
    this.cert_Date = cert_Date;
  }

  public String getCert_Num() {
    return this.cert_Num;
  }

  public void setCert_Num(String cert_Num) {
    this.cert_Num = cert_Num;
  }

  public String getCity() {
    return this.city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getContact() {
    return this.contact;
  }

  public void setContact(String contact) {
    this.contact = contact;
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

  public String getDd_Account_Num() {
    return this.dd_Account_Num;
  }

  public void setDd_Account_Num(String dd_Account_Num) {
    this.dd_Account_Num = dd_Account_Num;
  }

  public String getDd_Acct_Type() {
    return this.dd_Acct_Type;
  }

  public void setDd_Acct_Type(String dd_Acct_Type) {
    this.dd_Acct_Type = dd_Acct_Type;
  }

  public String getDd_Bank_Dfi() {
    return this.dd_Bank_Dfi;
  }

  public void setDd_Bank_Dfi(String dd_Bank_Dfi) {
    this.dd_Bank_Dfi = dd_Bank_Dfi;
  }

  public String getDd_Disable_Flag() {
    return this.dd_Disable_Flag;
  }

  public void setDd_Disable_Flag(String dd_Disable_Flag) {
    this.dd_Disable_Flag = dd_Disable_Flag;
  }

  public String getDd_Prenote() {
    return this.dd_Prenote;
  }

  public void setDd_Prenote(String dd_Prenote) {
    this.dd_Prenote = dd_Prenote;
  }

  public String getDo_Not_Mail_Flag() {
    return this.do_Not_Mail_Flag;
  }

  public void setDo_Not_Mail_Flag(String do_Not_Mail_Flag) {
    this.do_Not_Mail_Flag = do_Not_Mail_Flag;
  }

  public String getEmail() {
    return this.email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getEpo_Flag() {
    return this.epo_Flag;
  }

  public void setEpo_Flag(String epo_Flag) {
    this.epo_Flag = epo_Flag;
  }

  public Date getEverify_Date() {
    return this.everify_Date;
  }

  public void setEverify_Date(Date everify_Date) {
    this.everify_Date = everify_Date;
  }

  public String getEverify_Num() {
    return this.everify_Num;
  }

  public void setEverify_Num(String everify_Num) {
    this.everify_Num = everify_Num;
  }

  public String getFax() {
    return this.fax;
  }

  public void setFax(String fax) {
    this.fax = fax;
  }

  public String getFemale_Owner() {
    return this.female_Owner;
  }

  public void setFemale_Owner(String female_Owner) {
    this.female_Owner = female_Owner;
  }

  public Date getLast_Pymt_Date() {
    return this.last_Pymt_Date;
  }

  public void setLast_Pymt_Date(Date last_Pymt_Date) {
    this.last_Pymt_Date = last_Pymt_Date;
  }

  public String getLegal_Name() {
    return this.legal_Name;
  }

  public void setLegal_Name(String legal_Name) {
    this.legal_Name = legal_Name;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getNote1() {
    return this.note1;
  }

  public void setNote1(String note1) {
    this.note1 = note1;
  }

  public String getNote2() {
    return this.note2;
  }

  public void setNote2(String note2) {
    this.note2 = note2;
  }

  public String getNote3() {
    return this.note3;
  }

  public void setNote3(String note3) {
    this.note3 = note3;
  }

  public String getPay_Terms() {
    return this.pay_Terms;
  }

  public void setPay_Terms(String pay_Terms) {
    this.pay_Terms = pay_Terms;
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

  public String getRace() {
    return this.race;
  }

  public void setRace(String race) {
    this.race = race;
  }

  public String getSeparate_Check_Flag() {
    return this.separate_Check_Flag;
  }

  public void setSeparate_Check_Flag(String separate_Check_Flag) {
    this.separate_Check_Flag = separate_Check_Flag;
  }

  public String getSmall_Business() {
    return this.small_Business;
  }

  public void setSmall_Business(String small_Business) {
    this.small_Business = small_Business;
  }

  public String getSt() {
    return this.st;
  }

  public void setSt(String st) {
    this.st = st;
  }

  public String getSt_Contract() {
    return this.st_Contract;
  }

  public void setSt_Contract(String st_Contract) {
    this.st_Contract = st_Contract;
  }

  public String getStatus() {
    return this.status;
  }

  public void setStatus(String status) {
    this.status = status;
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

  public String getTax_Id() {
    return this.tax_Id;
  }

  public void setTax_Id(String tax_Id) {
    this.tax_Id = tax_Id;
  }

  public String getThreshold_Flag() {
    return this.threshold_Flag;
  }

  public void setThreshold_Flag(String threshold_Flag) {
    this.threshold_Flag = threshold_Flag;
  }

  public String getType_1099() {
    return this.type_1099;
  }

  public void setType_1099(String type_1099) {
    this.type_1099 = type_1099;
  }

  public String getType_TIN() {
    return this.type_TIN;
  }

  public void setType_TIN(String type_TIN) {
    this.type_TIN = type_TIN;
  }

  public String getViatech_Flag() {
    return this.viatech_Flag;
  }

  public void setViatech_Flag(String viatech_Flag) {
    this.viatech_Flag = viatech_Flag;
  }

  public String getVP_Password() {
    return this.VP_Password;
  }

  public void setVP_Password(String VP_Password) {
    this.VP_Password = VP_Password;
  }

  public String getVP_Username() {
    return this.VP_Username;
  }

  public void setVP_Username(String VP_Username) {
    this.VP_Username = VP_Username;
  }

  public Date getW9_Date() {
    return this.w9_Date;
  }

  public void setW9_Date(Date w9_Date) {
    this.w9_Date = w9_Date;
  }

  public String getWebsite() {
    return this.website;
  }

  public void setWebsite(String website) {
    this.website = website;
  }

  public String getZip() {
    return this.zip;
  }

  public void setZip(String zip) {
    this.zip = zip;
  }

  public List<Vnmastaddr> getVnmastaddrs() {
    return this.vnmastaddrs;
  }

  public void setVnmastaddrs(List<Vnmastaddr> vnmastaddrs) {
    this.vnmastaddrs = vnmastaddrs;
  }

  public Vnmastaddr addVnmastaddr(Vnmastaddr vnmastaddr) {
    getVnmastaddrs().add(vnmastaddr);
    return vnmastaddr;
  }

  public Vnmastaddr removeVnmastaddr(Vnmastaddr vnmastaddr) {
    getVnmastaddrs().remove(vnmastaddr);
    return vnmastaddr;
  }

  public List<Vnmastcommodity> getVnmastcommodities() {
    return this.vnmastcommodities;
  }

  public void setVnmastcommodities(List<Vnmastcommodity> vnmastcommodities) {
    this.vnmastcommodities = vnmastcommodities;
  }

  public Vnmastcommodity addVnmastcommodity(Vnmastcommodity vnmastcommodity) {
    getVnmastcommodities().add(vnmastcommodity);
    return vnmastcommodity;
  }

  public Vnmastcommodity removeVnmastcommodity(Vnmastcommodity vnmastcommodity) {
    getVnmastcommodities().remove(vnmastcommodity);
    return vnmastcommodity;
  }

}