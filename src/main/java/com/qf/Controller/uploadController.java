package com.qf.Controller;


import com.qf.Entity.User;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.*;

//@RestController
@Controller
public class uploadController {
    /**
     * 文件上传
     */
    @RequestMapping(value = "fileuploadTest",method = RequestMethod.POST)
    public void fileuploadTest(@RequestParam(value ="file")CommonsMultipartFile commonsMultipartFile) throws IOException {
        //给一个时间戳，防止文件重名
        long time=System.currentTimeMillis();
        //上传路径
        //commonsMultipartFile.getOriginalFilename():获取文件上传的文件名
        String path="G:/"+time+commonsMultipartFile.getOriginalFilename();
        //上传文件
        commonsMultipartFile.transferTo(new File(path));
    }

    /**
     * 文件下载
     */
    @RequestMapping(value = "downloadFile")
    public ResponseEntity<byte[]> downloadFile() throws FileNotFoundException ,IOException{
       //要下载的文件路径
        File file=new File("G://1554721492036slideshow3.jpg");
        //用流读取
        InputStream in=new FileInputStream(file);
        //创建一个缓冲字节数组，长度是file的长度
        byte[] b=new byte[in.available()];
        //读
        in.read(b);
        //设置响应头
        HttpHeaders Headers=new HttpHeaders();
        Headers.add("Content-Disposition", "attchement;filename=" + file.getName());
        //设置状态
        HttpStatus status=HttpStatus.OK;
        //根据springMVC提供的包装类包装，然后响应
        ResponseEntity responseEntity=new ResponseEntity(b,Headers,status);
        return  responseEntity;
    }
    /**
     * Thymeleaf 测试
     */
    /**
     * @PostMapping:@RequestMapping(method = RequestMethod.POST)
     * @GetMapping:@RequestMapping(method = RequestMethod.GET)
     */
    @GetMapping("hello")
    public Object hello(Model model) {
        User user=new User();
        user.setName("zs");
        model.addAttribute("user", user);
        return "TestFileupload";
    }
}
