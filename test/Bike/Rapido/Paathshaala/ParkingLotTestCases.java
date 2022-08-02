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
        int allotId=pl.allotParking("br02");

        boolean slotOccupied=pl.checkGivenParkingSlotEmpty(allotId);

        assertEquals(false,slotOccupied);

        boolean emptySlot =pl.deallotParking(allotId);

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








}
