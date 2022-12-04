<#import "parts/page.ftlh" as c>

<@c.page>
<div>
    <table class="table">
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Course</th>
        </tr>
    <#list users as user>
        <tr>
            <th>${user.id}</th>
            <th>${user.name}</th>
            <th>${user.course}</th>
        </tr>
    </#list>
    </table>
</div>
</@c.page>