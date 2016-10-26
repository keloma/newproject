package util;

import java.util.Calendar;

/**
 *
 * @author pupil
 */
public class ParseCode {

    private String code;
    private Integer age;
    private Integer day;
    private Integer month;
    private Integer year;
    private String birthday;
    private String sex;

    public ParseCode(String code) {
        this.code = code;
        setSex(code);
        setBirthday(code);
    }

    public void setAge() {
        Calendar dob = Calendar.getInstance();
        Calendar today = Calendar.getInstance();

        dob.set(getYear(), getMonth(), getDay());
        dob.add(Calendar.DAY_OF_MONTH, -1);

        Integer intAge = today.get(Calendar.YEAR) - dob.get(Calendar.YEAR);
        if (today.get(Calendar.DAY_OF_YEAR) <= dob.get(Calendar.DAY_OF_YEAR)) {
            intAge--;
        }
        this.age = intAge;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        String stringGender = code.substring(0, 1);
        String codeYear = code.substring(1, 3);
        String codeDay = code.substring(5, 7);
        String codeMonth = code.substring(3, 5);
        String stringYear = "";
        String stringDay = "";
        String stringMonth = "";
        //if("3".equals(numberGender))
        //this.gender = "Мужчина";
        switch (stringGender) {
            case "3":
                this.sex = "Мужчина";
                stringYear = "19" + codeYear;
                stringDay = codeDay;
                stringMonth = codeMonth;
                break;
            case "4":
                this.sex = "Женщина";
                stringYear = "19" + codeYear;
                stringDay = codeDay;
                stringMonth = codeMonth;
                break;
            case "5":
                this.sex = "Мужчина";
                stringYear = "20" + codeYear;
                stringDay = codeDay;
                stringMonth = codeMonth;
                break;
            case "6":
                this.sex = "Женщина";
                stringYear = "20 " + codeYear;
                stringDay = codeDay;
                stringMonth = codeMonth;
                break;

            default:
                System.out.println("Неправельная инициализация ID!");

        }
        this.setYear(Integer.parseInt(stringYear));
        this.setDay(Integer.parseInt(stringDay));
        this.setMonth(Integer.parseInt(stringMonth));

    }

    public String getBirthdey() {
        return birthday;
    }

    public void setBirthdey() {
        String d = Integer.toString(getDay());
        String m = Integer.toString(getMonth());
        String y = Integer.toString(getYear());
        this.birthday = d + "." + m + "." + y;

    }
}
