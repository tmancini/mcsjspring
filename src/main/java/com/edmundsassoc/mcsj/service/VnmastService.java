package com.edmundsassoc.mcsj.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.edmundsassoc.mcsj.entity.Vnmast;
import com.edmundsassoc.mcsj.repository.VnmastRepository;

@Service
public class VnmastService implements IVnmastService {
  @Autowired
  private VnmastRepository vnmastRepository;

  @Override
  public Vnmast getVnmastById(String vnmId) {
    Vnmast obj = vnmastRepository.findOne(vnmId);
    return obj;
  }

  @Override
  public List<Vnmast> getAllVnmasts() {
    List<Vnmast> list = new ArrayList<>();
    vnmastRepository.findAll().forEach(e -> list.add(e));
    return list;
  }

  @Override
  public synchronized boolean addVnmast(Vnmast vnmast) {
    Vnmast vendor = vnmastRepository.findOne(vnmast.getVnm_Id());
    if(vendor != null) {
      return false;
    }
    else {
      vnmastRepository.save(vnmast);
      return true;
    }
  }

  @Override
  public void updateVnmast(Vnmast vnmast) {
    vnmastRepository.save(vnmast);
  }

  @Override
  public void deleteVnmast(String vnmId) {
    vnmastRepository.delete(getVnmastById(vnmId));
  }
}