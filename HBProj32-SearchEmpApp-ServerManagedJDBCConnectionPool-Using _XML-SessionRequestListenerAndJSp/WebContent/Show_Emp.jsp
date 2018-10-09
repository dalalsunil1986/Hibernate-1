 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:choose>

<c:when test="${!empty empData}">

    <h1 style=color:pink>Employee Details</h1>
    
    <b>Emp Number::${empData.eid}</b><br>
    
    <b>Emp Name::${empData.ename}</b><br>
    
    <b>Emp Email::${empData.email}</b><br>
    
    <b>Emp Salary::${empData.salary}</b><br>
    
    </c:when>
    
    <c:otherwise>
    
    <b>Record Not Found</b>
    
   
    </c:otherwise>
    
    </c:choose>
    
    <br><br>
    
    <a href="search.html">Home</a>