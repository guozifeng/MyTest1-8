package com.guo.offer.testmath;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 
 * @author Administrator
 * @date 2017/12/07
 * 
 */
public class TestIo {

    public static boolean copyFile(String str, String sourcePath, String destPath) throws IOException {
        boolean f = false;
        String destFilePath = destPath + str;
        String sourceFilePath = sourcePath + str;
        System.out.println("----------------" + sourceFilePath);
        File newDir = new File(destFilePath.substring(0, destFilePath.lastIndexOf('/')));
        File sourceFile = new File(sourceFilePath.trim());
        if (!sourceFile.exists()) {
            System.out.println("----------------");
            return f;
        }
        System.out.println("-------------2---" + destFilePath);
        File destFile = new File(destFilePath.trim());
        if (!newDir.exists()) {
            newDir.mkdirs();
        }
        if (!sourceFile.isDirectory()) {
            InputStream in = new FileInputStream(sourceFile);
            FileOutputStream out = new FileOutputStream(destFile);
            byte[] buffer = new byte[1024];
            int ins;
            while ((ins = in.read(buffer)) != -1) {
                out.write(buffer, 0, ins);
            }
            in.close();
            out.flush();
            out.close();
            f = true;
        }
        return f;

    }

    public static void main(String[] args) {

        try {

            System.out.println(
                copyFile("促销扣款批导格式.xlsx", "C:/Users/Administrator/Desktop/", "C:/Users/Administrator/Desktop/a/"));

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
