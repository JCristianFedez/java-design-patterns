package com.cristian.design.patterns.ejemplo02;

import com.cristian.design.patterns.ejemplo02.coin.Dollar;
import com.cristian.design.patterns.ejemplo02.coin.Euro;
import com.cristian.design.patterns.ejemplo02.coin.EuroAdapter;
import com.cristian.design.patterns.ejemplo02.wallet.Wallet;

public class Demo {

  public static void main(String[] args) {
    final Euro euro = new Euro(25);
    //    final Wallet euroWallet = new Wallet(euro); No compila

    final Dollar dollar = new Dollar(100);
    final Wallet dollarWallet = new Wallet(dollar);
    System.out.println("dollarWallet = " + dollarWallet.currentMoney());

    final EuroAdapter euroAdapter = new EuroAdapter(euro);
    final Wallet adapterWallet = new Wallet(euroAdapter);
    System.out.println("adapterWallet = " + adapterWallet.currentMoney());
  }
}
