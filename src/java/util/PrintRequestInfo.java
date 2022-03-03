/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Victor Rodrigues at https://github/taveirasrc
 */
public class PrintRequestInfo {
  public static void print (HttpServletRequest request) {
    
    System.out.println("getAuthType(): " + request.getAuthType());
    System.out.println("getCharacterEncoding(): " + request.getCharacterEncoding());
    System.out.println("getContentLength(): " + request.getContentLength());
    System.out.println("getContentLengthLong(): " + request.getContentLengthLong());
    System.out.println("getContentType(): " + request.getContentType());
    System.out.println("getContextPath(): " + request.getContextPath());
    System.out.println("getLocalAddr(): " + request.getLocalAddr());
    System.out.println("getLocalName(): " + request.getLocalName());
    System.out.println("getLocalPort(): " + request.getLocalPort());
    System.out.println("getMethod(): " + request.getMethod());
    System.out.println("getPathInfo(): " + request.getPathInfo());
    System.out.println("getPathTranslated(): " + request.getPathTranslated());
    System.out.println("getProtocol(): " + request.getProtocol());
    System.out.println("getQueryString(): " + request.getQueryString());
    System.out.println("getRemoteAddr(): " + request.getRemoteAddr());
    System.out.println("getRemoteHost(): " + request.getRemoteHost());
    System.out.println("getRemotePort(): " + request.getRemotePort());
    System.out.println("getRemoteUser(): " + request.getRemoteUser());
    System.out.println("getRequestURI(): " + request.getRequestURI());
    System.out.println("getRequestURL(): " + request.getRequestURL());
    System.out.println("getRequestedSessionId(): " + request.getRequestedSessionId());
    System.out.println("getScheme(): " + request.getScheme());
    System.out.println("getServerName(): " + request.getServerName());
    System.out.println("getServerPort(): " + request.getServerPort());
    System.out.println("getServletPath(): " + request.getServletPath());
  }
}
