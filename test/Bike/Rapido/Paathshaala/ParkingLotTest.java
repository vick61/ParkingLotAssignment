package Bike.Rapido.Paathshaala;

import org.junit.jupiter.api.BeforeEach;
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
    void shouldParkTheCar() {
        ParkingLot parkingLot=new ParkingLot(1);
        int slotId=parkingLot.allotParkingSpace("BR02");

        boolean isSlotEmpty=parkingLot.checkGivenParkingSlotEmpty(slotId);

        assertFalse(isSlotEmpty);

    }

    @Test
    void shouldUnparkTheCar() {
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
    void shouldSendNotificationToLotOwnerWhenLotIsFull() {
        ParkingLot observable=new ParkingLot(1);
        LotOwner observer1BehavesAsLotOwner=new LotOwner();

        observable.addObserverForNotifyingWhenLotIsFull(observer1BehavesAsLotOwner);

        observable.allotParkingSpace("bro1");


        boolean notifiedToLotOwner=observer1BehavesAsLotOwner.isLotFull();

        assertTrue(notifiedToLotOwner);



    }



    @Test
    void shouldSendNotificationToSecurityPersonalWhenLotIsFull() {

        ParkingLot observable=new ParkingLot(1);
        SecurityPersonal observer2BehavesAsSecurityPersonal=new SecurityPersonal();

        observable.addObserverForNotifyingWhenLotIsFull(observer2BehavesAsSecurityPersonal);

        observable.allotParkingSpace("bro1");

        boolean notifiedToSecurityPersonal=observer2BehavesAsSecurityPersonal.isLotFull();

        assertTrue(notifiedToSecurityPersonal);


    }

    @Test
    void ShoulsSendNotificationToLotOwnerWhenLotHasSpaceAgain() {

        ParkingLot observable=new ParkingLot(1);
        observable.allotParkingSpace("bro1");
        LotOwner observer1BehavesAsLotOwner=new LotOwner();

        observable.addObserverForNotifyingLotHasSpaceAgain(observer1BehavesAsLotOwner);
        observable.deallotParkingSpace(0);

        boolean notifiedLotOwner=observer1BehavesAsLotOwner.hasLotSpaceAgain();

        assertTrue(notifiedLotOwner);

    }

    @Test
    void shouldParkTheCarByParkingAssistant() {
        ParkingLot []parkingLots=new ParkingLot[2];
        parkingLots[0]=new ParkingLot(2);
        parkingLots[1]=new ParkingLot(2);
        FirstFreeLotParking strategy=new FirstFreeLotParking();

        ParkingAssistant parkingAssistant=new ParkingAssistant(parkingLots,2);

        assertNotEquals(-1,parkingAssistant.parkTheCarByParkingAssistant("bro1",strategy));

    }


    @Test

    void shouldUnparkTheCarByParkingAssistant () {

            ParkingLot[] parkingLots = new ParkingLot[2];
            parkingLots[0] = new ParkingLot(2);
            parkingLots[1] = new ParkingLot(2);
            FirstFreeLotParking strategy =new FirstFreeLotParking();
            ParkingAssistant parkingAssistant = new ParkingAssistant(parkingLots, 2);
            int parkingSlotId = parkingAssistant.parkTheCarByParkingAssistant("bro1",strategy);

            parkingAssistant.unparkTheCarByParkingAssistant(0, parkingSlotId);

            assertTrue(parkingLots[0].checkGivenParkingSlotEmpty(parkingSlotId));
        }

    @Test
    void shouldParkEvenlyInParkingLots() {
        EvenlyDistributionOfParkingVehicle strategy=new EvenlyDistributionOfParkingVehicle();
        ParkingLot[] parkingLots=new ParkingLot[2];
        parkingLots[0]=new ParkingLot(2);
        parkingLots[1]=new ParkingLot(2);
        ParkingAssistant parkingAssistant=new ParkingAssistant(parkingLots,2);

        int parkingLotId1=parkingAssistant.parkTheCarByParkingAssistant("Br01",strategy);
        int parkingLotId2=parkingAssistant.parkTheCarByParkingAssistant("Br02",strategy);


        assertFalse(parkingLots[0].checkGivenParkingSlotEmpty(parkingLotId1));
        assertFalse(parkingLots[1].checkGivenParkingSlotEmpty(parkingLotId2));

    }

    @Test
    void shouldParkFisrtFreeInParkingLots() {

            EvenlyDistributionOfParkingVehicle strategy=new EvenlyDistributionOfParkingVehicle();

            FirstFreeLotParking strategy1 =new FirstFreeLotParking();
            ParkingLot[] parkingLots=new ParkingLot[2];
            parkingLots[0]=new ParkingLot(2);
            parkingLots[1]=new ParkingLot(2);
            ParkingAssistant parkingAssistant=new ParkingAssistant(parkingLots,2);

            int parkingLotId1=parkingAssistant.parkTheCarByParkingAssistant("Br01",strategy1);
            int parkingLotId2=parkingAssistant.parkTheCarByParkingAssistant("Br02",strategy1);


            assertFalse(parkingLots[0].checkGivenParkingSlotEmpty(parkingLotId1));
            assertFalse(parkingLots[0].checkGivenParkingSlotEmpty(parkingLotId2));


    }
}


