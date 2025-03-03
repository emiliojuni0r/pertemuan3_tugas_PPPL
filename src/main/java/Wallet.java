package org.example;

import java.util.ArrayList;
import java.util.Arrays;

public class Wallet {
    private String owner;
    private ArrayList<String> listOfCards;
    private Integer cash;
    private Integer coin;

    public Wallet(String owner, String[] listOfCards, Integer cash, Integer coin) {
        this.owner = owner;
        this.listOfCards = new ArrayList<>(Arrays.asList(listOfCards));
        this.cash = cash;
        this.coin = coin;
    }

    public void addCard(String newCard) {
        listOfCards.add(newCard);
    }

    public boolean withdrawCard(String card) {
        return listOfCards.remove(card);
    }


    public String setWalletOwner(String newName) {
        setOwner(newName);
        return getOwner();
    }



    public void addMoney(Integer addedCash, Integer addedCoin) {
        if (addedCash >= 0 && addedCoin >= 0) {
            cash = cash + addedCash;
            coin = coin + addedCoin;
            System.out.println("added money : +" + (addedCash + addedCoin));
            System.out.println("Total money now: " + (cash + coin));
        } else {
            System.out.println("can't add minus");

        }
    }

    public void withdrawMoney(Integer cashAmount, Integer coinAmount){
        if (cashAmount >= 0 && coinAmount >= 0) {
            if((cash + coin) > 0) {
                cash = cash - cashAmount;
                coin = coin - coinAmount;
                System.out.println("Withdraw money: -" + (cashAmount + coinAmount));
                System.out.println("Total money now: " + (cash + coin));
            } else {
                System.out.println("Not Enough Money");
            }
        } else {
            System.out.println("can't withdraw minus amount");
        }
    }

    public Integer showTotalMoney() {
        return cash + coin;
    }


    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public ArrayList<String> getListOfCards() {
        return listOfCards;
    }

    public void setListOfCards(ArrayList<String> listOfCards) {
        this.listOfCards = listOfCards;
    }

    public Integer getCash() {
        return cash;
    }

    public void setCash(Integer cash) {
        this.cash = cash;
    }

    public Integer getCoin() {
        return coin;
    }

    public void setCoin(Integer coin) {
        this.coin = coin;
    }
}
