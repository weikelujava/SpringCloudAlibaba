package com.smart.generator.db.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 内容
 * </p>
 *
 * @author Weike Lu
 * @since 2020-11-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("cms_content")
public class CmsContent extends Model<CmsContent> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 站点ID
     */
    @TableField("site_id")
    private Integer siteId;

    /**
     * 标题
     */
    @TableField("title")
    private String title;

    /**
     * 发表用户
     */
    @TableField("user_id")
    private Long userId;

    /**
     * 审核用户
     */
    @TableField("check_user_id")
    private Long checkUserId;

    /**
     * 分类
     */
    @TableField("category_id")
    private Integer categoryId;

    /**
     * 模型
     */
    @TableField("model_id")
    private String modelId;

    /**
     * 父内容ID
     */
    @TableField("parent_id")
    private Long parentId;

    /**
     * 是否转载
     */
    @TableField("copied")
    private Boolean copied;

    /**
     * 作者
     */
    @TableField("author")
    private String author;

    /**
     * 编辑
     */
    @TableField("editor")
    private String editor;

    /**
     * 外链
     */
    @TableField("only_url")
    private Boolean onlyUrl;

    /**
     * 拥有图片列表
     */
    @TableField("has_images")
    private Boolean hasImages;

    /**
     * 拥有附件列表
     */
    @TableField("has_files")
    private Boolean hasFiles;

    /**
     * 已经静态化
     */
    @TableField("has_static")
    private Boolean hasStatic;

    /**
     * 地址
     */
    @TableField("url")
    private String url;

    /**
     * 简介
     */
    @TableField("description")
    private String description;

    /**
     * 标签
     */
    @TableField("tag_ids")
    private String tagIds;

    /**
     * 封面
     */
    @TableField("cover")
    private String cover;

    /**
     * 内容页数
     */
    @TableField("childs")
    private Integer childs;

    /**
     * 分数
     */
    @TableField("scores")
    private Integer scores;

    /**
     * 评论数
     */
    @TableField("comments")
    private Integer comments;

    /**
     * 点击数
     */
    @TableField("clicks")
    private Integer clicks;

    /**
     * 发布日期
     */
    @TableField("publish_date")
    private LocalDateTime publishDate;

    /**
     * 创建日期
     */
    @TableField("create_date")
    private LocalDateTime createDate;

    /**
     * 顺序
     */
    @TableField("sort")
    private Integer sort;

    /**
     * 状态：0、草稿 1、已发布 2、待审核
     */
    @TableField("status")
    private Integer status;

    /**
     * 是否删除
     */
    @TableField("disabled")
    private Boolean disabled;

    @TableField("Ismobilepublish")
    private Integer ismobilepublish;

    @TableField("DeptId")
    private Integer deptid;

    @TableField("sayGoodCount")
    private Long saygoodcount;

    @TableField("degree")
    private Integer degree;

    @TableField("uid")
    private Long uid;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
