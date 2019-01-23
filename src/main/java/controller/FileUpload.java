package controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import pagemodel.MSG;

@Api(tags = "文件上传")
@Controller
public class FileUpload {

	@ApiOperation("文件上传页面")
	@RequestMapping(value = "/fileupload", method = RequestMethod.GET)
	public String upload() {
		return "/html/fileupload.html";
	}

	@ApiOperation("上传一个文件")
	@RequestMapping(value = "/uploadfile", method = RequestMethod.POST)
	@ResponseBody
	public MSG fileupload(@RequestParam MultipartFile uploadfile, HttpServletRequest request) {
		try {
			String filename = uploadfile.getOriginalFilename();
			String nowTimeStamp = String.valueOf(System.currentTimeMillis() / 1000);
			String username = (String) request.getSession().getAttribute("username");
			String realfilename = username + nowTimeStamp + "." + StringUtils.getFilenameExtension(filename);
			String targetDir = request.getSession().getServletContext().getRealPath("uploadfiles");
			File targetfile = new File(targetDir, realfilename);
			uploadfile.transferTo(targetfile);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new MSG("上传成功");
	}

	@ApiOperation("上传一组文件")
	@RequestMapping(value = "/uploadfile2", method = RequestMethod.POST)
	@ResponseBody
	public MSG fileuploads(@RequestParam MultipartFile[] uploadfile, HttpServletRequest request) {
		try {
			if (uploadfile != null && uploadfile.length > 0) {
				// 循环获取file数组中得文件
				for (int i = 0; i < uploadfile.length; i++) {
					MultipartFile file = uploadfile[i];
					if (file.getSize() == 0) {
						continue;
					}
					// 保存文件
					String filename = file.getOriginalFilename();
					String nowTimeStamp = String.valueOf(System.currentTimeMillis() / 1000);
					String username = (String) request.getSession().getAttribute("username");
					String realfilename = username + String.valueOf(i) + nowTimeStamp + "."
							+ StringUtils.getFilenameExtension(filename);
					String targetDir = request.getSession().getServletContext().getRealPath("uploadfiles");
					File targetfile = new File(targetDir, realfilename);
					file.transferTo(targetfile);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new MSG("上传成功");
	}

}
