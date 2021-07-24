package com.mukesh.surl.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.UUID;

@Entity(name = "impl_url")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SmallUrl {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  UUID id;

  @Column(name = "url")
  String url;

  @Column(name = "small_url")
  String smallUrl;

}
