package Bike.Rapido.Paathshaala;

public class EvenlyDistributionOfCarsInParkingLots implements ParkingStrategy {

    public ParkingLot getParkingLot(ParkingLot[] parkingLots) {
        int minIndex=-1;
        double minValue=2;
        for(int countParkingLot=0;countParkingLot<parkingLots.length;countParkingLot++){
            if(parkingLots[countParkingLot].checkAnyParkingSlotEmpty())
            {
                double calculateRatio=((double)parkingLots[countParkingLot].getCountOccupiedSlot())/parkingLots[countParkingLot].getParkingLotSize();

                if(calculateRatio<minValue)
                {
                    minIndex=countParkingLot;
                    minValue=calculateRatio;
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


