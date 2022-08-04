package Bike.Rapido.Paathshaala;

public class ParkingAssistant {
    ParkingLot[] parkingLot;
    int parkingLotSize;
    public ParkingAssistant(ParkingLot[] parkingLot,int parkingLotSize){
        this.parkingLotSize=parkingLotSize;
        this.parkingLot =parkingLot;
    }
    public int getEmptyParkingLot(){
        for(int countParkingLot=0;countParkingLot<parkingLotSize;countParkingLot++){
            if(parkingLot[countParkingLot].checkAnyParkingSlotEmpty())
                return countParkingLot;
        }
        return -1;
    }
    public int parkTheCar(String carNumber){
        int emptyLot=getEmptyParkingLot();
        return  parkingLot[emptyLot].allotParkingSpace(carNumber);


    }
    public boolean unparkTheCar(int parkingLotId,int parkingSpaceId){
        return parkingLot[parkingLotId].deallotParkingSpace(parkingSpaceId);


    }
    public int parkTheCarEvenlyInParkingLots(String carNumber){
        int minIndex=-1;
        double minValue=2;
        for(int countParkingLot=0;countParkingLot<parkingLotSize;countParkingLot++){
            if(parkingLot[countParkingLot].checkAnyParkingSlotEmpty())
            {
                double calculatePercentage=((double)parkingLot[countParkingLot].getCountOccupiedSlot())/parkingLot[countParkingLot].getParkingLotSize();

                if(calculatePercentage<minValue)
                {
                    minIndex=countParkingLot;
                    minValue=calculatePercentage;
                }
            }
        }
        if(minIndex!=-1)
        {

           return parkingLot[minIndex].allotParkingSpace(carNumber);
        }
        return -1;
    }


}
