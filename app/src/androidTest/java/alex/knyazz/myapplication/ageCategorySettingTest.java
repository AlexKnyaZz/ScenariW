package alex.knyazz.myapplication;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.containsString;

import android.view.View;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.UiController;
import androidx.test.espresso.ViewAction;
import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.rule.ActivityTestRule;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.Rule;
import org.junit.Test;


public class ageCategorySettingTest {
    @Rule
    public ActivityTestRule<edit_page_1> activityRule = new ActivityTestRule<>(edit_page_1.class);

    @Test
    public void testAgeCategory6() {
        // Нажимаем addRow
        onView(ViewMatchers.withId(R.id.addRow)).perform(ViewActions.click());

        // Находим поле TextInputEditText по его тегу
        ViewInteraction textInputEditText = Espresso.onView(ViewMatchers.withTagValue(Matchers.<Object>equalTo("a0")));

        // Выполняем действие ввода текста
        textInputEditText.perform(ViewActions.typeText("hero was cold"), ViewActions.closeSoftKeyboard());

        //после тяжёлого дня, герой выпил

        // Проверяем содержание поля categoryAssist на наличие цифры 18
        category(6);


        //onView(isRoot()).perform(waitFor(5000));
    }

    @Test
    public void testAgeCategory18() {
        // Нажимаем addRow
        onView(ViewMatchers.withId(R.id.addRow)).perform(ViewActions.click());

        // Находим поле TextInputEditText по его тегу
        ViewInteraction textInputEditText = Espresso.onView(ViewMatchers.withTagValue(Matchers.<Object>equalTo("a0")));

        // Выполняем действие ввода текста
        textInputEditText.perform(ViewActions.typeText("hero was drunk "), ViewActions.closeSoftKeyboard());

        //после тяжёлого дня, герой выпил

        // Проверяем содержание поля categoryAssist на наличие цифры 18
        category(18);


        //onView(isRoot()).perform(waitFor(5000));
    }

    @Test
    public void test18InsteadOfResult() {
        // Нажимаем addRow
        onView(ViewMatchers.withId(R.id.addRow)).perform(ViewActions.click());

        // Находим поле TextInputEditText по его тегу
        ViewInteraction textInputEditText = Espresso.onView(ViewMatchers.withTagValue(Matchers.<Object>equalTo("a0")));

        // Выполняем действие ввода текста
        textInputEditText.perform(ViewActions.typeText("hero was cold "), ViewActions.closeSoftKeyboard());

        //после тяжёлого дня, герой выпил

        // Проверяем содержание поля categoryAssist на наличие цифры 18
        category(18);


        //onView(isRoot()).perform(waitFor(5000));
    }

    @Test
    public void test6InsteadOfResult() {
        // Нажимаем addRow
        onView(ViewMatchers.withId(R.id.addRow)).perform(ViewActions.click());

        // Находим поле TextInputEditText по его тегу
        ViewInteraction textInputEditText = Espresso.onView(ViewMatchers.withTagValue(Matchers.<Object>equalTo("a0")));

        // Выполняем действие ввода текста
        textInputEditText.perform(ViewActions.typeText("hero was drunk "), ViewActions.closeSoftKeyboard());

        //после тяжёлого дня, герой выпил

        // Проверяем содержание поля categoryAssist на наличие цифры 18
        category(6);


        //onView(isRoot()).perform(waitFor(5000));
    }

    private void category(int a) {
        // Проверяем содержание поля categoryAssist на наличие указанной цифры
        onView(ViewMatchers.withId(R.id.categoryAssist)).check(matches(withText(containsString(String.valueOf(a)))));
    }


    public static ViewAction waitFor(final long millis) {
        return new ViewAction() {
            @Override
            public Matcher<View> getConstraints() {
                return isRoot();
            }

            @Override
            public String getDescription() {
                return "Wait for " + millis + " milliseconds.";
            }

            @Override
            public void perform(UiController uiController, View view) {
                uiController.loopMainThreadForAtLeast(millis);
            }
        };
    }

}
