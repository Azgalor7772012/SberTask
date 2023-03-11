

import org.assertj.core.api.Assertions;
import org.example.BracketChecker;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.ClassBasedNavigableIterableAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;


class BracketsTest {

    BracketChecker checker = new BracketChecker();
    String case1 = "2-()"; // Ввод: "(()"
    String case2 = "4-()()"; // Ввод: ")()())"
    String case3 = "6-(()())"; // Ввод: ")(()())"
    String case4 = "0"; // Ввод: ")("
    String case5 = "12-()()((()))()"; // ()()((()))()

    @Test
    void checkIfMethodWorks() {
        assertAll(
                () -> Assertions.assertThat(checker.getValidBrackets("(()")).isEqualTo(case1),
                () -> Assertions.assertThat(checker.getValidBrackets(")()())")).isEqualTo(case2),
                () -> Assertions.assertThat(checker.getValidBrackets(")(()())")).isEqualTo(case3),
                () -> Assertions.assertThat(checker.getValidBrackets(")(")).isEqualTo(case4),
                () -> Assertions.assertThat(checker.getValidBrackets("))))()()((())))()")).isEqualTo(case5)
        );
    }
}
