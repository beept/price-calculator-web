/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import static util.GlobalVariables.DEFAULT_NAME_PASSWORD_PARAMETER;
import static util.GlobalVariables.DEFAULT_NAME_USERNAME_PARAMETER;

/**
 *
 * @author Victor Rodrigues at https://github/taveirasrc
 */
public class UserDataBase {

  private static final List<UserCredentials> userList = new ArrayList();
  private static int IDSEQUENCE = 1;

  private static final Pattern NUMBERS = Pattern.compile("^[0-9]*$");
  private static final Pattern ALPHABETS = Pattern.compile("^[a-zA-Z]*$");
  private static final Pattern ALPHANUMERIC = Pattern.compile("^[a-zA-Z0-9]*$");

  public static class UserCredentials {

    private final int id;
    private String nickname;
    private String password;

    public UserCredentials(int id, String nickname, String password) {
      this.id = id;
      this.nickname = nickname;
      this.password = password;
    }

    public UserCredentials() {
      this.id = -1;
      this.nickname = "";
      this.password = "";
    }

    public void setNickname(String nickname) {
      this.nickname = nickname;
    }

    public void setPassword(String password) {
      this.password = password;
    }

    public String getNickname() {
      return nickname;
    }

    //Remover [TESTE]
    public String getPassword() {
      return password;
    }

    //Remover [TESTE]
    public int getId() {
      return id;
    }

  }

  private static UserCredentials containsUser(String nameUser) {
    for (UserCredentials user : userList) {
      if (user.getNickname().equals(nameUser)) {
        return user;
      }
    }
    return null;
  }

  private static boolean isValidSize(String nameUser) {
    return nameUser.length() >= 6 && nameUser.length() <= 8;
  }

  private static boolean isPasswordRangeValid(String password) {
    return password.length() == 4;
  }

  public static boolean isAlphaNumeric(Pattern p, String s) {
    return p.matcher(s).find();
  }

  public static int addUserByUserObj(UserCredentials user) {
    return addUserByArguments(user.getNickname(), user.getPassword());
  }

  public static int loginUserByUserObj(UserCredentials user) {
    UserCredentials _user = containsUser(user.getNickname());
    if (_user != null) {
      if (!_user.getPassword().equals(user.getPassword())) {
        return 8;
      }
      return 9;
    }
    return 7;
  }

  public static int addUserByArguments(String nameUser, String password) {

    if (containsUser(nameUser) != null) {
      return 1;
    }

    if (!isValidSize(nameUser)) {
      return 2;
    }

    if (!isPasswordRangeValid(password)) {
      return 3;
    }

    if (!isAlphaNumeric(ALPHANUMERIC, password)) {
      return 4;
    }

    if (isAlphaNumeric(ALPHABETS, password)) {
      return 5;
    }

    if (isAlphaNumeric(NUMBERS, password)) {
      return 6;
    }

    //Para login, usuario ja exite: outro metodo que chama somente containsUser() e retorna 1;
    //Para login, e senha invalida: o mesmo metodo que e retorna 7;
    UserDataBase.userList.add(new UserCredentials(IDSEQUENCE++, nameUser, password));
    return 0;
  }

  public static UserCredentials getUserCredentialsFromList(List<GlobalVariables.keyValue> list) {
    UserCredentials user = new UserCredentials();

    for (GlobalVariables.keyValue value : list) {
      if (value.getParameter().equals(DEFAULT_NAME_USERNAME_PARAMETER)) {
        user.setNickname(value.getArgument());
      }

      if (value.getParameter().equals(DEFAULT_NAME_PASSWORD_PARAMETER)) {
        user.setPassword(value.getArgument());
      }
    }
    return user; //estranho verificar
  }
}
