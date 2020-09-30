package com.baomidou.samples.metainfo.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 *
 * </p>
 *
 * @author dawn
 * @since 2020-09-30
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("mp_school")
@ApiModel(value = "School对象", description = "")
public class School implements Serializable {

	private static final long serialVersionUID = 1L;

	@TableId(value = "id")
	private Long id;

	@TableField(value = "name", insertStrategy = FieldStrategy.NOT_EMPTY, updateStrategy = FieldStrategy.NOT_EMPTY)
	private String name;

	@TableField("del_flag")
	private String delFlag;

	@TableField(value = "location", insertStrategy = FieldStrategy.NOT_NULL, updateStrategy = FieldStrategy.NOT_NULL)
	private String location;

	@TableField("version")
	@Version
	private Long version;

	@TableField(value = "create_user", fill = FieldFill.INSERT)
	private Long createUser;

	@TableField(value = "create_time", fill = FieldFill.INSERT)
	private LocalDateTime createTime;

	@TableField(value = "update_user", fill = FieldFill.UPDATE)
	private Long updateUser;

	@TableField(value = "update_time", fill = FieldFill.UPDATE)
	private LocalDateTime updateTime;


}
