package org.multidispenser.multifueldispenser.data.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Admin {
   private String username;
   private String password;
   private static Admin instance;

   private Admin(){
      username="";
      password="";
   }
   public static Admin getInstance(){
      if(instance ==null){
         instance = new Admin();
      }
      return instance;
   }
}
