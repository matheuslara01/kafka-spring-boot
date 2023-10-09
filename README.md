# Guide to using Kafka with Spring Boot

![Java 17](https://img.icons8.com/color/48/java-coffee-cup-logo--v1.png)
![Spring](https://img.icons8.com/color/48/spring-logo.png)
![Docker](https://img.icons8.com/color/48/docker.png)
![Kafka](https://img.shields.io/badge/Kafka-green)

This guide covers setting up a Kafka environment with Spring Boot, detailing the creation of a producer and a consumer. We will use Docker Compose to orchestrate Kafka, Zookeeper and Kafdrop.

## Requirements

 - ![Java-17](https://img.shields.io/badge/Java-17-blue)
 - ![Docker](https://img.shields.io/badge/Docker-blue)

## Apache Kafka: An Overview

Apache Kafka is an open source platform widely known for its distributed event streaming capabilities. It stands out for its scalability and resilience to failures.

## Kafka Fundamentals

Unlike traditional messaging systems like RabbitMQ, Kafka operates on the following concepts:

 - **Topics:** They are responsible for storing messages.
 - **Partitions:** Optimize the message reading process.
 - **Producers:** These are systems that produce and send messages to topics.
 - **Consumers:** These are systems that consume and process messages.
 - **Clusters:** Consist of a set of machines (brokers) that run Kafka.

## Consumer Groups

Consumers are grouped into consumption groups. Each consumer within a group is responsible for reading a partition of the topic. The number of consumers must be equal to or less than the number of partitions.

## Zookeeper

Zookeeper acts as a service discovery and orchestration system for Kafka brokers. It manages errors and failure recovery, playing a critical role in Kafka's reliability.

## Kafdrop

Kafdrop is an interface that offers a detailed view of topics and messages within Kafka.

## Configuring the Producer

In the ``producer`` project, we employ Spring Web, Lombok and Kafka dependencies. Configuration properties can be found in application.yml. The ProducerConfig class manages the serialization, while the KafkaTemplate is used to send messages to the "user-topic" topic.

## Configuring the Consumer

In the ``consumer`` project, we configure the same dependencies and properties. The ``@EnableKafka`` annotation on the main class enables the use of Kafka. The ConsumerConfig class manages deserialization. The User model and service are configured to process messages using the ``@KafkaListener`` annotation.

## Getting Started

1. Clone this repository on your local machine:
- ``git clone 'https://github.com/matheuslara01/kafka-springboot.git'``

2. Navigate to the project directory:
- ``cd kafka-springboot``

3. Run the following command to build and run the project:
- ``docker-compose up -d``

4. To check running containers:
- ``docker ps``

5. The Kafdrop interface will be accessible at:
- ``localhost:19000``

## Running the example

To observe the exchange of messages between the producer and the consumer, send requests to ``localhost:8081/user``. The consumer will automatically be associated with the topic's partitions.

---

## License

This project is licensed under the [MIT License](https://opensource.org/licenses/MIT).
