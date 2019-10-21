package pl.tom.springboottestapp.databaseExample;

import javax.persistence.*;

@Entity
@Table(name = "MyCar")
public class Car {

    public Car() {
    }

    public Car(String mark, String model, Color color) {
        this.mark = mark;
        this.model = model;
        this.color = color;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String mark;
    // @Transient - powoduje że to pole nie zostanie zapisane w bazie danych
//    @Transient
    private String model;

    // @Enumerated(EnumType.STRING) - zapisuje enum jako string (domyślnie jest to liczba)
    @Enumerated(EnumType.STRING)
    private Color color;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", mark='" + mark + '\'' +
                ", model='" + model + '\'' +
                ", color=" + color +
                '}';
    }
}
