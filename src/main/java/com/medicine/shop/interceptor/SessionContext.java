package com.medicine.shop.interceptor;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;

/**  请求上下文
 * @Author xhua
 * @Date 2020/3/22 1:03
 **/
@Data
@NoArgsConstructor
public final class SessionContext {

    private String sid;

    private static  ThreadLocal<SessionContext> threadLocal = new ThreadLocal<>();

    /**
     *  初始化请求参数
     * @param request
     * @return
     */
    public static  SessionContext init(HttpServletRequest request){
        SessionContext sessionContext = new SessionContext();
        if (!StringUtils.isEmpty(request.getHeader("token"))){
            sessionContext.setSid(request.getHeader("token"));
        }
        threadLocal.set(sessionContext);
        return sessionContext;
    }

    public static void clear(){
        threadLocal.remove();
    }

    /**
     * 获取 session id
     * @return
     */
    public static String getRemoteSid() {
        SessionContext sessionContext = threadLocal.get();
        return sessionContext == null ? null : sessionContext.getSid();
    }

}
