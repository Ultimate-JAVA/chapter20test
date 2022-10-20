package com.sz.guigu.test02;

import java.io.*;

public class CopyFileTest {

    public static void main(String[] args) throws IOException {
        File srcFile = new File("E:\\专插本\\C语言");
        File destFile = new File("F:\\");
        copyDir(srcFile,destFile);
    }
    private static void copyDir(File srcFile, File destFile) {
        if (srcFile.isFile()) {
            FileInputStream fis = null;
            FileOutputStream fps = null;
            try {
                fis = new FileInputStream(srcFile);
                String path = destFile.getAbsolutePath().endsWith("\\") ? destFile.getAbsolutePath() : destFile.getAbsolutePath() + "\\"+srcFile.getAbsolutePath().substring(3);
                fps = new FileOutputStream(path);
                byte[] bytes = new byte[1024*1024];
                int count = 0 ;
                while ((count = fis.read(bytes))!=-1){
                    fps.write(bytes,0,count);
                }
                fps.close();
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                if (fps != null) {
                    try {
                        fps.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (fis != null) {
                    try {
                        fis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            return;
        }
        File[] files = srcFile.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                String srcDir = file.getAbsolutePath();
                String destDir = srcDir.substring(3);
                String dfp = destFile.getAbsolutePath();
                File newFile = new File((dfp.endsWith("\\") ? dfp : dfp + "\\") + destDir);
                if (!newFile.exists()) {
                    newFile.mkdirs();
                }
            }
            copyDir(file, destFile);
        }
    }
}
