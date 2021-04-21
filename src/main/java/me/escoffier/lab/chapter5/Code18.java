package me.escoffier.lab.chapter5;

import io.reactivex.Single;
import me.escoffier.superheroes.Character;

import java.util.Arrays;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class Code18 {

    public static void main(String[] args) {
        System.out.println("Before operation");
        Character value = getBlockingSuperVillain().blockingGet();
        System.out.println("Operation completed: " + value);
    }

    private static Single<Character> getBlockingSuperVillain() {
        return Single.just(new Character("Frog-Man",
            Arrays.asList("super strength", "leaping", "mega agility", "French"),
            false))
            .delay(1, TimeUnit.SECONDS)
            .doAfterTerminate(() -> System.out.println("Operation done"));
    }

}
