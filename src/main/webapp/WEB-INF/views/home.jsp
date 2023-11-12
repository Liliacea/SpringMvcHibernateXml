<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="t" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div>
  <h2>A global community of friends and strangers spitting out their 
  inner-most and personal thoughts on the web for everyone else to 
  see.</h2>
  <h3>Look at what these people are spitting right now...</h3>

  <ol class="person-list">
    <c:forEach var="person" items="${person}"> <!--<co id="cp_foreach_spittles"/>-->
    
      <s:url value="/persons/{personName}"
                  var="person_url" >    <!--<co id="cp_spitter_url"/>-->
        <s:param name="personName"
                      value="${person.name}" />
      </s:url>


    </c:forEach>
  </ol>
</div>
