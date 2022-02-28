/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

/**
 *
 * @author Victor Rodrigues at https://github/taveirasrc
 */
public class RequestData {
  
  private String parameter;
  private String argument;

  public RequestData(String parameter, String argument) {
    this.parameter = parameter;
    this.argument = argument;
  }

  
  public String getParameter() {
    return parameter;
  }

  public void setParameter(String parameter) {
    this.parameter = parameter;
  }

  public String getArgument() {
    return argument;
  }

  public void setArgument(String argument) {
    this.argument = argument;
  }

  @Override
  public String toString() {
    return this.parameter + ":" + this.argument;
  }
}
