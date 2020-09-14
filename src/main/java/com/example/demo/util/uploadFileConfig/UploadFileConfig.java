package com.example.demo.util.uploadFileConfig;

import java.io.File;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 * 上传文件测试
 * 
 * @author Administrator
 *
 */
@Controller
public class UploadFileConfig {
	private static final Logger LOGGER = LoggerFactory.getLogger(UploadFileConfig.class);

	@Value("${file.uploadFilePath}")
	private String fileRootPath;

	@GetMapping("/upload")
	public String upload() {
		return "upload";
	}

	@PostMapping("/uploadfile")
	@ResponseBody
	public String upload(@RequestParam("file") MultipartFile[] files) {
		String filePath = "";
		// 多文件上传
		for (MultipartFile file : files) {
			// 上传简单文件名
			String originalFilename = file.getOriginalFilename();
			LOGGER.info(originalFilename);
			// 存储路径
			filePath = new StringBuilder(fileRootPath).append(System.currentTimeMillis()).append(originalFilename)
					.toString();
			try {
				// 保存文件
				file.transferTo(new File(filePath));
			} catch (IOException e) {
				LOGGER.error(e.toString());
			}
		}
		return filePath;
	}
}
