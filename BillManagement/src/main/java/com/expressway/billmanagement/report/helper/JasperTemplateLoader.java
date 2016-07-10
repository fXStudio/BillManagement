package com.expressway.billmanagement.report.helper;

import java.io.InputStream;

/**
 * 报表模板加载工具
 * 
 * @author Ajaxfan
 */
public final class JasperTemplateLoader {
    /** 报表模板路径 */
    public static final String BASE_PATH = "/com/expressway/billmanagement/report/resources/";

    /**
     * 加载指定名称的报表模板
     * 
     * @param fileName
     * @return
     */
    public static synchronized InputStream load(String fileName) {
        return JasperTemplateLoader.class.getResourceAsStream(BASE_PATH + fileName.trim());
    }
}
