package bootiful.modulith.orders;

import org.springframework.data.repository.ListCrudRepository;

interface OrderRepository extends ListCrudRepository<Order, Integer> {

}
