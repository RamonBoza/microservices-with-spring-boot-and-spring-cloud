ZIPKIN

In order to download and run zipkin use:

curl -sSL https://zipkin.io/quickstart.sh | bash -s
Java -jar zipkin.jar

To tell zipkin that we have RabbitMQ in the background running we should execute it instead with

RABBIT_URI=amqp://localhost java -jar zipkin.jar