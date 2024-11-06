package bootiful.modulith.orders;

import bootiful.modulith.AmqpIntegrationConfiguration;
import org.jmolecules.event.annotation.Externalized;

@Externalized(target = AmqpIntegrationConfiguration.ORDER_QUEUE)
public record OrderPlacedEvent(Integer id) {}
