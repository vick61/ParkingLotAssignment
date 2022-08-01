package Bike.Rapido.Paathshaala;

class ParkingTicket{
    //String driverName;
    String carNumber;
    ParkingTicket(String carNumber){
        //this.driverName=driverName;
        this.carNumber=carNumber;
    }
}




public class ParkingLot {
    ParkingSpace[] ps=new ParkingSpace[10];
    public ParkingLot() {
        for (int count = 0; count < 10; count++) {
            ps[count] = new ParkingSpace(count);
        }
    }
   public  int allotParking( String carNumber) {


       for (int count = 0; count < 10; count++) {
           if (ps[count].getIsEmpty()) {
               if (ps[count].generateTicket(carNumber)) {
                   return count;
               }


           }

       }
       System.out.println("Parking Slots is Full");
       return -1;
   }

   public boolean deallotParking(int id){
         return  ps[id].emptyParkingSpace();


   }
   public boolean isFull(){
       for (int count = 0; count < 10; count++) {
           if(ps[count].getIsEmpty())
               return false;
       }
       return true;
   }
   public boolean checkGivenParkingSlotEmpty(int id){
            return ps[id].getIsEmpty();

   }

    public boolean checkAnyParkingSlotEmpty(){
         return !isFull();
    }



}

 class ParkingSpace{
    private  int id;
    private  boolean isEmpty;

    private  ParkingTicket ticket;
    ParkingSpace(int id)
    {
        this.id=id;
        this.isEmpty=true;

    }
    public boolean getIsEmpty(){
        return isEmpty;
    }
    public boolean  generateTicket(String carNumber){
        if(!isEmpty){
            return false;
        }
        else
        {
            ticket=new ParkingTicket(carNumber);
            isEmpty=false;
        }
        return true;
    }
    public boolean emptyParkingSpace(){
        isEmpty=true;
        ticket=null;
        return true;
    }




}