package com.sensiblemetrics.api.alpenidos.core.netty;

import static io.netty.channel.ChannelHandler.Sharable;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.CharsetUtil;

@Sharable
class ServerMessageHandler extends ChannelHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        ByteBuf message = (ByteBuf) msg;
        System.out.println("Server received: " + message.toString(CharsetUtil.UTF_8));
        ctx.writeAndFlush(message);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }
}
