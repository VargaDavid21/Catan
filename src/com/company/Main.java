package com.company;

import com.company.Construction.*;
import com.company.Engine.Game;
import com.company.Engine.Player;
import com.company.Map.*;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException {

        ///// De implementat logica ce scoate resurse din hashMap-ul de resurse al playerului in cantitatea costului cladirii

         /*Game game = new Game(3, 4, 10);

        System.out.println(game); */

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

        Player p1 = new Player("Vasile", "Black");
        Player p2 = new Player("Goldis", "Yellow");

        p1.addResource("Stone", 100);
        p1.addResource("Wheat", 100);
        p1.addResource("Wood", 100);
        p1.addResource("Sheep", 100);
        p1.addResource("Brick", 100);

        p2.addResource("Stone", 100);
        p2.addResource("Wheat", 100);
        p2.addResource("Wood", 100);
        p2.addResource("Sheep", 100);
        p2.addResource("Brick", 100);

        Construction c1 = new City(p1);
        Construction c2 = new City(p1);
        Construction c3 = new Village(p2);
        Construction c4 = new Village(p2);

        Construction r1 = new MudRoad(p1);
        Construction r2 = new MudRoad(p1);
        Construction r3 = new StoneRoad(p2);
        Construction r4 = new StoneRoad(p2);

        Construction f1 = new Fortress(p1);
        Construction f2 = new Fortress(p2);

        OperationalTile t = new Granary();
        t.addConstruction(c1, 0, 0);
        t.addConstruction(c2, 0, 1);
        t.addConstruction(c3, 0, 2);
        t.addConstruction(c4, 0, 3);
        t.addConstruction(f1, 0, 4);
        t.addConstruction(f2, 0, 5);

        t.addConstruction(r1, 1, 0);
        t.addConstruction(r2, 1, 1);
        t.addConstruction(r3, 1, 2);
        t.addConstruction(r4, 1, 3);

        Game game = new Game(4, 3, 15);

        System.out.println(game);

        // t.distribute();

        System.out.println(p1 + " \n  " + p2);

       /* Map map = new Map(4);
        System.out.println(map); */
    }
}