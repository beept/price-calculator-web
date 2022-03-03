/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Victor Rodrigues at https://github/taveirasrc
 */
public class GlobalVariables {

  private static final String[] defaultMsg = {
    "Cadastro efetuado", //0
    "Usuário já existe", //1
    "Nome de usuário deve ter o tamanho de 6 a 8 carácteres", //2
    "A senha deve conter exatamente 4 dígitos alfanuméricos", //3
    "Apenas carácteres alfanuméricos", //4
    "A senha deve conter pelo menos um número", //5
    "A senha deve conter pelo menos uma letra", //6
    "Usuário não encontrado", //7
    "Senha inválida", //8
    "Login efetuado!" //9
  };

  private static final List<GlobalVariables.keyValue> pList = new ArrayList();
  private static Enumeration<String> parameters = null;
  private static String param;

  public static HttpSession session = null;
  public static RequestDispatcher rd = null;
  public static String DEFAULT_NAME_USERNAME_PARAMETER = "login";
  public static String DEFAULT_NAME_PASSWORD_PARAMETER = "senha";

  public static class keyValue {

    private final String parameter;
    private final String argument;

    public keyValue(String parameter, String argument) {
      this.parameter = parameter;
      this.argument = argument;
    }

    public String getParameter() {
      return parameter;
    }

    public String getArgument() {
      return argument;
    }
  }

  private static boolean containParameter() {
    //Nao deixar inserir parametro repitido
    return true;
  }

  public static void populateParameters(HttpServletRequest request) {
    parameters = request.getParameterNames();
    while (parameters.hasMoreElements()) {
      param = parameters.nextElement();
      //Se contem parametro, apenas atualizar
      if (containParameter()) {
        GlobalVariables.pList.add(new GlobalVariables.keyValue(param, request.getParameter(param)));
      }
    }
  }

  public static void clearParameterList() {
    GlobalVariables.pList.clear();
  }

  public static boolean containsParameter(List<keyValue> pList, String parameter) {
    for (keyValue value : pList) {
      if (value.parameter.equals(parameter)) {
        return true;
      }
    }
    return false;
  }

  public static List<keyValue> getParametersList() {
    List<keyValue> tempList = new ArrayList(GlobalVariables.pList);
    clearParameterList();
    return tempList;
  }

  public static int getListSize() {
    return pList.size();
  }

  public static String getDefaultMsg(int msgCode) {
    if (msgCode >= 0 && msgCode - 1 < defaultMsg.length) {
      return defaultMsg[msgCode];
    }
    return "Ivalid msg code";
  }
}
