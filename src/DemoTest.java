import com.hc.Calculator;
import com.hc.impl.CalculatorImpl;
import com.hc.impl.CalculatorProxy;

/**
 * Created by Administrator on 2016/12/5.
 */
public class DemoTest {
    public static void main(String[] args) {
        Calculator calculator = new CalculatorProxy(new CalculatorImpl()).getCalculator();
        int addRes = calculator.add(31, 4);
        System.out.println(addRes);
    }
}
