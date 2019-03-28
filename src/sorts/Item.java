package sorts;
import java.util.Comparator;

public class Item implements Comparable<Item>{
    private int size;
    private int weight;
    private String color;

    public static final Comparator<Item> BY_WEIGHT = new ByWeight();
    public static final Comparator<Item> BY_COLOR = new ByColor();

    public Item(int size, int weight, String color){
        this.size = size;
        this.weight = weight;
        this.color = color;
    }

    @Override
    public int compareTo(Item that){
        return this.size - that.size;
    }

    @Override
    public String toString(){
        return "{Size: " + this.size + "; Weight: "+ this.weight + "; Color: " + this.color + " }";
    }

    private static class ByWeight implements Comparator<Item>{



        @Override
        public int compare(Item first,Item second) {
            return first.weight-second.weight;
        }
    }

    private static class ByColor implements Comparator<Item>{


        @Override
        public int compare(Item first,Item second) {
            return first.color.compareToIgnoreCase(second.color);
        }
    }



}