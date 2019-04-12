package com.qf.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
/**
 * @author:admin
 * 测试多文件上传
 */
public class MoreUploadController {
    @RequestMapping(value = "moreuploadTest", method = RequestMethod.POST)
    /**
     * 这里的参数也可以使用CommonsMultipartFile作为形参，因为它是MultipartFile（接口）的实现类。
     * 不过建议使用MultipartFile，因为这样可以实现多态，方便扩展，而且实际上也是指向了它实现类CommonsMultipartFile
     */
    public Map<String, Object> moreuploadTest(MultipartFile dropzFile, HttpServletRequest request) {
        //拿map作为缓存区，因为上传的文件有可能不只一个
        Map<String, Object> result = new HashMap<String, Object>();
        // 获取上传的原始文件名
        String fileName = dropzFile.getOriginalFilename();
        // 设置文件上传路径(获取当前项目下的绝对路径)
        String filePath = request.getSession().getServletContext().getRealPath("/upload");
        // 获取文件后缀（.jpg）
        String fileSuffix = fileName.substring(fileName.lastIndexOf("."), fileName.length());
        // 判断并创建上传用的文件夹
        File file = new File(filePath);
        if (!file.exists()) {
            file.mkdir();
        }
        // 重新设置文件名为 UUID，以确保唯一
        file = new File(filePath, UUID.randomUUID() + fileSuffix);
        //获取绝对路径
        System.out.println(file.getAbsolutePath());
        //如果文件不存在，则创建
//        if(!file.exists()){
//            try {
//                file.createNewFile();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
        try {
            // 写入文件
            dropzFile.transferTo(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //返回 JSON 数据，这里只带入了文件名
        result.put("fileName", file.getName());
        return result;
    }
}
