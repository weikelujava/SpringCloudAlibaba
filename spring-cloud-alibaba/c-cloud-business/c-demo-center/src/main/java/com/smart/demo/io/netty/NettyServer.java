//package com.smart.demo.io.netty;
//
//
//import java.nio.channels.SocketChannel;
//
///**
// * netty的底层依然是NIO
// *
// * https://github.com/bjmashibing/NettyStudy
// *
// */
//public class NettyServer {
//
//    public static void main(String[] args) {
//        new NettyServerConfig(8888).starter();
//    }
//
//   static class NettyServerConfig{
//
//        int port = 8888;
//
//       public NettyServerConfig(int port) {
//           this.port = port;
//       }
//
//       public void starter(){
//           EventLoopGroup bossGroup = new NioEventLoopGroup();
//           EventLoopGroup workGroup = new NioEventLoopGroup();
//           ServerBootstrap b = new ServerBootstrap();
//
//           b.group(bossGroup,workGroup)
//                   .channel(NioServerSocketChannel.class)
//                   .childHandler(new ChannelInitialize<SocketChannel>(){
//                        @Override
//                       protected void initChannel(SocketChannel ch) throws Exception{
//                            ch.pipeline().addLast(new Handler());
//                        }
//                   });
//
//           try {
//               ChannelFuture f = b.bind(port).sync();
//               f.channel().closeFuture().sync();
//
//           }catch (InterruptedException e){
//               e.printStackTrace();
//           }finally {
//               workGroup.shutdownGracefully();
//               bossGroup.shutdownGracefully();
//           }
//
//       }
//   }
//
//   class Handler() extends ChannelInboundHandlerAdapter{
//
//        @Override
//       public void channelRead(ChannelHandlerContext ctx,Object msg) throws Exception{
//            System.out.println("server:channel read");
//            ByteBuf buf = (ByteBuf) msg;
//            System.out.println(buf.toString(CharsetUtil.UTF_8));
//            ctx.writeAndFlush(msg);
//            ctx.close();
//            // buf.release();
//
//        }
//        @Override
//       public void exceptionCauht(ChannelHandlerContext ctx,Throwable cause) throws Exception{
//            cause.printStackTrace();
//            ctx.close();
//        }
//
//
//
//   }
//}
