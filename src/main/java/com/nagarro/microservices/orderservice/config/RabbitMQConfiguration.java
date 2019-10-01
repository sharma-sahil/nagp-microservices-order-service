package com.nagarro.microservices.orderservice.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.nagarro.microservices.orderservice.constants.AppConstants;

/**
 * The Class RabbitMQConfiguration.
 *
 * @author sahilsharma
 */
@Configuration
public class RabbitMQConfiguration {

	@Bean
	Queue queue() {
		return new Queue(AppConstants.QUEUE_NAME, false);
	}

	@Bean
	TopicExchange exchange() {
		return new TopicExchange(AppConstants.TOPIC_EXCHANGE_NAME);
	}

	@Bean
	Binding binding(Queue queue, TopicExchange topicExchange) {
		return BindingBuilder.bind(queue).to(topicExchange).with(AppConstants.ROUTING_KEY);
	}

}
