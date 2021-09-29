package com.ms.email.models;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "tb_email")
public class EmailModel implements Serializable {
  private static final long serialVersionUID = 1l;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  private String ownerRef;

  private String emailFrom;

  private String emailTo;

  private String subject;

  @Column(columnDefinition = "TEXT")
  private String text;

  private LocalDateTime sendDateEmail;
  private StatusEmail statusEmail;
  
  public enum StatusEmail {
    SENT,
    ERROR
  }
}
