package com.bizzjen.cipes.response;

import lombok.Getter;

@Getter
public enum ResponseMessage {
    REQUEST_SUCCESSFUL("This request is successfully completed!");

    private final String description;

    ResponseMessage(String description) {
        this.description = description;
    }

}
