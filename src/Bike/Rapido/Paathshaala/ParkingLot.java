package Bike.Rapido.Paathshaala;

import java.util.ArrayList;
import java.util.List;
public class ParkingLot {
    ParkingSpace[] parkingSpace;
    int parkingLotSize;
    int countOccupiedSlot;
    public ParkingLot(int parkingLotSize) {
        this.parkingLotSize=parkingLotSize;
        parkingSpace=new ParkingSpace[parkingLotSize];

        for (int count = 0; count <parkingLotSize; count++)
        {
            parkingSpace[count] = new ParkingSpace(count);
        }
    }

    public int getCountOccupiedSlot() {
        return countOccupiedSlot;
    }

    public int getParkingLotSize() {
        return parkingLotSize;
    }

    private List <ParkingLotObserver> registeredObserversNotifyWhenLotIsFull =new ArrayList<>();
    private List <ParkingLotObserver>registeredObserversForNotifyingLotHasSpaceAgain =new ArrayList<>();
   public void addObserverForNotifyingWhenLotIsFull(ParkingLotObserver parkingLotObserver)
   {
       this.registeredObserversNotifyWhenLotIsFull.add(parkingLotObserver);
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

   public  int allotParkingSpace(String carNumber) {


       for (int countParkingSlot = 0; countParkingSlot <parkingLotSize; countParkingSlot++)
       {
           if (parkingSpace[countParkingSlot].getIsEmpty())
           {
               if (parkingSpace[countParkingSlot].generateTicket(carNumber))
               {    countOccupiedSlot +=1;
                   if(isFull())
                  {
                   notifyToAllObservers();
                  }
                   return countParkingSlot;
               }


           }

       }

       return -1;
   }

   public boolean deallotParkingSpace(int id){
         if(!checkAnyParkingSlotEmpty())
         {
             notifyObserverWhenLotHasSpaceAgain();
         }
         if(!checkGivenParkingSlotEmpty(id)){
             countOccupiedSlot -=1;
         }
         return  parkingSpace[id].emptyParkingSpace();
   }
   public boolean isFull(){

       return countOccupiedSlot ==parkingLotSize;
   }
   public boolean checkGivenParkingSlotEmpty(int id){
            return parkingSpace[id].getIsEmpty();
   }

    public boolean checkAnyParkingSlotEmpty(){

        for (int countParkingSlot = 0; countParkingSlot < parkingLotSize; countParkingSlot++)
        {
            if(parkingSpace[countParkingSlot].getIsEmpty())
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





