package com.mukesh.surl.controller;

import com.mukesh.surl.exception.InvalidDataException;
import com.mukesh.surl.service.SurlService;
import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j
@RestController
public class SurlController {

  @Value("${base.url}")
  private String BASE_URL;

  SurlService surlService;

  @Autowired
  public SurlController(SurlService surlService) {
    this.surlService = surlService;
  }

  @GetMapping("/surl")
  @Operation(description = "Generate small url for your query string", tags = "surl")
  public ResponseEntity<String> getSmallUrl(@RequestParam String url) throws InvalidDataException {
    validateUrl(url);

    String surl = surlService.getSmallUrl(url);
    String completeSurl = BASE_URL + surl;
    log.info("Generated SURL:: {}", completeSurl);
    return ResponseEntity.ok(completeSurl);
  }

  @GetMapping("{smallUrl}")
  @Hidden
  @Operation(description = "Redirect to actual url represented by this small url", tags = "url")
  public ResponseEntity<Void> redirectToMainUrl(@PathVariable(name = "smallUrl") String smallUrl) {
    String url = surlService.getUrl(smallUrl);
    return ResponseEntity.status(HttpStatus.FOUND).location(URI.create(url)).build();
  }


  /**
   * Validate incoming URL
   *
   * @param url
   * @throws InvalidDataException if URL is not in accepted pattern
   */
  private void validateUrl(String url) throws InvalidDataException {
    String regex = "((http|https)://)(www.)?[a-zA-Z0-9@:%._\\+~#?&//=]{2,256}\\.[a-z]{2,6}\\b([-a-zA-Z0-9@:%._\\+~#?&//=]*)";

    Pattern p = Pattern.compile(regex);
    Matcher m = p.matcher(url);

    if (!m.matches()) {
      throw new InvalidDataException("Invalid URL:: " + url);
    }
  }
}
