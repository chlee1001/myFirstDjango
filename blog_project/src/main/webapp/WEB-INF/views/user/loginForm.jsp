<%--
  Created by IntelliJ IDEA.
  User: chlee
  Date: 2021-07-19
  Time: 오후 7:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="../layout/header.jsp" %>

<div class="container">
    <%--    /auth/loginProc를 userApiController에 만드는 것이 아니라 Spring Security가 가로채게 만든다.--%>
    <form action="/auth/loginProc" method="post">
        <div class="form-group">
            <label for="username">Username:</label>
            <input type="text" name="username" class="form-control" placeholder="Enter Username" id="username">
        </div>

        <div class="form-group">
            <label for="password">Password:</label>
            <input type="password" name="password" class="form-control" placeholder="Enter password" id="password">
        </div>

        <button id="btn-login" class="btn btn-primary">로그인</button>
    </form>
</div>

<%--<script src="/js/user.js"></script>--%>
<%@include file="../layout/footer.jsp" %>

