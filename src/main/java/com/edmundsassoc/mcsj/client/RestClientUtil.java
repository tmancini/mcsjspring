package com.edmundsassoc.mcsj.client;

import java.net.URI;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import com.edmundsassoc.mcsj.entity.Vnmast;

public class RestClientUtil {
  public void getVnmastByIdDemo() {
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);
    RestTemplate restTemplate = new RestTemplate();
    String url = "http://localhost:8080//mcsj/vnmast/{id}";
    HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
    ResponseEntity<Vnmast> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Vnmast.class, "00001");
    Vnmast vnmast = responseEntity.getBody();
    System.out.println("Id:" + vnmast.getVnm_Id() + ", Name:" + vnmast.getName() + ", Status:" + vnmast.getStatus());
  }

  public void getAllVnmastsDemo() {
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);
    RestTemplate restTemplate = new RestTemplate();
    String url = "http://localhost:8080//mcsj/vnmasts";
    HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
    ResponseEntity<Vnmast[]> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Vnmast[].class);
    Vnmast[] vnmasts = responseEntity.getBody();
    for(Vnmast vnmast : vnmasts) {
      System.out.println("Id:" + vnmast.getVnm_Id() + ", Name:" + vnmast.getName() + ", Status: " + vnmast.getStatus());
    }
  }

  public void addVnmastDemo() {
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);
    RestTemplate restTemplate = new RestTemplate();
    String url = "http://localhost:8080//mcsj/vnmast";
    Vnmast objVnmast = new Vnmast();
    objVnmast.setName("Spring REST Security using Hibernate");
    objVnmast.setStatus("A");
    HttpEntity<Vnmast> requestEntity = new HttpEntity<Vnmast>(objVnmast, headers);
    URI uri = restTemplate.postForLocation(url, requestEntity);
    System.out.println(uri.getPath());
  }

  public void updateVnmastDemo() {
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);
    RestTemplate restTemplate = new RestTemplate();
    String url = "http://localhost:8080//mcsj/vnmast";
    Vnmast objVnmast = new Vnmast();
    objVnmast.setVnm_Id("TEST005");
    objVnmast.setName("Update:Java Concurrency");
    objVnmast.setStatus("I");
    HttpEntity<Vnmast> requestEntity = new HttpEntity<Vnmast>(objVnmast, headers);
    restTemplate.put(url, requestEntity);
  }

  public void deleteVnmastDemo() {
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);
    RestTemplate restTemplate = new RestTemplate();
    String url = "http://localhost:8080//mcsj/vnmast/{id}";
    HttpEntity<Vnmast> requestEntity = new HttpEntity<Vnmast>(headers);
    restTemplate.exchange(url, HttpMethod.DELETE, requestEntity, Void.class, 4);
  }

  public static void main(String args[]) {
    RestClientUtil util = new RestClientUtil();
    // util.getVnmastByIdDemo();
    // util.addVnmastDemo();
    // util.updateVnmastDemo();
    // util.deleteVnmastDemo();
    util.getAllVnmastsDemo();
  }
}