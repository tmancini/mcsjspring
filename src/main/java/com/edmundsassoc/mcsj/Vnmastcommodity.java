package com.edmundsassoc.mcsj;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;

/**
 * The persistent class for the vnmastcommodity database table.
 * 
 */
@Entity
@NamedQuery(name = "Vnmastcommodity.findAll", query = "SELECT v FROM Vnmastcommodity v")
public class Vnmastcommodity implements Serializable {
  private static final long serialVersionUID = 1L;

  @EmbeddedId
  private VnmastcommodityPK id;

  private String commodity_Code;

  public Vnmastcommodity() {
  }

  public VnmastcommodityPK getId() {
    return this.id;
  }

  public void setId(VnmastcommodityPK id) {
    this.id = id;
  }

  public String getCommodity_Code() {
    return this.commodity_Code;
  }

  public void setCommodity_Code(String commodity_Code) {
    this.commodity_Code = commodity_Code;
  }

}