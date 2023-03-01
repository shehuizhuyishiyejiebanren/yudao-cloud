package com.custome.module.utils.utils2;
import org.springframework.util.Assert;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName: WebUtils
 * @Author: sunlin
 * @Description: WebUtils
 * @Date: 2022/8/29 15:47
 */

public class WebUtils {

    /**
     * 获取Response
     *
     */
    public static HttpServletResponse getResponse() {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        Assert.notNull(requestAttributes, "requestAttributes is null");
        return requestAttributes.getResponse();
    }
}

