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

/**
 *
 * @author Victor Rodrigues at https://github/taveirasrc
 */
@WebServlet(name = "AutenticarContaServlet", urlPatterns = {"/loginConta"})
public class AutenticarContaServlet extends HttpServlet {

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
    List<GlobalVariables.keyValue> list;
    list = (List<GlobalVariables.keyValue>) GlobalVariables.session.getAttribute("listaParametrosPost");
    
    UserDataBase.UserCredentials user = UserDataBase.getUserCredentialsFromList(list);
    
    int operationSatusCode = UserDataBase.loginUserByUserObj(user);
    
    GlobalVariables.session.setAttribute("recentUserName", user.getNickname());
    GlobalVariables.session.setAttribute("recentUserPass", user.getPassword());
    
    //Remover atributo opStatus caso login foi bem sussedido.
    GlobalVariables.session.setAttribute("opStatus", GlobalVariables.getDefaultMsg(operationSatusCode));
    
    if(operationSatusCode == 9)
    {
      //PAREI AQUI
      GlobalVariables.session.removeAttribute("opStatus");
      GlobalVariables.session.setAttribute("userAreLog", user);
    }
    
    GlobalVariables.session.setAttribute("opStatus", GlobalVariables.getDefaultMsg(operationSatusCode));
  }
}
