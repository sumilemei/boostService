package com.netty.day02;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.*;
import java.util.Iterator;

@Slf4j
public class TestSelector {
    private static final Logger logger = LoggerFactory.getLogger(TestSelector.class);

    public static void main(String[] args) throws IOException {
        //1.创建selector
        Selector selector = Selector.open();
        //2.channel注册到selector
        ServerSocketChannel ssc = ServerSocketChannel.open();
        ssc.configureBlocking(false);
        ssc.bind(new InetSocketAddress(8082));
        //返回值SelectionKey，可以得到事件和是哪一个channel发生的事件,简单的理解为channel在注册到selector时返回的这个channel的管理员
        //事件又分为四种类型 accept   connect   read   write
        //accept   --ServerSocketChannel会在有连接请求时触发
        //connect  --客户端侧，连接建立后触发
        //read     --SocketChannel可读事件
        //write    --可写事件
        SelectionKey sscKey = ssc.register(selector, 0, null);
        //3. 关注事件
        sscKey.interestOps(SelectionKey.OP_ACCEPT);
        logger.debug("register key: {}",sscKey);
        while(true){
            //4. 调用select方法,没有事件发生，线程阻塞，有事件发生，线程恢复运行
            //select在事件未处理时，它不会阻塞。可以使用cancel方法取消事件
            selector.select();
            //5. 处理事件
            //selector.selectedKeys()可以拿到所有事件类型
            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
            while(iterator.hasNext()){
                SelectionKey key = iterator.next();
                logger.debug("selectionKey: {}",key);
                ServerSocketChannel channel = (ServerSocketChannel)key.channel();
                SocketChannel accept = channel.accept();
                logger.debug("{}",accept);
            }
        }

    }
}
