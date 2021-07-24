package com.mukesh.surl.service;

import com.mukesh.surl.model.SmallUrl;
import com.mukesh.surl.repository.SurlRepository;
import com.mukesh.surl.util.GenerateUrlUtility;
import org.springframework.stereotype.Service;

@Service
public class SurlService {

  SurlRepository repository;

  public SurlService(SurlRepository repository) {
    this.repository = repository;
  }

  public String getSmallUrl(String url) {
    String smallUrl = GenerateUrlUtility.generateSmallUrl(url).get();

    if (!repository.existsBySmallUrl(smallUrl)) {
      SmallUrl entity = new SmallUrl();
      entity.setUrl(url);
      entity.setSmallUrl(smallUrl);

      repository.saveAndFlush(entity);
    }

    return smallUrl;
  }

  public String getUrl(String smallUrl) {
    SmallUrl entity = repository.findBySmallUrl(smallUrl);
    return entity.getUrl();
  }
}
