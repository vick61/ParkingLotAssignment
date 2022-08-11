package Bike.Rapido.Paathshaala;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class FirstFreeLotStrategyTest {

    @Test
    void shouldParkTheCarInFirstFreeParkingLot() {


        ParkingLot[] parkingLots=new ParkingLot[2];
        parkingLots[0]=new ParkingLot(2);
        parkingLots[1]=new ParkingLot(2);
        ParkingAssistant parkingAssistant=new ParkingAssistant(parkingLots);

        FirstFreeLotParking parkingStrategy =new FirstFreeLotParking();



        parkingAssistant.parkTheCarByParkingAssistant("Br01",parkingStrategy);

        Optional<Integer> parkingLot1SlotId=parkingAssistant.parkTheCarByParkingAssistant("Br02",parkingStrategy);

        boolean hasParkedInFirstParkingLot=parkingLots[0].checkSlotId(parkingLot1SlotId.get());


        assertTrue(hasParkedInFirstParkingLot);


    }


}
