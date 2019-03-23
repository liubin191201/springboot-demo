package com.bin.liu.springboot.demo.springboot.mail;

import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.mail.Message;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.List;

/**
 * @program: springboot-parent
 * @description: 邮件发送
 * @author: bin.liu
 * @create: 2019-03-23 16:23
 **/

@Component
@Slf4j
public class MailSendService{

    @Resource
    private JavaMailSender javaMailSender;

    /** 
    * @Description: 纯文本格式 
    * @Param: [fromAccount, toAccount, subject, context] 
    * @return: boolean 
    * @Author: bin.liu 
    * @Date: 2019-03-23 
    */ 
    public boolean sendTextMail(String fromAccount,String toAccount,String subject,String context){
        boolean isSuccess = true;

        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(fromAccount);
            message.setTo(toAccount);
            message.setSubject(subject);
            message.setText(context);
            javaMailSender.send(message);
        }catch (Exception e){
            isSuccess = false;
            log.info("发送邮件错误",e);
        }
        return isSuccess;
    }
    
    /** 
    * @Description: 包含附件
    * @Param: [fromAccount, toAccount, subject, context, attachFiles] 
    * @return: boolean 
    * @Author: bin.liu 
    * @Date: 2019-03-23 
    */ 
    public boolean sendAttach(String fromAccount, String toAccount, String subject, String context, List<File> attachFiles){
        boolean isSuccess = true;

        try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();

            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,true);
            helper.setFrom(fromAccount);
            helper.setTo(toAccount);
            helper.setSubject(subject);
            helper.setText(context,true);

                //抄送人
            //helper.setCc("");
                //密送人
            //helper.setBcc("");
            
            if (attachFiles != null && attachFiles.size() > 0){
                for (File attachFile:attachFiles) {
                    helper.addAttachment(attachFile.getName(), attachFile);
                }
            }
            javaMailSender.send(mimeMessage);
        }catch (Exception e){
            isSuccess = false;
            log.info("发送邮件错误",e);
        }
        return isSuccess;
    }



}
