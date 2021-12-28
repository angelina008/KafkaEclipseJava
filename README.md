# KafkaEclipseJava
###### For this code to work we need docker and docker compose, the we activate the kafka with: 
##### docker-compose -f ./kafka.yml up -d 
###### To check if you created the containters succesfully use: 
##### docker ps
###### For creating the topics use:
##### docker exec -it nameOfKafkaContainer /bin/sh
##### cd usr (important files are in usr file)
##### ./bin/kafka-topics --create --zookeeper zoo:2181 --replication-factor 1 --partitions 1 --topic topicName
###### For checking the list of topics:
##### ./bin/kafka-topics --list --zookeeper zoo:2181 
###### If you want to send and recieve messages form cmd then: (open them in different windows, and commands come after the "cd usr")
#### ./bin/kafka-console-producer --broker-list localhost:9092 --topic topicName
#### ./bin/kafka-console-consumer --bootstrap-server localhost:9092 --topic topicName
