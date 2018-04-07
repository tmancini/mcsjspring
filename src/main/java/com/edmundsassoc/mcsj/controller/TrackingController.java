package com.edmundsassoc.mcsj.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.UriComponentsBuilder;
import com.edmundsassoc.mcsj.entity.Tracking;
import com.edmundsassoc.mcsj.service.ITrackingService;

@Controller
@RequestMapping("mcsj")
public class TrackingController {
  @Autowired
  private ITrackingService trackingService;

  @GetMapping("tracking/{id}")
  public ResponseEntity<Tracking> getTrackingById(@PathVariable("id") String vnmId) {
    Tracking tracking = trackingService.getTrackingById(vnmId);
    return new ResponseEntity<Tracking>(tracking, HttpStatus.OK);
  }

  @GetMapping("trackings")
  public ResponseEntity<List<Tracking>> getAllTrackings() {
    List<Tracking> list = trackingService.getAllTrackings();
    return new ResponseEntity<List<Tracking>>(list, HttpStatus.OK);
  }

  @PostMapping("tracking")
  public ResponseEntity<Void> addTracking(@RequestBody Tracking tracking, UriComponentsBuilder builder) {
    boolean flag = trackingService.addTracking(tracking);
    if(flag == false) {
      return new ResponseEntity<Void>(HttpStatus.CONFLICT);
    }
    HttpHeaders headers = new HttpHeaders();
    headers.setLocation(builder.path("/tracking/{id}").buildAndExpand(tracking.getTracking_Id()).toUri());
    return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
  }

  @PutMapping("tracking")
  public ResponseEntity<Tracking> updateTracking(@RequestBody Tracking tracking) {
    trackingService.updateTracking(tracking);
    return new ResponseEntity<Tracking>(tracking, HttpStatus.OK);
  }

  @DeleteMapping("tracking/{id}")
  public ResponseEntity<Void> deleteTracking(@PathVariable("id") String vnmId) {
    trackingService.deleteTracking(vnmId);
    return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
  }
}