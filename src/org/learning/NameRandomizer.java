package org.learning;

public class NameRandomiser {
    static String[] names = {"Giuseppe\tMongelli", "Giulio\tD'Angelo", "Roberto\tBenfini",
            "Salvatore\tBono", "Umberto Maria\tFaenza", "Massimo\tAzzini", "Alessandro\tCingolani",
            "Giuseppe\tGerace", "Alessandro\tMatricardi", "Alessandro\tPirisinu",
            "Salvatore Dario\tTorrisi", "Valerio\tCarbone", "Edoardo\tCicognani", "Gabriel\tD'Amico",
            "Francesco\tCarrara", "Vinicius\tDe Miranda", "Davide\tGila", "Luca\tMasera",
            "Mekki\tOuertani", "Matteo\tPupino", "Alberto\tStizzoli", "Cristian\tUrsino",
            "Luca\tMincuzzi", "Serena\tPeschiaroli"};

    public static void pickVictim(String[] array) {
        int victim = (int)(Math.random() * array.length);
        System.out.println(names[victim]);
    }

    public static void main(String[] args) {

        for (int i = 0; i < 100; i++) {
            pickVictim(names);
        }

    }
}
