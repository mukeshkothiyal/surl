package com.mukesh.surl.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Optional;

class GenerateUrlUtilityTest {

  @Test
  void generateSmallUrl() {
    Optional<String> hash = GenerateUrlUtility.generateSmallUrl("http://test.com/sdfhsdlfkdskfjsdlfjsl????ljsdfjoiweskjfsoiuwelr23809&dfkjsd=ljsdfjoiweskjfsoiuwelr23809&dlskfj=ljsdfjoiweskjfsoiuwelr23809&sdlkfj=ljsdfjoiweskjfsoiuwelr23809");
    Assertions.assertNotNull(hash.get());
  }
}