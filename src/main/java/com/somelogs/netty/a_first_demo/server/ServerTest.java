package com.somelogs.netty.a_first_demo.server;

/**
 * 描述
 *
 * @author LBG - 2022/9/29
 */
public class ServerTest {

	public static void main(String[] args) throws Exception {
		new EchoServer(8899).start();
	}
}
