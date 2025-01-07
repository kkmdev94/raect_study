package lang.immutable.ex;

public class ImmutableMyDate {

    private final int year;
    private final int month;
    private final int day;

    public ImmutableMyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    //전체적으로 변경할 때
    public ImmutableMyDate changeAll(int newYear, int newMonth, int newDay) {
        return new ImmutableMyDate(newYear,newMonth,newDay);
    }

    public ImmutableMyDate withYear(int newYear) {
        return new ImmutableMyDate(newYear,month,day);
    }

    public ImmutableMyDate withMonth(int newMonth) {
        return new ImmutableMyDate(year,newMonth,day);
    }

    public ImmutableMyDate withDay(int newDay) {
        return new ImmutableMyDate(year,month,newDay);
    }

    @Override
    public String toString() {
        return year + "-" + month + "-" + day;
    }
}
