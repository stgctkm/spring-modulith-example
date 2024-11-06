package bootiful.modulith.products;

import bootiful.modulith.orders.OrderPlacedEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.modulith.events.ApplicationModuleListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
class ProductService {

  Logger logger = LoggerFactory.getLogger(this.getClass());


//  @EventListener // sync
  @ApplicationModuleListener //async
  void on(OrderPlacedEvent orderPlacedEvent) throws InterruptedException {
    logger.info("stating [{}]", orderPlacedEvent);
    Thread.sleep(15_000);
    logger.info("stopping[{}]", orderPlacedEvent);
  }


}
