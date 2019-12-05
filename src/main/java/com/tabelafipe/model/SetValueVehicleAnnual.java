package com.tabelafipe.model;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import static com.tabelafipe.util.Utils.formatPercent;

public class SetValueVehicleAnnual {

    private List<ValueVehicleAnnual> valueVehicleAnnuals = new ArrayList<>();

    private DecimalFormat formatator = new DecimalFormat("#,##0.00");

    public void add(Vehicle vehicle){
        ValueVehicleAnnual valueVehicleAnnual = new ValueVehicleAnnual();
        valueVehicleAnnual.setPreco(vehicle.getPrecoDouble());
        valueVehicleAnnual.setSentense(getSentence(vehicle));
        valueVehicleAnnual.setYear(vehicle.getAnoModelo());
        valueVehicleAnnuals.add(valueVehicleAnnual);
    }


    private String getSentence(Vehicle vehicle){
        String sentence;
        if(valueVehicleAnnuals.size() > 0) {
            ValueVehicleAnnual lastElement = getLastElement();
            lastElement.addToSentence(",");
            sentence = createSentenceWithComparison(vehicle, lastElement);
        }else{
            sentence = createSentence(vehicle);
        }
        return sentence;
    }

    public List<String> getValueVehicleAnnuals(){
        List<String> sentences = new ArrayList<>();
        valueVehicleAnnuals.forEach(depreciationDto -> sentences.add(depreciationDto.getSentense()));
        return sentences;
    }

    private ValueVehicleAnnual getLastElement(){
        return valueVehicleAnnuals.get(valueVehicleAnnuals.size()-1);
    }

    private String createSentence(Vehicle vehicle){
        return "Valor em " + vehicle.getAnoModelo() + " -> " + vehicle.getPreco();
    }

    private String createSentenceWithComparison(Vehicle vehicle, ValueVehicleAnnual lastElement){
        String sentence = createSentence(vehicle);
        double difference = lastElement.getPreco() - vehicle.getPrecoDouble();
        double percent = (difference * 100) / lastElement.getPreco();
        sentence += " alteração de R$ " + formatator.format(difference);
        sentence += " (" + formatPercent(percent) + "%) em relação a " + lastElement.getYear();
        return sentence;
    }
}
