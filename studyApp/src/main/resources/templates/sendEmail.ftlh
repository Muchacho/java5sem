<#import "parts/page.ftlh" as c>

<@c.page>
    <form action="http://localhost:8081/sendEmail/" method="post" class="form-inline mb-3">
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <div class="form-group"><input class="form-control ml-3" type="text" name="to" placeholder="Email"/></div>
        <div class="form-group"><input class="form-control ml-3" type="text" name="subject" placeholder="Subject"/></div>
        <div class="form-group"><input class="form-control ml-3" type="text" name="text" placeholder="Mail text"/></div>
        <div class="form-group"><button type="submit" class="btn btn-primary ml-3">Send</button></div>
    </form>
</@c.page>