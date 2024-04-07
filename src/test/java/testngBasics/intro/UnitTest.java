package testngBasics.intro;

public class UnitTest {

    public static void main(String[] args) {

        // We come up with a scenario
        // Provide data: 10, 20
        // Expect as a result: 30

        int expectedSum = 30;
        Calculator calculator = new Calculator();
        int actualSum = calculator.add(10, 20);

        if(actualSum == expectedSum){
            System.out.println("TEST PASSED");
        } else {
            System.out.println("TEST FAILED");
        }


        // Provide: -10, 10
        // Expect: 0

    }

}
