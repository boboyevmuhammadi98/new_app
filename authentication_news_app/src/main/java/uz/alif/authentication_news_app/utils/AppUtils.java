package uz.alif.authentication_news_app.utils;

import java.util.Random;

public class AppUtils {
    public static String generateCode(){
        return String.valueOf(new Random().nextInt(0, 9999));
    }
}
