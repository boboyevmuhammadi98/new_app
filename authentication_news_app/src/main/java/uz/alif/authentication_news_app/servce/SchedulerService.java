package uz.alif.authentication_news_app.servce;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import uz.alif.authentication_news_app.repository.TokenBlockListRepository;

import java.util.Date;

@Service
@EnableScheduling
@EnableAsync
public class SchedulerService {


    @Autowired
    TokenBlockListRepository tokenBlockListRepository;
    @Async
    @Scheduled(cron = "0 34 17 * * *")
    @Transactional
    public void deleteTokenWithScheduled(){
        tokenBlockListRepository.deleteAllByExpireDateIsBefore(new Date());
    }

}
