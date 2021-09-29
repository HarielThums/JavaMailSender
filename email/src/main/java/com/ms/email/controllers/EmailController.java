package com.ms.email.controllers;

import java.util.List;

import javax.validation.Valid;

import com.ms.email.dtos.EmailDto;
import com.ms.email.models.EmailModel;
import com.ms.email.services.EmailService;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {
  
  @Autowired
  EmailService emailService;

  @PostMapping("/sending-mail")
  public ResponseEntity<EmailModel> sendEmail(@RequestBody @Valid EmailDto email) {
    EmailModel emailModel = new EmailModel();

    BeanUtils.copyProperties(email, emailModel);

    emailService.sendEmail(emailModel);

    return new ResponseEntity<>(emailModel, HttpStatus.CREATED);
  }

  @GetMapping("/emails")
  public ResponseEntity<List<EmailModel>> getEmails() {
    return new ResponseEntity<>(emailService.findAll(), HttpStatus.OK);
  }
}