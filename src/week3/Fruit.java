package week3;

import week3.grid.Actor;

/**
 * This represents one of many fruits to collect.
 */
public class Fruit extends Actor {

    /**
     * These are all the fruits in our small emoji set.
     */
    public static String[] EMOJI_NAMES = { "strawberry", "cherries", "grapes", "green-apple", "kiwi-fruit", "lemon",
            "mango", "pear", "pineapple", "red-apple", "tangerine", "watermelon" };

    /**
     * Construct a new Fruit object.
     */
    public Fruit(int callNum) {
        // Take an int parameter to this constructor, and look up into the static
        // array for the setEmoji call.

        this.setEmoji(EMOJI_NAMES[callNum]);
        this.visual.setScale(0.8);
    }

    @Override
    public void act() {
        // Challenge: the amazing shrinking fruit.
        // Use this.visual.getScale() and this.visual.setScale() to shrink this fruit
        // over time, and use this.remove() to remove it when it gets too small.
        // this.takeRandomStep();
        double size = this.visual.getScale();
        this.visual.setScale(size - 0.02);
        if (size < 0.05) {
            this.remove();
        }
    }

}
