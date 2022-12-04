<#import "parts/page.ftlh" as c>

<@c.page>
    <form action="http://localhost:8081/findUsers" method="post" class="form-inline mb-3">
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <input class="form-control" type="number" name="id" placeholder="Student id"/>
        <button type="submit" class="btn btn-primary ml-2">find</button>
    </form>
    <table class="table mt-3">
        <tr>
            <th>Subject</th>
            <th>Student id</th>
            <th>Grade</th>
            <th>Comment</th>
        </tr>
        <#list GradesList as grade>
            <tr>
                <th>${grade.subject}</th>
                <th>${grade.student}</th>
                <th>${grade.grade}</th>
                <th>${grade.comment}</th>
            </tr>
        </#list>
    </table>
</@c.page>