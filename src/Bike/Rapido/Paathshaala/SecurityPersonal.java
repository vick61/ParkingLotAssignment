package Bike.Rapido.Paathshaala;

public class SecurityPersonal  implements ParkingLotObserver{
    public void notifyObservers()
    {
        System.out.println("Parking lot Is Full");
    }
}
