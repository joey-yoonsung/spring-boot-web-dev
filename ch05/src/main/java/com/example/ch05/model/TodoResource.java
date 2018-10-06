package com.example.ch05.model;

import lombok.Data;
import org.springframework.hateoas.ResourceSupport;
@Data
public class TodoResource extends ResourceSupport{
    private String title;

    public TodoResource(String title) {
        this.title = title;
    }

    public TodoResource() {
    }
}
