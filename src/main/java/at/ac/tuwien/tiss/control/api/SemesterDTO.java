package at.ac.tuwien.tiss.control.api;

import lombok.Data;

import java.util.Comparator;
import java.util.Date;

@Data
public class SemesterDTO implements Comparable<SemesterDTO> {

    private Date start;
    private Date end;
    private String code;
    private Season season;

    public SemesterDTO(String code, Date start, Date end) {
        this.start = start;
        this.end = end;
        this.code = code;
        try {
            this.season = Season.valueOf(code.substring(4));
        } catch (IllegalArgumentException | IndexOutOfBoundsException ex ) {
            System.err.println(code + " does not have a correct season!");
        }
    }

    @Override
    public int compareTo(SemesterDTO o) {
        return start.compareTo(o.getStart());
    }

    public enum Season {
        W,
        S
    }
}
