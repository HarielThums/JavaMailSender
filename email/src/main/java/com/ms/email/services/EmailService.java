package com.ms.email.services;

import java.time.LocalDateTime;
import java.util.List;

import com.ms.email.models.EmailModel;
import com.ms.email.models.EmailModel.StatusEmail;
import com.ms.email.repositories.EmailRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

  @Autowired
  EmailRepository emailRepository;

  @Autowired
  private JavaMailSender emailSender;

  public EmailModel sendEmail(EmailModel email) {
    try {
      SimpleMailMessage message = new SimpleMailMessage();
      
      email.setSendDateEmail(LocalDateTime.now());

      message.setFrom(email.getEmailFrom());
      message.setTo(email.getEmailTo());
      message.setSubject(email.getSubject());
      message.setText(email.getText());
      emailSender.send(message);

      email.setStatusEmail(StatusEmail.SENT);

    } catch (Exception e) {
      System.out.println(e);
      email.setStatusEmail(StatusEmail.ERROR);
    } finally {
      return emailRepository.save(email);
    }
  }

  public List<EmailModel> findAll() {
    return emailRepository.findAll();
  }

}
