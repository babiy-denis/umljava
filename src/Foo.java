import java.util.ArrayList;
import java.util.List;

class Foo {
    public Bar<Baz> field;
    List<Integer> ints = new ArrayList<Integer>();
    List<? extends Number> nums = ints;  // it is OK
}
class Bar<T> { /* ... */ }

class Baz { /* ... */ }