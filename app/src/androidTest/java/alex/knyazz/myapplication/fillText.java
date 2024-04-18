package alex.knyazz.myapplication;

import static androidx.test.espresso.matcher.ViewMatchers.isRoot;

import android.view.View;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.UiController;
import androidx.test.espresso.ViewAction;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.rule.ActivityTestRule;

import org.hamcrest.Matcher;
import org.junit.Rule;
import org.junit.Test;

public class fillText {
    @Rule
    public ActivityTestRule<scenarious_create2> activityRule = new ActivityTestRule<>(scenarious_create2.class);

    @Test
    public void testFillFields() {

        // Заполните поле AutoCompleteTextView с id = auto_complete_txt словом Scenarist
        Espresso.onView(ViewMatchers.withId(R.id.type_input))
                //.inRoot(RootMatchers.isPlatformPopup())
                .perform(ViewActions.typeText("Story"), ViewActions.closeSoftKeyboard());

        // Заполните поле AutoCompleteTextView с id = auto_complete_txt1 словом Story
        Espresso.onView(ViewMatchers.withId(R.id.role_input))
                //.inRoot(RootMatchers.isPlatformPopup())
                .perform(ViewActions.typeText("Scenarist"), ViewActions.closeSoftKeyboard());


        ViewActions.closeSoftKeyboard();
        //onView(isRoot()).perform(waitFor(1000));


        // Заполните поле EditText с id = scenName текстом "Witchrer 3: Wild Hunt"
        Espresso.onView(ViewMatchers.withId(R.id.scenName))
                .perform(ViewActions.typeText("Witcher 3: Wild Hunt"), ViewActions.closeSoftKeyboard());
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
