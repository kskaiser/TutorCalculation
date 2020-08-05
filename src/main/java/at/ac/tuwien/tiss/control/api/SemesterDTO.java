package at.ac.tuwien.tiss.control.api;

import lombok.Data;

import java.util.Date;

@Data
public class SemesterDTO {

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

    enum Season {
        W,
        S
    }
}
