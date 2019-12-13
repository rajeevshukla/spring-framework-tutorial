package com.gl.kafka.consumer;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class Consumer {


    @KafkaListener(topics = "avengers", groupId = "group_id")
    public void consume(String message) throws IOException {
       System.out.println(message);
       writeMessageOnFileSystem(message);
    }
    
    
    private void writeMessageOnFileSystem(String data) {
    	 try {
             String userHomePath= getUsersHomeDir()+File.separator+"kafka-warehouse"+File.separator;
             
             if(new File(userHomePath).mkdirs()) {
            	 System.out.println("Directory 'kafka-warehouse' created under userhome path");
             }
             
             File f1 = new File(userHomePath+"kafka.dat");
             if(!f1.exists()) {
                f1.createNewFile();
             }

             FileWriter fileWritter = new FileWriter(f1.getName(),true);
             BufferedWriter bw = new BufferedWriter(fileWritter);
             bw.write(data);
             bw.close();
          } catch(IOException e){
             e.printStackTrace();
          }
    }
    
    public static String getUsersHomeDir() {
        String users_home = System.getProperty("user.home");
        return users_home.replace("\\", "/"); // to support all platforms.
    }
}
