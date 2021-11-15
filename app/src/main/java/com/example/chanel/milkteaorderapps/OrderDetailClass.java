package com.example.chanel.milkteaorderapps;

/**
 * Created by Edgar-PC on 11/24/2016.
 */

public class OrderDetailClass {

    private int jeansNo;
    private int lengthPercent;
    private int waistPercent;
    private int orderQuantity;
    private boolean typereapair;



    public OrderDetailClass() {
        this.jeansNo = 0;
        this.lengthPercent = 0;
        this.waistPercent = 0;
        this.orderQuantity = 0;
        this.typereapair = false;
    }




    public OrderDetailClass(int mealNo, int waistpercent, int lengthpercent, int orderQuantity, boolean repairType) {
        this.jeansNo = mealNo;
        this.waistPercent = waistpercent;
        this.lengthPercent =  lengthpercent;
        this.orderQuantity = orderQuantity;
        this.typereapair = repairType;

    }


    public int getJeansNo() {
        return jeansNo;
    }

    public void setMealNo(int mealNo) {
        this.jeansNo = mealNo;
    }


    public int getLengthPercent() {
        return lengthPercent;

    }

    public void setLengthPercent(int lengthpercent) {
        this.lengthPercent = lengthpercent;
    }



    public int getWaistPercent() {
        return waistPercent;
    }

    public void setSaltPercent(int waistpercent) {
        this.waistPercent = waistpercent;
    }


    public int getOrderQuantity() {
        return orderQuantity;
    }

    public void setOrderQuantity(int orderQuantity) {
        this.orderQuantity = orderQuantity;
    }

    public boolean isHaveSoup() {
        return typereapair;
    }

    public void setHaveSoup(boolean haveSoup) {
        this.typereapair = haveSoup;
    }

    @Override
    public String toString() {
        return "OrderDetailClass{" +
                "mealNo=" + jeansNo +
                ", spicyPercent=" + (lengthPercent)+
                ", saltPercent=" + (waistPercent) +
                ", orderQuantity=" + orderQuantity +
                ", repair=" + typereapair +
                '}';
    }

}
