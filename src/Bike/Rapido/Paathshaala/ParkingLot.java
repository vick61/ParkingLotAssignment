package Bike.Rapido.Paathshaala;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
public class ParkingLot {
    ParkingSpace[] parkingSpace=new ParkingSpace[10];
    public ParkingLot() {
        for (int count = 0; count < 10; count++)
        {
            parkingSpace[count] = new ParkingSpace(count);
        }
    }

   private List <ParkingLotObserver>lotObserver =new ArrayList<>();
   public void addObserver(ParkingLotObserver variableOfParkingLotObserver)
   {
       this.lotObserver.add(variableOfParkingLotObserver);
   }
   public void removeObserver(ParkingLotObserver variableOfParkingLotObserver)
   {
       this.lotObserver.remove(variableOfParkingLotObserver);
   }

   public boolean notifyToAllObserverToTakeOutTheFullSign() {
       for(ParkingLotObserver variableOfParkingLotObserver:this.lotObserver)
       {
           variableOfParkingLotObserver.notifyObserversToTakeOutTheFullSign();
       }
       return true;

   }
   public boolean notifyToAllObserverToTakeInTheFullSign(){
       for(ParkingLotObserver variableOfParkingLotObserver:this.lotObserver)
       {
           variableOfParkingLotObserver.notifyObserversToTakeInTheFullSign();
       }
       return true;
   }

   public  int allotParking( String carNumber) {


       for (int count = 0; count < 10; count++)
       {
           if (parkingSpace[count].getIsEmpty())
           {
               if (parkingSpace[count].generateTicket(carNumber))
               {
                   return count;
               }


           }

       }

       return -1;
   }

   public boolean deallotParking(int id){
         return  parkingSpace[id].emptyParkingSpace();
   }
   public boolean isFull(){
       for (int count = 0; count < 10; count++)
       {
           if(parkingSpace[count].getIsEmpty())
               return false;
       }
       notifyToAllObserverToTakeOutTheFullSign();
       return true;
   }
   public boolean checkGivenParkingSlotEmpty(int id){
            return parkingSpace[id].getIsEmpty();
   }

    public boolean checkAnyParkingSlotEmpty(){

        for (int count = 0; count < 10; count++)
        {
            if(parkingSpace[count].getIsEmpty())
                return true;
        }
        notifyToAllObserverToTakeInTheFullSign();
        return false;


    }

}

 class ParkingSpace{
    private  int id;
    private  boolean isEmpty;

    private  String carNumber;
    ParkingSpace(int id)
    {
        this.id=id;
        this.isEmpty=true;
        this.carNumber=null;

    }
    public boolean getIsEmpty(){
        return isEmpty;
    }
    public boolean  generateTicket(String carNumber){
        if(!isEmpty)
        {
            return false;
        }
        else
        {
            this.carNumber=carNumber;
            isEmpty=false;
        }
        return true;
    }
    public boolean emptyParkingSpace(){
        isEmpty=true;
        carNumber=null;
        return true;
    }
}





