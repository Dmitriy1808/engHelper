package com.enghelper.enghelperserver.dto.response;

import lombok.Data;

@Data
public class TestSuccessResponse {
    private String content;

    public TestSuccessResponse(String string) {
        this.content = string;
    }
}
