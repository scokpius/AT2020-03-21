package runner;


import org.junit.FixMethodOrder;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.junit.runners.Suite;
import tests.b_splitengineers.BaseEngineerTest;
import tests.b_splitengineers.ExecuteTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({BaseEngineerTest.class, ExecuteTest.class})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class JUnitRunner {
}
