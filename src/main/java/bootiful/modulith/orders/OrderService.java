package bootiful.modulith.orders;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
class OrderService {

  OrderRepository repository;
  ApplicationEventPublisher publisher;

  Logger logger = LoggerFactory.getLogger(this.getClass());

  OrderService(OrderRepository repository, ApplicationEventPublisher publisher) {
    this.repository = repository;
    this.publisher = publisher;
  }


  void place(Order order) {
    Order saved = this.repository.save(order);
    logger.info("Placed order {}", saved);

    publisher.publishEvent(new OrderPlacedEvent(saved.id()));
  }


}
