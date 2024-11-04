package ru.Khismatov.data;

public class Name_new {
    private String last_name;
    private String first_name;
    private String middle_name;

    public Name_new(String first_name, String last_name, String middle_name) {
        if ((last_name == null || last_name.isEmpty()) && (first_name == null || first_name.isEmpty())) {
            throw new IllegalArgumentException("Name or surname must not be null");
        }
        this.first_name = first_name;
        this.last_name = last_name;
        this.middle_name = middle_name;
    }

    public Name_new(String first_name, String last_name) {
        this(first_name, last_name, null);
    }

    public Name_new(String first_name) {
        this(first_name, null, null);
    }

    @Override
    public String toString() {
        String result = "";
        if (last_name != null) {
            result += last_name + " ";
        }
        if (first_name != null) {
            result += first_name + " ";
        }
        if (middle_name != null) {
            result += middle_name;
        }
        return result.trim();
    }
}
