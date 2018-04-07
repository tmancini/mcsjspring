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
import com.edmundsassoc.mcsj.entity.Vnmast;
import com.edmundsassoc.mcsj.service.IVnmastService;

@Controller
@RequestMapping("mcsj")
public class VnmastController {
  @Autowired
  private IVnmastService vnmastService;

  @GetMapping("vnmast/{id}")
  public ResponseEntity<Vnmast> getVnmastById(@PathVariable("id") String vnmId) {
    Vnmast vnmast = vnmastService.getVnmastById(vnmId);
    return new ResponseEntity<Vnmast>(vnmast, HttpStatus.OK);
  }

  @GetMapping("vnmasts")
  public ResponseEntity<List<Vnmast>> getAllVnmasts() {
    List<Vnmast> list = vnmastService.getAllVnmasts();
    return new ResponseEntity<List<Vnmast>>(list, HttpStatus.OK);
  }

  @PostMapping("vnmast")
  public ResponseEntity<Void> addVnmast(@RequestBody Vnmast vnmast, UriComponentsBuilder builder) {
    boolean flag = vnmastService.addVnmast(vnmast);
    if(flag == false) {
      return new ResponseEntity<Void>(HttpStatus.CONFLICT);
    }
    HttpHeaders headers = new HttpHeaders();
    headers.setLocation(builder.path("/vnmast/{id}").buildAndExpand(vnmast.getVnm_Id()).toUri());
    return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
  }

  @PutMapping("vnmast")
  public ResponseEntity<Vnmast> updateVnmast(@RequestBody Vnmast vnmast) {
    vnmastService.updateVnmast(vnmast);
    return new ResponseEntity<Vnmast>(vnmast, HttpStatus.OK);
  }

  @DeleteMapping("vnmast/{id}")
  public ResponseEntity<Void> deleteVnmast(@PathVariable("id") String vnmId) {
    vnmastService.deleteVnmast(vnmId);
    return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
  }
}