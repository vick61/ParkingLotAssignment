package Bike.Rapido.Paathshaala;


import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class ParkingLotTest {

    @Test
    void shouldCheckEmptySlotIsAvailable() {
        ParkingLot parkingLot = new ParkingLot(1);

        boolean isAnySlotEmpty = parkingLot.checkAnyParkingSlotEmpty();

        assertTrue(isAnySlotEmpty);
    }

    @Test
    void shouldNotAllowToParkTheCarWhenSlotIsNotEmpty() {
        ParkingLot parkingLot=new ParkingLot(1);
        parkingLot.allotParkingSpace("BR02");


        Optional<Integer>slotId=parkingLot.allotParkingSpace("BR03");


        assertFalse(slotId.isPresent());




    }

    @Test
    void shouldAllowToParkTheCarWhenSlotIsEmpty() {
        ParkingLot parkingLot=new ParkingLot(1);
        Optional<Integer> slotId=parkingLot.allotParkingSpace("BR02");


        assertTrue(slotId.isPresent());

    }


    @Test
    void shouldUnParkTheCar() {
        ParkingLot parkingLot=new ParkingLot(1);
        Optional<Integer> slotId=parkingLot.allotParkingSpace("BR02");

        parkingLot.deallotParkingSpace(slotId.get());

        boolean isSlotEmpty=parkingLot.checkGivenParkingSlotEmpty(slotId.get());

        assertTrue(isSlotEmpty);


    }

    @Test
    void shouldCheckIfParkinglotIsFullOrNot() {
        ParkingLot parkingLot=new ParkingLot(1);

        parkingLot.allotParkingSpace("BR01");


        boolean isLotFull=parkingLot.isFull();

        assertTrue(isLotFull);

    }


    @Test
    void shouldSendNotificationToLotOwnerWhenLotIsFull() {
        ParkingLot parkingLot=new ParkingLot(1);
        LotOwner lotOwner=new LotOwner();

        parkingLot.addObserverForNotifyingWhenLotIsFull(lotOwner);

        parkingLot.allotParkingSpace("bro1");


        boolean hasNotifiedToLotOwner=lotOwner.isLotFull();

        assertTrue(hasNotifiedToLotOwner);



    }



    @Test
    void shouldSendNotificationToSecurityPersonalWhenLotIsFull() {

        ParkingLot parkingLot=new ParkingLot(1);
        SecurityPersonal securityPersonal=new SecurityPersonal();

        parkingLot.addObserverForNotifyingWhenLotIsFull(securityPersonal);

        parkingLot.allotParkingSpace("bro1");

        boolean hasNotifiedToSecurityPersonal=securityPersonal.isLotFull();

        assertTrue(hasNotifiedToSecurityPersonal);


    }

    @Test
    void ShouldSendNotificationToLotOwnerWhenLotHasSpaceAgain() {

        ParkingLot parkingLot=new ParkingLot(1);
        parkingLot.allotParkingSpace("bro1");
        LotOwner lotOwner=new LotOwner();

        parkingLot.addObserverForNotifyingLotHasSpaceAgain(lotOwner);
        parkingLot.deallotParkingSpace(0);

        boolean hasNotifiedLotOwner=lotOwner.hasLotSpaceAgain();

        assertTrue(hasNotifiedLotOwner);

    }

    @Test
    void shouldParkTheCarByParkingAssistant() {
        ParkingLot []parkingLots=new ParkingLot[2];
        parkingLots[0]=new ParkingLot(2);
        parkingLots[1]=new ParkingLot(3);

        FirstFreeLotParking parkingStrategy=new FirstFreeLotParking();

        ParkingAssistant parkingAssistant=new ParkingAssistant(parkingLots);

        Optional<Integer> slotId=parkingAssistant.parkTheCarByParkingAssistant("bro1",parkingStrategy);

        assertTrue(slotId.isPresent());

    }


    @Test

    void shouldUnParkTheCarByParkingAssistant () {

            ParkingLot[] parkingLots = new ParkingLot[2];
            parkingLots[0] = new ParkingLot(2);
            parkingLots[1] = new ParkingLot(2);

            FirstFreeLotParking parkingStrategy =new FirstFreeLotParking();

            ParkingAssistant parkingAssistant = new ParkingAssistant(parkingLots);

            Optional<Integer> parkingSlotId = parkingAssistant.parkTheCarByParkingAssistant("bro1",parkingStrategy);

            boolean hasCarUnParked=parkingAssistant.unParkTheCarByParkingAssistant(0, parkingSlotId.get());

            assertTrue(hasCarUnParked);

        }


}


