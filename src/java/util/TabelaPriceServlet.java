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
import static util.GlobalVariables.populateParameters;
import static util.GlobalVariables.getParametersList;
import static util.GlobalVariables.session;

import util.TabelaPrice.ArgumentosTabelaPrice;
import static util.TabelaPriceDataBase.generateTableByTArgs;
import static util.TabelaPriceDataBase.getPriceTable;
import static util.TabelaPriceDataBase.getTableParamsFromList;
import static util.TabelaPriceDataBase.getTotalJurosPago;

/**
 *
 * @author Victor Rodrigues at https://github/taveirasrc
 */
@WebServlet(name = "TabelaPriceServlet", urlPatterns = {"/tabelaPrice"})
public class TabelaPriceServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    session = request.getSession();
    populateParameters(request);

    session.setAttribute("listaParametrosPost", getParametersList());

    List <keyValue> list;
    list = (List <keyValue>) session.getAttribute("listaParametrosPost");

    ArgumentosTabelaPrice tArgs = getTableParamsFromList(list);
    System.out.println(tArgs);
    boolean opSucess = generateTableByTArgs(tArgs);

    if(opSucess){
      session.setAttribute("totJurosPago", getTotalJurosPago());
      session.setAttribute("tablePriceList", getPriceTable());
    } else {
      session.removeAttribute("tablePriceList");
    }
    response.sendRedirect("formTabelaPrice.jsp");
  }
}
