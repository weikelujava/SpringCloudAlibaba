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
 * 分类
 * </p>
 *
 * @author Weike Lu
 * @since 2020-11-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("cms_category")
public class CmsCategory extends Model<CmsCategory> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 站点ID
     */
    @TableField("site_id")
    private Integer siteId;

    /**
     * 名称
     */
    @TableField("name")
    private String name;

    /**
     * 父分类ID
     */
    @TableField("parent_id")
    private Integer parentId;

    /**
     * 分类类型
     */
    @TableField("type_id")
    private Integer typeId;

    /**
     * 所有子分类ID
     */
    @TableField("child_ids")
    private String childIds;

    /**
     * 标签分类
     */
    @TableField("tag_type_ids")
    private String tagTypeIds;

    /**
     * 编码
     */
    @TableField("code")
    private String code;

    /**
     * 模板路径
     */
    @TableField("template_path")
    private String templatePath;

    /**
     * 首页路径
     */
    @TableField("path")
    private String path;

    /**
     * 外链
     */
    @TableField("only_url")
    private Boolean onlyUrl;

    /**
     * 已经静态化
     */
    @TableField("has_static")
    private Boolean hasStatic;

    /**
     * 首页地址
     */
    @TableField("url")
    private String url;

    /**
     * 内容路径
     */
    @TableField("content_path")
    private String contentPath;

    /**
     * 包含子分类内容
     */
    @TableField("contain_child")
    private Boolean containChild;

    /**
     * 每页数据条数
     */
    @TableField("page_size")
    private Integer pageSize;

    /**
     * 允许投稿
     */
    @TableField("allow_contribute")
    private Boolean allowContribute;

    /**
     * 顺序
     */
    @TableField("sort")
    private Integer sort;

    /**
     * 隐藏
     */
    @TableField("hidden")
    private Boolean hidden;

    /**
     * 是否删除
     */
    @TableField("disabled")
    private Boolean disabled;

    /**
     * 内容数
     */
    @TableField("contents")
    private Integer contents;

    /**
     * 扩展ID
     */
    @TableField("extend_id")
    private Integer extendId;

    @TableField("enname")
    private String enname;

    @TableField("cover")
    private String cover;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
