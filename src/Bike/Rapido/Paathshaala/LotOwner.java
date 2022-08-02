package Bike.Rapido.Paathshaala;

public class LotOwner implements ParkingLotObserver{
    public void notifyObservers()
    {
        System.out.println("Parking lot Is Full");
    }

}
