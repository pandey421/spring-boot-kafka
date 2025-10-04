# spring-boot-kafka

Here is a complete README guide for setting up Kafka on Windows, including how to configure, start Zookeeper and Kafka server, create a topic, and start producer and consumer processes.

***

# Apache Kafka on Windows - README

## Prerequisites

- **Windows 10 or above** is recommended.[5]
- **Java Development Kit (JDK)** installed and JAVA_HOME set in your environment variables.[2][6]
- **7-Zip or WinRAR** to extract Kafka binaries.[2]

## Download & Setup Kafka

1. Download the latest Kafka binary from the [official Kafka website](https://kafka.apache.org/downloads).
2. Extract the downloaded archive to a preferred directory, e.g., `C:\kafka`.
3. Create a `data` folder inside the Kafka directory:
    - `C:\kafka\data\zookeeper`
    - `C:\kafka\data\kafka`

## Configure Zookeeper and Kafka

1. Open `config/zookeeper.properties` in a text editor.
    - Change the line starting with `dataDir=` to:
      ```
      dataDir=C:/kafka/data/zookeeper
      ```
    - Use forward slashes (`/`) in the path.[7][2]
2. Open `config/server.properties`.
    - Change `log.dirs=` to:
      ```
      log.dirs=C:/kafka/data/kafka
      ```
    - Again, use forward slashes.

## Start Zookeeper

Open a command prompt, change directory to Kafka root, and run:
```
.\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties
```
Leave this window open; do not close it as Zookeeper must keep running.[4][7][2]

## Start Kafka Server

Open a new command prompt, change directory to Kafka root, and run:
```
.\bin\windows\kafka-server-start.bat .\config\server.properties
```
Kafka server will now be running.[4][2]

## Create a Kafka Topic

Open another command prompt, change to `C:\kafka\bin\windows`, and run:
```
kafka-topics.bat --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic test
```
This command creates a topic named `test`.[3][1]

## Start Producer

Open another command prompt, change to `C:\kafka\bin\windows`, and run:
```
kafka-console-producer.bat --broker-list localhost:9092 --topic test
```
You can now type messages in this window.[1][3]

## Start Consumer

Open yet another command prompt, change to `C:\kafka\bin\windows`, and run:
```
kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic test --from-beginning
```
Messages sent by the producer will appear here.[3][1]

***

### Notes

- Ensure all command prompts are pointed to the correct Kafka directory when running commands.
- Always use forward slashes (`/`) in file paths within `.properties` files for Windows compatibility.[7][2]
- Producer and consumer consoles can be opened multiple times to simulate groups and multiple clients.[3]

This setup will enable basic Kafka operations for development and learning purposes on Windows. For advanced configurations, refer to the official [Apache Kafka documentation].[8][9]
