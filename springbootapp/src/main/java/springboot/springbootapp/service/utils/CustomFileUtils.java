package springboot.springbootapp.service.utils;

import org.apache.commons.io.FileUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import org.apache.tomcat.util.codec.binary.*;

public class CustomFileUtils {

    static String PROJECT_PATH = System.getProperty("user.dir");
    static String SEPARATOR = System.getProperty("file.separator");

    static String ROOT_PATH = PROJECT_PATH + SEPARATOR + "src" + SEPARATOR + "main" + SEPARATOR + "webapp" + SEPARATOR +"upload";

    public static File createFolder(String folderName) {
        File uploadDir = new File(ROOT_PATH);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }

        File folder = new File(uploadDir.getAbsolutePath() + SEPARATOR + folderName);

        if (!folder.exists()){
            folder.mkdir();
        }
        return folder;
    }


    public static void createImg(String folder, MultipartFile file) throws IOException {
        if (!file.isEmpty()&&file != null) {
            BufferedImage bi = ImageIO.read(new ByteArrayInputStream(file.getBytes()));

            File dir = new File(createFolder(folder).getAbsolutePath());
            if (dir.isDirectory()) {
                if (dir.list().length > 0) {
                    FileUtils.cleanDirectory(dir);
                }
            }
            File destination = new File(dir.getAbsolutePath() + SEPARATOR + file.getOriginalFilename());

            ImageIO.write(bi, "png", destination);
        }
    }


    public static String getImg(String folder, String image) throws IOException {
        File file = null;
        byte[] encodedFileToByte = null;
        String encodedFile = null;

        if (image != null || image != "") {
            file = new File(ROOT_PATH + SEPARATOR + folder + SEPARATOR + image);
        }

        encodedFileToByte = Base64.encodeBase64(FileUtils.readFileToByteArray(file));
        encodedFile = new String(encodedFileToByte);

        return encodedFile;
    }
}
