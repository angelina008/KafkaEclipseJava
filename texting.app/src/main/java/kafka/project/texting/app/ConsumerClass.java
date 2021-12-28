package kafka.project.texting.app;

import java.util.Arrays;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

public class ConsumerClass {
	Properties prop = new Properties();
	public void init() throws Exception{
		prop.setProperty("bootstrap.servers", "kafka:9092");
		prop.setProperty("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
		prop.setProperty("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
		prop.put("group.id", "gr1-consumer");
        prop.put("enable.auto.commit", "true");
        prop.put("auto.commit.interval.ms", "1000");
        prop.put("auto.offset.reset", "earliest");
        prop.put("session.timeout.ms", "30000");
        
		KafkaConsumer consumer = new KafkaConsumer(prop);
		consumer.subscribe(Arrays.asList("student", "professor"));
		
		while(true) {
			ConsumerRecords<String,String> records = consumer.poll(1000);
			for (ConsumerRecord record : records) {
                System.out.printf("This is recieved from topic: %s , the message is\"%s\"\n",
								  record.topic(), record.value());
			}
		}
		
	}
	public static void main(String [] args) throws Exception{
		ConsumerClass consumer = new ConsumerClass();
		consumer.init();
	}
    
}
