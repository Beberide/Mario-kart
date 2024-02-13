import java.util.Arrays;

public class Race {
    private String name;
    private Circuit circuit;
    private final  int NUM_KARTS=3;
    private Kart[] karts=new Kart[NUM_KARTS];
    private Kart[] finishedKarts=new Kart[NUM_KARTS];

    public Race(String name) {
        this.name = name;
    }

    public void run(){
        for (Kart a:karts){
            if (a.getPosition()==0){
                moveKart(a);
                if (isFinished(a)==true){
                    moveToFinished(a);
                }
            }

        }
        Arrays.sort(finishedKarts);

    }

    private  boolean  notAllFinished(){
        for (int i = 0; i < karts.length; i++) {
            if (karts[i].getPosition()!=0){
                return true;
            }
        }
        return false;
    }

    private void moveKart(Kart kart){
        int movedPositions= 0;
        movedPositions= kart.move() -circuit.difficulty();
        kart.setPosition(kart.getPosition() + movedPositions);
    }

    private boolean isFinished(Kart kart){
        if (kart.getPosition()>=circuit.getDistance()){
            return true;
        }
        return false;
    }

    private  void moveToFinished(Kart kart){
        for (int i = 0; i < finishedKarts.length; i++) {
            if (finishedKarts[i]==null){
                finishedKarts[i]=kart;
                for (Kart a:karts){
                    if (a.equals(kart)){
                        a.setPosition(0);
                    }
                }
                i= finishedKarts.length;
            }
        }
    }
    public  String  showResult(){
        StringBuilder sb= new StringBuilder();
        sb.append(name).append("\n");
        sb.append(circuit.toString()).append("\n");
        for (Kart kart:finishedKarts){
            sb.append(kart.toString());
            sb.append("\n");
        }
        return sb.toString();
    }

    public  void addKart(Kart kart){
        for (int i = 0; i < karts.length; i++) {
            if (karts[i]==null){
                karts[i]=kart;
                i= karts.length;
            }
        }
    }

    public void setCircuit(Circuit circuit){
        this.circuit=circuit;
    }

    public String toString() {
        String result= "Race: "+ this.getName() + "\n";
        result+= "Circuit: "+ circuit.toString() + "\n";
        for(int i= 0; i< karts.length; i++) {
            if(karts[i] != null) {
                result+= (i+ 1) + ".-"+ karts[i].toString() + "\n";
            }
        }
        return result;
    }

    public String getName() {
        return name;
    }
}
