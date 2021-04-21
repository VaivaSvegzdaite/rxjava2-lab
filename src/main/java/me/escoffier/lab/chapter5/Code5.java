package me.escoffier.lab.chapter5;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Single;
import me.escoffier.superheroes.Character;

import java.util.Collection;
import java.util.Collections;
import java.util.Random;

public class Code5 extends AbstractSuperAPI {

    public static void main(String[] args) {
        new Code5().hero()
            .subscribe(System.out::println, Throwable::printStackTrace);

        new Code5().villain()
            .subscribe(System.out::println, Throwable::printStackTrace);
    }

    @Override
    public Single<Character> hero() {
        return load()
            // Implement the pipeline to return a random hero.
                .filter(character -> !character.isVillain()).toList().map( list -> {
                    if(list.isEmpty()){
                        throw new RuntimeException("Hero sarasas tuscias");
                    }
                    Collections.shuffle(list);
                    return list.get(0);
                });

    }

    @Override
    public Single<Character> villain() {
        return load()
            // Implement the pipeline to return a random villain.
                .filter(character -> character.isVillain())
                .toList()
                .map(list -> {
                    Collections.shuffle(list);
                    return list;
                })
              .flatMapObservable(list -> Observable.fromIterable(list))
            .firstOrError();
    }

}
