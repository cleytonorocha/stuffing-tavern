package cleytonorocha.com.github.client.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;

@EnableKafka
@Configuration
public class KafkaConfig {
    private String bootstrapServers;
    private String groupId;
    private String autoOffsetReset;
    private String startSagaTopic;
    private String notifyEndingTopic;
    
}
