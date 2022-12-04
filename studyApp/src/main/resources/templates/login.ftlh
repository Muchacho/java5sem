<#import "parts/page.ftlh" as c>
<@c.page>
<form action="/login" method="post">
    <div class="form-group">
        <label> Login: <input type="text" name="username"  class="form-control"/> </label>
    </div>
    <div class="form-group">
        <label> Password: <input type="password" name="password" class="form-control"/> </label>
    </div>
    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
    <div><a href="http://localhost:8081/regist" class="mr-2">Registration</a><button type="submit" class="btn btn-primary">Sign In</button></div>
</form>
</@c.page>