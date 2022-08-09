package Bike.Rapido.Paathshaala;

public class FirstFreeLotParking implements ParkingStrategy{
    public  ParkingLot getParkingLot(ParkingLot[] parkingLots) {

        for(int countParkingLot=0;countParkingLot<parkingLots.length;countParkingLot++){
            if(parkingLots[countParkingLot].checkAnyParkingSlotEmpty())
            {
                return parkingLots[countParkingLot];
            }
        }

        return null;
    }
}

