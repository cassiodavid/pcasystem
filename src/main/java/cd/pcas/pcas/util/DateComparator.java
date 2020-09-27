package cd.pcas.pcas.util;

import java.util.Comparator;

import cd.pcas.pcas.model.HospitalEntity;

public class DateComparator implements Comparator<HospitalEntity> {

    @Override
    public int compare(HospitalEntity arg0, HospitalEntity arg1) {
        return arg0.getDataCriacao().compareTo(arg1.getDataCriacao());
    }

    
}
 