package com.smart.generator.db.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 内容扩展
 * </p>
 *
 * @author Weike Lu
 * @since 2020-11-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("cms_content_attribute")
public class CmsContentAttribute extends Model<CmsContentAttribute> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "content_id", type = IdType.ASSIGN_ID)
    private Long contentId;

    /**
     * 内容来源
     */
    @TableField("source")
    private String source;

    /**
     * 来源地址
     */
    @TableField("source_url")
    private String sourceUrl;

    /**
     * 数据JSON
     */
    @TableField("data")
    private String data;

    /**
     * 内容
     */
    @TableField("text")
    private String text;

    /**
     * 字数
     */
    @TableField("word_count")
    private Integer wordCount;


    @Override
    protected Serializable pkVal() {
        return this.contentId;
    }

}
