package cn.ling.medicalview.mapper;

import cn.ling.medicalview.pojo.UserToken;
import org.apache.ibatis.annotations.Mapper;

import java.sql.Savepoint;

/**
 * @program: medical2
 * @author: zhanling.li
 * @create: 2021-10-17 23:14
 */
//@Mapper
public interface UserTokenMapper {

    int save(UserToken userToken);
}
