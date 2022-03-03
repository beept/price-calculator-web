package util;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import util.GlobalVariables.keyValue;

@WebServlet("/frmControl")
public class frmControlServlet extends HttpServlet {

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
    GlobalVariables.session = request.getSession(false);
    GlobalVariables.populateParameters(request);

    GlobalVariables.session.setAttribute("listaParametrosPost", GlobalVariables.getParametersList());

    List<keyValue> list;
    list = (List<keyValue>) GlobalVariables.session.getAttribute("listaParametrosPost");

    String path = GlobalVariables.containsParameter(list, "registerOption") ? "/novaConta" : "/loginConta";

    GlobalVariables.rd = request.getRequestDispatcher(path);
    GlobalVariables.rd.forward(request, response);
  }
}
