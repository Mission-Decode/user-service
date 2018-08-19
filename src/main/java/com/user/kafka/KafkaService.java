package com.user.kafka;

import com.user.entity.UserBo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;

public class KafkaService {
    private static final Logger logger = LoggerFactory.getLogger(KafkaService.class);

    @Autowired
    private KafkaTemplate<String, UserBo> kafkaTemplate;

    public void pushToKafka(String topic, UserBo userBo) {
        logger.info("sending payload='{}' to topic='{}'", userBo, topic);
        kafkaTemplate.send(topic, userBo);
    }
}
