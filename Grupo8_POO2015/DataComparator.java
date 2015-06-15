

import java.io.Serializable;
import java.util.Comparator;
public class DataComparator implements Serializable,Comparator<Actividade>
{
   public int compare(Actividade a1,Actividade a2) {
    long d1 = a1.getData().getTimeInMillis();
    long d2 = a2.getData().getTimeInMillis();
      
    if(d2 > d1)
                return 1;
        else if(d1 > d2)
                return -1;
        else
                return 0;
    
           
            }
            
}
