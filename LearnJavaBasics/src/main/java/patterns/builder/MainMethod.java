package patterns.builder;

/**
 * Created by Razvan on 27.12.2016.
 */
public class MainMethod {
    public static void main(String[] args) {
//        NutritionFacts cocaCola = new NutritionFacts.Builder(240, 8).
//                calories(100).sodium(35).carbohydrate(27).build();

//        Person p1 = new Person.Builder()
//                .firstName("Popescu")
//                .lastName("Ion")
//                .address("Iasi")
//                .phoneNumber("123456767")
//                .build();
//        System.out.println(p1);

        Book b1 = new Book.Builder()
                .title("Amintiri din copilarie")
                .author("Ion Creanga")
                .type("Literatura")
                .build();
        System.out.println(b1);
    }
}
