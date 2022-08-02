package Bike.Rapido.Paathshaala;

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

   private List <ParkingLotObserver> registeredObserversNotifyWhenLotIsFull =new ArrayList<>();
    private List <ParkingLotObserver>registeredObserversForNotifyingLotHasSpaceAgain =new ArrayList<>();
   public void addObserver(ParkingLotObserver parkingLotObserver)
   {
       this.registeredObserversNotifyWhenLotIsFull.add(parkingLotObserver);
   }
   public void removeObserver(ParkingLotObserver parkingLotObserver)
   {
       this.registeredObserversNotifyWhenLotIsFull.remove(parkingLotObserver);
   }

    public void addObserverForNotifyingLotHasSpaceAgain(ParkingLotObserver parkingLotObserver)
    {
        this.registeredObserversForNotifyingLotHasSpaceAgain.add(parkingLotObserver);
    }

   public void notifyToAllObservers() {
       for(ParkingLotObserver parkingLotObserver:this.registeredObserversNotifyWhenLotIsFull)
       {
           parkingLotObserver.notifyObservers();
       }


   }
   public void notifyObserverWhenLotHasSpaceAgain(){
       for(ParkingLotObserver parkingLotObserver:this.registeredObserversForNotifyingLotHasSpaceAgain)
       {
           parkingLotObserver.notifyObserverWhenLotHasSpaceAgain();
       }

   }

   public  int allotParking( String carNumber) {


       for (int count = 0; count < 10; count++)
       {
           if (parkingSpace[count].getIsEmpty())
           {
               if (parkingSpace[count].generateTicket(carNumber))
               {   if(isFull())
               {
                   notifyToAllObservers();
               }
                   return count;
               }


           }

       }

       return -1;
   }

   public boolean deallotParking(int id){
         if(!checkAnyParkingSlotEmpty()){
             notifyObserverWhenLotHasSpaceAgain();
         }
         return  parkingSpace[id].emptyParkingSpace();
   }
   public boolean isFull(){
       for (int count = 0; count < 10; count++)
       {
           if(parkingSpace[count].getIsEmpty())
               return false;
       }

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





