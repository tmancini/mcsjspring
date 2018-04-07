package com.edmundsassoc.mcsj.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.edmundsassoc.mcsj.entity.Tracking;
import com.edmundsassoc.mcsj.repository.TrackingRepository;

@Service
public class TrackingService implements ITrackingService {
  @Autowired
  private TrackingRepository trackingRepository;

  @Override
  public Tracking getTrackingById(String vnmId) {
    Tracking obj = trackingRepository.findOne(vnmId);
    return obj;
  }

  @Override
  public List<Tracking> getAllTrackings() {
    List<Tracking> list = new ArrayList<>();
    trackingRepository.findAll().forEach(e -> list.add(e));
    return list;
  }

  @Override
  public synchronized boolean addTracking(Tracking tracking) {
    Tracking vendor = trackingRepository.findOne(tracking.getTracking_Id());
    if(vendor != null) {
      return false;
    }
    else {
      trackingRepository.save(tracking);
      return true;
    }
  }

  @Override
  public void updateTracking(Tracking tracking) {
    trackingRepository.save(tracking);
  }

  @Override
  public void deleteTracking(String vnmId) {
    trackingRepository.delete(getTrackingById(vnmId));
  }
}