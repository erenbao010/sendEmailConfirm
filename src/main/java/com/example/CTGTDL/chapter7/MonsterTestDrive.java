package com.example.CTGTDL.chapter7;

import com.example.CTGTDL.dependencyInjection.BubbleSortAlgorithm;
import com.example.CTGTDL.dependencyInjection.SortAlg;
import com.example.CTGTDL.dependencyInjection.quickShort;
import com.example.CTGTDL.dependencyInjection.veryComplexService;

public class MonsterTestDrive {
    public static void main(String[] args) {
        Monster[] anime = new Monster[3];
        anime[0] = new Vampire();
        anime[1] = new Dragon();
        anime[2] = new Monster();
        for (int i = 0; i < 3; i++) {
            anime[i].frighten(i);
        }
        anime[1].fly(5);
        Evil monster = new Vampire();
        monster.kill();

        }
    }
abstract class Devil {
    String hand;
    String body;
    void bite() {
        System.out.println("bite");
    }

}
    class Monster {
        boolean frighten(int x) {
            System.out.println("arrrgh");
            return false;
        }
        boolean fly(int x) {
            System.out.println("FLY monster");
            return false;
        }
    }
    class Dragon extends Monster {
        boolean frighten(int degree) {
            System.out.println("breath fire");
            return true;
        }

        @Override
        boolean fly(int x) {
            System.out.println("dragon flies");
            return true;
        }
    }
    class Vampire extends Monster implements Evil {
        boolean scare(int x) {
            System.out.println("a bite?");
            return true;
        }
        boolean frighten(int degree) {
            System.out.println("Vampire");
            return true;
        }

        @Override
        public void kill() {
            System.out.println("kill me");
        }
    }
