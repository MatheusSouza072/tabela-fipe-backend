package com.tabelafipe.model;


public class AnnualValueVehicle {

    private double preco;

    private String year;

    private String sentence;

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getSentence() {
        return sentence;
    }

    public void setSentence(String sentence) {
        this.sentence = sentence;
    }

    public void addToSentence(String s){
        sentence += s;
    }

}
