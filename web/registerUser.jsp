<%-- 
    Document   : registerUser
    Created on : 26 de fev. de 2022, 17:16:11
    Author     : Victor Rodrigues at https://github/taveirasrc
--%>

<%@page import="java.util.Enumeration"%>
<%@page import="java.util.List"%>
<%@page import="util.RequestData"%>
<%@page import="java.util.ArrayList"%>

<%!
  boolean send = false;
%>

<%
  if (send) {
    Enumeration<String> pNames = request.getParameterNames();
    if (pNames == null) {
      System.out.println("null");
    }
    while (pNames.hasMoreElements()) {
      System.out.println(pNames.nextElement());
    }
  } else {
    send = true;%>
<script>
  let formData = new FormData();
  formData.append('name', 'victor');
  formData.append('lastName', 'taveira');
  fetch('registerUser.jsp', {
    method: 'POST',
    headers: new Headers({
      'Content-Type': 'text/plain'
    }),
    body: formData
  }).then(console.log('Enviou'));

</script>
<%}%>



