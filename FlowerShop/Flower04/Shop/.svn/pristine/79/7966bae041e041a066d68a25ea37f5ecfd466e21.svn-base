package com.exception;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import com.po.Auser;
import com.po.Buser;
public class MyExceptionHandler implements HandlerExceptionResolver {
	@Override
	public ModelAndView resolveException(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2,
			Exception arg3) {
	   	Map<String, Object> model = new HashMap<String, Object>();  
        model.put("ex", arg3); 
        // 根据不同错误转向不同页面  
       if(arg3 instanceof AdminLoginNoException){//当arg3为AdminLoginNoException的子类时，返回true；否则返回false
        	//登录页面需要auser对象
        	arg0.setAttribute("auser", new Auser());
        	arg0.setAttribute("msg", "没有登录，请登录！");
        	return new ModelAndView("/admin/login", model);//返回到管理员登陆页面
        } else if(arg3 instanceof UserLoginNoException){
        	arg0.setAttribute("buser", new Buser());
        	arg0.setAttribute("msg", "没有登录，请登录！");
        	return new ModelAndView("/before/loginin", model);//返回到用户登陆页面
       }else{  
        	return new ModelAndView("/error/error", model); //返回到错误页面
        }  
	}
}
