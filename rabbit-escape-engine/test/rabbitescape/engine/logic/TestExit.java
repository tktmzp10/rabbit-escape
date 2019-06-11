package rabbitescape.engine.logic;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
import static rabbitescape.engine.Tools.*;
import static rabbitescape.engine.textworld.TextWorldManip.*;
import static rabbitescape.engine.util.WorldAssertions.*;

import org.junit.Test;

import rabbitescape.engine.World;

public class TestExit {

    /**
     * Purpose: To test rabbit is exiting on grounds
     * Input:
     * steps to exit = 4
     * World maps
     * "r  O ",
     * "#####"
     * Expected: Rabbit exits exactly after four steps.
     */
    @Test
    public void Rabbit_disappears_into_exit() {
        World world = createWorld(
            "r  O ",
            "#####"
        );

        world.step();

        assertThat(
            renderWorld(world, true, false),
            equalTo(
                " r>O ",
                "#####"
            )
        );

        world.step();

        assertThat(
            renderWorld(world, true, false),
            equalTo(
                "  r> ",
                "#####"
            )
        );

        world.step();

        assertThat(
            renderWorld(world, true, false),
            equalTo(
                "   R ",  // Entering
                "#####"
            )
        );

        world.step();

        assertThat(
            renderWorld(world, true, false),
            equalTo(
                "   O ",  // Gone
                "#####"
            )
        );
    }

    /**
     * Purpose: To test rabbit is exiting on climbing right
     * Input:
     * steps to exit = 6
     * World maps
     * "     "
     * " O# #"
     * "  ###"
     * "rc#  "
     * "###  "
     * "#####"
     * Expected: Rabbit exits exactly after six steps.
     */
    @Test
    public void EnteringExitClimbingRight() {
        World world = createWorld(
            "     ",
            " O# #",
            "  ###",
            "rc#  ",
            "###  "
        );

        assertWorldEvolvesLike(
            world,
            6,
            new String[]{
                "     ",
                " O# #",
                "  ###",
                "  #  ",
                "###  "
            });
    }

    /**
     * Purpose: To test rabbit is exiting on climbing left
     * Input:
     * steps to exit = 6
     * World maps that Rabbit reaches Exit through left climbing
     * Expected: Rabbit exits exactly after six steps.
     */
    @Test
    public void EnteringExitClimbingLeft() {
        World world = createWorld(
            "     ",
            "# #O ",
            "###  ",
            "  #cj",
            "#####"
        );

        assertWorldEvolvesLike(
            world,
            6,
            new String[]{
                "     ",
                "# #O ",
                "###  ",
                "  #  ",
                "#####"
            });

    }

    /**
     * Purpose: To test world class maintaining the number of escaped rabbits.
     * Input: World maps that four Rabbit reaches Exit
     * Expected: the saved number of rabbit in world instance is 4.
     */
    @Test
    public void World_keeps_score() {
        World world = createWorld(
            "Ojjjj   ",
            "########"
        );

        world.step();
        assertThat(world.num_saved, equalTo(0));
        world.step();
        assertThat(world.num_saved, equalTo(1));
        world.step();
        assertThat(world.num_saved, equalTo(2));
        world.step();
        assertThat(world.num_saved, equalTo(3));
        world.step();
        assertThat(world.num_saved, equalTo(4));
    }

    /**
     * Purpose: To test world class maintaining the number of escaped rabbits.
     * Input: World maps that three Rabbit reaches Exit
     * Expected: the saved number of rabbit in world instance is 3.
     */
    @Test
    public void Splatting_prevents_exit() {
        World world = createWorld(
            "r         #       ",
            "# r       #       ",
            "  # r     #       ",
            "    # r   #       ",
            "      # r #       ",
            "        # r       ",
            "          # r     ",
            "            # r   ",
            "              #   ",
            " O O O O O O O O  ",
            " # # # # # # # #  ",
            "#                #",
            "##################"
        );

        assertWorldEvolvesLike(
            world,
            10,
            new String[]{
                "          #       ",
                "#         #       ",
                "  #       #       ",
                "    #     #       ",
                "      #   #       ",
                "        #         ",
                "          #       ",
                "            #     ",
                "              #   ",
                " O O O O O O O O  ",
                " # # # # # # # #  ",
                "#                #",
                "##################"
            });

        assertThat(world.num_saved, equalTo(3));
    }

    /**
     * Purpose: To test rabbit is exiting using climbing actions.
     * Input:
     * steps to exit = 6
     * World maps that Rabbit reaches Exit using climbing actions.
     * Expected: Rabbit exits exactly after six steps.
     */
    @Test
    public void Climb_into_exit() {
        // Has a trap to see if the character climbed past
        World world = createWorld(
            "     ",
            " O# #",
            "  ###",
            "rc#  ",
            "###  "
        );

        assertWorldEvolvesLike(
            world,
            6,
            new String[]{
                "     ",
                " O# #",
                "  ###",
                "  #  ",
                "###  "
            });

        // The character escaped
        assertThat(world.num_saved, equalTo(1));
    }

    @Test
    public void Fall_past_exit() {
        // All must die
        World world = createWorld(
            "rrrrrrr",
            "O      ",
            " O     ",
            "  O    ",
            "   O   ",
            "    O  ",
            "     O ",
            "      O"
        );

        assertWorldEvolvesLike(
            world,
            5,
            new String[]{
                "       ",
                "O      ",
                " O     ",
                "  O    ",
                "   O   ",
                "    O  ",
                "     O ",
                "      O"
            });

        // None lived
        assertThat(world.num_saved, equalTo(0));
    }

    @Test
    public void Rabbots_ignore_the_exit() {
        assertWorldEvolvesLike(
            "t  O y" + "\n" +
                "######",

            " t><y " + "\n" +
                "######",

            "  <>  " + "\n" +
                "######",

            " <yO> " + "\n" + // They just walked straight past!
                "######",

            "<y Ot>" + "\n" +
                "######"
        );
    }
}
