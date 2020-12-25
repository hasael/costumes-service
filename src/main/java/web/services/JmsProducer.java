package web.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;
import web.core.Costume;

@Slf4j
@Component
public class JmsProducer implements MessageNotifier {

    @Autowired
    private JmsTemplate jmsTemplate;

    @Override
    public void notifyCostume(Costume costume) {
        try {
            log.info("sending costume: " + costume.getId());
            jmsTemplate.convertAndSend("topic", toJson(costume));
        } catch (Exception ex) {
            log.error("error: " + ex.getLocalizedMessage());
        }
    }

    private String toJson(Costume costume){
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(costume);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }
}
