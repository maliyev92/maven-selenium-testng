package testngBasics.intro;

import org.testng.annotations.Test;

public class DifferentPackageTest {

    @Test(groups = "regression")
    public void test_case_from_dif_package(){
        System.out.println("This test case is from completely different package!");
    }


}