package com.custome.module.utils.utils2;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.junit.platform.commons.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;

/**
 * @ClassName: WordUtils
 * @Author: sunlin
 * @Description: WordUtils
 * @Date: 2022/8/29 15:48
 */

public class WordUtils {
    protected static final Logger log = LoggerFactory.getLogger(IOUtils.class);
    /**
     * 文件分隔符
     */
    public static String FILE_DELIMITER = "/";

    /**
     * 模板FTL文件后缀
     */
    public static String FTL_SUFFIX = ".ftl";

    /**
     * 生成DOC文件后缀
     */
    public static String DOC_SUFFIX = "_%s.doc";

    public static void exportDocWordByWeb(String fileNamePrefix, String templateFilePath, Map<String, Object> dataMap) {
        // 获取模板文件名称
        String templateFileName = templateFilePath.substring(templateFilePath.lastIndexOf(FILE_DELIMITER) + 1);
        // 获取当前日期
        String currentDate = LocalDate.now().format(DateTimeFormatter.BASIC_ISO_DATE);
        // 处理导出后文件名称
        String fileName = templateFileName.replace(FTL_SUFFIX, String.format(DOC_SUFFIX, currentDate));
        if (StringUtils.isNotBlank(fileNamePrefix)) {
            fileName = String.format("%s_%s", fileNamePrefix, fileName);
        }

        // 文件名称使用UTF_8编码
        String encodeFileName;
        try {
            encodeFileName = URLEncoder.encode(fileName, StandardCharsets.UTF_8.name());
        } catch (UnsupportedEncodingException e) {
            log.error("编码文件名失败，文件名称{}", fileName);
            log.error(e.getMessage(), e.getCause());
            throw new RuntimeException("编码文件名失败");
        }
        InputStream templateFileInputStream = null;
        InputStreamReader inputStreamReader = null;
        ByteArrayOutputStream byteArrayOutputStream = null;
        OutputStreamWriter outputStreamWriter = null;
        ByteArrayInputStream byteArrayInputStream = null;
        OutputStream outputStream = null;
        try {
            templateFileInputStream = WordUtils.class.getClassLoader().getResourceAsStream(templateFilePath);
            Assert.notNull(templateFileInputStream, String.format("模板文件不存在，路径：%s", templateFilePath));
            Configuration configuration = new Configuration(Configuration.VERSION_2_3_28);
            configuration.setDefaultEncoding(StandardCharsets.UTF_8.name());
            inputStreamReader = new InputStreamReader(templateFileInputStream);
            Template template = new Template(templateFileName, inputStreamReader, configuration);
            byteArrayOutputStream = new ByteArrayOutputStream();
            outputStreamWriter = new OutputStreamWriter(byteArrayOutputStream);
            template.process(dataMap, outputStreamWriter);

            // 导出文件
            HttpServletResponse response = WebUtils.getResponse();
            response.setCharacterEncoding(StandardCharsets.UTF_8.name());
            response.setContentType("application/msword");
            response.setHeader("Content-Disposition", "attachment;filename=" + encodeFileName);
            outputStream = response.getOutputStream();
            byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
            byte[] buffer = new byte[1024];
            int count;
            while ((count = byteArrayInputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, count);
            }
        } catch (IOException | TemplateException e) {
            log.error(e.getMessage(), e.getCause());
            throw new RuntimeException("文件导出异常");
        } finally {
            // 关闭流
            IOUtils.close(outputStream);
            IOUtils.close(byteArrayInputStream);
            IOUtils.close(outputStreamWriter);
            IOUtils.close(byteArrayOutputStream);
            IOUtils.close(inputStreamReader);
            IOUtils.close(templateFileInputStream);
        }
    }
}

