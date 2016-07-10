package com.expressway.billmanagement.report.api;

import java.util.HashMap;
import java.util.List;

/**
 * 报表构建工具
 * @author Ajaxfan
 */
public interface IReportCreator {
    public JasperPrint build(HashMap<String, String> params, List beans, Class reportClazz);
}
