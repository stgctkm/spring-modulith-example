# spring modulith example

1. イベント発行
    - DB
    - RabbitMQ
2. テスト
    - moduleの依存関係のテスト
3. ドキュメンテーション
   - 図（plantUML）
   - actuator/modulith

```shell
curl localhost:8080/orders \
  -X POST \
  -H "content-type: application/json" \
  -d '{"lineItems": [{"quantity": 2, "product": 1}]}'
```


### example
- https://spring.io/projects/spring-modulith#samples