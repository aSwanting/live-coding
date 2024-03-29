package org.learning;

public class NameRandomizer {
    static String[] names = {
            "Giuseppe\tMongelli", "Giulio\tD'Angelo", "Roberto\tBenfini",
            "Salvatore\tBono", "Umberto Maria\tFaenza", "Massimo\tAzzini", "Alessandro\tCingolani",
            "Giuseppe\tGerace", "Alessandro\tMatricardi", "Alessandro\tPirisinu",
            "Salvatore Dario\tTorrisi", "Valerio\tCarbone", "Edoardo\tCicognani", "Gabriel\tD'Amico",
            "Francesco\tCarrara", "Vinicius\tDe Miranda", "Davide\tGila", "Luca\tMasera",
            "Mekki\tOuertani", "Matteo\tPupino", "Alberto\tStizzoli", "Cristian\tUrsino",
            "Luca\tMincuzzi", "Serena\tPeschiaroli"
    };

    public static String pickVictim(String[] array) {
        int victim = (int) (Math.random() * (array.length - 1));
        return names[victim];
    }

    public static void main(String[] args) {
        System.out.println(names.length);

        for (int i = 0; i < 40; i++) {
//            System.out.println(pickVictim(names));
            double rand = Math.random() * (names.length - 1);
            int randInt = (int) rand;
            int randRound = Math.round((float) rand);
            System.out.print(rand);
            System.out.print(" ");
            System.out.print(randInt);
            System.out.print(" ");
            System.out.print(randRound);
            System.out.println(" ");

        }
    }
}
