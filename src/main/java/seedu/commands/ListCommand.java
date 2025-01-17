package seedu.commands;

import seedu.exceptions.LifeTrackerException;
import seedu.exceptions.MissingArgumentsException;
import seedu.storage.ExerciseStorage;
import seedu.storage.FoodStorage;
import seedu.storage.MealStorage;
import seedu.storage.UserStorage;
import seedu.exceptions.InvalidArgumentsException;
import seedu.ui.GeneralUi;

public class ListCommand extends Command {
    private String argument;

    public ListCommand(String commandWord, String userInput) throws LifeTrackerException {
        if (commandWord.length() == userInput.length() || userInput.split(" ").length < 2) {
            throw new MissingArgumentsException(commandWord, "[meals/foods]");
        }

        this.argument = userInput.split(" ")[1];

        if (!this.argument.equals("meals") && !this.argument.equals("foods")) {
            throw new InvalidArgumentsException(commandWord, "[meals/foods]");
        }
    }

    @Override
    public void execute(GeneralUi ui, FoodStorage foodStorage,
                        MealStorage mealStorage, UserStorage userStorage, ExerciseStorage exerciseStorage)
            throws LifeTrackerException {
        if (argument.equals("meals")) {
            ui.printAllMeals(mealStorage);
        } else {
            ui.printAllFoods(foodStorage);
        }
    }
}
