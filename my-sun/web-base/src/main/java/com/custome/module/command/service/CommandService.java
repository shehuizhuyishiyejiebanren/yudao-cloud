package com.custome.module.command.service;

import com.custome.module.utils.CommandUtils;
import org.springframework.stereotype.Service;

/**
 * @Author: sun
 * @Signature: When I wrote there code, only God and I understood it. Now, only God.
 * @Date 2021/11/18
 * @Description:
 * @note
 **/
@Service
public class CommandService {

    /**
     * @Author sun
     * @Description 远程执行命令
     * @Date 10:23 2021/11/18
     * @Param [srcDirPath, destinationDirPath]
     * @return boolean
     * @note
     **/
    public void doRemoteShell(String shell) {

    }

    /**
     * @Author sun
     * @Description 执行调用脚本命令
     * @Date 10:23 2021/11/23
     * @Param [scriptPath]
     * @return boolean
     * @note
     **/
    public void systemRecover(String dirPath, String type) throws Exception{
        String common_command = CommandUtils.common_command(dirPath,type);
        String execute = CommandUtils.execute(common_command);
    }
}
