package pl.tom.springboottestapp.databaseExample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class Start {

    private CarRepo carRepo;
    @Autowired
    public Start(CarRepo carRepo) {
        this.carRepo = carRepo;
    }

    //@EventListener(ApplicationReadyEvent.class) odpala metodę kiedy applikacja jest gotowa (przy starcie aplikacji)
    @EventListener(ApplicationReadyEvent.class)
    public void runExample() {
        Car car = new Car("BMW", "X5", Color.WHITE);
        carRepo.save(car);

        Car car2 = new Car("Subaru", "IMPREZA", Color.BLUE);
        carRepo.save(car2);

        Car car3 = new Car("Mercedes", "CLS", Color.BLACK);
        carRepo.save(car3);

        carRepo.deleteById(1L);

//        Iterable<Car> all = carRepo.findAll();
        Iterable<Car> all = carRepo.findAllByColor(Color.BLUE);
        all.forEach(System.out::println);
    }
}
