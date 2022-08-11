package Bike.Rapido.Paathshaala;


import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;


public class EvenlyDistributionTest {

    @Test
    void shouldParkTheCarInEvenlyDistributionLots() {
        ParkingLot[] parkingLots=new ParkingLot[2];
        parkingLots[0]=new ParkingLot(2);
        parkingLots[1]=new ParkingLot(2);
        ParkingAssistant parkingAssistant=new ParkingAssistant(parkingLots);

        EvenlyDistributionOfCarsInParkingLots parkingStrategy=new EvenlyDistributionOfCarsInParkingLots();


        parkingAssistant.parkTheCarByParkingAssistant("Br01",parkingStrategy);

        Optional<Integer> parkingLot1SlotId=parkingAssistant.parkTheCarByParkingAssistant("Br02",parkingStrategy);

        boolean hasParkedInSecondParkingLot=parkingLots[1].checkSlotId(parkingLot1SlotId.get());


        assertTrue(hasParkedInSecondParkingLot);

    }


}
