
<%--jsp 文件头--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge"/>
    <title>风雨无阻-网上书店</title>
    <base href="<%=request.getContextPath() + "/"%>">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"/>
    <link rel="stylesheet" href="assets/css/vendor/vendor.min.css"/>
    <link rel="stylesheet" href="assets/css/plugins/plugins.min.css"/>
    <link rel="stylesheet" href="assets/css/style.min.css"/>
    <script type="text/javascript" src="script/jquery-3.6.0.min.js"></script>
    <script type="text/javascript">
        window.onload = function () {//页面执行完毕后执行function

            //决定显示登录还是注册，如果注册失败显示注册tab
            if ("${requestScope.active}" =="register"){
                $("#register_tab")[0].click();//模拟点击
            }
            //绑定验证码图片的点击事件，可以获得新的验证码
            $("#codeImg").click(function () {
                //this对象，表示当前正在响应的dom对象
                //很多浏览器在url未发生改变的情况下，图片不会发出新的请求
                //为了防止不请求，不刷新，可以携带一个变化参数
                this.src = "<%=request.getContextPath()+'/'%>kaptchaServlet?id="+new Date();
            })
            //用户注册验证
            $("#sub-btn").click(function () {//绑定点击事件
                var usernameVal = $("#username").val();//获得输入的用户名
                var usernamePattern = /^\w{6,10}$/;//验证用户名为6-10个字符（数字或者字母）
                if (!usernamePattern.test(usernameVal)) {
                    $("span.errorMsg").text("用户名格式不对，需要6-10个字符");
                    return false;//错误则不跳转到登录页面
                }
                var passwordVal = $("#password").val();
                var passwordPattern = /^\w{6,10}$/;
                if (!passwordPattern.test(passwordVal)) {
                    $("span[class='errorMsg']").text("密码格式不对，需要6-10个字符");
                    return false;
                }
                var repwdVal = $("#repwd").val();
                if (repwdVal != passwordVal) {
                    $("span[class='errorMsg']").text("两次密码不同");
                    return false;
                }
                var emailVal = $("#email").val();
                var emailPattern = /^[\w-]+@([a-zA-Z]+\.)+[a-zA-Z]+$/;
                if (!emailPattern.test(emailVal)) {
                    $("span[class='errorMsg']").text("电子邮箱格式不正确");
                    return false;
                }
                //验证码验证
                // var codeText = $("#code").val();
                // if(codeText == null || codeText ==""){
                //     $("span[class='errorMsg']").text("验证码不能为空!");
                //     return false;
                // }
                //到这里全部通关，暂时不提交，显示验证通过信息
                return true;
            })
            $("#submit-login").click(function () {
                var usernameVal = $("#username-login").val();
                var usernamePattern = /^\w{6,10}$/;//验证用户名为6-10个字符（数字或者字母）
                if (!usernamePattern.test(usernameVal)) {
                    $("span.errorMsg-login").text("用户名格式不对，需要6-10个字符");
                    return false;//错误则不跳转到登录页面
                }
                var passwordVal = $("#password-login").val();
                var passwordPattern = /^\w{6,10}$/;
                if (!passwordPattern.test(passwordVal)) {
                    $("span[class='errorMsg-login']").text("密码格式不对，需要6-10个字符");
                    return false;
                }
                return true;
            })


        }
    </script>
</head>
<body>
<!-- Header Area start  -->
<div class="header section">
    <!-- Header Top Message Start -->
    <!-- Header Top  End -->
    <!-- Header Bottom  Start -->
    <div class="header-bottom d-none d-lg-block">
        <div class="container position-relative">
            <div class="row align-self-center">
                <!-- Header Logo Start -->
                <div class="col-auto align-self-center">
                    <div class="header-logo">
                        <a href="index.jsp"><img src="assets/images/logo/logo2.png" alt="Site Logo"/></a>
                    </div>
                </div>
                <!-- Header Logo End -->

            </div>
        </div>
    </div>
    <!-- Header Bottom  Start 手机端的header -->
    <div class="header-bottom d-lg-none sticky-nav bg-white">
        <div class="container position-relative">
            <div class="row align-self-center">
                <!-- Header Logo Start -->
                <div class="col-auto align-self-center">
                    <div class="header-logo">
                        <a href="index.jsp"><img width="280px" src="assets/images/logo/logo2.png" alt="Site Logo"/></a>
                    </div>
                </div>
                <!-- Header Logo End -->
            </div>
        </div>
    </div>
    <!-- Main Menu Start -->
    <div style="width: 100%;height: 50px;background-color: black"></div>
    <!-- Main Menu End -->
