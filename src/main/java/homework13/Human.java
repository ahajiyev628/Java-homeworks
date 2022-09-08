package homework13;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

public class Human {
    private String name;
    private String surname;
    private String birthDate;
    private int iq;
    private HashMap<DayOfWeek, String> schedule;
    private static DayOfWeek dw;

    Calendar cal = Calendar.getInstance();

    public Human(){}

    public Human(String name, String surname, String birthDate, int iq, HashMap<DayOfWeek, String> schedule) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date date = sdf.parse(birthDate);
        this.name = name;
        this.surname = surname;
        this.birthDate = sdf.format(date);
        this.iq = iq;
        this.schedule = schedule;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public HashMap<DayOfWeek, String> getSchedule() {
        return schedule;
    }

    public void setSchedule(HashMap<DayOfWeek, String> schedule) {
        this.schedule = schedule;
    }

    public void setIq(int iq) {
        if (iq > 100 || iq < 0) {
            this.iq = Integer.parseInt("");
            return;
        }
        this.iq=iq;
    }
    public int getIq() {
        return iq;
    }
    public Human(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }
    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", iq=" + iq +
                ", schedule=" + schedule.clone() +
                '}';
    }

}
