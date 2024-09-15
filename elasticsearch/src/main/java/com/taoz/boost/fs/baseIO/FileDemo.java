package com.taoz.boost.fs.baseIO;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author taozheng
 * @date 2023/4/12 - 21:57
 * @introduce:
 */
public class FileDemo {
    public static void main(String[] args) throws IOException {
        File file = new File("D:\\opt\\njzf\\logs\\iss-dc-service\\sql2.log");
        if(!file.exists()){
            file.createNewFile();
        }
        File file1 = new File("E:\\opt\\njzf\\logs\\iss-dc-service");
        if(!file1.exists()){
            file1.mkdirs();
        }
        System.out.println(file.getAbsolutePath());
        File file2 = new File("D:\\");
        String[] list = file2.list();
        for(String s : list){
            System.out.println(s);
        }
        File[] files = file2.listFiles();
        for(File f : files){
            System.out.println(f);
        }

        //使用文件名称过滤器来实现输出指定目录下以.sql结尾的文件
        System.out.println("--------------**---------------");
        File file3 = new File("D:\\");
        String[] sqlList = file3.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return new File(dir, name).isFile() && name.endsWith(".sql");
            }
        });
        for(String s : sqlList){
            System.out.println(s);
        }

        //遍历D盘，找出所有.sql结尾的文件
        System.out.println("-------&&---------");
        List<String> file4 = getFile(new ArrayList<>(),"D:\\ceshi\\", ".sql");
        System.out.println(file4);
    }

    static List<String> getFile(List<String> s ,String directory, String fileName){
        File file = new File(directory);
        File[] files = file.listFiles();
        for(File f:files){
            if(f.isDirectory()){
                getFile(s,f.getAbsolutePath(),fileName);
            }
            if(f.isFile() && f.getName().endsWith(fileName)){
                s.add(f.getAbsolutePath());
            }
        }
        return s;
    }
}
