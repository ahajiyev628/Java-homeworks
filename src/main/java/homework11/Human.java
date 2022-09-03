package homework11;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Human {
    private String name;
    private String surname;
    private int age;
    long unix_time;
    //1322018752992l
    private String birthDate;
    private int iq;
    private Pet pet;
    private Human mother;
    private Human father;

    private Family family;

    Calendar cal = Calendar.getInstance();

    public Human(){}

    public Human(String name, String surname, String birthDate, int iq) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date date = sdf.parse(birthDate);
        this.name = name;
        this.surname = surname;
        this.birthDate = sdf.format(date);
        this.iq = iq;
    }

    public Human(String name, String surname, long unix_time, int iq) {
        SimpleDateFormat sd = new SimpleDateFormat("MM/dd/yyyy");
        cal.setTimeInMillis(unix_time);
        cal.add(Calendar.DATE,0);
        Date date = cal.getTime();
        this.name = name;
        this.surname = surname;
        this.birthDate = sd.format(date);
        this.iq = iq;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Human getMother() {
        return mother;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public Human getFather() {
        return father;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public Family getFamily() {
        return family;
    }

    public void setFamily(Family family) {
        this.family = family;
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

    public long getUnix_time() {
        return unix_time;
    }

    public void setUnix_time(long unix_time) {
        this.unix_time = unix_time;
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
        SimpleDateFormat sd = new SimpleDateFormat("MM/dd/yyyy");
        cal.setTimeInMillis(unix_time);
        cal.add(Calendar.DATE,0);
        Date date = cal.getTime();
        return "Human{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birthdate=" + birthDate +
                ", iq=" + iq +
                '}';
    }

    public String describeAge(long timestamp) {
        cal.setTimeInMillis(timestamp);
        return "year: " + cal.get(Calendar.YEAR) + ". month: " + cal.get(Calendar.MONTH) + ". day: " + cal.get(Calendar.DAY_OF_MONTH);
    }
}
