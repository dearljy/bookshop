package com.tjt.books.web;



import com.tjt.books.entity.Member;
import com.tjt.books.service.CartItemService;
import com.tjt.books.service.Impl.CartItemServiceImpl;
import com.tjt.books.service.Impl.MemberServiceImpl;
import com.tjt.books.service.MemberService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

@SuppressWarnings("all")
@WebServlet("/memberServlet")

/**
 * 
 */
public class MemberServlet extends BasicServlet {
    private MemberService memberService = new MemberServiceImpl();
    private CartItemService cartItemService = new CartItemServiceImpl();
    protected void register(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String code = req.getParameter("code");
        //从session中获取验证码
        String sessionCode = (String)req.getSession().getAttribute(KAPTCHA_SESSION_KEY);
        //得到session验证码后，立即删除，防止验证码被重复提交
        req.getSession().removeAttribute(KAPTCHA_SESSION_KEY);
        Member member = new Member(null, username, password, email);
        if (sessionCode != null && sessionCode.equalsIgnoreCase(code)){
            if (!memberService.isExistsUsername(username)){
                memberService.registerMember(member);
                req.getRequestDispatcher("/views/member/register_ok.jsp").forward(req,resp);

            }else {
                req.getRequestDispatcher("/views/member/login.jsp").forward(req,resp);
            }
        }else {
            req.setAttribute("error","验证码有误");
            req.setAttribute("active","register");
            req.setAttribute("member",member);
            req.getRequestDispatcher("/views/member/login.jsp").forward(req,resp);
        }

    }
    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //如果在登录页面，用户没有输入内容，后台接受到的是""(空串)
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        Member member = memberService.login(new Member(null, username, password, null));
        if (member != null){
            HttpSession session = req.getSession();
            session.setAttribute("member",member);
            int totalCount = cartItemService.getTotalCount(member.getId());
            //根据用户id，查询商品数量
            req.getRequestDispatcher("/views/member/login_ok.jsp?totalCount="+totalCount).forward(req,resp);
        }else {
            System.out.println("登录失败~~~");
            if(!memberService.isExistsUsername(username)){
                req.setAttribute("error","用户名有误");
                System.out.println("用户名有误");
            }else {
                req.setAttribute("error","密码有误");
                System.out.println("密码有误");
            }
            req.getRequestDispatcher("/views/member/login.jsp").forward(req,resp);
        }
    }

    /**
     * 退出登录，将登录信息从session中删除
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //销毁当前用户session
        HttpSession session = req.getSession();
        session.invalidate();
        //重定向到网站首页-> 刷新首页
        resp.sendRedirect(req.getContextPath());
    }
}
