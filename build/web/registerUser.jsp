<%-- 
    Document   : registerUser
    Created on : 26 de fev. de 2022, 17:16:11
    Author     : Victor Rodrigues at https://github/taveirasrc
--%>

<%@page import="java.util.LinkedList"%>
<%@page import="util.PrintRequestInfo"%>
<%@page import="sun.security.util.IOUtils"%>
<%@page import="java.util.Enumeration"%>
<%@page import="java.util.List"%>
<%@page import="util.RequestData"%>
<%@page import="java.util.ArrayList"%>

<%!
  boolean send = false;
%>

<%
  List <RequestData> requestValuesList = (ArrayList) session.getAttribute("user-arguments");
  
  
  System.out.println(requestValuesList.get(0).getArgument()); //login
  System.out.println(requestValuesList.get(1).getArgument()); //senha
  
  %> <%
  
  if(true)
  {
    
  }
  
  /*
  if (send) {
    Enumeration<String> pNames = request.getParameterNames();
    while (pNames.hasMoreElements()) {
      System.out.println(">" + pNames.nextElement().toString());
    }

  } else {
    send = true;
  }
  */
%>
