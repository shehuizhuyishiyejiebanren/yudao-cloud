package com.custome.utils;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

/**
 * @ClassName: IOUtils
 * @Author: sunlin
 * @Description: IOUtils
 * @Date: 2022/8/29 15:29
 */

public class IOUtils {
    protected static final Logger log = LoggerFactory.getLogger(IOUtils.class);
    /**
     * 关闭InputStream
     *
     * @param stream InputStream
     */
    public static void close(InputStream stream) {
        if (stream != null) {
            try {
                stream.close();
            } catch (IOException e) {
                log.error("close stream error", e);
            }
        }
    }

    /**
     * 关闭OutputStream
     *
     * @param stream OutputStream
     */
    public static void close(OutputStream stream) {
        if (stream != null) {
            try {
                stream.close();
            } catch (IOException e) {
                log.error("close stream error", e);
            }
        }
    }

    /**
     * 关闭Reader
     *
     * @param stream Reader
     */
    public static void close(Reader stream) {
        if (stream != null) {
            try {
                stream.close();
            } catch (IOException e) {
                log.error("close stream error", e);
            }
        }
    }

    /**
     * 关闭Writer
     *
     * @param stream Writer
     */
    public static void close(Writer stream) {
        if (stream != null) {
            try {
                stream.close();
            } catch (IOException e) {
                log.error("close stream error", e);
            }
        }
    }
}
