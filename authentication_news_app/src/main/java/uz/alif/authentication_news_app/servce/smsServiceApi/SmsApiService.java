package uz.alif.authentication_news_app.servce.smsServiceApi;

import com.google.gson.Gson;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.entity.mime.MultipartEntityBuilder;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.ContentType;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import uz.alif.authentication_news_app.exception.SmsApiServerErrorException;

@Service
public class SmsApiService {

    @Value("${spring.sms.api.email}")
    private String smsApiEmail;

    @Value("${spring.sms.api.password}")
    private String smsApiPassword;

    public String getTokenFromSmsServiceApi() {
        final HttpPost httpPost = new HttpPost("https://notify.eskiz.uz/api/auth/login");
        final MultipartEntityBuilder multipartEntityBuilder = MultipartEntityBuilder.create();
        multipartEntityBuilder.addTextBody("email", smsApiEmail);
        multipartEntityBuilder.addTextBody("password", smsApiPassword);
        multipartEntityBuilder.setContentType(ContentType.MULTIPART_FORM_DATA);

        final HttpEntity multipart = multipartEntityBuilder.build();
        httpPost.setEntity(multipart);
        try (
                CloseableHttpClient client = HttpClients.createDefault();
                CloseableHttpResponse response = client.execute(httpPost)
        ) {
            return new Gson().fromJson(EntityUtils.toString(response.getEntity()), SmsApiServiceToken.class).getData().getToken();
        } catch (Exception e) {
            throw new SmsApiServerErrorException("server error pleas try again later");
        }
    }

    public boolean sendSms(String phone, String message) {
        final HttpPost httpPost = new HttpPost("https://notify.eskiz.uz/api/message/sms/send");
        httpPost.setHeader("Authorization", "Bearer " + getTokenFromSmsServiceApi());
        final MultipartEntityBuilder multipartEntityBuilder = MultipartEntityBuilder.create();
        multipartEntityBuilder.addTextBody("mobile_phone", phone);
        multipartEntityBuilder.addTextBody("message", message);

        final HttpEntity multipart = multipartEntityBuilder.build();
        httpPost.setEntity(multipart);
        try (
                CloseableHttpClient client = HttpClients.createDefault();
                CloseableHttpResponse response = client.execute(httpPost)
        ) {
            return true;
        } catch (Exception e) {
            throw new SmsApiServerErrorException("server error pleas try again later");
        }
    }
}
