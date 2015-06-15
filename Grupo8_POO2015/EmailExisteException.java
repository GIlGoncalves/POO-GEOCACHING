
import java.io.*;
public class EmailExisteException extends Exception implements Serializable
{
   public EmailExisteException() {
       super();
   }
   
   public EmailExisteException(String s) {
       super(s);
    }

}
