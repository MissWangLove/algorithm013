package test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class TestMain {
    public static void main(String[] args) {
        /*User user = new User();
        List<User> list = new ArrayList<>();
        list.add(user);
        String collect = list.stream().map(User::getId).collect(Collectors.joining(","));
        System.out.println(collect);*/
        System.out.println(Pattern.matches(REGULAR_ID_CARD, "610422196312280058"));
        System.out.println(Pattern.matches(REGULAR_ID_CARD, "610422197306020094"));
        System.out.println(Pattern.matches(REGULAR_ID_CARD, "610422196807203855"));
    }


    public static final String REGULAR_ID_CARD = "^[1-9]\\d{7}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}$|^[1-9]\\d{5}[1-9]\\d{3}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}([0-9]|X)$";
}

class User {

    private String id;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
