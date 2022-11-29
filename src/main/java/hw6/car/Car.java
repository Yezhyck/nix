package hw6.car;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Car {
    private double tankFullness;
    private double fuelConsumptionPerThunderedKm;
    private LocalDate inspectionDate;

    public boolean isAbleToDrive() {
        return tankFullness > 0;
    }

    public boolean isApprovedForUse() {
        LocalDate nowMinusTwoYears = LocalDate.now().minusYears(2);
        return inspectionDate != null && (nowMinusTwoYears.isAfter(inspectionDate) || nowMinusTwoYears.isEqual(inspectionDate));
    }

    public double distanceRemainingToDrive() {
        return fuelConsumptionPerThunderedKm != 0 ? tankFullness * 100 / fuelConsumptionPerThunderedKm : 0;
    }
}

