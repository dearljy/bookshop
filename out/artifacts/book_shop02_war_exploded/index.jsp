<%--
  Created by IntelliJ IDEA.
  User: 简
  Date: 2022/5/21
  Time: 8:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
%--直接请求CustomerFurnServlet, 获取网站首页要显示的分页数据
类似我们网站的入口页面
加载页面
--%>
<jsp:forward page="/customerBookServlet?action=pageByBookName&pageNo=1"></jsp:forward>