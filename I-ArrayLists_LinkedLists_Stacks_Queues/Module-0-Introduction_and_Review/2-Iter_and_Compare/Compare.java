
public class Compare {
    public static void main(String[] args){
        MenuItem item1 = new MenuItem("cheesesteak", 4);
        MenuItem item2 = new MenuItem("cheesecake", 7);

        // we should compare these items like this:
        if (item1.compareTo(item2) < 0) {
            System.out.println("Item 1 is more than item 2");
        }

        // this DOES NOT work:
        // if (item1 < item2) {
        //     System.out.println("Item 1 is more than item 2");
        // }



        // this works properly
        if (item1.compareTo(item2) < 0) {
            System.out.println(item1.getName() + " is cheaper than " + item2.getName());
        } else if (item1.compareTo(item2) > 0) {
            System.out.println(item1.getName() + " is more expensive than " + item2.getName());
        } else {
            System.out.println(item1.getName() + " and " + item2.getName() + " are the same price!");
        }

        // this does NOT work properly: (item2.price - item1.price) is 3, so the first two conditions are false
        //compareTo doesnt have to return -1/1/0, just a positive/negative/0
        // if (item1.compareTo(item2) == -1) {
        //     System.out.println(item1.name + " is cheaper than " + item2.name);
        // } else if (item1.compareTo(item2) == 1) {
        //     System.out.println(item1.name + " is more expensive than " + item2.name);
        // } else {
        //     System.out.println(item1.name + " and " + item2.name + " are the same price!");
        // }
    }
}

class MenuItem implements Comparable<MenuItem> {
    private String name;
    private int price;

    public MenuItem(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public int getPrice(){
        return this.price;
    }

    public void setPrice(int p){
        this.price = p;
    }


    public String getName(){
        return this.name;
    }

    public void setName(String n){
        this.name=n;
    }

    public int compareTo(MenuItem otherItem) {
        return this.price - otherItem.getPrice();
    }
}


//unlike iterable and iterator, comparable and compartor are completely independant; neither needs the other to operate

//compareTo method: x.compareTo(y) [declared as: public int compareTO(T y)]
    //negative if x<y
    //0 if x==y
    //positive if x>y
    //essentialy the result of x-y if that were possible

    //allows for establishing a natural ordering

//an object from a comparable class compares itself to another with the compare method
    //user can use a comparator object to compare two objects of the same type 
    //allows implementation of a custom ordering
    //