</div>
<!-- Header Area End  -->
<!-- login area start -->
<div class="login-register-area pt-70px pb-100px">
    <div class="container">
        <div class="row">
            <div class="col-lg-7 col-md-12 ml-auto mr-auto">
                <div class="login-register-wrapper">
                    <div class="login-register-tab-list nav">
                        <a class="active" data-bs-toggle="tab" href="#lg1">
                            <h4>会员登录</h4>
                        </a>
                        <a id="register_tab" data-bs-toggle="tab" href="#lg2">
                            <h4>会员注册</h4>
                        </a>
                    </div>
                    <div class="tab-content">
                        <div id="lg1" class="tab-pane active">
                            <div class="login-form-container">
                                <div class="login-register-form">
                                    <%--提示错误信息--%>
                                    <span class="errorMsg"
                                          style="float: right; font-weight: bold; font-size: 20pt; margin-left: 10px;">
                                        ${requestScope.error}
                                    </span>
                                    <%--会员登录表单--%>
                                    <form action="memberServlet" method="post">
                                        <%--增加隐藏域表示login请求--%>
                                        <input type="hidden" name="action" value="login">
                                        <input type="text" id="username-login" name="username" placeholder="Username"
                                               value=${requestScope.username}>
                                        <input type="password" id="password-login" name="password"
                                               placeholder="Password"/>
                                        <div class="button-box">
                                            <div class="login-toggle-btn">
                                                <input type="checkbox"/>
                                                <a class="flote-none" href="javascript:void(0)">Remember me</a>
                                                <a href="#">Forgot Password?</a>
                                            </div>
                                            <button type="submit" id="submit-login"><span>Login</span></button>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                        <div id="lg2" class="tab-pane">
                            <div class="login-form-container">
                                <div class="login-register-form">
                                    <span class="errorMsg"
                                          style="float: right; font-weight: bold; font-size: 20pt; margin-left: 10px;">
                                        ${requestScope.error}
                                    </span>
                                    <!-- 注册表单-->
                                    <form action="memberServlet" method="post">
                                        <input type="hidden" name="action" value="register">
                                        <input type="text" id="username" name="username" value="${requestScope.member.username}" placeholder="Username"/>
                                        <input type="password" id="password" name="password" value="${requestScope.member.password}" placeholder="输入密码"/>
                                        <input type="password" id="repwd" name="repassword" value="${requestScope.member.password}" placeholder="确认密码"/>
                                        <input name="email" id="email" placeholder="电子邮件" value="${requestScope.member.email}" type="email"/>
                                        <input type="text" id="code" name="code" style="width: 50%"
                                               placeholder="验证码"/>　　<img id="codeImg" alt="" src="kaptchaServlet" style="height:50px ;width: 120px">
                                        <div class="button-box">
                                            <button type="submit" id="sub-btn"><span>会员注册</span></button>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- login area end -->

<!-- Footer Area Start -->
<div class="footer-area">
    <div class="footer-container">
        <div class="footer-top">
            <div class="container">
                <div class="row">
                    <!-- Start single blog -->
                    <!-- End single blog -->
                    <!-- Start single blog -->
                    <div class="col-md-6 col-sm-6 col-lg-3 mb-md-30px mb-lm-30px" data-aos="fade-up"
                         data-aos-delay="400">
                        <div class="single-wedge">
                            <h4 class="footer-herading">信息</h4>
                            <div class="footer-links">
                                <div class="footer-row">
                                    <ul class="align-items-center">
                                        <li class="li"><a class="single-link" href="about.html">关于我们</a></li>
                                        <li class="li"><a class="single-link" href="#">交货信息</a></li>
                                        <li class="li"><a class="single-link" href="privacy-policy.html">隐私与政策</a></li>
                                        <li class="li"><a class="single-link" href="#">条款和条件</a></li>
                                        <li class="li"><a class="single-link" href="#">制造</a></li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- End single blog -->
                    <!-- Start single blog -->
                    <div class="col-md-6 col-lg-2 col-sm-6 mb-lm-30px" data-aos="fade-up" data-aos-delay="600">
                        <div class="single-wedge">
                            <h4 class="footer-herading">我的账号</h4>
                            <div class="footer-links">
                                <div class="footer-row">
                                    <ul class="align-items-center">
                                        <li class="li"><a class="single-link" href="my-account.html">我的账号</a>
                                        </li>
                                        <li class="li"><a class="single-link" href="cart.html">我的购物车</a></li>
                                        <li class="li"><a class="single-link" href="login.jsp">登录</a></li>
                                        <li class="li"><a class="single-link" href="wishlist.html">感兴趣的</a></li>
                                        <li class="li"><a class="single-link" href="checkout.html">结账</a></li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- End single blog -->
                    <!-- Start single blog -->
                    <div class="col-md-6 col-lg-3" data-aos="fade-up" data-aos-delay="800">

                    </div>
                    <!-- End single blog -->
                </div>
            </div>
        </div>
        <div class="footer-bottom">
            <div class="container">
                <div class="row flex-sm-row-reverse">
                    <div class="col-md-6 text-right">
                        <div class="payment-link">
                            <img src="#" alt="">
                        </div>
                    </div>
                    <div class="col-md-6 text-left">
                        <p class="copy-text">Copyright &copy; 2022 风雨无阻有限公司~</p>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- Footer Area End -->
<script src="assets/js/vendor/vendor.min.js"></script>
<script src="assets/js/plugins/plugins.min.js"></script>
<!-- Main Js -->
<script src="assets/js/main.js"></script>
</body>
</html>