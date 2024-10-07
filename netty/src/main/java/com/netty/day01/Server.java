package com.netty.day01;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.List;


public class Server {
    private static final Logger logger = LoggerFactory.getLogger(TestByteBuffer.class);

    public static void main(String[] args) throws IOException {
        ByteBuffer buffer = ByteBuffer.allocate(16);
        //1. 创建服务器
        ServerSocketChannel ssc = ServerSocketChannel.open();
        //2. 绑定监听端口
        ssc.bind(new InetSocketAddress(8081));
        List<SocketChannel> channels = new ArrayList<>();
        //3. accept建立与客户端的连接,SocketChannel用来与客户端之间通信
        while(true){
            logger.debug("connecting...");
            SocketChannel sc = ssc.accept();//阻塞方法，线程停止运行
            logger.debug("connected...{}",sc);
            channels.add(sc);
            for(SocketChannel channel : channels){
                logger.debug("before read... {}",channel);
                channel.read(buffer);//阻塞方法，线程停止运行
                buffer.flip();
                buffer.clear();
                logger.debug("after read...{}",channel);
            }
        }
    }
}
