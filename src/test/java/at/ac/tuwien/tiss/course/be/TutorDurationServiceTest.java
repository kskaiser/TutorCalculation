package at.ac.tuwien.tiss.course.be;

import at.ac.tuwien.tiss.control.api.EmploymentDTO;
import org.apache.commons.lang3.time.DateUtils;
import org.junit.Assert;
import org.junit.Test;

import java.text.ParseException;
import java.util.Arrays;
import java.util.List;

public class TutorDurationServiceTest {

    private static final String DATE_FORMAT = "yyyy-MM-dd";

    @Test
    public void getDaysTest() throws ParseException {
        Assert.assertEquals(150, TutorDurationService.getDays(p0Employments, DateUtils.parseDate("2020-10-01", DATE_FORMAT)));
        Assert.assertEquals(811, TutorDurationService.getDays(p1Employments, DateUtils.parseDate("2020-10-01", DATE_FORMAT)));
        Assert.assertEquals(600, TutorDurationService.getDays(p2Employments, DateUtils.parseDate("2020-10-01", DATE_FORMAT)));
        Assert.assertEquals(30, TutorDurationService.getDays(p3Employments, DateUtils.parseDate("2020-10-01", DATE_FORMAT)));
        Assert.assertEquals(572, TutorDurationService.getDays(p4Employments, DateUtils.parseDate("2020-10-01", DATE_FORMAT)));
    }

    private static List<EmploymentDTO> p0Employments;
    {
        try {
            p0Employments = Arrays.asList(
                    new EmploymentDTO(DateUtils.parseDate("2018-10-01", DATE_FORMAT), DateUtils.parseDate("2019-02-28", DATE_FORMAT))
            );
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private static List<EmploymentDTO> p1Employments;
    {
        try {
            p1Employments = Arrays.asList(
                    new EmploymentDTO(DateUtils.parseDate("2016-10-01", DATE_FORMAT), DateUtils.parseDate("2016-11-30", DATE_FORMAT)),
                    new EmploymentDTO(DateUtils.parseDate("2017-10-01", DATE_FORMAT), DateUtils.parseDate("2018-07-31", DATE_FORMAT)),
                    new EmploymentDTO(DateUtils.parseDate("2018-10-01", DATE_FORMAT), DateUtils.parseDate("2018-12-31", DATE_FORMAT)),
                    new EmploymentDTO(DateUtils.parseDate("2019-01-01", DATE_FORMAT), DateUtils.parseDate("2019-02-28", DATE_FORMAT)),
                    new EmploymentDTO(DateUtils.parseDate("2019-10-01", DATE_FORMAT), DateUtils.parseDate("2020-09-30", DATE_FORMAT))
            );
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private static List<EmploymentDTO> p2Employments;
    {
        try {
            p2Employments = Arrays.asList(
                    new EmploymentDTO(DateUtils.parseDate("2017-10-01", DATE_FORMAT), DateUtils.parseDate("2018-02-28", DATE_FORMAT)),
                    new EmploymentDTO(DateUtils.parseDate("2018-10-01", DATE_FORMAT), DateUtils.parseDate("2019-02-28", DATE_FORMAT)),
                    new EmploymentDTO(DateUtils.parseDate("2019-10-01", DATE_FORMAT), DateUtils.parseDate("2020-07-31", DATE_FORMAT))
            );
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private static List<EmploymentDTO> p3Employments;
    {
        try {
            p3Employments = Arrays.asList(
                    new EmploymentDTO(DateUtils.parseDate("2017-09-01", DATE_FORMAT), DateUtils.parseDate("2017-09-30", DATE_FORMAT))
            );
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private static List<EmploymentDTO> p4Employments;
    {
        try {
            p4Employments = Arrays.asList(
                    new EmploymentDTO(DateUtils.parseDate("2017-10-01", DATE_FORMAT), DateUtils.parseDate("2018-02-28", DATE_FORMAT)),
                    new EmploymentDTO(DateUtils.parseDate("2018-10-01", DATE_FORMAT), DateUtils.parseDate("2019-02-28", DATE_FORMAT)),
                    new EmploymentDTO(DateUtils.parseDate("2019-10-01", DATE_FORMAT), DateUtils.parseDate("2020-06-30", DATE_FORMAT))
            );
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
