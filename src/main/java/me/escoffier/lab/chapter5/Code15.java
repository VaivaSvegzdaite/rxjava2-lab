package me.escoffier.lab.chapter5;

import io.reactivex.Single;
import me.escoffier.superheroes.Character;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class Code15 {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Before operation");
        getBlockingSuperVillain()
            .subscribe(value -> System.out.println("Operation completed: " + value));

        Thread.sleep(2000);
    }

    private static Single<Character> getBlockingSuperVillain() {
        return Single.just(new Character("Frog-Man",
            Arrays.asList("super strength", "leaping", "mega agility", "French"),
            false))
            .delay(1, TimeUnit.SECONDS)
            .doAfterTerminate(() -> System.out.println("Operation done"));
    }

}
