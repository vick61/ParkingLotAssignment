package Bike.Rapido.Paathshaala;

public class EvenlyDistributionOfParkingVehicle implements ParkingStrategy {

    public ParkingLot getParkingLot(ParkingLot[] parkingLots) {
        int minIndex=-1;
        double maxValue=2;
        for(int countParkingLot=0;countParkingLot<parkingLots.length;countParkingLot++){
            if(parkingLots[countParkingLot].checkAnyParkingSlotEmpty())
            {
                double calculateRatio=((double)parkingLots[countParkingLot].getCountOccupiedSlot())/parkingLots[countParkingLot].getParkingLotSize();

                if(calculateRatio<maxValue)
                {
                    minIndex=countParkingLot;
                    maxValue=calculateRatio;
                }
            }
        }
        if(minIndex!=-1)
        {

            return parkingLots[minIndex];
        }
        return null;
    }
    }


