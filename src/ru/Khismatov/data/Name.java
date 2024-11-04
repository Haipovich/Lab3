package ru.Khismatov.data;

public class Name {
    private final String last_name;
    private final String first_name;
    private final String middle_name;

    public Name(String last_name, String first_name, String middle_name) {
        if (is_null_or_empty(last_name) && is_null_or_empty(first_name) && is_null_or_empty(middle_name)) {
            throw new IllegalArgumentException("At least one name parameter must not be empty");
        }
        this.last_name = last_name;
        this.first_name = first_name;
        this.middle_name = middle_name;
    }

    public Name(String last_name, String first_name) {
        this(last_name, first_name, null);
    }

    public Name(String first_name) {
        this(null, first_name, null);
    }

    private boolean is_null_or_empty(String str) {
        return str == null || str.trim().isEmpty();
    }

    @Override
    public String toString() {
        String result = "";
        if (last_name != null && !last_name.isEmpty()) {
            result += last_name + " ";
        }
        if (first_name != null && !first_name.isEmpty()) {
            result += first_name + " ";
        }
        if (middle_name != null && !middle_name.isEmpty()) {
            result += middle_name;
        }
        return result.trim();
    }
}