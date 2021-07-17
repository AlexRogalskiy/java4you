package com.sensiblemetrics.api.alpenidos.core.netty;

import static io.netty.channel.ChannelHandler.Sharable;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;

@Sharable
class ClientMessageHandler extends SimpleChannelInboundHandler<ByteBuf> {

    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        ctx.writeAndFlush(Unpooled.copiedBuffer("Hello Netty!", CharsetUtil.UTF_8));
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }

    @Override
    protected void messageReceived(ChannelHandlerContext ctx, ByteBuf byteBuf) {
        System.out.println("Client received: " + byteBuf.toString(CharsetUtil.UTF_8));
        ctx.close();
    }
}
