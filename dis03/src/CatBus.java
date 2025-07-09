public class CatBus implements  Vehicle, Noisemaker {
    @Override
    public void revEngine() { /* CatBus revs engine, code not shown */ }

    @Override
    public void makeNoise() { /* CatBus makes noise, code not shown */ }

    /**
     * Allows CatBus to make noise at other CatBuses.
     */
    public void conversation(Noisemaker target) {
        makeNoise();
        target.makeNoise();
    }
}