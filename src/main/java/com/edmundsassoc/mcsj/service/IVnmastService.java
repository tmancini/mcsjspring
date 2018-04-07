package com.edmundsassoc.mcsj.service;

import java.util.List;
import com.edmundsassoc.mcsj.entity.Vnmast;

public interface IVnmastService {
  List<Vnmast> getAllVnmasts();

  Vnmast getVnmastById(String vnmId);

  boolean addVnmast(Vnmast vnmast);

  void updateVnmast(Vnmast vnmast);

  void deleteVnmast(String vnmId);
}