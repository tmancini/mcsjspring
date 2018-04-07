package com.edmundsassoc.mcsj.service;

import java.util.List;
import com.edmundsassoc.mcsj.entity.Tracking;

public interface ITrackingService {
  List<Tracking> getAllTrackings();

  Tracking getTrackingById(String vnmId);

  boolean addTracking(Tracking tracking);

  void updateTracking(Tracking tracking);

  void deleteTracking(String vnmId);
}