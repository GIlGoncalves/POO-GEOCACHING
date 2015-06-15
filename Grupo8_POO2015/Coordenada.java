

import java.util.*;
import java.io.*;
public class Coordenada implements Serializable
{
    private int longitude;
    private char coordLongitude,coordLatitude;
    private int latitude;
    private double localLatitude;
    private double localLongitude;
    
    public Coordenada (){
    this.longitude=-1;
    this.localLongitude=-1;
    
    this.latitude=-1;
    this.localLatitude=-1;
    }
    
    public Coordenada (int lati, char coordLati, double localLat, int longi,char coordLong,double localLongi) {
    this.latitude=lati;
    this.coordLatitude=coordLati;
    this.localLatitude=localLat;
    
    this.longitude=longi;
    this.coordLongitude=coordLong;
    this.localLongitude=localLongi;
    }
    
    public Coordenada(Coordenada u){
    this.longitude=u.getLongitude();
    this.coordLongitude=u.getCoordLongitude();
    this.localLongitude=u.getLocalLongitude();
    
    this.latitude=u.getLatitude();
    this.coordLatitude=u.getCoordLatitude();
    this.localLatitude=u.getLocalLatitude();
   
    
    }
    
    public double getLocalLatitude(){
    return this.localLatitude;
    }
    
    public double getLocalLongitude(){
    return this.localLongitude;
    
    }
    
    public int getLongitude(){
    return this.longitude;
    }
    
    public char getCoordLongitude(){
    return this.coordLongitude;
    }
    
    public int getLatitude(){
    return this.latitude;
    }
    
    public char getCoordLatitude(){
    return this.coordLatitude;
    }
    
    public void setLocalLatitude(double localL){
    this.localLatitude=localL;
    }
    
    public void setLocalLongitude(double localLon) {
    this.localLongitude=localLon;
    
    }
    
    public void setLongitude(int longi) {
    this.longitude=longi;
    }
    
    public void setCoordLatitude(char coordLat){
    this.coordLatitude=coordLat;
    }
    
    public void setLatitude(int latit){
    this.latitude=latit;
    }
    
     public void setCoordLongitude(char coordLong){
    this.coordLongitude=coordLong;
    }
    
    
    
    
    
    public boolean equals(Object o) {
    if(this==o) {return true;}
     else{
     if(((o == null) || (this.getClass() != o.getClass()))) {return false;}
     else{
     Coordenada u=(Coordenada) o;
      return (this.longitude== u.getLongitude() && this.latitude==u.getLatitude() &&  this.coordLatitude==u.getCoordLatitude() && this.coordLongitude==u.getCoordLongitude() &&
           this.localLatitude== u.getLocalLatitude() && this.localLongitude==u.getLocalLongitude());
    
    }
    
    }
    }
    public String toString(){
      StringBuilder s = new StringBuilder();
       s.append("Grau da Latitude\n");
       s.append(this.latitude+"\n");
       s.append ("Coordenada  da Latitude \n");
       s.append (this.coordLatitude +"\n");
       s.append ("Minutos da Latitude\n");
       s.append (this.localLatitude +"\n");
       
      s.append("Grau Longitude\n");
      s.append(this.longitude +"\n");
      s.append ("Coordenada da Longitude\n");
      s.append (this.coordLongitude +"\n");
      s.append ("Minutos da Longitude\n");
      s.append (this.localLongitude+ "\n");
      
    
      return s.toString();
    
    
    }
    
    public Coordenada clone(){
    return new Coordenada(this);
    }
}
