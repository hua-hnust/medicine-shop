package com.medicine.shop.util;

import java.io.File;
import java.io.FileOutputStream;
import java.util.UUID;

/**  文件处理工具类
 * @Author xhua
 * @Date 2020/4/6 17:12
 **/
public class FileUtil {

    /**
     *  上传文件
     * @param file
     * @param filePath
     * @param fileName
     * @return
     */
    public static void upload(byte[] file,String filePath,String fileName) throws Exception{
        File targetFile = new File(filePath);
        if (!targetFile.exists()){
            targetFile.mkdirs();
        }
        FileOutputStream out = new FileOutputStream(filePath + fileName);
        out.write(file);
        out.flush();
        out.close();
    }

    /**
     *  获取新的文件名
     * @param fileName
     * @return
     */
    public static String renameFile(String fileName){
        int index = fileName.lastIndexOf(".");
        String suffix = fileName.substring(index);
        return UUID.randomUUID().toString().replace("-", "") + suffix;
    }

}
