package academy.mindswap;

public class RegularBear implements Bear {
    private int battery = 100;


    public RegularBear(int battery) {
        this.battery = battery;
    }

    @Override
    public void talk() {
        this.battery -= 10;
        if (this.battery > 0) {
            System.out.println("Hello");
            System.out.println(this.battery + " Battery left");
        }
        System.out.println("-------------- Silence --------------");
        this.battery = 0;
    }
}
