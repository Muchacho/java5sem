<#--<#include "security.ftlh">-->
<#include "logoutForm.ftlh">

<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="/">Study</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item">
        <a class="nav-link" href="/">Home</a>
      </li>
<#--      <#if isAdmin>-->
      <li class="nav-item">
        <a class="nav-link" href="/user/getGrades">Grades</a>
      </li>
<#--      </#if>-->
      <li class="nav-item">
        <a class="nav-link" href="/getUsers">Students</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="/email">Send mail</a>
      </li>
    </ul>
<#--    <div class="navbar-text mr-3">${name}</div>-->
      <@logout/>
  </div>
</nav>