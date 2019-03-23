package com.bin.liu.springboot.demo.mail;

import com.bin.liu.springboot.demo.common.ResultDto;
import com.bin.liu.springboot.demo.springboot.mail.MailSendService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: springboot-parent
 * @description: 邮件发送
 * @author: bin.liu
 * @create: 2019-03-23 16:40
 **/

@RestController
@RequestMapping(value = "/mail")
@Slf4j
@Api(tags = "邮件发送")
public class MailSendController {

    private static final String FILE_PATH= "/Users/liubin/Downloads/";

    @Resource
    private freemarker.template.Configuration freemarkerConfig;


    @Resource
    private MailSendService mailSendService;

    @PostMapping(value = "text")
    @ApiOperation("发送文本格式邮件")
    public ResultDto sendText(@RequestParam("from_account")String fromAccount, @RequestParam("to_account")String toAccount,@RequestParam("subject")String subject,@RequestParam("context")String context){
        boolean isSuccess = mailSendService.sendTextMail(fromAccount, toAccount, subject, context);
        if (isSuccess){
            return ResultDto.SUCCESS("发送成功");
        }
        return ResultDto.FAIL("发送失败");

    }

    @PostMapping(value = "attach")
    @ApiOperation("发送附件格式邮件")
    public ResultDto sendAttach(@RequestParam("from_account")String fromAccount, @RequestParam("to_account")String toAccount, @RequestParam("subject")String subject, @RequestParam("context")String context, @RequestParam()MultipartFile file) throws Exception{
        String originalFilename = file.getOriginalFilename();
        File newFile  = new File(FILE_PATH + originalFilename);
        file.transferTo(newFile);

        //设置替换的参数对象
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("userName",  "liubin" );
        context = FreeMarkerTemplateUtils.processTemplateIntoString(freemarkerConfig.getTemplate("mail.ftl"),model);

        List<File> attachFiles = new ArrayList<>();
        attachFiles.add(newFile);
        boolean isSuccess = mailSendService.sendAttach(fromAccount, toAccount, subject, context,attachFiles);
        if (isSuccess){
            return ResultDto.SUCCESS("发送成功");
        }
        return ResultDto.FAIL("发送失败");

    }
}
