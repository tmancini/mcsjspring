package com.edmundsassoc.mcsj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.CommonsRequestLoggingFilter;

@SpringBootApplication
public class McsjApplicationServer {

  public static void main(String[] args) {
    SpringApplication.run(McsjApplicationServer.class, args);
  }

  @Bean
  public CommonsRequestLoggingFilter requestLoggingFilter() {
    CommonsRequestLoggingFilter crlf = new CommonsRequestLoggingFilter();
    crlf.setIncludeClientInfo(true);
    crlf.setIncludeQueryString(true);
    crlf.setIncludePayload(true);
    return crlf;
  }
}
