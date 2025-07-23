interface MealPlan {
    String getType();
}

class VegetarianMeal implements MealPlan {
    public String getType() { return "Vegetarian"; }
}

class VeganMeal implements MealPlan {
    public String getType() { return "Vegan"; }
}

class Meal<T extends MealPlan> {
    private T plan;
    public Meal(T plan) { this.plan = plan; }

    public T getMealPlan() { return plan; }

    public static <T extends MealPlan> void generateMealPlan(Meal<T> meal) {
        System.out.println("Generated meal plan: " + meal.getMealPlan().getType());
    }
}

public class MealPlanner {
    public static void main(String[] args) {
        Meal<VegetarianMeal> meal = new Meal<>(new VegetarianMeal());
        Meal.generateMealPlan(meal);
    }
}
