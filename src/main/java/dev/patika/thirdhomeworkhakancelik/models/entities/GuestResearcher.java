package dev.patika.thirdhomeworkhakancelik.models.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GuestResearcher extends Instructor{
    private int hourlySalary;


    @Builder
    public GuestResearcher( String name, String address, String phoneNumber,  int hourlySalary) {
        super(name, address, phoneNumber);
        this.hourlySalary = hourlySalary;
    }

    @Override
    public String toString() {
        return "GuestResearcher{" +
                "hourlySalary=" + hourlySalary +
                '}';
    }

}
