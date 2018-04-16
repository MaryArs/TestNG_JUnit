package com.mycompany.app;

import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import static org.junit.experimental.categories.Categories.*;

@SuiteClasses({AppTest.class})
@RunWith(MyCategories.class)
@IncludeCategory({MyCategories.PositiveTests.class, MyCategories.NegativeTests.class})

public class RunSuite {
}
