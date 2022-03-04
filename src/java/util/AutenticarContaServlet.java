/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package util;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import util.GlobalVariables.keyValue;

/**
 * Chamado esse servlet depois de autenticado, nem mesmo processa, gerando erro. [ ] Tratar
 * @author Victor Rodrigues at https://github/taveirasrc
 */
@WebServlet(name = "AutenticarContaServlet", urlPatterns = {"/loginConta"})
public class AutenticarContaServlet extends HttpServlet {

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    System.out.println("no login");

    List<keyValue> list;
    list = (List<keyValue>) GlobalVariables.session.getAttribute("listaParametrosPost");

    UserDataBase.UserCredentials user = UserDataBase.getUserCredentialsFromList(list);

    int operationSatusCode = UserDataBase.loginUserByUserObj(user);

    if (operationSatusCode == 9) {

      list = (List<keyValue>) GlobalVariables.session.getAttribute("listaParametrosPost");
      list.clear();
      GlobalVariables.session.removeAttribute("listaParametrosPost");
      GlobalVariables.session.setAttribute("userLoggedIn", "userLoggedIn");
      response.sendRedirect("formTabelaPrice.jsp");

    } else {

      GlobalVariables.session.setAttribute("recentUserName", user.getNickname());
      GlobalVariables.session.setAttribute("recentUserPass", user.getPassword());
      GlobalVariables.session.setAttribute("opStatus", GlobalVariables.getDefaultMsg(operationSatusCode));
      response.sendRedirect("index.jsp");
    }
  }
  
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.sendRedirect("index.jsp");
  }
}
