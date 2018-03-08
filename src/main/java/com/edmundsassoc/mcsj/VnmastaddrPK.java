package com.edmundsassoc.mcsj;

import java.io.Serializable;
import javax.persistence.Embeddable;

/**
 * The primary key class for the vnmastaddr database table.
 * 
 */
@Embeddable
public class VnmastaddrPK implements Serializable {
  // default serial version id, required for serializable classes.
  private static final long serialVersionUID = 1L;

  private String vnm_Id;

  private int seq;

  public VnmastaddrPK() {
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
    if(!(other instanceof VnmastaddrPK)) {
      return false;
    }
    VnmastaddrPK castOther = (VnmastaddrPK)other;
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