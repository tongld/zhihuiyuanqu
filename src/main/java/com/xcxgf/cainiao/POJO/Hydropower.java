package com.xcxgf.cainiao.POJO;


import java.sql.Timestamp;

public class Hydropower {
    private int id;

    public Float getWater() {
        return Water;
    }

    public void setWater(Float water) {
        Water = water;
    }

    public Float getElectricity() {
        return Electricity;
    }

    public void setElectricity(Float electricity) {
        Electricity = electricity;
    }

    private Float Water;
    private Float Electricity;
    private Long Time;
    public Long getTime() {
        return Time;
    }

    public void setTime(Long time) {
        Time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }




}

