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

        assertEquals(true,isLotFull);
    }

    @Test
    void parkAndUnParkTheCar() {
        ParkingLot parkingLot=new ParkingLot();
        int slotId=parkingLot.allotParking("br02");

        boolean slotOccupied=parkingLot.checkGivenParkingSlotEmpty(slotId);

        assertEquals(false,slotOccupied);

        boolean emptySlot =parkingLot.deallotParking(slotId);

        assertEquals(true,emptySlot);

    }



    @Test
    void checkEmptySlotIsAvailable() {
        ParkingLot parkingLot=new ParkingLot();
        for(int count=0;count<5;count++)
        {
            parkingLot.allotParking("bro1");
        }

        boolean anyEmptySlot= parkingLot.checkAnyParkingSlotEmpty();

        assertEquals(true,anyEmptySlot);


        for(int count=0;count<5;count++)
        {
            parkingLot.allotParking("bro1");
        }

        boolean isSlotFull=parkingLot.checkAnyParkingSlotEmpty();


        assertEquals(false,isSlotFull);

    }

    @Test
    void sendNotificationAboutLotIsFull() {
        ParkingLot observable=new ParkingLot();
        LotOwner observer1BehavesAsLotOwner=new LotOwner();
        SecurityPersonal observer2BehavesAsSecurityPersonal=new SecurityPersonal();
        observable.addObserver(observer1BehavesAsLotOwner);
        observable.addObserver(observer2BehavesAsSecurityPersonal);


        boolean notifiedToAllObserver=observable.notifyToAllObserverToTakeOutTheFullSign();

        assertEquals(true,notifiedToAllObserver);

        observable.removeObserver(observer1BehavesAsLotOwner);
        boolean notifiedOnlySecurityPersonal=observable.notifyToAllObserverToTakeOutTheFullSign();

        assertEquals(true,notifiedOnlySecurityPersonal);
    }

    @Test
    void sendNotificationAboutLotIsNotFull() {
        ParkingLot observable=new ParkingLot();
        LotOwner observer1BehavesAsLotOwner=new LotOwner();
        SecurityPersonal observer2BehavesAsSecurityPersonal=new SecurityPersonal();
        observable.addObserver(observer1BehavesAsLotOwner);
        observable.addObserver(observer2BehavesAsSecurityPersonal);


        boolean notifiedToAllObserver=observable.notifyToAllObserverToTakeInTheFullSign();

        assertEquals(true,notifiedToAllObserver);

        observable.removeObserver(observer1BehavesAsLotOwner);
        boolean notifiedOnlySecurityPersonal=observable.notifyToAllObserverToTakeInTheFullSign();

        assertEquals(true,notifiedOnlySecurityPersonal);
    }
}
