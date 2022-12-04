<#import "parts/page.ftlh" as c>
<@c.page>
    <h1>add new user</h1>
    <form action="/regist" method="post">
        <div class="form-group"><label> User Name : <input type="text" name="username" class="form-control"/> </label></div>
        <div class="form-group"><label> Course : <input type="text" name="course" class="form-control"/> </label></div>
        <div class="form-group"><label> Login: <input type="text" name="login" class="form-control"/> </label></div>
        <div class="form-group"><label> Password: <input type="password" name="password" class="form-control"/> </label></div>
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <div><a href="http://localhost:8081/login" class="mr-2">Sign in</a><button type="submit" class="btn btn-primary">Confirm</button></div>
    </form>
</@c.page>