package com.project.fitness.enums;

public enum Messages {

    SUCCESS("Success"),
    NO_ACTIVITY("No Activity");

    private final String value;

    Messages(String value){
        this.value = value;
    }

    public String getValue(){
        return this.value;
    }
}
