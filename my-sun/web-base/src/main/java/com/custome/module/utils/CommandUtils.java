/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.custome.module.utils;

import java.io.*;
import java.util.Properties;

/**
 * Command
 * @author ThinkGem
 * @version 2017年2月17日
 */
public class CommandUtils {

	public static String execute(String command) throws IOException {
		return execute(command, "GBK");
	}
	
	public static String execute(String command, String charsetName) throws IOException {
		Process process = Runtime.getRuntime().exec(command);

		// 记录dos命令的返回信息
		StringBuffer stringBuffer = new StringBuffer();
		// 获取返回信息的流
		InputStream in = process.getInputStream();
		Reader reader = new InputStreamReader(in, charsetName);
		BufferedReader bReader = new BufferedReader(reader);
		//bReader.readLine()会等待cmd窗口执行完毕关闭才会读取到响应信息，该方法会造成线程阻塞
		/*String res = bReader.readLine();
		while (res != null) {
			stringBuffer.append(res);
			stringBuffer.append("\n");
			res = bReader.readLine();
		}*/
		//当cmd命令没有有start。当不包含satrt时，cmd在隐式窗口执行，没有新建cmd窗口，如果当前线程不等等待，直接结束，导致隐式窗口在执行命令启动jar包还没完成而直接结束，jar包启动失败。适当等待可解决
		/*try {
			Thread.sleep(1000*10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}*/
		bReader.close();
		reader.close();
		String response = stringBuffer.toString();
		return response ;
	}

	public static void main(String[] args) {
			String command = "cmd /k start  java -jar C:\\Users\\Administrator\\Desktop\\123\\system-back.jar";
		try {
			String execute = execute(command);
			System.out.println(execute);
		} catch (Exception e) {
			e.printStackTrace();
		}

		//execute2
		/*CmdTask cmdTask = new CmdTask(command);
		cmdTask.run();*/
	}

	/**
	 * @Author sun
	 * @Description win_bat
	 * @Date 13:16 2021/11/25
	 * @Param
	 * @return
	 * @note
	**/
	public static String win_bat(){
		//bat
		String command1 = "cmd.exe";
		String command2 = " /c start";
		//xdxt
		//String command3 = " C:\\Users\\Administrator\\Desktop\\123\\piesat-SEC\\WEB-INF\\startup.bat";
		//system-back
		String command3 = " C:\\Users\\Administrator\\Desktop\\123\\test.bat";

		String command = "";
		command += command1;
		command += command2;
		command += command3;
		return command;
	}

	/**
	 * @Author sun
	 * @Description win_jar
	 * @Date 13:16 2021/11/25
	 * @Param
	 * @return
	 * @note
	 **/
	public static String win_cmd(){
		//jar  可行
		String command1 = "cmd /c";
		String command2 = " C: && cd C:\\Users\\Administrator\\Desktop\\123";
		String command3 = " && start java -jar system-back.jar";

		String command = "";
		command += command1;
		command += command2;
		command += command3;
		return command;
	}




	/**
	 * @Author sun
	 * @Description 判断操作系统类型，组装command命令调用脚本
	 * @Date 15:19 2021/11/25
	 * @Param []
	 * @return java.lang.String
	 * @note
	**/
	public static String common_command(String dirPath, String type){
		Properties properties = System.getProperties();
		String osName = properties.getProperty("os.name");
		System.out.println("===========os.name:"+osName);
		String fileSeparator = properties.getProperty("file.separator");
		System.out.println("===========file.separator:"+fileSeparator);
		//判断操作系统
		String commmand;
		if(osName.toLowerCase().startsWith("win")){
			if("jar".equals(type))
			{
				//jar
				String s = File.separator + File.separator;
				dirPath = dirPath.replace("\\","\\\\");
				commmand = "cmd.exe /c start java -jar " + dirPath;
			}
			else
			{
				//bat
				commmand = "cmd.exe /c start " + dirPath;
			}
		}else {
			if("jar".equals(type))
			{
				//jar
				//commmand = "nohup java -jar /home/project/xdxt/system-back.jar >log.out &";
				commmand = "nohup java -jar "+dirPath+" >log.out &";
			}
			else
			{
				//shell
				commmand = "sh " + dirPath;
			}

		}
		return commmand;
	}


}
