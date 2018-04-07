package com.edmundsassoc.mcsj.entity;

import java.io.Serializable;
import javax.persistence.Embeddable;

/**
 * The primary key class for the vnmastcommodity database table.
 * 
 */
@Embeddable
public class VnmastcommodityPK implements Serializable {
  // default serial version id, required for serializable classes.
  private static final long serialVersionUID = 1L;

  private String vnm_Id;

  private int seq;

  public VnmastcommodityPK() {
  }

  public String getVnm_Id() {
    return this.vnm_Id;
  }

  public void setVnm_Id(String vnm_Id) {
    this.vnm_Id = vnm_Id;
  }

  public int getSeq() {
    return this.seq;
  }

  public void setSeq(int seq) {
    this.seq = seq;
  }

  public boolean equals(Object other) {
    if(this == other) {
      return true;
    }
    if(!(other instanceof VnmastcommodityPK)) {
      return false;
    }
    VnmastcommodityPK castOther = (VnmastcommodityPK)other;
    return this.vnm_Id.equals(castOther.vnm_Id) && (this.seq == castOther.seq);
  }

  public int hashCode() {
    final int prime = 31;
    int hash = 17;
    hash = hash * prime + this.vnm_Id.hashCode();
    hash = hash * prime + this.seq;

    return hash;
  }
}