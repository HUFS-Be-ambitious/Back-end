package hufs.capstone.demo.security;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Component
public class InterceptorConfig implements HandlerInterceptor {
    @Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		HttpSession session = request.getSession(false);
        if(session.getAttribute("id") == null){
            response.sendRedirect("/member/login");
            return false;
        } else {
            return true;
        }
	}
    /*public boolean preHandle(HttpServletResponse rep, HttpServletRequest req, Object handler) throws Exception{
        HttpSession session = req.getSession();
        if(session.getAttribute("mail") == null){
            rep.sendRedirect("/member/login");
            return false;
        } else {
            return true;
        }
    }
     */
}
