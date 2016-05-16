package ru.yarobot.entities.model;

public enum Position {
    SPECIAL_1(0), SPECIAL_2(1), SPECIAL_3(2),
    GUARANTEE_1(3), GUARANTEE_2(4), GUARANTEE_3(5),
    GUARANTEE_4(6), UNKNOWN_ERROR(7);

    private int order;

    Position(int order) {
        this.order = order;
    }

    public boolean higher(Position position){
        return this.order < position.order;
    }

}