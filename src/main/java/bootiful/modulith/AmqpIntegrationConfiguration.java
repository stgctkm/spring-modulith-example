package bootiful.modulith;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AmqpIntegrationConfiguration {

  @Bean
  Binding binding(Queue queue, Exchange exchange) {
    return BindingBuilder
        .bind(queue)
        .to(exchange)
        .with(ORDER_QUEUE)
        .noargs();
  }

  @Bean
  Exchange exchange() {
    return ExchangeBuilder.directExchange(ORDER_QUEUE).build();
  }

  @Bean
  Queue queue() {
    return QueueBuilder.durable(ORDER_QUEUE).build();
  }

  public static final String ORDER_QUEUE = "orders";

}
