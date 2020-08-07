package at.ac.tuwien.tiss.control.be;

import at.ac.tuwien.tiss.control.api.SemesterDTO;
import org.apache.commons.lang3.time.DateUtils;
import org.junit.Assert;
import org.junit.Test;

public class SemesterServiceTest {

    private static final String DATE_FORMAT = "yyyy-MM-dd";

    @Test
    public void getByDateTest() throws Exception {
        Assert.assertEquals("2018W", SemesterService.getByDate(DateUtils.parseDate("2018-10-01", DATE_FORMAT)).getCode());
        Assert.assertEquals("2018W", SemesterService.getByDate(DateUtils.parseDate("2019-01-31", DATE_FORMAT)).getCode());
        Assert.assertEquals("2018W", SemesterService.getByDate(DateUtils.parseDate("2019-02-28", DATE_FORMAT)).getCode());
        Assert.assertEquals("2019S", SemesterService.getByDate(DateUtils.parseDate("2019-03-01", DATE_FORMAT)).getCode());
        Assert.assertEquals("2019S", SemesterService.getByDate(DateUtils.parseDate("2019-06-11", DATE_FORMAT)).getCode());
        Assert.assertEquals("2019S", SemesterService.getByDate(DateUtils.parseDate("2019-07-11", DATE_FORMAT)).getCode());
        Assert.assertEquals("2019S", SemesterService.getByDate(DateUtils.parseDate("2019-09-30", DATE_FORMAT)).getCode());
    }

    @Test
    public void getByCodeTest() throws Exception {
        Assert.assertEquals("2018W", SemesterService.getByCode("2018W").getCode());
    }

    @Test
    public void getNextText() throws Exception {
        SemesterDTO sem = SemesterService.getByCode("2018W");
        Assert.assertEquals(SemesterDTO.Season.W, sem.getSeason());
        SemesterDTO next = SemesterService.getNext(sem);
        Assert.assertEquals("2019S", next.getCode());
        Assert.assertEquals(SemesterDTO.Season.S, next.getSeason());
    }
}
