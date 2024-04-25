package alex.knyazz.myapplication;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;

import android.view.View;

import androidx.test.espresso.UiController;
import androidx.test.espresso.ViewAction;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.rule.ActivityTestRule;

import org.hamcrest.Matcher;
import org.junit.Rule;
import org.junit.Test;

public class ButtonClickTest {

    @Rule
    public ActivityTestRule<authorisation_activity> activityRule = new ActivityTestRule<>(authorisation_activity.class);

    @Test
    public void testButtonClick() {
        // Дождитесь загрузки активности
        //onView(isRoot()).perform(waitFor(2000));

        onView(ViewMatchers.withId(R.id.btnLogin)).perform(ViewActions.click());

        // Дождитесь загрузки следующей активности
        //onView(isRoot()).perform(waitFor(2000));

        // Нажмите на кнопку с id Scenarious
        onView(ViewMatchers.withId(R.id.Scenarious)).perform(ViewActions.click());

        // Дождитесь загрузки следующей активности
        //onView(isRoot()).perform(waitFor(2000));

        // Нажмите на кнопку с id Create
        onView(ViewMatchers.withId(R.id.Create)).perform(ViewActions.click());

        // Дождитесь загрузки следующей активности
        //onView(isRoot()).perform(waitFor(2000));

        // Нажмите на кнопку с id CreateNew
        onView(ViewMatchers.withId(R.id.CreateNew)).perform(ViewActions.click());

        // Дождитесь загрузки следующей активности
        //onView(isRoot()).perform(waitFor(15000));
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

