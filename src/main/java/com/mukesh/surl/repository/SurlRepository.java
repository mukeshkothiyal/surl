package com.mukesh.surl.repository;

import com.mukesh.surl.model.SmallUrl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SurlRepository extends JpaRepository<SmallUrl, UUID> {

  SmallUrl findBySmallUrl(String smallUrl);

  boolean existsBySmallUrl(String smallUrl);
}
