package util;

/**
 *
 * @author Victor Rodrigues at https://github/taveirasrc
 */
public class TabelaPrice {

  public static class ValoresTabelaPrice {

    private final int numParcela; //passado por fora
    private final double valorParcela; //passado por fora
    
    double amortizacaoParcela;
    double juroParcela;
    double saldoDevedorParcela;
            
    public ValoresTabelaPrice(int numParcela, double valorParcela, double saldoDevedorParcela) {
      this.numParcela = numParcela;
      this.valorParcela = valorParcela;
      
      this.amortizacaoParcela = 0.0;                  //vai ser calculado
      this.juroParcela = 0.0;                         //vai ser calculado
      this.saldoDevedorParcela = saldoDevedorParcela;
    }
    
    public int getNumParcela() {
      return numParcela;
    }

    public String getValorParcela() {
      return String.format("%.2f", valorParcela);
//      return valorParcela;
    }
    
    public void setAmortizacaoParcela(double amortizacaoParcela) {
      this.amortizacaoParcela = amortizacaoParcela;
    }

    public String getAmortizacaoParcela() {
      return String.format("%.2f", amortizacaoParcela);
//      return amortizacaoParcela;
    }
    
    public void setJuroParcela(double juroParcela) {
      this.juroParcela = juroParcela;
    }

    public String getJuroParcela() {
      return String.format("%.2f", juroParcela);
//      return juroParcela;
    }

    public void setSaldoDevedorParcela(double saldoDevedorParcela) {
      this.saldoDevedorParcela = saldoDevedorParcela;
    }
    
    public String getSaldoDevedorParcela() {
      return String.format("%.2f", saldoDevedorParcela);
//      return saldoDevedorParcela;
    }
  }

  public static class ArgumentosTabelaPrice {

    private double valorEmprestimo;
    private double valorJuro;
    private int qtdeParcela;

    public void setValorEmprestimo(double valorEmprestimo) {
      this.valorEmprestimo = valorEmprestimo;
    }

    public void setValorJuro(double valorJuro) {
      this.valorJuro = valorJuro;
    }

    public void setQtdeParcela(int qtdeParcela) {
      this.qtdeParcela = qtdeParcela;
    }

    public double getValorEmprestimo() {
      return valorEmprestimo;
    }

    public double getValorJuro() {
      return valorJuro;
    }

    public int getQtdeParcela() {
      return qtdeParcela;
    }

    @Override
    public String toString() {
      return "ArgumentosTabelaPrice{" + "valorEmprestimo=" + valorEmprestimo + ", valorJuro=" + valorJuro + ", qtdeParcela=" + qtdeParcela + '}';
    }
  }
}
