/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.util.ArrayList;
import java.util.List;
import util.TabelaPrice.ArgumentosTabelaPrice;
import util.TabelaPrice.ValoresTabelaPrice;

/**
 *
 * @author Victor Rodrigues at https://github/taveirasrc
 */
public class TabelaPriceDataBase {

  public static String DEFAULT_NAME_VEMP_PARAMETER = "vEmp";
  public static String DEFAULT_NAME_JURO_PARAMETER = "vJuros";
  public static String DEFAULT_NPARC_JURO_PARAMETER = "nParcela";
  private static double totalJurosPago;
  private static final List<ValoresTabelaPrice> priceTable = new ArrayList();

  static private double calculoPrice(double montante, double juros, int n_parc) {
    juros /= 100;
    double _juros = juros + 1;
    return montante * juros * Math.pow(_juros, n_parc) / (Math.pow(_juros, n_parc) - 1);
  }

  public static ArgumentosTabelaPrice getTableParamsFromList(List<GlobalVariables.keyValue> list) {
    ArgumentosTabelaPrice tArgs = new ArgumentosTabelaPrice();

    for (GlobalVariables.keyValue value : list) {
      if (value.getParameter().equals(DEFAULT_NAME_VEMP_PARAMETER)) {
        tArgs.setValorEmprestimo(Double.valueOf(value.getArgument()));
      }

      if (value.getParameter().equals(DEFAULT_NAME_JURO_PARAMETER)) {
        tArgs.setValorJuro(Double.valueOf(value.getArgument()));
      }

      if (value.getParameter().equals(DEFAULT_NPARC_JURO_PARAMETER)) {
        tArgs.setQtdeParcela(Integer.valueOf(value.getArgument()));
      }
    }
    return tArgs;
  }

  private static boolean finishedCalc(int steps) {
    return steps <= 0;
  }

  public static List<ValoresTabelaPrice> getPriceTable() {
    List<ValoresTabelaPrice> p = new ArrayList(priceTable);
    TabelaPriceDataBase.priceTable.clear();
    return p;
  }

  public static String getTotalJurosPago() {
    return String.format("%.2f", totalJurosPago);
//    return totalJurosPago;
  }

  public static boolean generateTableByTArgs(ArgumentosTabelaPrice tArgs) {

    int n = 1;
    int steps = tArgs.getQtdeParcela();

    totalJurosPago = 0.0;
    double salDev = tArgs.getValorEmprestimo();
    double juro = tArgs.getValorJuro() / 100;
    double valorParcela = calculoPrice(tArgs.getValorEmprestimo(), tArgs.getValorJuro(), tArgs.getQtdeParcela());
    ValoresTabelaPrice value;

    while (!finishedCalc(steps)) {
      value = new ValoresTabelaPrice(n, valorParcela, salDev);

      value.juroParcela = value.saldoDevedorParcela * juro;
//      value.setJuroParcela(value.getSaldoDevedorParcela() * juro);

      totalJurosPago += value.juroParcela;
//      totJuro += value.getJuroParcela();

      value.amortizacaoParcela = valorParcela - value.juroParcela;
//      value.setAmortizacaoParcela(valorParcela - value.getJuroParcela());

      salDev = value.saldoDevedorParcela - value.amortizacaoParcela;
      value.saldoDevedorParcela = salDev;
      steps--;
      n++;
      priceTable.add(value);
    }
    return !priceTable.isEmpty();
  }
}
