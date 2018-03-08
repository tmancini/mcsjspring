package com.edmundsassoc.mcsj;

import java.util.ArrayList;
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

@Controller
@RequestMapping("mcsj")
public class VnmastService {
  @Autowired
  private VnmastRepository repo;

  @GetMapping("vnmast/{id}")
  public ResponseEntity<Vnmast> getVendorById(@PathVariable("id") String id) {
    Vnmast vnmast = repo.findOne(id);
    ResponseEntity<Vnmast> responseEntity = new ResponseEntity<Vnmast>(vnmast, HttpStatus.OK);
    return responseEntity;
  }

  @GetMapping("vnmasts")
  public ResponseEntity<List<Vnmast>> getAllVnmasts() {
    List<Vnmast> list = new ArrayList<>();
    repo.findAll().forEach(e -> list.add(e));
    return new ResponseEntity<List<Vnmast>>(list, HttpStatus.OK);
  }

  @PostMapping("vnmast")
  public ResponseEntity<Void> addVnmast(@RequestBody Vnmast vnmast, UriComponentsBuilder builder) {
    Vnmast vendor = repo.findOne(vnmast.getVnm_Id());
    if(vendor == null) {
      return new ResponseEntity<Void>(HttpStatus.CONFLICT);
    }
    else {
      repo.save(vnmast);
      HttpHeaders headers = new HttpHeaders();
      headers.setLocation(builder.path("/article/{id}").buildAndExpand(vnmast.getVnm_Id()).toUri());
      return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
  }

  @PutMapping("vnmast")
  public ResponseEntity<Vnmast> updateVnmast(@RequestBody Vnmast article) {
    repo.save(article);
    return new ResponseEntity<Vnmast>(article, HttpStatus.OK);
  }

  @DeleteMapping("vnmast/{id}")
  public ResponseEntity<Void> deleteVnmast(@PathVariable("id") String id) {
    repo.delete(id);
    return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
  }
}
