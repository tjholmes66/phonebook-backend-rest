package com.opensource.products.phonebook.server.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service("sendEmailService")
public class SendEmailServiceImpl implements SendEmailService
{
    @Autowired
    private MailSender mailSender;

    public MailSender getMailSender()
    {
        return mailSender;
    }

    public void setMailSender(MailSender mailSender)
    {
        this.mailSender = mailSender;
    }

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
