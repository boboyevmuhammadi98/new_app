package uz.alif.authentication_news_app.exception;

import uz.alif.authentication_news_app.dtos.ApiResponseWithToken;

public class AppLoginException extends RuntimeException {
    public AppLoginException(String usernameOrPasswordIsIncorrect) {
        super(usernameOrPasswordIsIncorrect);
    }
}
