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

//Chamado esse servlet depois de autenticado, nem mesmo processa, gerando erro. [ ] Tratar
@WebServlet(name = "NovaContaServlet", urlPatterns = {"/novaConta"})
public class NovaContaServlet extends HttpServlet {

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    //Regasta o objeto da sessão novamente
    List<keyValue> list;
    list = (List<keyValue>) GlobalVariables.session.getAttribute("listaParametrosPost");

    //Usa metodo especializado em obter parametros que diz respeito somente a credenciais do usuario.
    UserCredentials user = UserDataBase.getUserCredentialsFromList(list);

    //Pindura as credenciais atualmente passadas para devolvelas novamente no formulario JSP
    GlobalVariables.session.setAttribute("recentUserName", user.getNickname());
    GlobalVariables.session.setAttribute("recentUserPass", user.getPassword());

    //Tenta realizar a adicao desse usuario no banco de dados ficticio, retornando o status da operacao
    int operationStatusCode = UserDataBase.addUserByUserObj(user);

    //Pindura as a mensagem referente ao codigo de status devolvido da operacao de insercao, para usar como retorno no formulario
    GlobalVariables.session.setAttribute("opStatus", GlobalVariables.getDefaultMsg(operationStatusCode));

    //limpando dados em memoria desnecessaria
    list = (List<keyValue>) GlobalVariables.session.getAttribute("listaParametrosPost");
    list.clear();
    GlobalVariables.session.removeAttribute("listaParametrosPost");

    // redireciona para o formulario principal ja com o status da operacao na sessao
    response.sendRedirect("index.jsp");
  }
  
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.sendRedirect("index.jsp");
  }
}
