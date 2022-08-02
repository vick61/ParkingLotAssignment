package Bike.Rapido.Paathshaala;

public class LotOwner implements ParkingLotObserver{
    public void notifyObserversToTakeOutTheFullSign()
    {
        System.out.println("Parking lot Is Full");
    }
    public void notifyObserversToTakeInTheFullSign()
    {
        System.out.println("Parking lot Is Not Full");
    }


}
