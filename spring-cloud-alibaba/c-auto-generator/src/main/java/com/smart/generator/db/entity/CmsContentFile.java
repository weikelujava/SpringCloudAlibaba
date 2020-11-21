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
 * 内容附件
 * </p>
 *
 * @author Weike Lu
 * @since 2020-11-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("cms_content_file")
public class CmsContentFile extends Model<CmsContentFile> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 内容
     */
    @TableField("content_id")
    private Long contentId;

    /**
     * 用户
     */
    @TableField("user_id")
    private Long userId;

    /**
     * 文件路径
     */
    @TableField("file_path")
    private String filePath;

    /**
     * 是否图片
     */
    @TableField("image")
    private Boolean image;

    /**
     * 大小
     */
    @TableField("size")
    private Integer size;

    /**
     * 点击数
     */
    @TableField("clicks")
    private Integer clicks;

    /**
     * 排序
     */
    @TableField("sort")
    private Integer sort;

    /**
     * 描述
     */
    @TableField("description")
    private String description;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
