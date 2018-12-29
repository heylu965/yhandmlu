package com.yh.yhandmlu.bo;

/**
 *
 * 类ExportCsvBO的实现描述: 导出数据共性BO
 * @author 青芒
 * @since  2018-05-09
 */
public abstract class ExportDataBO {

    /**
     * 文件标题
     * @return 标题
     */
    public abstract String getHead();


    /**
     * 文件每行内容
     * @return 每行数据
     */
    public abstract String getContext();

}
