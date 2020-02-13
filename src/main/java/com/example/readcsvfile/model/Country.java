package com.example.readcsvfile.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Country {

    @Id
    @GeneratedValue
    private int Id;
    private String region;
    private int ladder;
    private int sdOfLadder;
    private int positiveAffect;
    private int negativeAffect;
    private int socialSupport;
    private int freedom;
    private int corruption;
    private int generosity;
    private int logOfGDP;
    private int healthy;

    public Country() {
    }

    @Override
    public String toString() {
        return "Country{" +
                "Id=" + Id +
                ", region='" + region + '\'' +
                ", ladder=" + ladder +
                ", SdofLadder=" + sdOfLadder +
                ", positiveAffect=" + positiveAffect +
                ", negativeAffect=" + negativeAffect +
                ", socialSupport=" + socialSupport +
                ", freedom=" + freedom +
                ", corruption=" + corruption +
                ", generosity=" + generosity +
                ", logOfGDP=" + logOfGDP +
                ", healthy=" + healthy +
                '}';
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public int getLadder() {
        return ladder;
    }

    public void setLadder(int ladder) {
        this.ladder = ladder;
    }

    public int getSdOfLadder() {
        return sdOfLadder;
    }

    public void setSdOfLadder(int sdOfLadder) {
        this.sdOfLadder = sdOfLadder;
    }

    public int getPositiveAffect() {
        return positiveAffect;
    }

    public void setPositiveAffect(int positiveAffect) {
        this.positiveAffect = positiveAffect;
    }

    public int getNegativeAffect() {
        return negativeAffect;
    }

    public void setNegativeAffect(int negativeAffect) {
        this.negativeAffect = negativeAffect;
    }

    public int getSocialSupport() {
        return socialSupport;
    }

    public void setSocialSupport(int socialSupport) {
        this.socialSupport = socialSupport;
    }

    public int getFreedom() {
        return freedom;
    }

    public void setFreedom(int freedom) {
        this.freedom = freedom;
    }

    public int getCorruption() {
        return corruption;
    }

    public void setCorruption(int corruption) {
        this.corruption = corruption;
    }

    public int getGenerosity() {
        return generosity;
    }

    public void setGenerosity(int generosity) {
        this.generosity = generosity;
    }

    public int getLogOfGDP() {
        return logOfGDP;
    }

    public void setLogOfGDP(int logOfGDP) {
        this.logOfGDP = logOfGDP;
    }

    public int getHealthy() {
        return healthy;
    }

    public void setHealthy(int healthy) {
        this.healthy = healthy;
    }

    public Country(String region, int ladder, int sdofLadder, int positiveAffect, int negativeAffect, int socialSupport, int freedom, int corruption, int generosity, int logOfGDP, int healthy) {
        this.region = region;
        this.ladder = ladder;
        sdOfLadder = sdofLadder;
        this.positiveAffect = positiveAffect;
        this.negativeAffect = negativeAffect;
        this.socialSupport = socialSupport;
        this.freedom = freedom;
        this.corruption = corruption;
        this.generosity = generosity;
        this.logOfGDP = logOfGDP;
        this.healthy = healthy;
    }
}
