package com.ms.email.dtos;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class EmailDto {

  @NotNull
  private String ownerRef;

  @NotNull
  @Email
  private String emailFrom;

  @NotNull
  @Email
  private String emailTo;

  @NotNull
  private String subject;

  @NotNull
  private String text;
}
