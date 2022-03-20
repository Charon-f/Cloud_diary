package com.yun.servlet;

import com.yun.dao.NoteTypeDao;
import com.yun.entity.NoteType;
import com.yun.entity.User;
import com.yun.service.NoteTypeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/type")
public class NoteTypeServlet extends HttpServlet {
    private NoteTypeService typeService = new NoteTypeService();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置首页导航的高亮值
        req.setAttribute("menu_page","type");
        //得到用户行为
        String actionName=req.getParameter("actionName");
        //判断用户行为
        if ("list".equals(actionName)){
            //查询类型列表
            typeList(req,resp);
        }
    }
/*通过用户id查询类型列表
* 1. 获取Session作用域设置的user对象
  2. 调用Service层的查询方法，查询当前登录用户的类型集合，返回集合
  3. 将类型列表设置到request请求域中
  4. 设置首页动态包含的页面值
  5. 请求转发跳转到index.jsp页面*/
    private void typeList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1. 获取Session作用域设置的user对象
        User user = (User) req.getSession().getAttribute("user");
        //2. 调用Service层的查询方法，查询当前登录用户的类型集合，返回集合
        List<NoteType> typeList = typeService.findTypeList(user.getUserId());
        //3. 将类型列表设置到request请求域中
        req.setAttribute("typeList",typeList);
        //4. 设置首页动态包含的页面值
        req.setAttribute("changPage","note/lint.jsp");
        //5. 请求转发跳转到index.jsp页面
        req.getRequestDispatcher("index.jsp").forward(req,resp);
    }
}
