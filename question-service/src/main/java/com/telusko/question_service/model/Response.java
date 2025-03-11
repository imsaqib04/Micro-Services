package com.telusko.question_service.model;

import jakarta.persistence.Id;
import lombok.Data;

@Data
public class Response {

    @Id
    private int id;

    public Response() {
    }

    public Response(int id, String response) {
        this.id = id;
        this.response = response;
    }

    private String response;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
}
