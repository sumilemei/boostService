//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.taoz.boost.iss.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.google.common.collect.Maps;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.hibernate.validator.constraints.Length;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Map;

public abstract class BaseEntity implements Serializable {
    private static final Logger log = LoggerFactory.getLogger(BaseEntity.class);
    protected static final long serialVersionUID = 1L;
    protected Long id;
    @TableField(
            fill = FieldFill.INSERT
    )
    @JsonFormat(
            pattern = "yyyy-MM-dd HH:mm:ss"
    )
    protected LocalDateTime createDate;
    @JsonFormat(
            pattern = "yyyy-MM-dd HH:mm:ss"
    )
    @TableField(
            fill = FieldFill.INSERT_UPDATE
    )
    protected LocalDateTime updateDate;
    @TableField(
            fill = FieldFill.INSERT
    )
    protected String createBy;
    @TableField(
            fill = FieldFill.INSERT_UPDATE
    )
    protected String updateBy;
    @Length(
            max = 255
    )
    protected String remarks;
    @TableLogic
    @JsonIgnore
    @Length(
            min = 1,
            max = 1
    )
    protected String delFlag;
    @TableField(
            exist = false
    )
    @JsonProperty(
            access = Access.WRITE_ONLY
    )
    private String errors;
    @TableField(
            exist = false
    )
    @JsonProperty(
            access = Access.WRITE_ONLY
    )
    protected Page page;
    @TableField(
            exist = false
    )
    protected Map<String, String> sqlMap;
    @TableField(
            exist = false
    )
    protected Long size;
    @TableField(
            exist = false
    )
    protected Long current;
    public static final String DEL_FLAG_NORMAL = "0";
    public static final String DEL_FLAG_DELETE = "1";

    public BaseEntity() {
        this.size = 10L;
        this.current = 1L;
    }

    public BaseEntity(Long id) {
        this();
        this.id = id;
    }

    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }

    public IPage getPage() {
        if (this.page == null) {
            this.page = new Page(this.current, this.size);
        }

        return this.page;
    }

    @JsonIgnore
    public Map<String, String> getSqlMap() {
        if (this.sqlMap == null) {
            this.sqlMap = Maps.newHashMap();
        }

        return this.sqlMap;
    }

    public BaseEntity setId(final Long id) {
        this.id = id;
        return this;
    }

    public BaseEntity setCreateDate(final LocalDateTime createDate) {
        this.createDate = createDate;
        return this;
    }

    public BaseEntity setUpdateDate(final LocalDateTime updateDate) {
        this.updateDate = updateDate;
        return this;
    }

    public BaseEntity setCreateBy(final String createBy) {
        this.createBy = createBy;
        return this;
    }

    public BaseEntity setUpdateBy(final String updateBy) {
        this.updateBy = updateBy;
        return this;
    }

    public BaseEntity setRemarks(final String remarks) {
        this.remarks = remarks;
        return this;
    }

    public BaseEntity setDelFlag(final String delFlag) {
        this.delFlag = delFlag;
        return this;
    }

    public BaseEntity setErrors(final String errors) {
        this.errors = errors;
        return this;
    }

    public BaseEntity setPage(final Page page) {
        this.page = page;
        return this;
    }

    public BaseEntity setSqlMap(final Map<String, String> sqlMap) {
        this.sqlMap = sqlMap;
        return this;
    }

    public BaseEntity setSize(final Long size) {
        this.size = size;
        return this;
    }

    public BaseEntity setCurrent(final Long current) {
        this.current = current;
        return this;
    }

    public Long getId() {
        return this.id;
    }

    public LocalDateTime getCreateDate() {
        return this.createDate;
    }

    public LocalDateTime getUpdateDate() {
        return this.updateDate;
    }

    public String getCreateBy() {
        return this.createBy;
    }

    public String getUpdateBy() {
        return this.updateBy;
    }

    public String getRemarks() {
        return this.remarks;
    }

    public String getDelFlag() {
        return this.delFlag;
    }

    public String getErrors() {
        return this.errors;
    }

    public Long getSize() {
        return this.size;
    }

    public Long getCurrent() {
        return this.current;
    }
}

