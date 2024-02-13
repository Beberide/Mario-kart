public class Main {
    public static void main(String[] args) {
        Race race= new Race("Prueba");

        Kart kart1= new Kart("Mario");
        Kart kart2= new Kart("Luigi");
        Kart kart3= new Kart("Bowser");

        race.addKart(kart1);
        race.addKart(kart2);
        race.addKart(kart3);

        Circuit circuit=new Circuit("Mansion",10);

        race.setCircuit(circuit);
        System.out.println("**** Init Super Mario Kart ****");
        mostrar(race);
    }

    public static void mostrar(Race race){
        System.out.println(race.toString());
        System.out.println("**** Game Over ****");
        race.run();
        System.out.println(race.showResult());
    }

}