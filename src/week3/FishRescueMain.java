package week3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import me.jjfoley.gfx.IntPoint;
import week3.grid.Actor;
import week3.grid.Buttons;
import week3.grid.Decoration;
import week3.grid.GridEnv;
import week3.grid.GridView;

/**
 * FishRescueMain deals with bringing fish to safety.
 */
public class FishRescueMain extends GridView {
    /**
     * Fish initially begin in this list; totally randomly placed, "missing".
     */
    private List<LostFish> missingFish;
    /**
     * 
     * Once you bump into them, they decide to follow you around.
     */
    private List<LostFish> followFish;
    /**
     * When you get to the same place as the 'home', they are saved.
     */
    private Actor fishHome;
    /**
     * The hero is (once again) not a special class, since we move it here.
     */
    private Decoration hero;

    // Track the number of fish saved.

    private Integer FishCount;

    /**
     * Construct a new FishRescue simulation.
     */
    public FishRescueMain() {
        super(new GridEnv(10, 10));
        // create a list of missing fish; add to grid.
        this.missingFish = LostFish.createLostFish();
        for (LostFish f : this.missingFish) {
            this.grid.insertRandomly(f);
        }
        // the list of 'following' fish starts empty.
        this.followFish = new ArrayList<>();
        this.FishCount = 0;

        // create a home for the fish:
        this.fishHome = new Decoration("houses"); // maybe "coral" is more thematic...
        // put it anywhere:
        this.grid.insertRandomly(this.fishHome);

        // create a hero, put it on top of the home, add to grid:
        this.hero = new Decoration("dolphin");
        this.hero.setPoint(this.fishHome.getPoint());
        this.grid.insert(hero);
    }

    // Override getHeaderText to express the number of fish saved.

    @Override
    public String getHeaderText() {
        // This text shows up at the top of the window.
        // You won't need to mess with this.
        return "Fish Saved: " + FishCount;
    }

    @Override
    public void buttons(Buttons pressed) {
        IntPoint maybeStep = pressed.nextPosition(this.hero.getPoint());
        // Don't let the hero go outside the grid.

        if (maybeStep.x > 9 || maybeStep.x < 0 || maybeStep.y > 9 || maybeStep.y < 0) {
        } else {
            this.hero.setPoint(maybeStep);
        }

        // update fish locations based on hero movement:
        this.fishFollow();
        // grab any fish in the same spot as the hero to follow
        this.recruitFish();
        // if we're at home, 'rescue' all the fish.
        this.rescueFish();
    }

    /**
     * For all the missing fish, if they're in the same spot as the hero: 1. move
     * them from missingFish to followFish. 2. change their isMissing variable to
     * false.
     */

    public void recruitFish() {
        for (LostFish f : new ArrayList<>(missingFish)) {
            if (f.getPoint().equals(this.hero.getPoint())) {
                // Recruit fish to follow you.
                f.isMissing = false;
                missingFish.remove(f);
                followFish.add(f);
            }
        }
    }

    public void rescueFish() {
        if (this.fishHome.getPoint().equals(this.hero.getPoint())) {
            for (LostFish f : new ArrayList<>(followFish)) {
                // Remove if touching home
                this.grid.remove(f);
                followFish.remove(f);
                this.FishCount += 1;
            }
        }
    }

    /**
     * Keep track of the places we have been recently: Why a LinkedList... hmm?
     */
    private LinkedList<IntPoint> steps = new LinkedList<>();

    /**
     * Make fish in the follow list trail after you.
     * 
     * This works good enough (no todos).
     */
    public void fishFollow() {
        // Following fish trail after the hero:
        for (int i = 0; i < Math.min(this.steps.size(), this.followFish.size()); i++) {
            this.followFish.get(i).setPoint(this.steps.get(i));
        }

        // keep track of where the hero has been:
        if (this.steps.size() > 32) {
            this.steps.removeLast();
        }
        this.steps.addFirst(this.hero.getPoint());
    }

    /**
     * Start up the game!
     * 
     * @param args - ignored, as usual.
     */
    public static void main(String[] args) {
        GridView app = new FishRescueMain();
        app.start();
    }

}
