package Bike.Rapido.Bike;

import Bike.Rapido.Pathshala.ParkingLot;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ParkingLotTestCases {
    @Test
    void checkParkinglotIsFull() {
        ParkingLot pl=new ParkingLot();
        for(int count=0;count<10;count++){
            pl.allotParking("bro1");
        }

        assertEquals(true,pl.isFull());
    }

    @Test
    void parkAndUnParkTheCar() {
        ParkingLot pl=new ParkingLot();
        int allotId=pl.allotParking("br02");

        assertEquals(false,pl.checkGivenParkingSlotEmpty(allotId));

        pl.deallotParking(allotId);

        assertEquals(true,pl.checkGivenParkingSlotEmpty(allotId));

    }



    @Test
    void checkEmptySlotIsAvailable() {
        ParkingLot pl=new ParkingLot();
        for(int count=0;count<5;count++){
            pl.allotParking("bro1");
        }

        assertEquals(true,pl.checkAnyParkingSlotEmpty());


        for(int count=0;count<5;count++){
            pl.allotParking("bro1");
        }

        assertEquals(false,pl.checkAnyParkingSlotEmpty());

    }


    /* @Test
    void parkTheCar() {
        Boolean parkedThecar=ParkingLot.allotParking("Vick","br02");

        assertEquals(true,true);
    }




  //  @Test
    void isEmpty() {

    }

   */


}
