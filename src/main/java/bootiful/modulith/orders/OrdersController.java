package bootiful.modulith.orders;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
class OrdersController {

  OrderService orderService;

  OrdersController(OrderService orderService) {
    this.orderService = orderService;
  }

  @PostMapping
  void place(@RequestBody Order order) {
    orderService.place(order);
  }

}
