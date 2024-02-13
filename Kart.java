public class Kart implements Comparable<Kart>{

    private String driver;
    private int speed;
    private int acceleration;
    private int position;
    private int random;
    private final int MAX_POINTS=18;
    private final int MAX_RANDOM=6;

    public Kart(String driver) {
        this.driver = driver;
        init();
    }

    private void init(){
        this.position=0;
        this.speed= random(MAX_POINTS);
        this.acceleration=MAX_POINTS-speed;
    }

    public int move(){
        return speed+acceleration+random(MAX_RANDOM);
    }

    private int random(int maximo){
        this.random=(int)(Math.random()*maximo)+1;
        return random;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getAcceleration() {
        return acceleration;
    }

    public void setAcceleration(int acceleration) {
        this.acceleration = acceleration;
    }

    public int getRandom() {
        return random;
    }

    public void setRandom(int random) {
        this.random = random;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getMAX_POINTS() {
        return MAX_POINTS;
    }

    public int getMAX_RANDOM() {
        return MAX_RANDOM;
    }

    @Override
    public String toString() {
        StringBuilder sb= new StringBuilder("Kart [");
        sb.append("name=").append(driver);
        sb.append(", speed=").append(speed);
        sb.append(", acceleration=").append(acceleration);
        sb.append("]");
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Kart kart = (Kart) o;

        return position == kart.position;
    }

    @Override
    public int compareTo(Kart o) {
        return (int) Math.signum(o.getPosition()-this.position);
    }
}
