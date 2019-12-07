package com.tabelafipe.model;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import static com.tabelafipe.util.Utils.formatPercent;

public class SetValueVehicleAnnual {

    private List<AnnualValueVehicle> annualValueVehicles = new ArrayList<>();

    private DecimalFormat formatter = new DecimalFormat("#,##0.00");

    public void add(Vehicle vehicle){
        AnnualValueVehicle annualValueVehicle = new AnnualValueVehicle();
        annualValueVehicle.setPreco(vehicle.getPrecoDouble());
        annualValueVehicle.setSentence(getSentence(vehicle));
        annualValueVehicle.setYear(vehicle.getAnoModelo());
        annualValueVehicles.add(annualValueVehicle);
    }


    private String getSentence(Vehicle vehicle){
        String sentence;
        if(annualValueVehicles.size() > 0) {
            AnnualValueVehicle lastElement = getLastElement();
            lastElement.addToSentence(",");
            sentence = createSentenceComparison(vehicle, lastElement);
        }else{
            sentence = createSentence(vehicle);
        }
        return sentence;
    }

    public List<String> getAnnualValueVehicles(){
        List<String> sentences = new ArrayList<>();
        annualValueVehicles.forEach(devaluationDto -> sentences.add(devaluationDto.getSentence()));
        return sentences;
    }

    private AnnualValueVehicle getLastElement(){
        return annualValueVehicles.get(annualValueVehicles.size()-1);
    }

    private String createSentence(Vehicle vehicle){
        return "Value in " + vehicle.getAnoModelo() + " -> " + vehicle.getPreco();
    }

    private String createSentenceComparison(Vehicle vehicle, AnnualValueVehicle lastElement){
        String sentence = createSentence(vehicle);
        double difference = lastElement.getPreco() - vehicle.getPrecoDouble();
        double percent = (difference * 100) / lastElement.getPreco();
        sentence += " change of R$ " + formatter.format(difference);
        sentence += " (" + formatPercent(percent) + "%) in relation to " + lastElement.getYear();
        return sentence;
    }
}
