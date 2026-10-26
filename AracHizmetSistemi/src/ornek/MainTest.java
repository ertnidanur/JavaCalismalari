package ornek;


public class MainTest {

 public static void main(String[] args) {
        try {
	 Suruculer s1= new Suruculer("Ali",35);
	 Suruculer s2=new Suruculer("Veli",40);
	 Suruculer s3=new Suruculer("Ayse",25);
	 Suruculer s4=new Suruculer("Mehmet",30);

	 Araclar[] araclar = {
	            new Sedan("Toyota","Corolla","White",2020,
	                      s1 , 250.0, 7.0),
	            new ElectricCar("Tesla","Model 3","Black",2023,
	                            s2, 200.0, 2.0),
	            new Scooter("Honda","Dio","110cc",
	                        s3, 100.0, 2.0),
	            new RacingMotorcycle("Yamaha","R1","1000cc",
	                                 s4, 180.0, 9.0)
	        };
	        for (Araclar a : araclar) {
	            a.performJob();              
	            a.cagir();                   
	            System.out.println("-------------------");
	        }

        } catch (IllegalArgumentException e) {
            System.out.println("Hata: " + e.getMessage());
        } finally {
            System.out.println("Kontrol tamamlandı");
        }

	    } 
 }
 