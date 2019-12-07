package com.tabelafipe.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;


@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Vehicle {

    private String id;

    @JsonProperty(value = "fipe_marca")
    private String fipeMarca;

    private String name;

    private String marca;

    private String key;

    @JsonProperty(value = "fipe_name")
    private String fipeName;

    private String referencia;

    @JsonProperty(value = "fipe_codigo")
    private String fipeCodigo;

    private String combustivel;

    @JsonProperty(value = "ano_modelo")
    private String anoModelo;

    private String preco;

    private String time;

    private String veiculo;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFipeMarca() {
        return fipeMarca;
    }

    public void setFipeMarca(String fipeMarca) {
        this.fipeMarca = fipeMarca;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getFipeName() {
        return fipeName;
    }

    public void setFipeName(String fipeName) {
        this.fipeName = fipeName;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getFipeCodigo() {
        return fipeCodigo;
    }

    public void setFipeCodigo(String fipeCodigo) {
        this.fipeCodigo = fipeCodigo;
    }

    public String getCombustivel() {
        return combustivel;
    }

    public void setCombustivel(String combustivel) {
        this.combustivel = combustivel;
    }

    public String getAnoModelo() {
        return anoModelo;
    }

    public void setAnoModelo(String anoModelo) {
        this.anoModelo = anoModelo;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(String veiculo) {
        this.veiculo = veiculo;
    }

    String getPreco(){
        return this.preco;
    }

    Double getPrecoDouble(){
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(
                                new Locale("pt", "BR"));
        Number number = 0;
        try {
            number = numberFormat.parse(preco);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return number.doubleValue();
    }

}
