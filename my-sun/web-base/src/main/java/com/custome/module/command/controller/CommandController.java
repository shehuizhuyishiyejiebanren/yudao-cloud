package com.custome.module.command.controller;

import com.custome.module.command.service.CommandService;
import com.custome.module.utils.NewFileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: sun
 * @Signature: When I wrote there code, only God and I understood it. Now, only God.
 * @Date 2021/11/17
 * @Description:
 * @note
 **/
@RestController
@RequestMapping("command")
public class CommandController {

    @Autowired
    private CommandService commandService;


    /**
     * @Author sun
     * @Description 备份，拷贝文件夹
     * @Date 10:23 2021/11/18
     * @Param [srcDirPath, destinationDirPath]
     * @return boolean
     * @note
    **/
    @RequestMapping("copyDirectory")
    public boolean copyDirectory(String srcDirPath, String destinationDirPath){
        boolean isSuccess = NewFileUtils.copyDirectoryCover(srcDirPath, destinationDirPath, true);
        return isSuccess;
    }


    /**
     * @Author sun
     * @Description 1.先把系统文件从共享盘拷贝到指定文件夹；2.通过调用命令启动系统
     * @Date 10:50 2021/11/29
     * @Param [srcDirPath, dirPath, type]源系统文件路径，备份目录文件夹路径，备份和恢复的系统文件类型，脚本还是jar包
     * @return java.util.Map<java.lang.String,java.lang.Object>
     * @note 系统恢复拷贝时，暂定拷贝文件。
    **/
    @RequestMapping("systemRecover")
    public Map<String, Object> systemRecover(String srcDirectoryPath,String fileName,String recoverDestinationPath,String recoverStartType){
        String srcFilePath = srcDirectoryPath+File.separator+fileName;
        Map<String, Object> responseResult = new HashMap<>();
        try {
            /*File srcFile = new File(srcFilePath);
            String fileName = srcFile.getName();*/
            String  dirPath = recoverDestinationPath+File.separator+fileName;
            //恢复拷贝
            NewFileUtils.copyFileCover(srcFilePath,dirPath,true);
            commandService.systemRecover(dirPath,recoverStartType);
            responseResult.put("success",true);
            responseResult.put("msg","执行成功，请稍后查看状态");
        } catch (Exception e) {
            responseResult.put("success",false);
            responseResult.put("msg","执行失败，请联系管理员");
            e.printStackTrace();
        }
        return responseResult;
    }


    /**
     * @Author sun
     * @Description 远程执行命令
     * @Date 10:23 2021/11/18
     * @Param [srcDirPath, destinationDirPath]
     * @return boolean
     * @note
     **/
    @RequestMapping("doRemoteShell")
    public boolean doRemoteShell(String shell){
        commandService.doRemoteShell(shell);
        return true;
    }

}
