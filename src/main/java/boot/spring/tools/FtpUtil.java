package boot.spring.tools;

import org.springframework.stereotype.Component;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.apache.poi.util.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Component
public class FtpUtil {

    /**
     * FTP地址
     **/
    @Value("${ftp.host}")
    private  String ftpAddress;
    /**
     * FTP端口
     **/
    @Value("${ftp.port}")
    private int ftpPort;
    /**
     * FTP用户名
     **/
    @Value("${ftp.username}")
    private String ftpUsername;
    /**
     * FTP密码
     **/
    @Value("${ftp.password}")
    private String ftpPassword;

    /**
     * 设置缓冲区大小4M
     **/
    private static final int BUFFER_SIZE = 1024 * 1024 * 4;

    /**
     * 连接FTP服务器
     *
     * @param address  地址，如：127.0.0.1
     * @param port     端口，如：21
     * @param username 用户名，如：root
     * @param password 密码，如：root
     */
    public FTPClient login() {
    	FTPClient ftpClient = new FTPClient();
        try {
            ftpClient.connect(ftpAddress, ftpPort);
            ftpClient.login(ftpUsername, ftpPassword);
            ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
            //限制缓冲区大小
            ftpClient.setBufferSize(BUFFER_SIZE);
            int reply = ftpClient.getReplyCode();
            if (!FTPReply.isPositiveCompletion(reply)) {
            	System.out.println(reply);
                closeConnect(ftpClient);
            }
            if (ftpClient.isConnected()){
            	System.out.println("FTP连接成功");
            	return ftpClient;
            }
        } catch (Exception e) {
        	e.printStackTrace();
        }
		return ftpClient;
    }
    
    /**
     * 下载该目录下文件到本地
     * @param basepath  FTP服务器上的相对路径，例如：test/123
     * @param savePath 保存文件到本地的路径，例如：D:/test
     * filename 文件名
     * @return 成功返回true，否则返回false
     * @throws Exception 
     */
	public boolean downloadFiles(String basepath, String filename, String savePath) throws Exception {
		FTPClient ftpClient = login();
		if (ftpClient != null) {
			ftpClient.setControlEncoding("GBK");
            ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
            ftpClient.enterLocalPassiveMode();
			try {
				// 由于FTP用的是ISO-8859-1，需要转好了才行
				String fpath = new String(basepath.getBytes("GBK"), FTP.DEFAULT_CONTROL_ENCODING);
				String fname = new String(filename.getBytes("GBK"), FTP.DEFAULT_CONTROL_ENCODING);
				if (!ftpClient.changeWorkingDirectory(fpath)) {
					System.out.println("FTP文件路径不存在");
					return false;
				}
				File file = new File(savePath + File.separatorChar + filename);
				try (OutputStream os = new FileOutputStream(file)) {
					ftpClient.retrieveFile(fpath + File.separatorChar + fname, os);
				} catch (Exception e) {
					e.printStackTrace();
				}
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				closeConnect(ftpClient);
			}
		}
		return Boolean.TRUE;
	}

	public InputStream exportFile(String basepath, String filename) throws Exception {
		FTPClient ftpClient = login();
		if (ftpClient != null) {
			ftpClient.setControlEncoding("GBK");
            ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
            ftpClient.enterLocalPassiveMode();
			try {
				// 由于FTP用的是ISO-8859-1，需要转好了才行
				String fpath = new String(basepath.getBytes("GBK"), FTP.DEFAULT_CONTROL_ENCODING);
				String fname = new String(filename.getBytes("GBK"), FTP.DEFAULT_CONTROL_ENCODING);
				if (!ftpClient.changeWorkingDirectory(fpath)) {
					System.out.println("FTP文件路径不存在");
					return null;
				}
					InputStream stream = ftpClient.retrieveFileStream(fpath + File.separatorChar + fname);
					return stream;
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				closeConnect(ftpClient);
			}
		}
		return null;
	}
	
	
	public String exportBase64(String basepath, String filename) throws Exception {
		FTPClient ftpClient = login();
		if (ftpClient != null) {
			ftpClient.setControlEncoding("GBK");
            ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
            ftpClient.enterLocalPassiveMode();
			try {
				// 由于FTP用的是ISO-8859-1，需要转好了才行
				String fpath = new String(basepath.getBytes("GBK"), FTP.DEFAULT_CONTROL_ENCODING);
				String fname = new String(filename.getBytes("GBK"), FTP.DEFAULT_CONTROL_ENCODING);
				if (!ftpClient.changeWorkingDirectory(fpath)) {
					System.out.println("FTP文件路径不存在");
					return null;
				}
					InputStream stream = ftpClient.retrieveFileStream(fpath + File.separatorChar + fname);
					byte[] bytes = IOUtils.toByteArray(stream);
					String encoded = Base64.getEncoder().encodeToString(bytes);
					
					return encoded;
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				closeConnect(ftpClient);
			}
		}
		return null;
	}	


    /**
     * 关闭FTP连接
     */
    private  void closeConnect(FTPClient ftpClient) {
        if (ftpClient != null && ftpClient.isConnected()) {
            try {
                ftpClient.logout();
                ftpClient.disconnect();
            } catch (IOException e) {
            }
        }
    }


    
    public static void main(String[] args) throws Throwable {
    	FtpUtil ftpUtil = new FtpUtil();
    	ftpUtil.downloadFiles("/wsz", "/测试1.png","D://pic");
    	ftpUtil.downloadFiles("/wsz", "/2.png","D://pic");
//    	util.downloadFiles(client, "/wsz", "/测试22.png","D://pic");
//    	Map<String, Object> result = ftpUtil.downLoadTableFile("shenzhanwnag", "D:/");
//    	System.out.println(result.get("result"));
    }
}
