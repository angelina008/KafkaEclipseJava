package kafka.project.texting.app;

import java.util.Date;
import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.ByteArraySerializer;
import org.apache.kafka.common.serialization.StringSerializer;

public class ProducerClass {
	
	Properties prop = new Properties();
	
	public void init() throws Exception{
		prop.setProperty("bootstrap.servers", "kafka:9092");
		prop.setProperty("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		prop.setProperty("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
	    KafkaProducer producer = new KafkaProducer(prop);

		for(int i=1;i<=3;i++){
		  System.out.println(" Student with index " + i + " is in 234");
		  String payload = (" Student with index " + i + " is in 234");
	      ProducerRecord record = new ProducerRecord("student","name", payload);
	      producer.send(record);
	      Thread.sleep(1000);
		}
		for(int i=1;i<=3;i++){
			  System.out.println(" Professor with id " + i*123 + " is in 512");
			  String payload = (" Professor with id " + i*123 + " is in 512");
		      ProducerRecord record = new ProducerRecord("professor","name", payload);
		      producer.send(record);
		      Thread.sleep(1000);
			}

		producer.close();

	}
	public static void main(String [] args) throws Exception {
		ProducerClass producer = new ProducerClass();
		producer.init();
		
		
	}

}
