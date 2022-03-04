package util;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import util.GlobalVariables.keyValue;

//Chamado esse servlet depois de autenticado, nem mesmo processa, gerando erro. [ ] Tratar
@WebServlet("/frmControl")
public class frmControlServlet extends HttpServlet {

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
    GlobalVariables.session = request.getSession(false);
    GlobalVariables.populateParameters(request);

    //Pindura os parametros na sessão atual, e destroi na memoria estatica da Java
    GlobalVariables.session.setAttribute("listaParametrosPost", GlobalVariables.getParametersList());

    
    //Regasta o objeto da sessão
    List<keyValue> list;
    list = (List<keyValue>) GlobalVariables.session.getAttribute("listaParametrosPost");
    
    //Verifica se contem determinado parametro dentro da lista, e atribui o path de acordo
    String path = GlobalVariables.containsParameter(list, "registerOption") ? "/novaConta" : "/loginConta";
    
    //Repassa a requisao do tipo POST para o path
    GlobalVariables.rd = request.getRequestDispatcher(path);
    GlobalVariables.rd.forward(request, response);
  }
  
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.sendRedirect("index.jsp");
  }
}
