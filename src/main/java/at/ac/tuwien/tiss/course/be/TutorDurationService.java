package at.ac.tuwien.tiss.course.be;

import at.ac.tuwien.tiss.control.api.EmploymentDTO;

import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;

public class TutorDurationService {

    public static long getDays(List<EmploymentDTO> employments, Date refDate) {

        return 0;
    }

    /** This is the method to calculate the number of days from 'start' (the first day)
     * to 'end' (the last day).
     * Because the time of the day is always at midnight (00:00:00), we have to add 1 day
     * to include also the last day in our calculations.
    **/
    private static long calcDays(Date start, Date end) {
        return ChronoUnit.DAYS.between(start.toInstant(), end.toInstant()) + 1;
    }

}
