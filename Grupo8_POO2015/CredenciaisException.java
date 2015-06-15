
import java.io.*;
public class CredenciaisException extends Exception implements Serializable
{
   public CredenciaisException() {
       super();
   }
   
   public CredenciaisException(String s) {
       super(s);
    }

}
