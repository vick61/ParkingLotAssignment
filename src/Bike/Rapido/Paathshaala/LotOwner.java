package Bike.Rapido.Paathshaala;

public class LotOwner implements ParkingLotObserver{
    public void notifyObserver()
    {
        System.out.println("Parking lot Is Full");
    }

}
