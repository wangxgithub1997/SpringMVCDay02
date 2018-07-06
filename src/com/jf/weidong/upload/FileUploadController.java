package com.jf.weidong.upload;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Controller
public class FileUploadController {

    @RequestMapping("/fileUpload")
    public String fileUpload(String name,
    @RequestParam("uploadFile") List<MultipartFile> uploadFile) throws IOException {
        System.out.println("执行了");
        if (!uploadFile.isEmpty()) {
            for (MultipartFile file : uploadFile) {
                String filename = file.getOriginalFilename();//获取文件真实的名称
                String newFileName = name + "_" + UUID.randomUUID() + "_" + filename;
                System.out.println(newFileName);
                File filePath = new File("D:\\upload\\");
                file.transferTo(new File(filePath, newFileName));
            }
        }
        return "index.jsp";
    }

}
