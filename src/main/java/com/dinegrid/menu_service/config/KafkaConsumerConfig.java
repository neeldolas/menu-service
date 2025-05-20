package com.dinegrid.menu_service.config;


import com.dinegrid.menu_service.dto.OrderPlacedEvent;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.listener.DefaultErrorHandler;
import org.springframework.kafka.support.serializer.JsonDeserializer;


import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaConsumerConfig {

    @Value("${spring.kafka.bootstrap-servers}")
    private String bootstrapServers;

    @Value("${spring.kafka.consumer.group-id}")
    private String groupId;

    @Bean
    public ConsumerFactory<String, OrderPlacedEvent> consumerFactory() {
        JsonDeserializer<OrderPlacedEvent> valueDeserializer = new JsonDeserializer<>(OrderPlacedEvent.class);
        valueDeserializer.setRemoveTypeHeaders(true); // Important!
        valueDeserializer.addTrustedPackages("*"); // Adjust as needed
        valueDeserializer.setUseTypeMapperForKey(false); // Not needed for key deserialization

        Map<String, Object> config = new HashMap<>();
        config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        config.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);
        config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);



        return new DefaultKafkaConsumerFactory<>(
                config,
                new StringDeserializer(),
                valueDeserializer
        );
    }


    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, OrderPlacedEvent> kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, OrderPlacedEvent> factory =
                new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());

        // Optional: Add error handler
        factory.setCommonErrorHandler(new DefaultErrorHandler());
        return factory;
    }
}
