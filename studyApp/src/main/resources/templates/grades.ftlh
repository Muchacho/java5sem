<#import "parts/page.ftlh" as c>

<@c.page>
    <#if gradeError??>
        <h5>${gradeError}</h5>
    </#if>
    <form action="http://localhost:8081/user/findGrades" method="post" class="form-inline mb-3">
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <input class="form-control" type="text" name="subject" placeholder="Subject"/>
        <button type="submit" class="btn btn-primary ml-2">Find</button>
    </form>
    <a class="btn btn-primary " data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false" aria-controls="collapseExample">
        Add grade
    </a>
    <form method="POST" action="http://localhost:8081/user/addGrade" class="collapse" id="collapseExample">
        <div class="form-check form-check-inline mt-3">
            <input class="form-check-input" type="checkbox" name="Subject" id="inlineCheckbox1" value="Physics">
            <label class="form-check-label" for="inlineCheckbox1">Physics</label>
        </div>
        <div class="form-check form-check-inline mt-3 ml-2">
            <input class="form-check-input" type="checkbox" name="Subject" id="inlineCheckbox2" value="Math">
            <label class="form-check-label" for="inlineCheckbox2">Math</label>
        </div>
        <div class="form-check form-check-inline mt-3 ml-2">
            <input class="form-check-input" type="checkbox" name="Subject" id="inlineCheckbox3" value="PE">
            <label class="form-check-label" for="inlineCheckbox2">PE</label>
        </div>
        <div class="form-group mt-3">
            <label> Student: <input type="text" name="Student"  class="form-control"/> </label>
        </div>
        <div class="form-group">
            <label> Grade: <input type="number" name="Grade"  class="form-control"/> </label>
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
            <#else >

        </#list>
    </table>
</@c.page>