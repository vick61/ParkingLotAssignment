package Bike.Rapido.Paathshaala;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ParkingLotTest {

    @Test
    void shouldCheckEmptySlotIsAvailable() {
        ParkingLot parkingLot = new ParkingLot(1);

        boolean isSlotEmpty = parkingLot.checkAnyParkingSlotEmpty();

        assertTrue(isSlotEmpty);
    }



    @Test
    void parkTheCar() {
        ParkingLot parkingLot=new ParkingLot(1);
        int slotId=parkingLot.allotParkingSpace("BR02");

        boolean isSlotEmpty=parkingLot.checkGivenParkingSlotEmpty(slotId);

        assertFalse(isSlotEmpty);

    }

    @Test
    void unparkTheCar() {
        ParkingLot parkingLot=new ParkingLot(1);
        int slotId=parkingLot.allotParkingSpace("BR02");

        parkingLot.deallotParkingSpace(slotId);

        assertTrue(parkingLot.checkGivenParkingSlotEmpty(slotId));


    }

    @Test
    void shouldCheckParkinglotIsFull() {
        ParkingLot parkingLot=new ParkingLot(1);

        parkingLot.allotParkingSpace("BR01");


        boolean isLotFull=parkingLot.isFull();

        assertTrue(isLotFull);

    }


    @Test
    void sendNotificationToLotOwnerWhenLotIsFull() {
        ParkingLot observable=new ParkingLot(1);
        LotOwner observer1BehavesAsLotOwner=new LotOwner();

        observable.addObserverForNotifyingWhenLotIsFull(observer1BehavesAsLotOwner);

        observable.allotParkingSpace("bro1");


        boolean notifiedToLotOwner=observer1BehavesAsLotOwner.isLotFull();

        assertTrue(notifiedToLotOwner);



    }

    @Test
    void sendNotificationToSecurityPersonalWhenLotIsFull() {

        ParkingLot observable=new ParkingLot(1);
        SecurityPersonal observer2BehavesAsSecurityPersonal=new SecurityPersonal();

        observable.addObserverForNotifyingWhenLotIsFull(observer2BehavesAsSecurityPersonal);

        observable.allotParkingSpace("bro1");

        boolean notifiedToSecurityPersonal=observer2BehavesAsSecurityPersonal.isLotFull();

        assertTrue(notifiedToSecurityPersonal);


    }

    @Test
    void sendNotificationToLotOwnerWhenLotHasSpaceAgain() {

        ParkingLot observable=new ParkingLot(1);
        observable.allotParkingSpace("bro1");
        LotOwner observer1BehavesAsLotOwner=new LotOwner();

        observable.addObserverForNotifyingLotHasSpaceAgain(observer1BehavesAsLotOwner);
        observable.deallotParkingSpace(0);

        boolean notifiedLotOwner=observer1BehavesAsLotOwner.hasLotSpaceAgain();

        assertTrue(notifiedLotOwner);

    }

    @Test
    void parkTheCarByParkingAssistant() {
        ParkingLot []parkingLots=new ParkingLot[2];
        parkingLots[0]=new ParkingLot(2);
        parkingLots[1]=new ParkingLot(2);

        ParkingAssistant parkingAssistant=new ParkingAssistant(parkingLots,2);

        assertNotEquals(-1,parkingAssistant.parkTheCar("bro1"));

    }


    @Test

    void unparkTheCarByParkingAssistant () {

            ParkingLot[] parkingLots = new ParkingLot[2];
            parkingLots[0] = new ParkingLot(2);
            parkingLots[1] = new ParkingLot(2);
            ParkingAssistant parkingAssistant = new ParkingAssistant(parkingLots, 2);
            int parkingSpaceId = parkingAssistant.parkTheCar("bro1");

            parkingAssistant.unparkTheCar(0, parkingSpaceId);

            assertTrue(parkingLots[0].checkGivenParkingSlotEmpty(parkingSpaceId));
        }

    @Test
    void ParkEvenlyInParkingLots() {

        ParkingLot[] parkingLots=new ParkingLot[2];
        parkingLots[0]=new ParkingLot(2);
        parkingLots[1]=new ParkingLot(2);
        ParkingAssistant parkingAssistant=new ParkingAssistant(parkingLots,2);

        int parkingSpaceId1=parkingAssistant.parkTheCarEvenlyInParkingLots("Br01");
        int parkingSpaceId2=parkingAssistant.parkTheCarEvenlyInParkingLots("Br02");


        assertFalse(parkingLots[0].checkGivenParkingSlotEmpty(parkingSpaceId1));
        assertFalse(parkingLots[1].checkGivenParkingSlotEmpty(parkingSpaceId2));

    }
}


