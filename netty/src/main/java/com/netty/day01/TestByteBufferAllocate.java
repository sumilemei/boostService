package com.netty.day01;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.StandardCharsets;

public class TestByteBufferAllocate {
    public static void main(String[] args) {
        //堆内存  读写效率较低，受到gc的影响
        System.out.println(ByteBuffer.allocate(10).getClass());
        //直接内存  读写效率高(少一次拷贝)，不会受到gc的影响，调用操作系统函数，分配的效率低
        System.out.println(ByteBuffer.allocateDirect(10).getClass());

        ByteBuffer buffer = ByteBuffer.allocate(20);
        buffer.put((new byte[]{'a','b','c','d'}));
        buffer.flip();
        System.out.println(buffer.get(new byte[3]));
        System.out.println(buffer.rewind());//重复读
        System.out.println(buffer.get(new byte[3]));
        //mark 和 reset
        //mark做一次标记，记录position的位置   reset就是将position重置到mark的位置
        System.out.println(buffer.get(3));


        //字符串转ByteBuffer
        ByteBuffer allocate1 = ByteBuffer.allocate(16);
        allocate1.put("hello".getBytes());//依然是写模式
        ByteBuffer allocate2 = StandardCharsets.UTF_8.encode("hello");//会自动切换到读模式
        ByteBuffer allocate3 = ByteBuffer.wrap("hello".getBytes());//会自动切换到读模式
        //ByteBuffer转字符串
        CharBuffer decode = StandardCharsets.UTF_8.decode(allocate2);
        System.out.println(decode.toString());

        ByteBuffer allocate = ByteBuffer.allocate(100);
        allocate.put("hello,world\nmy name is netty\nho".getBytes());
        split(allocate);
        allocate.put("w are you?\n".getBytes());
        split(allocate);

    }
    public static void split(ByteBuffer buffer){
        buffer.flip();
        for(int i=0; i<buffer.limit(); i++){
            if (buffer.get(i) == '\n') {
                int length = i+1 - buffer.position();
                ByteBuffer target = ByteBuffer.allocate(length);
                for(int j=0; j<length;j++){
                    target.put(buffer.get());
                }
            }
        }
        buffer.compact();
    }
}
