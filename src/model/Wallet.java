package model;

import java.util.ArrayList;
import java.util.List;

public class Wallet {
  private String color;
  private List<String> cardHolder;
  private double weight;
  private String brand;
  private double money;
  private boolean isLost;

  public Wallet(
      String color,
      List<String> cardHolder,
      double weight,
      String brand,
      double money,
      boolean isLost) {
    this.color = color;
    this.cardHolder = cardHolder;
    this.weight = weight;
    this.brand = brand;
    this.money = money;
    this.isLost = isLost;
  }

  public Wallet(String color, double weight, String brand) {
    this(color, new ArrayList<>(), weight, brand, 0.0, false);
  }

  public Wallet(String color, List<String> cardHolder, double weight, String brand, double money) {
    this(color, cardHolder, weight, brand, money, false);
  }

  public void addMoney(double amount) {
    if (amount <= 0) {
      System.out.println("Amount must be positive.");
      return;
    }
    this.money += amount;
  }

  public void withdrawMoney(double amount) {
    if (amount <= 0) {
      System.out.println("Amount must be positive.");
      return;
    }
    if (amount > money) {
      System.out.println("Insufficient funds. Current balance: " + money);
      return;
    }
    money -= amount;
  }

  public double checkMoney() {
    return money;
  }

  public void setMoney(double money) {
    if (money < 0) {
      System.out.println("Money cannot be negative.");
      return;
    }
    this.money = money;
  }

  public void addCard(String card) {
    if (cardHolder.contains(card)) {
      System.out.println("Card already exists in wallet.");
      return;
    }
    cardHolder.add(card);
  }

  public boolean lost() {
    if (!isLost) {
      money = 0.0;
      cardHolder.clear();
      isLost = true;
      System.out.println("Wallet has been marked as lost. All money and cards have been cleared.");
    }
    return isLost;
  }

  public boolean isLost() {
    return isLost;
  }

  public void setLost(boolean isLost) {
    this.isLost = isLost;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public List<String> getCardHolder() {
    return new ArrayList<>(cardHolder);
  }

  public void setCardHolder(List<String> cardHolder) {
    this.cardHolder = new ArrayList<>(cardHolder);
  }

  public double getWeight() {
    return weight;
  }

  public void setWeight(double weight) {
    this.weight = weight;
  }

  public String getBrand() {
    return brand;
  }

  public void setBrand(String brand) {
    this.brand = brand;
  }
}
