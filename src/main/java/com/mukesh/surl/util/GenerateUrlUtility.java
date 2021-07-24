package com.mukesh.surl.util;

import lombok.extern.slf4j.Slf4j;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Optional;

@Slf4j
public class GenerateUrlUtility {
  private static final char[] BASE62ARR = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ01234567890".toCharArray();
  private static final int BUCKETS = 5;

  public static Optional<String> generateSmallUrl(String url) {
    String smallUrl = null;
    try {
      MessageDigest md = MessageDigest.getInstance("MD5");
      byte[] digest = md.digest(url.getBytes(StandardCharsets.UTF_8));
      BigInteger no = new BigInteger(1, digest);
      // use max radix to reduce size
      String hash = no.toString(36);
      int bucketSize = hash.length() / BUCKETS;
      char[] smallUrlArr = new char[BUCKETS];
      for (int startIndex = 0, j = 0; j < BUCKETS; ) {
        int endIndex = startIndex + bucketSize <= hash.length() ? startIndex + bucketSize : hash.length();
        String tempStr = hash.substring(startIndex, endIndex);
        smallUrlArr[j] = BASE62ARR[tempStr.hashCode() % 62];

        startIndex = startIndex + bucketSize;
        j++;
      }
      smallUrl = new String(smallUrlArr);
      log.info("SmallURL:: {}, URL:: {}", smallUrl, url);
    } catch (NoSuchAlgorithmException e) {
      log.error("Exception occurred while assigning Hashing algo for Message Digest", e);
    }
    return Optional.ofNullable(smallUrl);
  }
}
