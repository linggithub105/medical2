package cn.ling.medicalview.utils.shiroutil;

import cn.ling.medicalview.pojo.User;
import cn.ling.medicalview.service.user.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;

/**
 * 自定义Realm
 *
 * @author lenovo
 */
public class UserRealm extends AuthorizingRealm {

    @Resource
    private UserService userService;

    /**
     * 执行授权逻辑
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
        System.out.println("执行授权逻辑");

        //给资源进行授权
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //添加资源的授权字符串  授权成功
        //info.addStringPermission("admin:adminY");

        //到数据库查询当前登录用户的授权字符串
        //获取当前登录用户
        Subject subject = SecurityUtils.getSubject();
        User user = (User) subject.getPrincipal();
        /*System.out.println("用户密码" + user.getUserpass() + ";手机号" + user.getUserphone() +
                ";邮箱" + user.getUseremail());*/
        //User dbUser = userSerivce.queryuserById(user.getUid());
        //info.addStringPermission(dbUser.getPerms());
        return info;
    }

    @Autowired
    private UserService userSerivce;

    /**
     * 执行认证逻辑
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken arg0) throws AuthenticationException {
        System.out.println("执行认证逻辑");
        //编写shiro判断逻辑，判断用户名和密码
        //1.判断用户名  token=用户名+密码
        UsernamePasswordToken token = (UsernamePasswordToken) arg0;
        System.out.println(token.getUsername()+";"+token.getPassword());
        User user = userService.queryUserByInfo(token.getUsername());
        if (user!=null){
            System.out.println("用户密码" + user.getUserpass() + ";手机号" + user.getUserphone() +
                    ";邮箱" + user.getUseremail());
        }
        if (user == null) {
            //用户名不存在
            return null;//shiro底层会抛出UnKnowAccountException
        }
        //2.判断密码  返回到Subject的数据，数据库密码，realmName
        return new SimpleAuthenticationInfo(user, user.getUserpass(), "");
    }
}
