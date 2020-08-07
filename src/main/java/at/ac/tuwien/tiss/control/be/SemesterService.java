package at.ac.tuwien.tiss.control.be;

import at.ac.tuwien.tiss.control.api.SemesterDTO;
import org.apache.commons.lang3.time.DateUtils;

import java.text.ParseException;
import java.util.*;
import java.util.stream.Collectors;

public class SemesterService {

    private static final String DATE_FORMAT = "yyyy-MM-dd";
    private static List<SemesterDTO> ALL_SEMESTERS;

    static {
        try {
            ALL_SEMESTERS = Arrays.asList(new SemesterDTO("2010W", DateUtils.parseDate("2010-10-01", DATE_FORMAT), DateUtils.parseDate("2011-01-31", DATE_FORMAT)),
                    new SemesterDTO("2011S", DateUtils.parseDate("2011-03-01", DATE_FORMAT), DateUtils.parseDate("2011-07-31", DATE_FORMAT)),
                    new SemesterDTO("2011W", DateUtils.parseDate("2011-10-01", DATE_FORMAT), DateUtils.parseDate("2012-01-31", DATE_FORMAT)),
                    new SemesterDTO("2012S", DateUtils.parseDate("2012-03-01", DATE_FORMAT), DateUtils.parseDate("2012-07-31", DATE_FORMAT)),
                    new SemesterDTO("2012W", DateUtils.parseDate("2012-10-01", DATE_FORMAT), DateUtils.parseDate("2013-01-31", DATE_FORMAT)),
                    new SemesterDTO("2013S", DateUtils.parseDate("2013-03-01", DATE_FORMAT), DateUtils.parseDate("2013-07-31", DATE_FORMAT)),
                    new SemesterDTO("2013W", DateUtils.parseDate("2013-10-01", DATE_FORMAT), DateUtils.parseDate("2014-01-31", DATE_FORMAT)),
                    new SemesterDTO("2014S", DateUtils.parseDate("2014-03-01", DATE_FORMAT), DateUtils.parseDate("2014-07-31", DATE_FORMAT)),
                    new SemesterDTO("2014W", DateUtils.parseDate("2014-10-01", DATE_FORMAT), DateUtils.parseDate("2015-01-31", DATE_FORMAT)),
                    new SemesterDTO("2015S", DateUtils.parseDate("2015-03-01", DATE_FORMAT), DateUtils.parseDate("2015-07-31", DATE_FORMAT)),
                    new SemesterDTO("2015W", DateUtils.parseDate("2015-10-01", DATE_FORMAT), DateUtils.parseDate("2016-01-31", DATE_FORMAT)),
                    new SemesterDTO("2016S", DateUtils.parseDate("2016-03-01", DATE_FORMAT), DateUtils.parseDate("2016-07-31", DATE_FORMAT)),
                    new SemesterDTO("2016W", DateUtils.parseDate("2016-10-01", DATE_FORMAT), DateUtils.parseDate("2017-01-31", DATE_FORMAT)),
                    new SemesterDTO("2017S", DateUtils.parseDate("2017-03-01", DATE_FORMAT), DateUtils.parseDate("2017-07-31", DATE_FORMAT)),
                    new SemesterDTO("2017W", DateUtils.parseDate("2017-10-01", DATE_FORMAT), DateUtils.parseDate("2018-01-31", DATE_FORMAT)),
                    new SemesterDTO("2018S", DateUtils.parseDate("2018-03-01", DATE_FORMAT), DateUtils.parseDate("2018-07-31", DATE_FORMAT)),
                    new SemesterDTO("2018W", DateUtils.parseDate("2018-10-01", DATE_FORMAT), DateUtils.parseDate("2019-01-31", DATE_FORMAT)),
                    new SemesterDTO("2019S", DateUtils.parseDate("2019-03-01", DATE_FORMAT), DateUtils.parseDate("2019-07-31", DATE_FORMAT)),
                    new SemesterDTO("2019W", DateUtils.parseDate("2019-10-01", DATE_FORMAT), DateUtils.parseDate("2020-01-31", DATE_FORMAT)),
                    new SemesterDTO("2020S", DateUtils.parseDate("2020-03-01", DATE_FORMAT), DateUtils.parseDate("2020-07-31", DATE_FORMAT)),
                    new SemesterDTO("2020W", DateUtils.parseDate("2020-10-01", DATE_FORMAT), DateUtils.parseDate("2021-01-31", DATE_FORMAT)),
                    new SemesterDTO("2021S", DateUtils.parseDate("2021-03-01", DATE_FORMAT), DateUtils.parseDate("2021-07-31", DATE_FORMAT)),
                    new SemesterDTO("2021W", DateUtils.parseDate("2021-10-01", DATE_FORMAT), DateUtils.parseDate("2022-01-31", DATE_FORMAT))
            );
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public static SemesterDTO getNext(SemesterDTO semester) throws IllegalArgumentException {
        Optional<SemesterDTO> opt = ALL_SEMESTERS.stream()
                .filter(s -> semester.getCode()
                        .compareTo(s.getCode()) < 0)
                .findFirst();
        if (opt.isPresent())
            return opt.get();
        throw new IllegalArgumentException(semester.getCode() + " does not have a 'next' semester.");
    }

    public static SemesterDTO getByCode(String code) throws Exception {
        Optional<SemesterDTO> opt = ALL_SEMESTERS.stream()
                .filter(s -> s.getCode()
                        .equals(code))
                .findAny();
        if (opt.isPresent())
            return opt.get();
        throw new Exception("No semester found for '" + code + "'");
    }

    public static SemesterDTO getByDate(Date date) throws Exception {
        Optional<SemesterDTO> opt = ALL_SEMESTERS.stream()
                .filter(s -> !s.getStart()
                        .after(date))
                .sorted(Comparator.reverseOrder())
                .findFirst();
        if (opt.isPresent())
            return opt.get();
        throw new Exception("No semester found for date '" + date + "'");
    }

    public static List<SemesterDTO> getAll() {
        return ALL_SEMESTERS;
    }

}
