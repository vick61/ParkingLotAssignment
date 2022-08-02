package Bike.Rapido.Paathshaala;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ParkingLotTestCases {
    @Test
    void checkParkinglotIsFull() {
        ParkingLot pl=new ParkingLot();
        for(int count=0;count<10;count++)
        {
            pl.allotParking("bro1");
        }

        boolean isLotFull=pl.isFull();

        assertEquals(true,isLotFull);
    }

    @Test
    void parkAndUnParkTheCar() {
        ParkingLot pl=new ParkingLot();
        int slotId=pl.allotParking("br02");

        boolean slotOccupied=pl.checkGivenParkingSlotEmpty(slotId);

        assertEquals(false,slotOccupied);

        boolean emptySlot =pl.deallotParking(slotId);

        assertEquals(true,emptySlot);

    }



    @Test
    void checkEmptySlotIsAvailable() {
        ParkingLot pl=new ParkingLot();
        for(int count=0;count<5;count++)
        {
            pl.allotParking("bro1");
        }

        boolean anyEmptySlot= pl.checkAnyParkingSlotEmpty();

        assertEquals(true,anyEmptySlot);


        for(int count=0;count<5;count++)
        {
            pl.allotParking("bro1");
        }

        boolean isSlotFull=pl.checkAnyParkingSlotEmpty();


        assertEquals(false,isSlotFull);

    }

    @Test
    void sendNotificationAboutLotIsFull() {
        ParkingLot observable=new ParkingLot();
        LotOwner overserver1BehavesAsLotOwner=new LotOwner();
        SecurityPersonal overserver2BehavesAsSecurityPersonal=new SecurityPersonal();
        observable.addObserver(overserver1BehavesAsLotOwner);
        observable.addObserver(overserver2BehavesAsSecurityPersonal);


        boolean notifiedToAllObserver=observable.notifyToAllObserver();

        assertEquals(true,notifiedToAllObserver);

        observable.removeObserver(overserver1BehavesAsLotOwner);
        boolean notifiedOnlySecurityPersonal=observable.notifyToAllObserver();

        assertEquals(true,notifiedOnlySecurityPersonal);
    }

    //@Test
    //void name() {
    //}
}
