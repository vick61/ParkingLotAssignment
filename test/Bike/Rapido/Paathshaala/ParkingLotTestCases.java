package Bike.Rapido.Paathshaala;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ParkingLotTestCases {
    @Test
    void checkParkinglotIsFull() {
        ParkingLot parkingLot=new ParkingLot();
        for(int count=0;count<10;count++)
        {
            parkingLot.allotParking("bro1");
        }

        boolean isLotFull=parkingLot.isFull();

        assertTrue(isLotFull);

    }

    @Test
    void parkAndUnParkTheCar() {
        ParkingLot parkingLot=new ParkingLot();
        int slotId=parkingLot.allotParking("br02");

        boolean isSlotEmpty=parkingLot.checkGivenParkingSlotEmpty(slotId);

        assertFalse(isSlotEmpty);


         isSlotEmpty =parkingLot.deallotParking(slotId);

         assertTrue(isSlotEmpty);


    }



    @Test
    void checkEmptySlotIsAvailable() {
        ParkingLot parkingLot=new ParkingLot();
        for(int count=0;count<5;count++)
        {
            parkingLot.allotParking("bro1");
        }

        boolean anyEmptySlot= parkingLot.checkAnyParkingSlotEmpty();

        assertTrue(anyEmptySlot);



        for(int count=0;count<5;count++)
        {
            parkingLot.allotParking("bro1");
        }

        boolean isSlotEmpty=parkingLot.checkAnyParkingSlotEmpty();

        assertFalse(isSlotEmpty);



    }

    @Test
    void sendNotificationToLotOwnerAndSecurityPersonalWhenLotIsFull() {
        ParkingLot observable=new ParkingLot();


        LotOwner observer1BehavesAsLotOwner=new LotOwner();
        SecurityPersonal observer2BehavesAsSecurityPersonal=new SecurityPersonal();

        observable.addObserver(observer1BehavesAsLotOwner);
        observable.addObserver(observer2BehavesAsSecurityPersonal);


        for(int count=0;count<10;count++)
        {
            observable.allotParking("bro1");
        }


        boolean notifiedToLotOwner=observer1BehavesAsLotOwner.isLotFull();

        assertTrue(notifiedToLotOwner);




        boolean notifiedToSecurityPersonal=observer2BehavesAsSecurityPersonal.isLotFull();

        assertTrue(notifiedToSecurityPersonal);


    }

    @Test
    void sendNotificationToLotOwnerWhenLotHasSpaceAgain() {
        ParkingLot observable=new ParkingLot();
        for(int count=0;count<10;count++)
        {
            observable.allotParking("bro1");
        }

        LotOwner observer1BehavesAsLotOwner=new LotOwner();

        observable.addObserverForNotifyingLotHasSpaceAgain(observer1BehavesAsLotOwner);

        observable.deallotParking(9);




        boolean notifiedLotOwner=observer1BehavesAsLotOwner.hasLotSpaceAgain();

         assertTrue(notifiedLotOwner);

        //assertEquals(true,notifiedLotOwner);





    }
}
