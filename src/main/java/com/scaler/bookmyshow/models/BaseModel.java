package com.scaler.bookmyshow.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;
@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseModel {
  //for each table primary key is use @Id
  @Id
  //To generate unique value
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @CreatedDate
  @Temporal(value =  TemporalType.TIMESTAMP)
  private Date createdAt;

  @LastModifiedDate
  @Temporal(value = TemporalType.TIMESTAMP)
  private Date lastModifiedAt;

}
