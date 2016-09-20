<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<nav class="navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
     <a class="navbar-brand inline-block" href="/FDMafia/">FDMafia</a>
    </div>
    <ul class="nav navbar-nav">
	  <c:choose>
	  	<c:when test="${user == null}">
			<li><a href="login">Login</a></li>
		</c:when>
	  	<c:otherwise>
	  		<li><a href="issues">My Issues</a></li>
	  		<c:if test="${role == 'DepartmentAdmin'}">	  	   
	  			<li><a class="myNewIssues" href="deptIssues">Department Issues</a>
			</c:if>
			<c:if test="${role == 'GeneralAdmin'}">
	  			<li><a class="myNewIssues" href="genIssues">General Issues</a>
			</c:if>
	       <li><a href="fileIssue">File New Issue</a></li>
		   <li><a href="logout">Logout</a></li>	   
		 </c:otherwise>
	  </c:choose>
    </ul>
	<c:if test="${user != null}">  
	    <div class="navbar-header float-right">
	      <a class="navbar-brand inactive-link" href="#">Logged in as ${user.username}</a>
	    </div>
	</c:if>
  </div>
</nav>

