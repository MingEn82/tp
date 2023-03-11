package seedu.Entities;

import java.util.ArrayList;

public class Meal {
    private ArrayList<Food> foods;
    private String date;
    private float totalCalories;

    public Meal(ArrayList<Food> foods, String date) {
        this.foods = foods;
        this.date = date;
        calculateTotalCalories();
    }

    public ArrayList<Food> getFoods() {
        return this.foods;
    }

    public void setFoods(ArrayList<Food> foods) {
        this.foods = foods;
    }

    public String getDate() {
        return this.date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public float getTotalCalories() {
        return this.totalCalories;
    }

    public void calculateTotalCalories() {
        for (Food food : foods) {
            this.totalCalories += food.getCalories();
        }
    }

    public String[] toWriteFormat(String delimiter) {
        String[] output = new String[2];
        output[0] = date;
        String[] foodArray = new String[foods.size()];
        for (int i = 0; i < foods.size(); i++)
        {
            foodArray[i] = String.valueOf(foods.get(i).getId());
        }
        output[1] = String.join(delimiter, foodArray);
        return output;
    }

    @Override
    public String toString() {
        String output = "Meal was consumed on " + date + "\n";
        output += "Total Calories are: " + this.getTotalCalories() + "\n";
        output += "Here are the foods you ate:";
        for (int i = 0; i < foods.size(); i++)
        {
            output += "\t" + i + ") " + foods.get(i).toString() + "\n";
        }
        return output;
    }
}