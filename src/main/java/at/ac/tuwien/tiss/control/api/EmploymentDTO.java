package at.ac.tuwien.tiss.control.api;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class EmploymentDTO {

    private Date start;
    private Date end;

}
