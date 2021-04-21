package me.escoffier.lab.chapter3;


import io.reactivex.Single;

public class Code2 {


    public static void main(String[] args) {
        Single.just("Superman")
            // use subscribe to retrieve the element and the error if any.
                .subscribe(
                        (name, err) -> {
                            if (err == null) {
                                System.out.println("Hello " + name);
                            } else {
                                err.printStackTrace();
                            }
                        }
                );
    }
}
