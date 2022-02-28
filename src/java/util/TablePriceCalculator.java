package util;

/**
 *
 * @author Victor Rodrigues at https://github/taveirasrc
 */
public class TablePriceCalculator {

  private final double parcela;
  private final double juro;

  private double sal_dev;
  private double juro_par;
  private double val_amortizacao;
  private double totJuro;

  private int quantidadeParcela;

  public TablePriceCalculator(double montante, double parc, double juros, int quantidadeParcela) {
    this.sal_dev = montante;
    this.parcela = parc;
    this.juro = juros / 100;
    this.quantidadeParcela = quantidadeParcela;
    this.totJuro = 0.0;

    nextCalc();
  }

  public String getAmortizacao() {
    if(finishedCalc())
      return "X";
    return String.format("%.2f", val_amortizacao);
  }

  public String getJuros() {
    if(finishedCalc())
      return "X";
    return String.format("%.2f", juro_par);
  }

  public String getSaldoDevedor() {
    if(finishedCalc())
      return "X";
    return String.format("%.2f", sal_dev);
  }

  public String getTotalJuros() {
    return String.format("%.2f", totJuro);
  }

  public final void nextCalc() {
    juro_par = sal_dev * juro;
    totJuro += juro_par;
    val_amortizacao = parcela - juro_par;
    sal_dev -= val_amortizacao;
    quantidadeParcela--;
  }

  public boolean finishedCalc() {
    return quantidadeParcela < 0;
  }

  static public double calc_price(double montante, double juros, int n_parc) {
    juros /= 100;
    double _juros = juros + 1;
    return montante * juros * Math.pow(_juros, n_parc) / (Math.pow(_juros, n_parc) - 1);
  }
}
