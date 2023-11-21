package uz.alif.authentication_news_app.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ApiResponse {
    private String message;
    private boolean success;
    private int code;
    private Object data;
}
