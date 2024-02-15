package me.bigfanoftim.domaindriven.temp.order.domain;

public enum OrderState {

    PAYMENT_WAITING, PREPARING,
    SHIPPED, DELIVERING, DELIVERY_COMPLETED,
    CANCELED;

    /**
     * 초기에 isShippingChangeable()로 제약 조건 검사
     * 이후에 도메인에 대한 이해도 증가 -> isNotYetShipped()로 변경
     */
    public boolean isNotYetShipped() {
        return this == PAYMENT_WAITING ||
                this == PREPARING;
    }
}
