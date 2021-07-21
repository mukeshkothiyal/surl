package com.mukesh.surl.controller;

import com.mukesh.surl.service.SurlService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class SurlController {

  SurlService surlService;

  @Autowired
  public SurlController(SurlService surlService) {
    this.surlService = surlService;
  }

  @GetMapping("/surl")
  public ResponseEntity<String> getSmallUrl(@RequestParam String url) {
    log.info("Inside getSmallUrl with URL: {}", url);
    String surl = surlService.getSmallUrl(url);
    log.info("Inside getSmallUrl with generated SURL: {}", surl);
    return ResponseEntity.ok(surl);
  }
}
