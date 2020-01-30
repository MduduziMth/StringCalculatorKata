import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorTest  {
    StringCalculatorKata test = new StringCalculatorKata();

    @Test
    void TestAdd() throws Exception{
        assertEquals(0,test.add("") );

        assertEquals(1,test.add("1") );

        assertEquals(2,test.add("1,1") );

        assertEquals(10,test.add("1,2,3,4") );

        assertEquals(6,test.add("1\n2,3") );

        assertEquals(3,test.add("//;\n1;2") );

        assertEquals(3,test.add("//4\n142") );

        assertEquals(3,test.add("//;\n1000,1;2") );

        assertEquals(6,test.add("//***\n1***2***3"));

        assertEquals(6,test.add("//[:D][%]\n1:D2%3"));

        assertEquals(6,test.add("//[***][%%%]\n1***2%%%3"));

        assertEquals(6,test.add("//[(-_-')][%]\n1(-_-')2%3"));

        assertEquals(7,test.add("//[abc][777][:(]\n1abc27773:(1"));



    }

}