package com.netty.day01;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

public class TestFileChannel {
    public static void main(String[] args) {
        try {
            FileChannel channelFrom = new FileInputStream("./md/threeKingdoms/tiaoyuanjieyi.txt").getChannel();
            FileChannel channelTo = new FileOutputStream("./md/threeKingdoms/three.txt").getChannel();
            //效率高，底层会使用操作系统的零拷贝进行优化,最多传输2GB
            //思考一下，当文件大小超过2GB，怎么通过这种方式完成传输呢？
            long size = channelFrom.size();
            for(long left = size; left>0;){
                left = left - channelFrom.transferTo((size-left),left,channelTo);
            }
            //channelFrom.transferTo(0,channelFrom.size(),channelTo);
        }  catch (IOException e) {
            e.printStackTrace();
        }
    }
}
