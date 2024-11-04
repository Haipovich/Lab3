package ru.Khismatov.secret;

import java.util.Random;

public class Secret {
    private final String secret;
    private final String name_guard;
    private final int order;
    private Secret next_guard;
    private final Secret previous_guard;

    public Secret(String secret, String name_guard) {
        if (name_guard == null || name_guard.isEmpty()) {throw new IllegalArgumentException("Name guard cannot be empty or null");}
        if (secret == null || secret.isEmpty()) {throw new IllegalArgumentException("Secret text cannot be empty or null");}
        this.secret = secret;
        this.name_guard = name_guard;
        this.order = 1;
        this.next_guard = null;
        this.previous_guard = null;
    }

    public Secret(Secret previous_guard, String name_guard) {
        if (name_guard == null || name_guard.isEmpty()) {throw new IllegalArgumentException("Name guard cannot be empty or null");}
        if (previous_guard == null) {throw new IllegalArgumentException("Previous guard cannot be null");}
        if (previous_guard.next_guard != null) {throw new IllegalStateException("The secret has already been passed on to another guard");}
        this.name_guard = name_guard;
        this.previous_guard = previous_guard;
        this.order = previous_guard.order + 1;
        this.secret = modify_secret(previous_guard.secret);
        previous_guard.next_guard = this;
        System.out.println(previous_guard.name_guard + " told that " + previous_guard.secret);
    }

    private String modify_secret(String secret) {
        StringBuilder modified_secret = new StringBuilder(secret);
        Random rand = new Random();
        for (int i = 0; i < (rand.nextInt(Math.max(1, secret.length() / 10) + 1)); i++) {
            modified_secret.insert(rand.nextInt(modified_secret.length()), (char)('a' + rand.nextInt(26)));
        }
        return modified_secret.toString();
    }

    @Override
    public String toString() {return name_guard + ": it's a secret!";}

    public int get_order() {return order;}

    public int get_count_next_guards() {
        Secret current_guard = this;
        while (current_guard.next_guard != null) {
            current_guard = current_guard.next_guard;
        }
        return current_guard.order - this.order;
    }

    public String get_guard_by_order(int N) {
        Secret current_guard = this;
        if (N > 0){
            for (int i = 0; i < N; i++) {
                if (current_guard.next_guard == null) {return null;}
                current_guard = current_guard.next_guard;
            }
        } else {
            for (int i = 0; i < -N; i++) {
                if (current_guard.previous_guard == null) {return null;}
                current_guard = current_guard.previous_guard;
            }
        }
        return current_guard.name_guard;
    }

    public int get_delta_length(int N) {
        Secret current_guard = this;
        if (N > 0){
            for (int i = 0; i < N; i++) {
                if (current_guard.next_guard == null) {return -1;}
                current_guard = current_guard.next_guard;
            }
        } else {
            for (int i = 0; i < -N; i++) {
                if (current_guard.previous_guard == null) {return -1;}
                current_guard = current_guard.previous_guard;
            }
        }
        return Math.abs(current_guard.secret.length() - this.secret.length());
    }
}
