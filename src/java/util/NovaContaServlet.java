package util;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import util.GlobalVariables.keyValue;
import util.UserDataBase.UserCredentials;

@WebServlet(name = "NovaContaServlet", urlPatterns = {"/novaConta"})
public class NovaContaServlet extends HttpServlet {

  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    /*
    System.out.println("chegou no servlet");
    System.out.println(GlobalVariables.getListSize());
    */
    
    List<keyValue> list;
    list = (List<GlobalVariables.keyValue>) GlobalVariables.session.getAttribute("listaParametrosPost");

    UserCredentials user = UserDataBase.getUserCredentialsFromList(list);
    
    int operationSatusCode = UserDataBase.addUserByUserObj(user);
    
    GlobalVariables.session.setAttribute("recentUserName", user.getNickname());
    GlobalVariables.session.setAttribute("recentUserPass", user.getPassword());
    GlobalVariables.session.setAttribute("opStatus", GlobalVariables.getDefaultMsg(operationSatusCode));
    
    System.out.format("[%d][%d][%s][%s][%s]\n", operationSatusCode, user.getId(), user.getNickname(), user.getPassword(), GlobalVariables.getDefaultMsg(operationSatusCode));
    
    // limpar a session quando a mesma nao estiver sendo mais necessaira.
    response.sendRedirect("index.jsp");
  }
}
