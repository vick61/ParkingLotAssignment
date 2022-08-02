package Bike.Rapido.Paathshaala;

public class LotOwner implements ParkingLotObserver{
    private boolean isLotFull=false;
    private boolean hasLotSpaceAgain=false;

    public boolean isLotFull() {
        return isLotFull;
    }

    public boolean hasLotSpaceAgain() {
        return hasLotSpaceAgain;
    }

    public void notifyObservers()
    {   isLotFull=true;
        System.out.println("Parking lot Is Full");
    }
    public void notifyObserverWhenLotHasSpaceAgain()
    {
        hasLotSpaceAgain=true;
        System.out.println("Parking lot Is Not Full");
    }


}
