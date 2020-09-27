package cd.pcas.pcas.util;

import java.util.Comparator;

import cd.pcas.pcas.model.HospitalEntity;

public class DateComparatorMenor implements Comparator<HospitalEntity> {

    @Override
    public int compare(HospitalEntity arg0, HospitalEntity arg1) {
        return arg1.getDataCriacao().compareTo(arg0.getDataCriacao());
    }

}
