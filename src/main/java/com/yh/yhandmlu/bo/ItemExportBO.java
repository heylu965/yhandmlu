package com.yh.yhandmlu.bo;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import com.google.common.base.MoreObjects;
/**
 *  导出模型
 */
@Data
public class ItemExportBO extends ExportDataBO {

    /**
     * 商品标题
     */
    private String title;

    /**
     * 商品规格  多规格用 - 隔开
     */
    private String spec;

    /**
     * 商品编码
     */
    private String goodsCode;

    /**
     * sku编码
     */
    private String skuCode;

    /**
     * 商品类型
     */
    private String goodsType;

    /**
     * 商品分组 多分组中文逗号隔开
     */
    private String goodsGroup;

    /**
     * 分享描述
     */
    private String shareDesc;

    /**
     * 商品卖点
     */
    private String sellPoint;

    /**
     * 商品价格
     */
    private String price;

    /**
     * 成本价
     */
    private String costPrice;


    /**
     * 库存
     */
    private long stock;

    /**
     * 销量
     */
    private long soldNum;

    /**
     * 是否参加会员折扣
     *
     * 参加/不参加
     */
    private String levelDiscount;


    /**
     * 商品地址
     */
    private String url;


    public ItemExportBO() {
        this.title = "";
        this.spec = "";
        this.goodsCode = "";
        this.skuCode = "";
        this.goodsType = "";
        this.goodsGroup = "";
        this.shareDesc = "";
        this.sellPoint = "";
        this.price = "0";
        this.costPrice = "0";
        this.stock = 0;
        this.soldNum = 0;
        this.levelDiscount = "";
        this.url = "";
    }



    @Override
    public String getHead() {
        return "商品名称,商品规格,商品编码,规格编码,商品类型,商品分组,分享描述,商品卖点,价格（元）,成本价（元）,库存,累计销量,会员折扣,商品链接\n";
    }

    @Override
    public String getContext() {

        StringBuilder sb = new StringBuilder();
        sb.append("\"").append((StringUtils.isBlank(this.title) ? " " : this.title)).append("\"");
        sb.append(",");
        sb.append("\"").append(StringUtils.isBlank(this.spec) ? " " : this.spec).append("\"");
        sb.append(",");
        sb.append("\"").append(StringUtils.isBlank(this.goodsCode) ? " " : this.goodsCode).append("\"");
        sb.append(",");
        sb.append("\"").append(StringUtils.isBlank(this.skuCode) ? " " : this.skuCode).append("\"");
        sb.append(",");
        sb.append("\"").append(StringUtils.isBlank(this.goodsType) ? " " : this.goodsType).append("\"");
        sb.append(",");
        sb.append("\"").append(StringUtils.isBlank(this.goodsGroup) ? " " : this.goodsGroup).append("\"");
        sb.append(",");
        sb.append("\"").append(StringUtils.isBlank(this.shareDesc) ? " " : this.shareDesc).append("\"");
        sb.append(",");
        sb.append("\"").append(StringUtils.isBlank(this.sellPoint) ? " " : this.sellPoint).append("\"");
        sb.append(",");
        sb.append("\"").append(StringUtils.isBlank(this.price) ? " " : this.price).append("\"");
        sb.append(",");
        sb.append("\"").append(StringUtils.isBlank(this.costPrice) ? " " : this.costPrice).append("\"");
        sb.append(",");
        sb.append("\"").append(MoreObjects.firstNonNull(this.stock,0L)).append("\"");
        sb.append(",");
        sb.append("\"").append(MoreObjects.firstNonNull(this.soldNum,0L)).append("\"");
        sb.append(",");
        sb.append("\"").append(StringUtils.isBlank(this.levelDiscount) ? " " : this.levelDiscount).append("\"");
        sb.append(",");
        sb.append("\"").append(StringUtils.isBlank(this.url) ? " " : this.url).append("\"");
        return sb.toString();
    }
}
