package com.netty.day01;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

@Slf4j
public class TestByteBuffer {
    private static final Logger logger = LoggerFactory.getLogger(TestByteBuffer.class);
    public static void main(String[] args) {
        //获取FileChannel
        //获取方式1. 输入输出流
        //获取方式2. RandomAccessFile
        try (FileChannel channel = new FileInputStream("./md/threeKingdoms/one.txt").getChannel()) {
            //开辟缓冲区ByteBuffer,堆内存，读写效率低，会受到gc影响
            ByteBuffer buffer = ByteBuffer.allocate(10);
            while(true){
                //从channel读取数据，即向buffer写入数据
                int len = channel.read(buffer);
                logger.debug("读取到的字节数{}", len);
                if(-1 == len){
                    break;
                }
                //切换至buffer的读模式
                buffer.flip();
                while(buffer.hasRemaining()){
                    //读buffer里的数据并打印出来
                    byte b = buffer.get();
                    System.out.println((char)b);
                }
                //切换至buffer的写模式
                buffer.clear();
            }


        } catch (IOException e) {
        }
    }
}
