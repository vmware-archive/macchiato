# macchiato

[![Build Status](https://secure.travis-ci.org/pivotal/macchiato.svg?branch=master)](http://travis-ci.org/pivotal/macchiato)

## Using

```java
import static io.pivotal.macchiato.*;

public class WaxTest extends ActivityInstrumentationTestCase2<DisActivity> {
  public WaxTest() {
    super(WaxActivity.class);
  }

  public void testOnAndOff() {
    getActivity();

    assertHasText("On")
    assertDoesNotHaveText("Off")

    clickOn(R.id.wax)
    assertDoesNotHaveText("On")
    assertHasText("Off")
  }
}
```

## Download

1. Download the latest macchiato release [here](https://github.com/pivotal/macchiato/releases)
2. In your project create a `libs` directory (if you haven't already) and add the following
to your `build.gradle` to include this in your dependencies:

  ```groovy
  repositories {
      flatDir {
          dirs 'libs'
      }
  }
  ```
3. Copy the macchiato .aar file you downloaded into `libs`
4. Finally add the dependencies to your `build.gradle`:

  ```groovy
  dependencies {
    androidTestCompile('com.android.support.test.espresso:espresso-core:2.0')
    androidTestCompile('com.android.support.test:testing-support-lib:0.1')
    androidTestCompile(name:'macchiato-0.1.0', ext:'aar')
  }
  ```
