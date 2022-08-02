package Bike.Rapido.Paathshaala;

public class SecurityPersonal  implements ParkingLotObserver {
    private boolean isLotFull = false;

    public boolean isLotFull() {
        return isLotFull;
    }

    public void notifyObservers() {
        isLotFull = true;
        System.out.println("Parking lot Is Full");
    }
    public void notifyObserverWhenLotHasSpaceAgain()
    {

    }

}
