package Bike.Rapido.Paathshaala;

import java.util.Optional;

public class ParkingAssistant {
    ParkingLot[] parkingLots;



    public ParkingAssistant(ParkingLot[] parkingLot){

        this.parkingLots =parkingLot;
    }

    public Optional<Integer> parkTheCarByParkingAssistant(String carNumber, ParkingStrategy strategy){
        ParkingLot emptyLot=strategy.getParkingLot(parkingLots);
        if(emptyLot!=null) {
            return emptyLot.allotParkingSpace(carNumber);
        }
        return Optional.empty();


    }

    public boolean unParkTheCarByParkingAssistant(int parkingLotId, int parkingSpaceId){
        return parkingLots[parkingLotId].deallotParkingSpace(parkingSpaceId);


    }






}
