package com.company;

import com.company.Engine.Game;

public class Main {

    public static void main(String[] args) {

        Game game = new Game(3, 4, 10);

        System.out.println(game);

       /* System.out.println(
                "Menu:\n " +
                        "1. See your resources. \n " +
                        "2. Add Construction. \n " +
                        "3. Upgrade Construction. \n " +
                        "4. Trade type1. \n " +
                        "5. Trade type2. \n " +
                        "6. Trade type3. \n " +
                        "7. See your Constructions. \n " +
                        "8. See the Board. \n " +
                        "9. See the Map. \n " +
                        "10. Finalize your round.");
        Map map = new Map(4);
        System.out.println(map);*/
    }
}