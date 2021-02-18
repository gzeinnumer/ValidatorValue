package com.gzeinnumer.vv;

public class ValidatorModel {

    boolean value;
    String msg = "Required correct value";

    public ValidatorModel(boolean value) {
        this.value = value;
    }

    public ValidatorModel(boolean value, String msg) {
        this.value = value;
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "ValidatorModel{" +
                "value=" + value +
                ", msg='" + msg + '\'' +
                '}';
    }
}
