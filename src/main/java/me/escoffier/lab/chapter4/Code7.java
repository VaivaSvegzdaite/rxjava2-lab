package me.escoffier.lab.chapter4;


import java.util.HashSet;

import static me.escoffier.superheroes.Helpers.heroes;
import static me.escoffier.superheroes.Helpers.villains;

public class Code7 {

    public static void main(String[] args) {
        villains()
            // Build a set containing all the super power from the villain
            // This exercise uses the `reduce` method
                .reduce(new HashSet<>(), (set, superstuff) -> {
                    set.addAll(superstuff.getSuperpowers());
                    return set;
                })
                .doOnSuccess(System.out::println)
                .subscribe(
                        set -> System.out.println("Villains have " + set.size() + " unique super powers")
                );
        ;
    }

}
