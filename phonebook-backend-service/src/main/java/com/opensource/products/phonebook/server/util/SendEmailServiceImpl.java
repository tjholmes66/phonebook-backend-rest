package com.opensource.products.phonebook.server.util;

import lombok.Setter;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Setter
@Transactional
@Service("sendEmailService")
public class SendEmailServiceImpl implements SendEmailService
{
    private JavaMailSender mailSender;

    @Override
    public void sendMail(String from, String to, String subject, String msg)
    {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(msg);
        mailSender.send(message);
    }
}
