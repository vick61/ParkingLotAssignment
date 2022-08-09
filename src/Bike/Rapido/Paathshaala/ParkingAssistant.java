package Bike.Rapido.Paathshaala;

public class ParkingAssistant {
    ParkingLot[] parkingLot;
    int parkingLotSize;

    ParkingStrategy parkingStrategy;
    public ParkingAssistant(ParkingLot[] parkingLot,int parkingLotSize){
        this.parkingLotSize=parkingLotSize;
        this.parkingLot =parkingLot;
    }

    public int parkTheCarByParkingAssistant(String carNumber,ParkingStrategy strategy){
        ParkingLot emptyLot=strategy.getParkingLot(parkingLot);
        if(emptyLot!=null) {
            return emptyLot.allotParkingSpace(carNumber);
        }
        return -1;


    }

    public boolean unparkTheCarByParkingAssistant(int parkingLotId, int parkingSpaceId){
        return parkingLot[parkingLotId].deallotParkingSpace(parkingSpaceId);


    }

    public ParkingStrategy getParkingStrategy() {
        return parkingStrategy;
    }





}
