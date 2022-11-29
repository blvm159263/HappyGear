package com.notimplement.happygear.model.enums;

public enum OrderStatus {
    COMPLETED(0),
    ON_PROCESSING(1),
    PENDING(2),
    CANCEL(3);

    private Integer action;

    public Integer getAction(){
        return this.action;
    }

    private OrderStatus(Integer action){
        this.action = action;
    }
}
