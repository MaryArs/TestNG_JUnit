package com.mycompany.app;

import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import static org.junit.experimental.categories.Categories.*;

@RunWith(Categories.class)
@IncludeCategory({MyCategories.PositiveTests.class, MyCategories.NegativeTests.class})
@SuiteClasses({AppFixture.class, AppTest.class})

public class RunSuite {
}
