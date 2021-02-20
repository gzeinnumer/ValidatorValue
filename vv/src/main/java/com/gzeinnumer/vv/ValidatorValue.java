package com.gzeinnumer.vv;

import android.annotation.SuppressLint;
import android.content.Context;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ValidatorValue {
    @SuppressLint("StaticFieldLeak")
    static volatile ValidatorValue singleton = null;
    private final List<ValidatorModel> list;
    private Context context;

    public ValidatorValue() {
        this.list = new ArrayList<>();
    }

    public static ValidatorValue with(Context context) {
        synchronized (ValidatorValue.class) {
            singleton = new ValidatorValue(context);
        }
        return singleton;
    }

    public static ValidatorValue with() {
        synchronized (ValidatorValue.class) {
            singleton = new ValidatorValue();
        }
        return singleton;
    }

    public ValidatorValue(Context context) {
        this.context = context;
        this.list = new ArrayList<>();
    }

    public ValidatorValue addValue(String value) {
        list.add(new ValidatorModel(value.length() > 0));
        return this;
    }

    public ValidatorValue addValue(String value, String msg) {
        list.add(new ValidatorModel(value.length() > 0, msg));
        return this;
    }

    public ValidatorValue addValue(String value, String msg, int minLength) {
        list.add(new ValidatorModel(value.length() >= minLength, msg));
        return this;
    }

    public ValidatorValue addValue(boolean value) {
        list.add(new ValidatorModel(value));
        return this;
    }

    public ValidatorValue addValue(boolean value, String msg) {
        list.add(new ValidatorModel(value, msg));
        return this;
    }

    public void validateListener(ValidatorValueResult callBack) {
        for (int i = 0; i < list.size(); i++) {
            if (!list.get(i).value) {
                if (context != null) {
                    String msg = list.get(i).msg;
                    Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
                }
                return;
            }
        }
        callBack.onSuccess();
    }

    public void validateListener(ValidatorValueResult callBackResult, ValidatorValueMessage callBack) {
        for (int i = 0; i < list.size(); i++) {
            if (!list.get(i).value) {
                String msg = list.get(i).msg;
                callBack.onFailed(msg);
                return;
            }
        }
        callBackResult.onSuccess();
    }
}
