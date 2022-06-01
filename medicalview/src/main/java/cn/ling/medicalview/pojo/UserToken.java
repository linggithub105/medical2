package cn.ling.medicalview.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @program: medical2
 * @author: zhanling.li
 * @create: 2021-10-17 22:49
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@TableName("user_token")
public class UserToken {
    @TableId(value = "id")
    private String  id;
    @TableField("userId")
    private String userId;
    @TableField("loginTime")
    private Date loginTime;
    @TableField("createTime")
    private Date createTime;
    @TableField("state")
    private Integer state;
}
