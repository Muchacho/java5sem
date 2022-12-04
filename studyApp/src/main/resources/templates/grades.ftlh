<#import "parts/page.ftlh" as c>

<@c.page>
    <form action="http://localhost:8081/user/findGrades" method="post" class="form-inline mb-3">
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <input class="form-control" type="text" name="subject" placeholder="Subject"/>
        <button type="submit" class="btn btn-primary ml-2">Find</button>
    </form>
    <a class="btn btn-primary " data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false" aria-controls="collapseExample">
        Add grade
    </a>
    <form method="POST" action="http://localhost:8081/user/addGrade" class="collapse" id="collapseExample">
        <div class="form-group">
            <label> Subject: <input type="text" name="Subject"  class="form-control"/> </label>
        </div>
        <div class="form-group">
            <label> Student: <input type="text" name="Student"  class="form-control"/> </label>
        </div>
        <div class="form-group">
            <label> Grade: <input type="text" name="Grade"  class="form-control"/> </label>
        </div>
        <div class="form-group">
            <label> Comment: <input type="text" name="Comment"  class="form-control"/> </label>
        </div>
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <button class="btn btn-primary mb-2" type="submit">send</button>
    </form>
    <table class="table mt-3">
        <tr>
            <th>Subject</th>
            <th>Student id</th>
            <th>Grade</th>
            <th>Comment</th>
        </tr>
        <#list GradeList as grade>
            <tr>
                <th>${grade.subject}</th>
                <th>${grade.student}</th>
                <th>${grade.grade}</th>
                <th>${grade.comment}</th>
            </tr>
        </#list>
    </table>
</@c.page>